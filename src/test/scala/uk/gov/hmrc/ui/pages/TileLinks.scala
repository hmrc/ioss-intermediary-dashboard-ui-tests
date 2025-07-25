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

import org.scalatest.matchers.should.Matchers.*
import uk.gov.hmrc.configuration.TestEnvironment

object TileLinks extends BasePage {

  private val registrationUrl: String        =
    TestEnvironment.url("ioss-netp-registration-frontend")
  private val registrationJourneyUrl: String = "/pay-clients-vat-on-eu-sales/register-new-ioss-client"

  def checkRegistrationJourneyUrl(page: String): Unit =
    getCurrentUrl should startWith(s"$registrationUrl$registrationJourneyUrl/$page")

}
