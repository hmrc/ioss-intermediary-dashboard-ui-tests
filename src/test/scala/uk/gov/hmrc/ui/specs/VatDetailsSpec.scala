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

class VatDetailsSpec extends BaseSpec {

  private val dashboard = Dashboard
  private val auth      = Auth

  Feature("Extra Vat Details journeys") {

    Scenario("Intermediary is presented with problem page if VAT info returns not found status.") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service where VAT info returns 'not found'")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "notFound")

      Then("the intermediary is shown the sorry there is a problem page")
      dashboard.checkProblemPage()
    }

    Scenario("Intermediary is presented with problem page if VAT info returns internal server error.") {

      Given(
        "the intermediary accesses the IOSS Intermediary Dashboard Service where VAT info returns internal server error"
      )
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "internalServerError")

      Then("the intermediary is shown the sorry there is a problem page")
      dashboard.checkProblemPage()
    }

    Scenario("Intermediary company name is displayed on dashboard for an organisation") {

      Given(
        "the intermediary accesses the IOSS Intermediary Dashboard Service where VAT info is for an organisation"
      )
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard")

      Then("the intermediary company name is displayed on the dashboard")
      dashboard.checkJourneyUrl("your-account")
      dashboard.checkName("organisation")
    }

    Scenario("Intermediary individual name is displayed on dashboard for an individual") {

      Given(
        "the intermediary accesses the IOSS Intermediary Dashboard Service where VAT info is for an individual"
      )
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "individual")

      Then("the intermediary company name is displayed on the dashboard")
      dashboard.checkJourneyUrl("your-account")
      dashboard.checkName("individual")
    }
  }
}
