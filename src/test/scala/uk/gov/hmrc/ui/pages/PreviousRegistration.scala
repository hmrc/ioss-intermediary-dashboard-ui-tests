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
import uk.gov.hmrc.selenium.webdriver.Driver

object PreviousRegistration extends BasePage {

  def multiplePreviousRegistrationsLink(version: String): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText

    val singleReturnText    = "View clients and returns from your previous IOSS registration"
    val multipleReturnsText = "View clients and returns from your previous IOSS registrations"

    val singleRegistrationText    = "View clients from your previous IOSS registration"
    val multipleRegistrationsText = "View clients from your previous IOSS registrations"

    version match {
      case "singleReturn"          =>
        Assert.assertTrue(htmlBody.contains(singleReturnText))
        Assert.assertFalse(htmlBody.contains(multipleReturnsText))
      case "multipleReturns"       =>
        Assert.assertTrue(htmlBody.contains(multipleReturnsText))
      case "singleRegistration"    =>
        Assert.assertTrue(htmlBody.contains(singleRegistrationText))
        Assert.assertFalse(htmlBody.contains(multipleRegistrationsText))
      case "multipleRegistrations" =>
        Assert.assertTrue(htmlBody.contains(multipleRegistrationsText))
      case "noneReturns"           =>
        Assert.assertFalse(htmlBody.contains(singleReturnText))
      case _                       =>
        Assert.assertFalse(htmlBody.contains(singleRegistrationText))
    }
  }

  def viewPreviousRegistrations(link: String): Unit =
    clickCssSelector(link)

  def selectPreviousRegistration(intermediaryNumber: String): Unit = {
    click(By.id(intermediaryNumber))
    click(By.id("continue"))
  }

  def checkIntermediaryNumber(intermediaryNumber: String): Unit = {
    val body = Driver.instance.findElement(By.tagName("body")).getText
    Assert.assertTrue(body.contains(s"IOSS intermediary number: $intermediaryNumber"))
  }

  def returnToCurrentRegistrationLink(page: String): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText
    Assert.assertTrue(htmlBody.contains("Return to your current registration"))
    clickCssSelector(page)
  }

  def selectPreviousRegistrationAmend(intermediaryNumber: String): Unit = {
    val radioButtonId = if (intermediaryNumber == "IN9000230002") {
      "value_0"
    } else {
      "value_1"
    }
    click(By.id(radioButtonId))
    click(By.id("continue"))
  }
}
