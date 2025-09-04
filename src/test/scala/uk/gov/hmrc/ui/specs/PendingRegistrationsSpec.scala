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

class PendingRegistrationsSpec extends BaseSpec {

  private val dashboard           = Dashboard
  private val auth                = Auth
  private val tileLinks           = TileLinks
  private val pendingRegistration = PendingRegistration

  Feature("Pending registration journeys") {

    Scenario("Intermediary can view their clients awaiting activation") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "default")
      dashboard.checkJourneyUrl("your-account")

      Then("the clients awaiting activation warning is displayed")
      pendingRegistration.checkClientsAwaitingActivationWarning(true)

      When("the intermediary clicks the '5 clients awaiting activation' link on the dashboard")
      dashboard.clickLink("pending-client-plural")

      Then("the intermediary is on the client-awaiting-activation page")
      dashboard.checkJourneyUrl("client-awaiting-activation")

      And("there are 5 clients awaiting activation")
      pendingRegistration.checkClientsAwaitingActivationHeading("plural")

      When("the intermediary selects the first client in the list")
      pendingRegistration.selectClientLink("client-not-activated\\/08c11d8b-e3e7-47b1-9fb1-d4efab81821d")

      Then("the intermediary is on the client-not-activated page for the first client in the list")
      tileLinks.checkRegistrationJourneyUrl("client-not-activated/08c11d8b-e3e7-47b1-9fb1-d4efab81821d")
      pendingRegistration.checkClientName("Company Name")

      When("the intermediary clicks the back button")
      dashboard.clickBackButton()

      And("the intermediary selects the third client in the list")
      dashboard.checkJourneyUrl("client-awaiting-activation")
      pendingRegistration.selectClientLink("client-not-activated\\/f97dc31b-5234-4f6c-94a7-b8bec5841a28")

      Then("the intermediary is on the client-not-activated page for the third client in the list")
      tileLinks.checkRegistrationJourneyUrl("client-not-activated/f97dc31b-5234-4f6c-94a7-b8bec5841a28")
      pendingRegistration.checkClientName("A different business name")
    }

    Scenario("Intermediary has no clients awaiting activation") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "noPending")
      dashboard.checkJourneyUrl("your-account")

      Then("the clients awaiting activation warning is not displayed")
      pendingRegistration.checkClientsAwaitingActivationWarning(false)

      And("there is no link for clients awaiting activation on the dashboard")
      pendingRegistration.noClientsAwaitingActivationLink()
    }

    Scenario("Intermediary has one client awaiting activation") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "onePending")
      dashboard.checkJourneyUrl("your-account")

      Then("the clients awaiting activation warning is displayed")
      pendingRegistration.checkClientsAwaitingActivationWarning(true)

      When("the intermediary clicks the '1 client awaiting activation' link on the dashboard")
      dashboard.clickLink("pending-client-singular")

      Then("the intermediary is on the client-awaiting-activation page")
      dashboard.checkJourneyUrl("client-awaiting-activation")

      And("there is 1 client awaiting activation")
      pendingRegistration.checkClientsAwaitingActivationHeading("single")

      When("the intermediary selects the only client in the list")
      pendingRegistration.selectClientLink("client-not-activated\\/6bf0b5aa-c9f1-4860-8bf4-a428c033c954")

      Then("the intermediary is on the client-not-activated page for the only client in the list")
      tileLinks.checkRegistrationJourneyUrl("client-not-activated/6bf0b5aa-c9f1-4860-8bf4-a428c033c954")
      pendingRegistration.checkClientName("1 registration")
    }
  }
}
