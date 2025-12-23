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

package uk.gov.hmrc.ui.pages

import org.junit.Assert
import org.openqa.selenium.By
import org.scalatest.matchers.should.Matchers.*
import uk.gov.hmrc.configuration.TestEnvironment
import uk.gov.hmrc.selenium.webdriver.Driver

object Exclusion extends BasePage {

  def warningToShow(scenario: String): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText

    scenario match {
      case "selfOutstanding" =>
        Assert.assertTrue(htmlBody.contains(
          "You have left this service. You must complete and pay any outstanding returns for all your clients."))
      case "selfNoOutstanding" =>
        Assert.assertTrue(htmlBody.contains(
          "You have left this service."))
      case "hmrcOutstanding" =>
        Assert.assertTrue(htmlBody.contains(
          "We have removed you from this service. You must complete and pay any outstanding returns for all your clients."))
      case "hmrcNoOutstanding" =>
        Assert.assertTrue(htmlBody.contains(
          "We have removed you from this service."))
      case "quarantinedOutstanding" =>
        Assert.assertTrue(htmlBody.contains(
          "We have removed you from this service, but you must complete and pay your final return for all your clients. You cannot rejoin until"))
      case "quarantinedNoOutstanding" =>
        Assert.assertTrue(htmlBody.contains(
          "We have removed you from this service. You cannot rejoin until"))

      case _ =>
        throw new Exception("Scenario doesn't exist")
    }
  }
}
