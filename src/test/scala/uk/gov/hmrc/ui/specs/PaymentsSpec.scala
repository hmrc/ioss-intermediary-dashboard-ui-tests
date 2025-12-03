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

class PaymentsSpec extends BaseSpec {

  private val dashboard = Dashboard
  private val auth      = Auth
  private val payment   = Payment

  Feature("View client payments list") {

    Scenario(
      "Intermediary views payments list for their clients"
    ) {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "multipleActiveAndPreviousRegistrations")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'Make a payment' link on the dashboard")
      dashboard.clickLink("make-a-payment")

      Then(
        "the intermediary is shown their client list to make a selection for payment"
      )
      dashboard.checkJourneyUrl("client-payments-list")
      payment.noClients(false)
      payment.checkClientList()
    }

    Scenario("Intermediary has no clients to select for payment") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "noRegistrations")
      dashboard.checkJourneyUrl("your-account")

      When("the intermediary clicks the 'Make a payment' link on the dashboard")
      dashboard.clickLink("make-a-payment")

      Then(
        "the intermediary has no clients to make payments for"
      )
      dashboard.checkJourneyUrl("client-payments-list")
      payment.noClients(true)
    }
  }
}
