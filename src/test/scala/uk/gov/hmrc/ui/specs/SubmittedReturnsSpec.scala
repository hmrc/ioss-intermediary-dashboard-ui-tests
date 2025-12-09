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

class SubmittedReturnsSpec extends BaseSpec {

  private val dashboard        = Dashboard
  private val auth             = Auth
  private val viewRegistration = ViewRegistration
  private val submittedReturn  = SubmittedReturn
  private val startReturn      = StartReturn

  Feature("View clients submitted returns list") {

    Scenario(
      "Intermediary views submitted returns list where they have returns submitted for some of their active clients and previous clients"
    ) {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "multipleActiveAndPreviousRegistrations")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'View submitted returns' link on the dashboard")
      dashboard.clickLink("view-return")

      Then(
        "the intermediary is shown their client's submitted returns list with multiple active clients and multiple previous clients"
      )
      dashboard.checkJourneyUrl("client-returns-list")
      submittedReturn.noReturnsSubmitted(false)
      submittedReturn.showInset(true)
      submittedReturn.clientsDisplayed("multipleActiveAndPreviousRegistrations")
    }

    Scenario(
      "Intermediary views submitted returns list with only active clients where only one has submitted returns"
    ) {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "onlyActiveRegistrations")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'View submitted returns' link on the dashboard")
      dashboard.clickLink("view-return")

      Then(
        "the intermediary is shown their client's submitted returns list with only active clients and no previous clients"
      )
      dashboard.checkJourneyUrl("client-returns-list")
      submittedReturn.noReturnsSubmitted(false)
      submittedReturn.showInset(true)
      viewRegistration.previousClients(false)
      submittedReturn.clientsDisplayed("onlyActiveRegistrations")
    }

    Scenario(
      "Intermediary views client's submitted returns list with only previous clients who have all submitted returns"
    ) {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "onlyPreviousRegistrations")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'View submitted returns' link on the dashboard")
      dashboard.clickLink("view-return")

      Then(
        "the intermediary is shown their client's submitted returns list with only previous clients and no active clients"
      )
      dashboard.checkJourneyUrl("client-returns-list")
      submittedReturn.noReturnsSubmitted(false)
      submittedReturn.showInset(true)
      viewRegistration.activeClients(false)
      submittedReturn.clientsDisplayed("onlyPreviousRegistrations")
    }

    Scenario("Intermediary views client's submitted returns list with no active or previous clients") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "noRegistrations")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'View submitted returns' link on the dashboard")
      dashboard.clickLink("view-return")

      Then(
        "the intermediary has no returns to display"
      )
      dashboard.checkJourneyUrl("client-returns-list")
      submittedReturn.noReturnsSubmitted(true)
      submittedReturn.showInset(false)
      viewRegistration.activeClients(false)
      viewRegistration.previousClients(false)
    }

    Scenario(
      "Intermediary views client's submitted returns list with only active clients who have no returns submitted yet"
    ) {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "activeNoReturns")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'View submitted returns' link on the dashboard")
      dashboard.clickLink("view-return")

      Then(
        "the intermediary has no returns to display"
      )
      dashboard.checkJourneyUrl("client-returns-list")
      submittedReturn.noReturnsSubmitted(true)
      submittedReturn.showInset(false)
      viewRegistration.activeClients(false)
      viewRegistration.previousClients(false)
    }

    Scenario(
      "Intermediary views client's submitted returns list with only previous clients who have no returns submitted"
    ) {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "previousNoReturns")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'View submitted returns' link on the dashboard")
      dashboard.clickLink("view-return")

      Then(
        "the intermediary has no returns to display"
      )
      dashboard.checkJourneyUrl("client-returns-list")
      submittedReturn.noReturnsSubmitted(true)
      submittedReturn.showInset(false)
      viewRegistration.activeClients(false)
      viewRegistration.previousClients(false)
    }

    Scenario(
      "Intermediary views a submitted return for a client"
    ) {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "multipleActiveAndPreviousRegistrations")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'View submitted returns' link on the dashboard")
      dashboard.clickLink("view-return")

      Then(
        "the intermediary is shown their client's submitted returns list with multiple active clients and multiple previous clients"
      )
      dashboard.checkJourneyUrl("client-returns-list")

      And("the intermediary selects 'First Client'")
      startReturn.selectClientReturnLink("start-returns-history-as-intermediary\\/IM9001144771")

      Then("the intermediary is redirected to view their submitted returns in the returns service")
      startReturn.checkIntermediaryReturnsJourneyUrl("past-returns")
    }
  }
}
