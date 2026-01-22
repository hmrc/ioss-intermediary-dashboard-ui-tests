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
import uk.gov.hmrc.selenium.webdriver.Driver

object SecureMessage extends BasePage {

  def checkSecureMessagesLink(numberOfMessages: Int): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText
    if (numberOfMessages == 2) {
      Assert.assertTrue(htmlBody.contains("2 unread secure messages"))
    } else if (numberOfMessages == 1) {
      Assert.assertTrue(htmlBody.contains("1 unread secure message"))
    } else if (numberOfMessages == 0) {
      Assert.assertTrue(htmlBody.contains("View your secure messages"))
    }
  }

  def selectSecureMessage(link: String): Unit =
    clickCssSelector(link)

  def checkSecureMessagesHeading(heading: String): Unit = {
    val heading = Driver.instance.findElement(By.tagName("h2")).getText
    Assert.assertTrue(heading.equals(heading))
  }
}
