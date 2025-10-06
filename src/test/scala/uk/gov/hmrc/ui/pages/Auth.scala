/*
 * Copyright 2023 HM Revenue & Customs
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

import org.openqa.selenium.By
import org.scalatest.matchers.should.Matchers.*
import uk.gov.hmrc.configuration.TestEnvironment

object Auth extends BasePage {

  private val authUrl: String      = TestEnvironment.url("auth-login-stub") + "/auth-login-stub/gg-sign-in"
  private val dashboardUrl: String =
    TestEnvironment.url("ioss-intermediary-dashboard-frontend")
  private val journeyUrl: String   = "/pay-clients-vat-on-eu-sales/manage-ioss-returns-payments-clients"

  def goToAuthorityWizard(): Unit =
    get(authUrl)

  def loginUsingAuthorityWizard(
    withIntEnrolment: Boolean,
    withVatEnrolment: Boolean,
    vrnType: String,
    intNumberType: String
  ): Unit = {

    getCurrentUrl should startWith(authUrl)

    sendKeys(By.name("redirectionUrl"), s"$dashboardUrl$journeyUrl")

    selectByValue(By.id("affinityGroupSelect"), "Organisation")

    if (withVatEnrolment) {
      sendKeys(By.id("enrolment[0].name"), "HMRC-MTD-VAT")
      sendKeys(By.id("input-0-0-name"), "VRN")
      if (vrnType == "notFound") {
        sendKeys(By.id("input-0-0-value"), "900000001")
      } else if (vrnType == "internalServerError") {
        sendKeys(By.id("input-0-0-value"), "800000001")
      } else if (vrnType == "individual") {
        sendKeys(By.id("input-0-0-value"), "700000002")
      } else {
        sendKeys(By.id("input-0-0-value"), "100000001")
      }
    }
    if (withIntEnrolment) {
      sendKeys(By.id("enrolment[1].name"), "HMRC-IOSS-INT")
      sendKeys(By.id("input-1-0-name"), "IntNumber")
      if (intNumberType == "noPending") {
        sendKeys(By.id("input-1-0-value"), "IN9001112224")
      } else if (intNumberType == "onePending") {
        sendKeys(By.id("input-1-0-value"), "IN9001112225")
      } else if (intNumberType == "multipleActiveAndPreviousRegistrations") {
        sendKeys(By.id("input-1-0-value"), "IN9001234567")
      } else if (intNumberType == "onlyActiveRegistrations") {
        sendKeys(By.id("input-1-0-value"), "IN9008888887")
      } else if (intNumberType == "onlyPreviousRegistrations") {
        sendKeys(By.id("input-1-0-value"), "IN9008888886")
      } else if (intNumberType == "noRegistrations") {
        sendKeys(By.id("input-1-0-value"), "IN9008888888")
      } else if (intNumberType == "excludedPast") {
        sendKeys(By.id("input-1-0-value"), "IN9002323232")
      } else if (intNumberType == "excludedFuture") {
        sendKeys(By.id("input-1-0-value"), "IN9003232323")
      } else if (intNumberType == "reversal") {
        sendKeys(By.id("input-1-0-value"), "IN9003233333")
      } else {
        sendKeys(By.id("input-1-0-value"), "IN9001112223")
      }
    }

    click(By.cssSelector("Input[value='Submit']"))

  }

}
