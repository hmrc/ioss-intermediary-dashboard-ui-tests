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

package uk.gov.hmrc.ui.pages

import org.junit.Assert
import org.openqa.selenium.By
import uk.gov.hmrc.selenium.webdriver.Driver

object PendingRegistration extends BasePage {

  def checkClientsAwaitingActivationWarning(displayed: Boolean): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText
    val text     = "You have clients awaiting activation."
    if (displayed) {
      Assert.assertTrue(htmlBody.contains(text))
    } else {
      Assert.assertFalse(htmlBody.contains(text))
    }
  }

  def checkClientsAwaitingActivationHeading(version: String): Unit = {
    val h1 = Driver.instance.findElement(By.tagName("h1")).getText
    if (version == "single") {
      Assert.assertTrue(h1.equals("1 client awaiting activation"))
    } else {
      Assert.assertTrue(h1.equals("5 clients awaiting activation"))
    }
  }

  def selectClientLink(link: String): Unit =
    click(By.cssSelector(s"a[href*=$link]"))

  def checkClientName(clientName: String): Unit = {
    val h1 = Driver.instance.findElement(By.tagName("h1")).getText
    Assert.assertTrue(h1.equals(s"$clientName has not activated their account"))
  }

  def noClientsAwaitingActivationLink(): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText
    Assert.assertFalse(htmlBody.contains("clients awaiting activation"))
  }
}
