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

object ViewRegistration extends BasePage {

  def noActiveClients(show: Boolean): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText
    val text     = "You have no active clients"

    if (show == true) {
      Assert.assertTrue(htmlBody.contains(text))
    } else {
      Assert.assertFalse(htmlBody.contains(text))
    }
  }

  def activeClients(show: Boolean): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText
    val text     = "Active clients"

    if (show == true) {
      Assert.assertTrue(htmlBody.contains(text))
    } else {
      Assert.assertFalse(htmlBody.contains(text))
    }
  }

  def previousClients(show: Boolean): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText
    val text     = "Previous clients that have left the service"

    if (show == true) {
      Assert.assertTrue(htmlBody.contains(text))
    } else {
      Assert.assertFalse(htmlBody.contains(text))
    }
  }

  def clientsDisplayed(scenario: String): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText

    scenario match {
      case "multipleIntermediaryNewestRegistration"    =>
        Assert.assertTrue(
          htmlBody.contains(
            "Active clients\n" +
              "Client name IOSS number\n" +
              "Change client details for\n" + // hidden text
              "New Client Five IM9001144671 Remove\n" +
              "Remove client details for New Client Five\n" + // hidden text
              "Change client details for\n" + // hidden text
              "New Client Six IM9001144672 Remove\n" +
              "Remove client details for New Client Six" // hidden text
          )
        )
      case "multipleIntermediaryOldestRegistration"    =>
        Assert.assertTrue(
          htmlBody.contains(
            "Client name IOSS number\n" +
              "Change client details for\n" + // hidden text
              "New Client One IM9001144667\n" +
              "Change client details for\n" + // hidden text
              "New Client Two IM9001144668"
          )
        )
      case "multipleIntermediaryMiddleRegistration"    =>
        Assert.assertTrue(
          htmlBody.contains(
            "Client name IOSS number\n" +
              "Change client details for\n" + // hidden text
              "New Client Three IM9001144669\n" +
              "Change client details for\n" + // hidden text
              "New Client Four IM9001144670"
          )
        )
      case "onePreviousIntermediaryNewestRegistration" =>
        Assert.assertTrue(
          htmlBody.contains(
            "Active clients\n" +
              "Client name IOSS number\n" +
              "Change client details for\n" + // hidden text
              "Current Reg - Client One IM9002144671 Remove\n" +
              "Remove client details for Current Reg - Client One\n" + // hidden text
              "Change client details for\n" + // hidden text
              "Current Reg - Client Two IM9002144672 Remove\n" +
              "Remove client details for Current Reg - Client Two" // hidden text
          )
        )
      case "onePreviousIntermediaryOldestRegistration" =>
        Assert.assertTrue(
          htmlBody.contains(
            "Client name IOSS number\n" +
              "Change client details for\n" + // hidden text
              "Single Previous Reg - Client One IM9002144669\n" +
              "Change client details for\n" + // hidden text
              "Single Previous Reg - Client Two IM9002144670"
          )
        )
      case _                                           =>
        throw new Exception("Scenario doesn't exist")
    }
  }
}
