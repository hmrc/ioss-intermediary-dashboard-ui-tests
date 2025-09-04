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

import uk.gov.hmrc.ui.pages._

class KickoutSpec extends BaseSpec {

  private val dashboard = Dashboard
  private val auth      = Auth

  Feature("Kickout journeys") {

    Scenario("Cannot access Intermediary Dashboard journey without being registered on the Intermediary service") {

      Given("a user who is not registered on the Intermediary service accesses the Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(false, true, "standard", "default")

      Then("the intermediary is on the cannot-use-this-service page")
      dashboard.checkJourneyUrl("cannot-use-this-service")
    }

    Scenario("No VAT enrolment when intermediary logs into Intermediary Dashboard service") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service without a VAT enrolment")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, false, "notRequired", "default")

      Then("the intermediary is shown the sorry there is a problem page")
      dashboard.checkProblemPage()
    }
  }
}
