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

class PreviousRegistrationsSpec extends BaseSpec {

  private val dashboard            = Dashboard
  private val auth                 = Auth
  private val submittedReturn      = SubmittedReturn
  private val startReturn          = StartReturn
  private val previousRegistration = PreviousRegistration

  Feature("View clients submitted returns list when the intermediary has previous registrations") {

    Scenario(
      "Intermediary has multiple previous registrations"
    ) {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "multipleIntermediaryRegistrations")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'View submitted returns' link on the dashboard")
      dashboard.clickLink("view-return")

      Then(
        "the intermediary is shown their client's submitted returns list for their current registration"
      )
      dashboard.checkJourneyUrl("client-returns-list")
      submittedReturn.noReturnsSubmitted(false)
      submittedReturn.showInset(true)
      submittedReturn.clientsDisplayed("multipleIntermediaryNewestRegistration")

      And("the correct link is displayed to allow intermediary to view returns from previous registrations")
      previousRegistration.multiplePreviousRegistrationsLink("multiple")

      When("the intermediary clicks the 'View clients and returns from your previous IOSS registrations' link")
      previousRegistration.viewPreviousRegistrations("client-previous-registration-list")

      Then("the intermediary selects the returns for IN9000230002")
      dashboard.checkJourneyUrl("client-previous-registration-list")
      previousRegistration.selectPreviousRegistration("IN9000230002")

      And("the correct clients are displayed with returns for IN9000230002")
      dashboard.checkJourneyUrl("client-previous-registration-returns-list")
      previousRegistration.checkIntermediaryNumber("IN9000230002")
      submittedReturn.clientsDisplayed("multipleIntermediaryOldestRegistration")

      When("the intermediary clicks on 'New Client One'")
      startReturn.selectClientReturnLink("start-returns-history-as-intermediary\\/IM9001144667")

      Then("the intermediary is redirected to the submitted return on the IOSS returns service")
      startReturn.checkIntermediaryReturnsJourneyUrl("past-returns")

      When("the intermediary hits the back button the browser")
      dashboard.clickBackButton()

      Then("the intermediary clicks the 'Return to your current registration' link")
      dashboard.checkJourneyUrl("client-previous-registration-returns-list")
      previousRegistration.returnToCurrentRegistrationLink()

      And("the intermediary is back to the client list for their current return")
      dashboard.checkJourneyUrl("client-returns-list")

      When("the intermediary selects the 'View clients and returns from your previous IOSS registrations' link")
      previousRegistration.viewPreviousRegistrations("client-previous-registration-list")

      Then("the intermediary selects the returns for IN9001230002")
      dashboard.checkJourneyUrl("client-previous-registration-list")
      previousRegistration.selectPreviousRegistration("IN9001230002")

      And("the correct clients are displayed with returns for IN9001230002")
      dashboard.checkJourneyUrl("client-previous-registration-returns-list")
      previousRegistration.checkIntermediaryNumber("IN9001230002")
      submittedReturn.clientsDisplayed("multipleIntermediaryMiddleRegistration")

      When("the intermediary clicks on 'New Client Three'")
      startReturn.selectClientReturnLink("start-returns-history-as-intermediary\\/IM9001144669")

      Then("the intermediary is redirected to the submitted return on the IOSS returns service")
      startReturn.checkIntermediaryReturnsJourneyUrl("past-returns")

      When("the intermediary hits the back button the browser")
      dashboard.clickBackButton()

      Then("the intermediary clicks the 'Return to your current registration' link")
      dashboard.checkJourneyUrl("client-previous-registration-returns-list")
      previousRegistration.returnToCurrentRegistrationLink()

      And("the intermediary is back to the client list for their current return")
      dashboard.checkJourneyUrl("client-returns-list")

      When("the intermediary clicks on 'New Client Five'")
      startReturn.selectClientReturnLink("start-returns-history-as-intermediary\\/IM9001144671")

      Then("the intermediary is redirected to the submitted return on the IOSS returns service")
      startReturn.checkIntermediaryReturnsJourneyUrl("past-returns")
    }

    Scenario(
      "Intermediary has one previous registration"
    ) {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "onePreviousIntermediaryRegistration")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'View submitted returns' link on the dashboard")
      dashboard.clickLink("view-return")

      Then(
        "the intermediary is shown their client's submitted returns list for their current registration"
      )
      dashboard.checkJourneyUrl("client-returns-list")
      submittedReturn.noReturnsSubmitted(false)
      submittedReturn.showInset(true)
      submittedReturn.clientsDisplayed("onePreviousIntermediaryNewestRegistration")

      And("the correct link is displayed to allow intermediary to view returns from previous registrations")
      previousRegistration.multiplePreviousRegistrationsLink("single")

      When("the intermediary clicks the 'View clients and returns from your previous IOSS registrations' link")
      previousRegistration.viewPreviousRegistrations("client-previous-registration-list")

      And("the correct clients are displayed with returns for IN9001230001")
      dashboard.checkJourneyUrl("client-previous-registration-returns-list")
      previousRegistration.checkIntermediaryNumber("IN9001230001")
      submittedReturn.clientsDisplayed("onePreviousIntermediaryOldestRegistration")

      When("the intermediary clicks on 'Single Previous Reg - Client One'")
      startReturn.selectClientReturnLink("start-returns-history-as-intermediary\\/IM9002144669")

      Then("the intermediary is redirected to the submitted return on the IOSS returns service")
      startReturn.checkIntermediaryReturnsJourneyUrl("past-returns")

      When("the intermediary hits the back button the browser")
      dashboard.clickBackButton()

      Then("the intermediary clicks the 'Return to your current registration' link")
      dashboard.checkJourneyUrl("client-previous-registration-returns-list")
      previousRegistration.returnToCurrentRegistrationLink()

      And("the intermediary is back to the client list for their current return")
      dashboard.checkJourneyUrl("client-returns-list")

      When("the intermediary clicks on 'Current Reg - Client Two'")
      startReturn.selectClientReturnLink("start-returns-history-as-intermediary\\/IM9002144672")

      Then("the intermediary is redirected to the submitted return on the IOSS returns service")
      startReturn.checkIntermediaryReturnsJourneyUrl("past-returns")
    }
  }
}
