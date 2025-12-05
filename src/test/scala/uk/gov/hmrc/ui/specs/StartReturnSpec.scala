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

class StartReturnSpec extends BaseSpec {

  private val dashboard   = Dashboard
  private val auth        = Auth
  private val startReturn = StartReturn

  Feature("Start client returns list") {

    Scenario(
      "Intermediary views start returns list where all clients have overdue returns"
    ) {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "multipleActiveAndPreviousRegistrations")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'Start a return' link on the dashboard")
      dashboard.clickLink("start-a-return")

      Then(
        "the intermediary is shown their clients with returns due, in the correct order"
      )
      dashboard.checkJourneyUrl("client-outstanding-returns-list")
      startReturn.checkHeading("Which clients return do you want to start?")
      startReturn.clientsWithReturns("allReturnsOverdue")

      When("the intermediary clicks on Eighth Client")
      startReturn.selectClientReturnLink("start-return-as-intermediary\\/IM9001144778")

      Then("the intermediary is redirected to the returns service to start the return")
      //      Not showing the correct return
      //      startReturn.checkIntermediaryReturnsJourneyUrl("2025-M1/start-return")
    }

    Scenario(
      "Intermediary views overdue returns list for their clients who all have overdue returns"
    ) {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "multipleActiveAndPreviousRegistrations")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'Start a return' link on the dashboard")
      dashboard.clickLink("start-a-return")
      dashboard.checkJourneyUrl("client-outstanding-returns-list")

      Then("the intermediary clicks on the 'View your clients with overdue returns' link")
      startReturn.selectClientReturnLink("client-overdue-returns-list")

      Then(
        "the intermediary is shown their clients with overdue returns, in the correct order"
      )
      dashboard.checkJourneyUrl("client-overdue-returns-list")
      startReturn.checkHeading("Start an overdue return")
      startReturn.clientsWithReturns("allReturnsOverdue")

      When("the intermediary clicks on Seventh Client")
      startReturn.selectClientReturnLink("start-return-as-intermediary\\/IM9001144777")

      Then("the intermediary is redirected to the returns service to start the return")
      //      Will not work until VEI-661 is merged
      //      startReturn.checkIntermediaryReturnsJourneyUrl("2025-M3/start-return")
    }

    Scenario(
      "Intermediary has returns due for two of their four clients, but no overdue returns"
    ) {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "noOverdueReturns")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'Start a return' link on the dashboard")
      dashboard.clickLink("start-a-return")

      Then(
        "the intermediary is shown their clients with returns due, in the correct order"
      )
      dashboard.checkJourneyUrl("client-outstanding-returns-list")
      startReturn.checkHeading("Which clients return do you want to start?")
      startReturn.clientsWithReturns("twoReturnsDue")
      startReturn.noOverdueReturnsLink()

      When("the intermediary clicks on Returns 2")
      startReturn.selectClientReturnLink("start-return-as-intermediary\\/IM9001144844")

      Then("the intermediary is redirected to the returns service to start the return")
      //      Will not work until VEI-661 is merged
//            startReturn.checkStartReturnDynamic("one")
    }

    Scenario(
      "Intermediary has overdue returns but not all returns due are overdue"
    ) {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "dueReturnsSomeOverdue")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'Start a return' link on the dashboard")
      dashboard.clickLink("start-a-return")

      Then(
        "the intermediary is shown their clients with returns due, in the correct order"
      )
      dashboard.checkJourneyUrl("client-outstanding-returns-list")
      startReturn.checkHeading("Which clients return do you want to start?")
      startReturn.clientsWithReturns("fourReturnsDue")

      When("the intermediary clicks on Returns 1")
      startReturn.selectClientReturnLink("start-return-as-intermediary\\/IM9001144877")

      Then("the intermediary is redirected to the returns service to start the return")
      //      Will not work until VEI-661 is merged
      //            startReturn.checkStartReturnDynamic("one")

      When("the intermediary manually navigates back to their returns due list")
      dashboard.goToPage("client-outstanding-returns-list")

      Then("the intermediary clicks on the 'View your clients with overdue returns' link")
      dashboard.checkJourneyUrl("client-outstanding-returns-list")
      startReturn.selectClientReturnLink("client-overdue-returns-list")

      Then(
        "the intermediary is shown their clients with overdue returns, in the correct order"
      )
      dashboard.checkJourneyUrl("client-overdue-returns-list")
      startReturn.checkHeading("Start an overdue return")
      startReturn.clientsWithReturns("twoReturnsOverdue")

      When("the intermediary clicks on Returns 3")
      startReturn.selectClientReturnLink("start-return-as-intermediary\\/IM9001144899")

      Then("the intermediary is redirected to the returns service to start the return")
      //      Will not work until VEI-661 is merged
      //            startReturn.checkStartReturnDynamic("two")
    }

    Scenario(
      "Intermediary has no returns due for their clients"
    ) {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "noReturnsDue")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'Start a return' link on the dashboard")
      dashboard.clickLink("start-a-return")

      Then(
        "the intermediary is shown they have no returns due"
      )
      dashboard.checkJourneyUrl("client-outstanding-returns-list")
      startReturn.checkHeading("You do not have any clients with outstanding returns on your account")
      startReturn.noOverdueReturnsLink()

      When("the intermediary manually navigates to the overdue ")
      dashboard.goToPage("client-overdue-returns-list")

      Then("the intermediary is shown they have no overdue returns")
      dashboard.checkJourneyUrl("client-overdue-returns-list")
      startReturn.checkHeading("You do not have any clients with outstanding returns on your account")
      startReturn.noViewClientsLink()
    }
  }
}
