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

package uk.gov.hmrc.ui.specs

import uk.gov.hmrc.ui.pages.*

class UnusableEmailSpec extends BaseSpec {

  private val dashboard = Dashboard
  private val auth      = Auth

  Feature("Unusable email journey") {

    Scenario("When intermediary logs in with unusable email status, they are presented with the intercept page instead of the dashboard tiles") {

      Given("the intermediary logs in")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "unusableEmailStatus")

      Then("the intermediary is on the intercept-unusable-email page")
      dashboard.checkJourneyUrl("intercept-unusable-email")
    }
  }
}
