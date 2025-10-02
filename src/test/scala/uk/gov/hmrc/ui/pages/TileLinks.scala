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

import org.junit.Assert
import org.openqa.selenium.By
import org.scalatest.matchers.should.Matchers.*
import uk.gov.hmrc.configuration.TestEnvironment
import uk.gov.hmrc.selenium.webdriver.Driver

object TileLinks extends BasePage {

  private val registrationUrl: String        =
    TestEnvironment.url("ioss-netp-registration-frontend")
  private val registrationJourneyUrl: String = "/pay-clients-vat-on-eu-sales/register-new-ioss-client"

  private val intermediaryRegistrationUrl: String        =
    TestEnvironment.url("ioss-intermediary-registration-frontend")
  private val intermediaryRegistrationJourneyUrl: String =
    "/pay-clients-vat-on-eu-sales/register-import-one-stop-shop-intermediary"

  private val intermediaryExclusionsUrl: String        =
    TestEnvironment.url("ioss-intermediary-exclusions-frontend")
  private val intermediaryExclusionsJourneyUrl: String =
    "/pay-clients-vat-on-eu-sales/leave-import-one-stop-shop-intermediary"

  private val netpExclusionsUrl: String        =
    TestEnvironment.url("ioss-netp-exclusions-frontend")
  private val netpExclusionsJourneyUrl: String =
    "/pay-clients-vat-on-eu-sales/leave-import-one-stop-shop-netp"

  def checkRegistrationJourneyUrl(page: String): Unit =
    getCurrentUrl should startWith(s"$registrationUrl$registrationJourneyUrl/$page")

  def checkIntermediaryRegistrationJourneyUrl(page: String): Unit =
    getCurrentUrl should startWith(s"$intermediaryRegistrationUrl$intermediaryRegistrationJourneyUrl/$page")

  def checkIntermediaryExclusionsJourneyUrl(page: String): Unit =
    getCurrentUrl should startWith(s"$intermediaryExclusionsUrl$intermediaryExclusionsJourneyUrl/$page")

  def checkNetpExclusionsJourneyUrl(): Unit =
    getCurrentUrl should startWith(netpExclusionsUrl + netpExclusionsJourneyUrl)

  def noLeaveThisServiceLink(): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText
    Assert.assertFalse(htmlBody.contains("Leave this service"))
  }

}
