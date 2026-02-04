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

class SavedReturnSpec extends BaseSpec {

  private val dashboard   = Dashboard
  private val auth        = Auth
  private val startReturn = StartReturn
  private val savedReturn = SavedReturn

  Feature("Saved returns") {

    Scenario(
      "Intermediary has saved returns for multiple clients"
    ) {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "multipleSavedReturns")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'Continue a return in progress' link on the dashboard")
      dashboard.clickLink("continue-return")

      Then(
        "the intermediary is shown their clients with saved returns"
      )
      dashboard.checkJourneyUrl("select-client-saved-return")
      savedReturn.savedReturnsAvailable("multipleSavedReturns")

      And("the intermediary selects the saved return for IM9006655442")
      savedReturn.selectSavedReturn("IM9006655442")

      Then("the intermediary is redirected to the returns service to complete the return")
      startReturn.checkIntermediaryReturnsRedirect()
    }

    Scenario(
      "Intermediary has a saved return for one client"
    ) {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "singleSavedReturn")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'Continue a return in progress' link on the dashboard")
      dashboard.clickLink("continue-return")

      Then("the intermediary is redirected to the returns service to complete the return")
      startReturn.checkIntermediaryReturnsRedirect()
    }

    Scenario(
      "Intermediary can delete a saved return"
    ) {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "multipleSavedReturns")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'Continue a return in progress' link on the dashboard")
      dashboard.clickLink("continue-return")

      Then(
        "the intermediary is shown their clients with saved returns"
      )
      dashboard.checkJourneyUrl("select-client-saved-return")
      savedReturn.savedReturnsAvailable("multipleSavedReturns")

      And("the intermediary selects the saved return for IM9006655443")
      savedReturn.selectSavedReturn("IM9006655443")

      Then("the intermediary is redirected to the returns service to complete the return")
      startReturn.checkIntermediaryReturnsRedirect()
    }
  }
}
