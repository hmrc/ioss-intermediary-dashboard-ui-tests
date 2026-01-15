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

object SubmittedReturn extends BasePage {

  def noReturnsSubmitted(show: Boolean): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText
    val text     = "You have not completed any returns."

    if (show == true) {
      Assert.assertTrue(htmlBody.contains(text))
    } else {
      Assert.assertFalse(htmlBody.contains(text))
    }
  }

  def showInset(show: Boolean): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText
    val text     = "If your client does not appear on this list, then you have not completed any returns for them."

    if (show) {
      Assert.assertTrue(htmlBody.contains(text))
    } else {
      Assert.assertFalse(htmlBody.contains(text))
    }
  }

  def clientsDisplayed(scenario: String): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText
    scenario match {
      case "multipleActiveAndPreviousRegistrations"    =>
        Assert.assertTrue(
          htmlBody.contains(
            "Active clients\n" +
              "Client name IOSS number\n" +
              "View returns for\n" + // hidden text
              "First Client IM9001144771\n" +
              "View returns for\n" + // hidden text
              "Seventh Client IM9001144777\n" +
              "Previous clients that have left the service\n" +
              "Client name IOSS number\n" +
              "View returns for\n" + // hidden text
              "Second Client IM9001144772"
          )
        )
      case "onlyActiveRegistrations"                   =>
        Assert.assertTrue(
          htmlBody.contains(
            "Active clients\n" +
              "Client name IOSS number\n" +
              "View returns for\n" + // hidden text
              "Active Client 2 IM9001144882"
          )
        )
      case "onlyPreviousRegistrations"                 =>
        Assert.assertTrue(
          htmlBody.contains(
            "Previous clients that have left the service\n" +
              "Client name IOSS number\n" +
              "View returns for\n" + // hidden text
              "Previous Client 1 IM9001144884\n" +
              "View returns for\n" + // hidden text
              "Previous Client 2 IM9001144885\n" +
              "View returns for\n" + // hidden text
              "Previous Client 3 IM9001144886"
          )
        )
      case "multipleIntermediaryNewestRegistration"    =>
        Assert.assertTrue(
          htmlBody.contains(
            "Active clients\n" +
              "Client name IOSS number\n" +
              "View returns for\n" + // hidden text
              "New Client Five IM9001144671" +
              "View returns for\n" + // hidden text
              "New Client Six IM9001144672"
          )
        )
      case "multipleIntermediaryOldestRegistration"    =>
        Assert.assertTrue(
          htmlBody.contains(
            "Active clients\n" +
              "Client name IOSS number\n" +
              "View returns for\n" + // hidden text
              "New Client One IM9001144667" +
              "View returns for\n" + // hidden text
              "New Client Two IM9001144668"
          )
        )
      case "multipleIntermediaryMiddleRegistration"    =>
        Assert.assertTrue(
          htmlBody.contains(
            "Active clients\n" +
              "Client name IOSS number\n" +
              "View returns for\n" + // hidden text
              "New Client Four IM9001144670" +
              "View returns for\n" + // hidden text
              "New Client Three IM9001144669"
          )
        )
      case "onePreviousIntermediaryNewestRegistration" =>
        Assert.assertTrue(
          htmlBody.contains(
            "Active clients\n" +
              "Client name IOSS number\n" +
              "View returns for\n" + // hidden text
              "Current Reg - Client One IM9002144671" +
              "View returns for\n" + // hidden text
              "Current Reg - Client Two IM9002144672"
          )
        )
      case "onePreviousIntermediaryOldestRegistration" =>
        Assert.assertTrue(
          htmlBody.contains(
            "Active clients\n" +
              "Client name IOSS number\n" +
              "View returns for\n" + // hidden text
              "Single Previous Reg - Client One IM9002144669" +
              "View returns for\n" + // hidden text
              "Single Previous Reg - Client Two IM9002144670"
          )
        )
      case _                                           =>
        throw new Exception("Scenario doesn't exist")
    }
  }
}
