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

object SubmittedReturn extends BasePage {

  def noReturnsSubmitted(show: Boolean): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText
    val text     = "You have not completed any returns."

    if (show == true) {
      Assert.assertTrue(htmlBody.contains(text))
    } else {
      Assert.assertFalse(htmlBody.contains(text))
    }
  }

  def showInset(show: Boolean): Unit = {
    val htmlBody = Driver.instance.findElement(By.tagName("body")).getText
    val text     = "If your client does not appear on this list, then you have not completed any returns for them."

    if (show == true) {
      Assert.assertTrue(htmlBody.contains(text))
    } else {
      Assert.assertFalse(htmlBody.contains(text))
    }
  }
}
