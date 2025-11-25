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

  private val dashboard           = Dashboard
  private val auth                = Auth
  private val viewRegistration    = ViewRegistration

  Feature("View clients submitted returns list") {

    Scenario("Intermediary views submitted returns list where they have multiple active clients and multiple previous clients") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "multipleActiveAndPreviousRegistrations")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'View submitted returns' link on the dashboard")
      dashboard.clickLink("view-return")

      Then("the intermediary is shown their client's submitted returns list with multiple active clients and multiple previous clients")
      dashboard.checkJourneyUrl("client-returns-list")
      viewRegistration.activeClients(true)
      viewRegistration.previousClients(true)
    }

    Scenario("Intermediary views submitted returns list with only active clients") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "onlyActiveRegistrations")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'View submitted returns' link on the dashboard")
      dashboard.clickLink("view-return")

      Then("the intermediary is shown their client's submitted returns list with only active clients and no previous clients")
      dashboard.checkJourneyUrl("client-returns-list")
      viewRegistration.activeClients(true)
      viewRegistration.previousClients(false)
    }

    Scenario("Intermediary views client's submitted returns list with only previous clients") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "onlyPreviousRegistrations")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'View submitted returns' link on the dashboard")
      dashboard.clickLink("view-return")

      Then("the intermediary is shown their client's submitted returns list with only previous clients and no active clients")
      dashboard.checkJourneyUrl("client-returns-list")
      viewRegistration.activeClients(false)
      viewRegistration.previousClients(true)
    }

    Scenario("Intermediary views client's submitted returns list with no active or previous clients") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "noRegistrations")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'View submitted returns' link on the dashboard")
      dashboard.clickLink("view-return")

      Then("the intermediary is shown their client's submitted returns list with no active clients and no previous clients")
      dashboard.checkJourneyUrl("client-returns-list")
      viewRegistration.activeClients(false)
      viewRegistration.previousClients(false)
    }

//    Following further development, will also need to add further steps/scenarios to check:
//    Clients who do not have any submitted returns are not on the list
//    Click through to view returns, single, multiple, over multiple years etc
//    Viewing returns from previous IOSS registrations
  }
}
