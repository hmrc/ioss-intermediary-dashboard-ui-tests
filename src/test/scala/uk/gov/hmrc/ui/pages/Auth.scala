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

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.scalatest.matchers.should.Matchers.*
import uk.gov.hmrc.configuration.TestEnvironment

object Auth extends BasePage {

  private val authUrl: String      = TestEnvironment.url("auth-login-stub") + "/auth-login-stub/gg-sign-in"
  private val dashboardUrl: String =
    TestEnvironment.url("ioss-intermediary-dashboard-frontend")
  private val journeyUrl: String   = "/pay-clients-vat-on-eu-sales/manage-ioss-returns-payments-clients"

  def goToAuthorityWizard(): Unit =
    get(authUrl)
    fluentWait.until(ExpectedConditions.urlContains(authUrl))

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
      val vrn = vrnType match {
        case "notFound"            => "900000001"
        case "internalServerError" => "800000001"
        case "individual"          => "700000002"
        case "nonNiAddress"        => "700000003"
        case _                     => "100000001"
      }
      sendKeys(By.id("input-0-0-value"), vrn)
    }

    if (withIntEnrolment) {
      sendKeys(By.id("enrolment[1].name"), "HMRC-IOSS-INT")
      sendKeys(By.id("input-1-0-name"), "IntNumber")

      val intNumber = intNumberType match {
        case "noPending" | "noUnreadSecureMessages"                           => "IN9001112224"
        case "onePending"                                                     => "IN9001112225"
        case "multipleActiveAndPreviousRegistrations" | "threeSecureMessages" => "IN9001234567"
        case "onlyActiveRegistrations"                                        => "IN9008888887"
        case "onlyPreviousRegistrations"                                      => "IN9008888886"
        case "noRegistrations"                                                => "IN9008888888"
        case "excludedPast"                                                   => "IN9002323232"
        case "excludedFuture"                                                 => "IN9003232323"
        case "reversal"                                                       => "IN9003233333"
        case "twoSecureMessages"                                              => "IN9001234012"
        case "oneSecureMessage"                                               => "IN9001234013"
        case "quarantined"                                                    => "IN9002323334"
        case "quarantineExpired"                                              => "IN9002323335"
        case "activeNoReturns"                                                => "IN9001144663"
        case "previousNoReturns"                                              => "IN9001144665"
        case "noReturnsDue"                                                   => "IN9008888885"
        case "noOverdueReturns"                                               => "IN9008888884"
        case "dueReturnsSomeOverdue"                                          => "IN9008888883"
        case "netpOutstandingReturns"                                         => "IN9000306832"
        case "netpNoOutstandingReturns"                                       => "IN9000306831"
        case "unusableEmailStatus"                                            => "IN9002222222"
        case "multipleSavedReturns"                                           => "IN9006655444"
        case "singleSavedReturn"                                              => "IN9006655555"
        case "hmrcExcludedOutstandingReturns"                                 => "IN9000306833"
        case "hmrcExcludedNoOutstandingReturns"                               => "IN9000306834"
        case "quarantinedOutstandingReturns"                                  => "IN9000306835"
        case "quarantinedNoOutstandingReturns"                                => "IN9000306836"
        case _                                                                => "IN9001112223"
      }
      sendKeys(By.id("input-1-0-value"), intNumber)
    }
    click(By.cssSelector("Input[value='Submit']"))

    if (vrnType == "nonNiAddress") {
      fluentWait.until(ExpectedConditions.urlContains("has-business-address-in-ni?waypoints=change-your-registration"))
    }
  }

}
