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

class ExclusionsSpec extends BaseSpec {

  private val dashboard = Dashboard
  private val auth      = Auth
  private val exclusion = Exclusion

  Feature("Exclusion dashboard warnings") {

    Scenario("Self-excluded intermediary where NETPs have outstanding returns") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "netpOutstandingReturns")

      When("the intermediary is on their dashboard")
      dashboard.checkJourneyUrl("your-account")

      Then(
        "the correct warning is displayed for an intermediary who has left the service and has outstanding returns for a NETP"
      )
      exclusion.warningToShow("selfOutstanding")

      And("there is no 'Add a new client' link on the dashboard")
      exclusion.noAddClientLink()
    }

    Scenario("Self-excluded intermediary where NETPs have no outstanding returns") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "netpNoOutstandingReturns")

      When("the intermediary is on their dashboard")
      dashboard.checkJourneyUrl("your-account")

      Then(
        "the correct warning is displayed for an intermediary who has left the service and has no outstanding returns for a NETP"
      )
      exclusion.warningToShow("selfNoOutstanding")

      And("there is no 'Add a new client' link on the dashboard")
      exclusion.noAddClientLink()
    }

    Scenario("HMRC-excluded intermediary where NETPs have outstanding returns") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "hmrcExcludedOutstandingReturns")

      When("the intermediary is on their dashboard")
      dashboard.checkJourneyUrl("your-account")

      Then("the correct warning is displayed for an HMRC-excluded intermediary who has outstanding returns for a NETP")
      exclusion.warningToShow("hmrcOutstanding")

      And("there is no 'Add a new client' link on the dashboard")
      exclusion.noAddClientLink()
    }

    Scenario("HMRC-excluded intermediary where NETPs have no outstanding returns") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "hmrcExcludedNoOutstandingReturns")

      When("the intermediary is on their dashboard")
      dashboard.checkJourneyUrl("your-account")

      Then(
        "the correct warning is displayed for an HMRC-excluded intermediary who has no outstanding returns for a NETP"
      )
      exclusion.warningToShow("hmrcNoOutstanding")

      And("there is no 'Add a new client' link on the dashboard")
      exclusion.noAddClientLink()
    }

    Scenario("Quarantined intermediary where NETPs have outstanding returns") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "quarantinedOutstandingReturns")

      When("the intermediary is on their dashboard")
      dashboard.checkJourneyUrl("your-account")

      Then("the correct warning is displayed for a quarantined intermediary who has outstanding returns for a NETP")
      exclusion.warningToShow("quarantinedOutstanding")

      And("there is no 'Add a new client' link on the dashboard")
      exclusion.noAddClientLink()
    }

    Scenario("Quarantined intermediary where NETPs have no outstanding returns") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "quarantinedNoOutstandingReturns")

      When("the intermediary is on their dashboard")
      dashboard.checkJourneyUrl("your-account")

      Then("the correct warning is displayed for a quarantined intermediary who has no outstanding returns for a NETP")
      exclusion.warningToShow("quarantinedNoOutstanding")

      And("there is no 'Add a new client' link on the dashboard")
      exclusion.noAddClientLink()
    }
  }
}
