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

package uk.gov.hmrc.ui.specs

import uk.gov.hmrc.ui.pages.*

class ViewRegistrationsSpec extends BaseSpec {

  private val dashboard           = Dashboard
  private val auth                = Auth
  private val viewRegistration    = ViewRegistration
  private val pendingRegistration = PendingRegistration
  private val tileLinks           = TileLinks

  Feature("View and remove registration list") {

    Scenario("Intermediary has multiple active clients and multiple previous clients") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "multipleActiveAndPreviousRegistrations")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'View, edit or remove a client' link on the dashboard")
      dashboard.clickLink("edit-client")

      Then("the intermediary is shown their client list with multiple active clients and multiple previous clients")
      dashboard.checkJourneyUrl("client-list")
      viewRegistration.noActiveClients(false)
      viewRegistration.activeClients(true)
      viewRegistration.previousClients(true)

      When("the intermediary clicks on the client name for IM9001144771")
      pendingRegistration.selectClientLink("start-amend-journey\\/IM9001144771")

      Then("the intermediary is redirected to the amend journey within the registration service")
//      Change your registration page not currently implemented
      tileLinks.checkRegistrationJourneyUrl("start-amend-journey/IM9001144771")

      When("the intermediary navigates back to the client list and clicks on the remove link for IM9001144773")
      dashboard.clickBackButton()
      dashboard.checkJourneyUrl("client-list")
      pendingRegistration.selectClientLink("start-journey\\/IM9001144773")

      Then("the intermediary is redirected to the exclusions service")
      tileLinks.checkNetpExclusionsJourneyUrl()

      When("the intermediary navigates back to the client list and clicks on the client name for IM9001144774")
      dashboard.clickBackButton()
      dashboard.checkJourneyUrl("client-list")
      pendingRegistration.selectClientLink("start-amend-journey\\/IM9001144774")

      Then("the intermediary is redirected to the amend journey within the registration service")
      //      Change your registration page not currently implemented
      tileLinks.checkRegistrationJourneyUrl("start-amend-journey/IM9001144774")
    }

    Scenario("Intermediary views client list with only active clients") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "onlyActiveRegistrations")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'View, edit or remove a client' link on the dashboard")
      dashboard.clickLink("edit-client")

      Then("the intermediary is shown their client list with only active clients and no previous clients")
      dashboard.checkJourneyUrl("client-list")
      viewRegistration.noActiveClients(false)
      viewRegistration.activeClients(true)
      viewRegistration.previousClients(false)

      When("the intermediary clicks on the remove link for IM9001144881")
      pendingRegistration.selectClientLink("start-journey\\/IM9001144881")

      Then("the intermediary is redirected to the exclusions service")
      tileLinks.checkNetpExclusionsJourneyUrl()

      When("the intermediary navigates back to the client list and clicks on the client name for IM9001144882")
      dashboard.clickBackButton()
      dashboard.checkJourneyUrl("client-list")
      pendingRegistration.selectClientLink("start-amend-journey\\/IM9001144882")

      Then("the intermediary is redirected to the amend journey within the registration service")
      //      Change your registration page not currently implemented
      tileLinks.checkRegistrationJourneyUrl("start-amend-journey/IM9001144882")
    }

    Scenario("Intermediary views client list with only previous clients") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "onlyPreviousRegistrations")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'View, edit or remove a client' link on the dashboard")
      dashboard.clickLink("edit-client")

      Then("the intermediary is shown their client list with only previous clients and no active clients")
      dashboard.checkJourneyUrl("client-list")
      viewRegistration.noActiveClients(true)
      viewRegistration.activeClients(false)
      viewRegistration.previousClients(true)

      When("the intermediary clicks on the client name for IM9001144886")
      pendingRegistration.selectClientLink("start-amend-journey\\/IM9001144886")

      Then("the intermediary is redirected to the amend journey within the registration service")
      //      Change your registration page not currently implemented
      tileLinks.checkRegistrationJourneyUrl("start-amend-journey/IM9001144886")
    }

    Scenario("Intermediary views client list with no active or previous clients") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "noRegistrations")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'View, edit or remove a client' link on the dashboard")
      dashboard.clickLink("edit-client")

      Then("the intermediary is shown their client list with no active clients and no previous clients")
      dashboard.checkJourneyUrl("client-list")
      viewRegistration.noActiveClients(true)
      viewRegistration.activeClients(false)
      viewRegistration.previousClients(false)
    }
  }
}
