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

class SecureMessagesSpec extends BaseSpec {

  private val dashboard     = Dashboard
  private val auth          = Auth
  private val secureMessage = SecureMessage

  Feature("Secure message journeys") {

    Scenario("Intermediary has two unread secure messages") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "twoSecureMessages")
      dashboard.checkJourneyUrl("your-account")

      Then("the link for two unread secure messages is displayed on the dashboard")
      secureMessage.checkSecureMessagesLink(2)

      When("the intermediary clicks the secure messages link")
      dashboard.clickLink("messages")

      Then("the secure-messages page is displayed")
      dashboard.checkJourneyUrl("secure-messages")

      And("the intermediary clicks on their first unread message")
      secureMessage.selectSecureMessage("individual-secure-message\\/69271ca31649fd80102e005c")

      And("the intermediary is viewing their first message")
      dashboard.checkJourneyUrl("individual-secure-message/69271ca31649fd80102e005c")
      secureMessage.checkSecureMessagesHeading("Your IOSS VAT Return for Trick Trouse is late")

      When("the intermediary clicks back")
      dashboard.clickBackButton()

      Then("the intermediary clicks on their next unread message")
      secureMessage.selectSecureMessage("individual-secure-message\\/692719481649fd80102e005a")

      And("the intermediary is viewing their second message")
      dashboard.checkJourneyUrl("individual-secure-message/692719481649fd80102e005a")
      secureMessage.checkSecureMessagesHeading("We have removed your client from the VAT IOSS scheme")
    }

    Scenario("Intermediary has one unread secure message") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "oneSecureMessage")
      dashboard.checkJourneyUrl("your-account")

      Then("the link for one unread secure message is displayed on the dashboard")
      secureMessage.checkSecureMessagesLink(1)

      When("the intermediary clicks the secure messages link")
      dashboard.clickLink("messages")

      Then("the secure-messages page is displayed")
      dashboard.checkJourneyUrl("secure-messages")

      When("the intermediary clicks on their unread message")
      secureMessage.selectSecureMessage("individual-secure-message\\/69271d701649fd80102e005d")

      Then("the intermediary can read their message")
      dashboard.checkJourneyUrl("individual-secure-message/69271d701649fd80102e005d")
      secureMessage.checkSecureMessagesHeading("We have removed your client from the VAT IOSS scheme")
    }

    Scenario("Intermediary has no unread secure messages") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "noUnreadSecureMessages")
      dashboard.checkJourneyUrl("your-account")

      Then("the link for no unread secure messages is displayed on the dashboard")
      secureMessage.checkSecureMessagesLink(0)

      When("the intermediary clicks the secure messages link")
      dashboard.clickLink("messages")

      Then("the secure-messages page is displayed")
      dashboard.checkJourneyUrl("secure-messages")
    }

    Scenario("Intermediary has both unread and read secure messages") {

      Given("the intermediary accesses the IOSS Intermediary Dashboard Service")
      auth.goToAuthorityWizard()
      auth.loginUsingAuthorityWizard(true, true, "standard", "threeSecureMessages")
      dashboard.checkJourneyUrl("your-account")

      Then("the link for two unread secure messages is displayed on the dashboard")
      secureMessage.checkSecureMessagesLink(2)

      When("the intermediary clicks the secure messages link")
      dashboard.clickLink("messages")

      Then("the secure-messages page is displayed")
      dashboard.checkJourneyUrl("secure-messages")

      And("the intermediary clicks on their first unread message")
      secureMessage.selectSecureMessage("individual-secure-message\\/69271e301649fd80102e0060")

      And("the intermediary is viewing their first message")
      dashboard.checkJourneyUrl("individual-secure-message/69271e301649fd80102e0060")
      secureMessage.checkSecureMessagesHeading("Your IOSS VAT Return for Trick Trouse is late")

      When("the intermediary clicks back")
      dashboard.clickBackButton()

      Then("the intermediary clicks on their next unread message")
      secureMessage.selectSecureMessage("individual-secure-message\\/69271e121649fd80102e005f")

      And("the intermediary is viewing their second message")
      dashboard.checkJourneyUrl("individual-secure-message/69271e121649fd80102e005f")
      secureMessage.checkSecureMessagesHeading("We have removed your client from the VAT IOSS scheme")

      When("the intermediary clicks back")
      dashboard.clickBackButton()

      Then("the intermediary clicks on their first read message")
      secureMessage.selectSecureMessage("individual-secure-message\\/69271e481649fd80102e0061")

      And("the intermediary is viewing their first read message")
      dashboard.checkJourneyUrl("individual-secure-message/69271e481649fd80102e0061")
      secureMessage.checkSecureMessagesHeading("Your IOSS VAT Return for Another Client is late")
    }
  }
}
