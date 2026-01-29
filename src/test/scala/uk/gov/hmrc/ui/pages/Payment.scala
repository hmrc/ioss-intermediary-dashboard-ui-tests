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
import org.scalatest.matchers.should.Matchers.*
import uk.gov.hmrc.configuration.TestEnvironment

object Payment extends BasePage {

  val paymentsHost: String = TestEnvironment.url("pay-frontend")

  def noClients(show: Boolean): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText
    val text     = "You do not have any clients on your account"

    if (show == true) {
      Assert.assertTrue(htmlBody.contains(text))
    } else {
      Assert.assertFalse(htmlBody.contains(text))
    }
  }

  def checkClientList(): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText
    Assert.assertTrue(
      htmlBody.contains(
        "Client name IOSS number\n" +
          "Payment details for First Client\n" + // hidden text
          "First Client IM9001144771\n" +
          "Payment details for Second Client\n" + // hidden text
          "Second Client IM9001144772\n" +
          "Payment details for Third Client\n" + // hidden text
          "Third Client IM9001144773\n" +
          "Payment details for Fourth Client\n" + // hidden text
          "Fourth Client IM9001144774\n" +
          "Payment details for Fifth Client\n" + // hidden text
          "Fifth Client IM9001144775\n" +
          "Payment details for Sixth Client\n" + // hidden text
          "Sixth Client IM9001144776\n" +
          "Payment details for Seventh Client\n" + // hidden text
          "Seventh Client IM9001144777\n" +
          "Payment details for Eighth Client\n" + // hidden text
          "Eighth Client IM9001144778"
      )
    )
  }

  def selectClientForPayment(link: String): Unit =
    clickCssSelector(link)

  def checkSinglePaymentsUrl(): Unit =
    getCurrentUrl should startWith(s"$paymentsHost/pay/select-payment-amount?traceId=")

  def noOutstandingPayments(): Unit =
    val h1 = Driver.instance.findElement(By.tagName("h1")).getText
    Assert.assertTrue(h1.equals("You do not owe any Import One Stop Shop VAT"))

  def multiplePayments(): Unit = {
    val h1       = Driver.instance.findElement(By.tagName("h1")).getText
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText

    Assert.assertTrue(h1.equals("Which month would you like to make a payment for?"))
    Assert.assertTrue(
      htmlBody.contains(
        "£397.30 owed for February 2025\n" +
          "£1,397.30 owed for January 2025"
      )
    )
  }
}
