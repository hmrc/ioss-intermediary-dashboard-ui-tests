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

class TileLinksSpec extends BaseSpec {

  private val dashboard = Dashboard
  private val auth      = Auth
  private val tileLinks = TileLinks

  Feature("Tile Link journeys") {

    Scenario("Intermediary can access the NETP Registration Service via the Intermediary Dashboard") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "default")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'Add a new client' link on the dashboard")
      dashboard.clickLink("add-client")

      Then("the intermediary is redirected to the first page of the NETP Registration service")
      tileLinks.checkRegistrationJourneyUrl("client-uk-based")
    }

    Scenario("Intermediary can amend their registration via the IOSS Intermediary Dashboard Service link") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "default")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the Change your registration link")
      dashboard.clickLink("change-your-registration")

      Then("the intermediary is redirected to the Intermediary registration service")
      tileLinks.checkIntermediaryRegistrationJourneyUrl("change-your-registration")
    }

    Scenario("Intermediary can leave the service via the IOSS Intermediary Dashboard Service link") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "default")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the Leave this service link")
      dashboard.clickLink("leave-scheme")

      Then("the intermediary is redirected to the Intermediary registration service")
      tileLinks.checkIntermediaryExclusionsJourneyUrl()
    }
  }
}
