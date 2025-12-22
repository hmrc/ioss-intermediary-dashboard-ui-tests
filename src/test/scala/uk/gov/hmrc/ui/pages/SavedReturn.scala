/*
 * Copyright 2025 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.ui.pages

import org.junit.Assert
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import uk.gov.hmrc.selenium.webdriver.Driver

object SavedReturn extends BasePage {

  def savedReturnsAvailable(scenario: String): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText
    val heading = Driver.instance.findElement(By.tagName("h1")).getText

    scenario match {
      case "multipleSavedReturns" =>
        Assert.assertTrue(
          htmlBody.contains(
            "Saved Return 1 (IOSS reference IM9006655441)\n" +
              "Saved Return 2 (IOSS reference IM9006655442)\n" +
              "Saved Return 3 (IOSS reference IM9006655443)"
          )
        )
      case "singleSavedReturn" =>
        Assert.assertTrue(
          heading.equals(
//            Will require update once issues resolved
            "Do you want to continue the return for Single Saved Return (VAT/tax reference: IM9006655551)?"
          )
        )

      case _ =>
        throw new Exception("Scenario doesn't exist")
    }
  }

  def selectSavedReturn(iossNumber: String): Unit = {
    val radioButtonId = iossNumber
    fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.id(radioButtonId)))
    click(By.id(radioButtonId))
    click(By.id("continue"))
  }

  def answerRadioButton(answer: String): Unit = {

    answer match {
      case "yes" => click(By.id("value_0"))
      case "no" => click(By.id("value_1"))
      case _ => throw new Exception("Option doesn't exist")
    }
    click(By.id("continue"))

    if (answer == "yes") {
      fluentWait.until(ExpectedConditions.urlContains("http://localhost:10193/pay-vat-on-goods-sold-to-eu/import-one-stop-shop-returns-payments"))
    }
  }

  def deleteReturn(answer: String): Unit = {

    answer match {
      case "yes" => click(By.id("value"))
      case "no" => click(By.id("value-no"))
      case _ => throw new Exception("Option doesn't exist")
    }
    click(By.id("continue"))
  }
}
