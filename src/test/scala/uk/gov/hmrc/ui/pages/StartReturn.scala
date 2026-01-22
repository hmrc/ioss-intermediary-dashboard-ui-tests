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
import org.scalatest.matchers.should.Matchers.*
import uk.gov.hmrc.configuration.TestEnvironment
import uk.gov.hmrc.selenium.webdriver.Driver

import java.time.LocalDate

object StartReturn extends BasePage {

  private val intermediaryReturnsUrl: String        =
    TestEnvironment.url("ioss-returns-frontend")
  private val intermediaryReturnsJourneyUrl: String =
    "/pay-vat-on-goods-sold-to-eu/import-one-stop-shop-returns-payments"

  def clientsWithReturns(scenario: String): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText
    scenario match {
      case "allReturnsOverdue" =>
        Assert.assertTrue(
          htmlBody.contains(
            "Client name IOSS number\n" +
              "Start return for\n" + // hidden text
              "Eighth Client IM9001144778\n" +
              "Start return for\n" + // hidden text
              "Fifth Client IM9001144775\n" +
              "Start return for\n" + // hidden text
              "First Client IM9001144771\n" +
              "Start return for\n" + // hidden text
              "Fourth Client IM9001144774\n" +
              "Start return for\n" + // hidden text
              "Second Client IM9001144772\n" +
              "Start return for\n" + // hidden text
              "Seventh Client IM9001144777\n" +
              "Start return for\n" + // hidden text
              "Sixth Client IM9001144776\n" +
              "Start return for\n" + // hidden text
              "Third Client IM9001144773"
          )
        )
      case "twoReturnsDue"     =>
        Assert.assertTrue(
          htmlBody.contains(
            "Client name IOSS number\n" +
              "Start return for\n" + // hidden text
              "Returns 2 IM9001144844\n" +
              "Start return for\n" + // hidden text
              "Returns 4 IM9001144866"
          )
        )
      case "fourReturnsDue"    =>
        Assert.assertTrue(
          htmlBody.contains(
            "Client name IOSS number\n" +
              "Start return for\n" + // hidden text
              "Returns 1 IM9001144877\n" +
              "Start return for\n" + // hidden text
              "Returns 2 IM9001144888\n" +
              "Start return for\n" + // hidden text
              "Returns 3 IM9001144899\n" +
              "Start return for\n" + // hidden text
              "Returns 4 IM9001144800"
          )
        )
      case "twoReturnsOverdue" =>
        Assert.assertTrue(
          htmlBody.contains(
            "Client name IOSS number\n" +
              "Start return for\n" + // hidden text
              "Returns 3 IM9001144899\n" +
              "Start return for\n" + // hidden text
              "Returns 4 IM9001144800"
          )
        )

      case _ =>
        throw new Exception("Scenario doesn't exist")
    }
  }

  def noOverdueReturnsLink(): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText
    Assert.assertFalse(htmlBody.contains("View your clients with overdue returns"))
  }

  def noViewClientsLink(): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText
    Assert.assertFalse(htmlBody.contains("View all your clients"))
  }

  def selectClientReturnLink(link: String): Unit =
    clickCssSelector(link)

  def checkIntermediaryReturnsJourneyUrl(page: String): Unit =
    getCurrentUrl should startWith(s"$intermediaryReturnsUrl$intermediaryReturnsJourneyUrl/$page")

  def checkStartReturnDynamic(monthsAgo: String): Unit = {

    val returnYear = LocalDate.now().minusMonths(1).getYear

    val returnMonth = if (monthsAgo == "one") {
      LocalDate.now().minusMonths(1).getMonthValue
    } else {
      LocalDate.now().minusMonths(2).getMonthValue
    }

    val periodString = s"$returnYear-M$returnMonth"

    getCurrentUrl should startWith(s"$intermediaryReturnsUrl$intermediaryReturnsJourneyUrl/$periodString/start-return")

  }

  def checkHeading(heading: String): Unit = {
    val heading = Driver.instance.findElement(By.tagName("h1")).getText
    Assert.assertTrue(heading.equals(heading))
  }
}
