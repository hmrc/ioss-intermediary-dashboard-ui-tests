/*
 * Copyright 2026 HM Revenue & Customs
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

class ReviewRegistrationSpec extends BaseSpec {

  private val dashboard = Dashboard
  private val auth      = Auth
  private val tileLinks = TileLinks

  Feature("Intermediary registration has not been updated for over 2 years") {

    Scenario(
      "Intermediary attempts to start return for client and has not updated their registration for 2 years - update registration "
    ) {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "reviewRegistration")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'Start a return' link on the dashboard")
      dashboard.clickLink("start-a-return")

      And("the intermediary is on the review-registration-intercept page")
      dashboard.checkJourneyUrl("review-registration-intercept")

      When("the intermediary clicks on the Review your registration details link")
      dashboard.clickCssSelector("start-amend-journey")

      Then(
        "the intermediary is redirected to the registration service to review their registration"
      )
      tileLinks.checkIntermediaryRegistrationJourneyUrl("change-your-registration")
    }

    Scenario(
      "Intermediary attempts to start return for client and has not updated their registration for 2 years - skip update registration "
    ) {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "reviewRegistration")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'Start a return' link on the dashboard")
      dashboard.clickLink("start-a-return")

      And("the intermediary is on the review-registration-intercept page")
      dashboard.checkJourneyUrl("review-registration-intercept")

      When("the intermediary clicks on the Skip for now button")
      dashboard.clickLink("skip")

      Then(
        "the intermediary is shown their clients with returns due"
      )
      dashboard.checkJourneyUrl("client-outstanding-returns-list")
    }
  }
}
