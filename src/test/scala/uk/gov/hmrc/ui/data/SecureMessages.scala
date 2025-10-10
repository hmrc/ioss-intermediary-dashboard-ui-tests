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

package uk.gov.hmrc.ui.data

import java.time.LocalDate

object SecureMessages {
  val yesterday  = LocalDate.now().minusDays(1)
  val twoDaysAgo = LocalDate.now().minusDays(2)

  val data: List[String] =
    List(
     """
        |{
        |  "_id": {
        |    "$oid": "68e524f8e7ef516a478bd1e4"
        |  },
        |  "externalRef": {
        |    "id": "AJD228705357190404836",
        |    "source": "gmc"
        |  },
        |  "recipient": {
        |    "regime": "ioss",
        |    "identifier": {
        |      "name": "HMRC-IOSS-INT",
        |      "value": "IN9001234012"
        |    },
        |    "email": "chandan.ray+M08aGIOSS@digital.hmrc.gov.uk"
        |  },
        |  "messageType": "mailout-batch",
        |  "validFrom": {
        |    "$date": "2025-08-01T00:00:00.000Z"
        |  },
        |  "content": [
        |    {
        |      "lang": "en",
        |      "subject": "Import One Stop Shop (IOSS)",
        |      "body": "281608923591592017"
        |    }
        |  ],
        |  "alertDetails": {
        |    "templateId": "new_message_alert_ioss_netp",
        |    "recipientName": {
        |      "line1": "Bob",
        |      "line2": "Jones"
        |    },
        |    "data": {
        |      "email": "chandan.ray+M08aGIOSS@digital.hmrc.gov.uk",
        |      "issueDate": "2025-08-01",
        |      "language": "en",
        |      "subject": "Import One Stop Shop (IOSS)"
        |    }
        |  },
        |  "details": {
        |    "formId": "M08aGIOSS",
        |    "sourceData": "test-source-data",
        |    "batchId": "IOSSMessage",
        |    "issueDate": "2025-08-01"
        |  },
        |  "emailAddress": "chandan.ray+M08aGIOSS@digital.hmrc.gov.uk",
        |  "hash": "JF7RReRmnD+POsOeTGnSiK1zYOm8t2QcKoEra6nSt1w=",
        |  "status": "deferred",
        |  "verificationBrake": false
        |}
         |""".stripMargin,
      """
        |{
        |  "_id": {
        |    "$oid": "68e52553e7ef516a478bd1e5"
        |  },
        |  "externalRef": {
        |    "id": "AJD158251913719425968",
        |    "source": "gmc"
        |  },
        |  "recipient": {
        |    "regime": "ioss",
        |    "identifier": {
        |      "name": "HMRC-IOSS-INT",
        |      "value": "IN9001234012"
        |    },
        |    "email": "chandan.ray+M08aGIOSS@digital.hmrc.gov.uk"
        |  },
        |  "messageType": "mailout-batch",
        |  "validFrom": {
        |    "$date": "2025-08-01T00:00:00.000Z"
        |  },
        |  "content": [
        |    {
        |      "lang": "en",
        |      "subject": "Import One Stop Shop (IOSS)",
        |      "body": "946380840376679184"
        |    }
        |  ],
        |  "alertDetails": {
        |    "templateId": "new_message_alert_ioss_netp",
        |    "recipientName": {
        |      "line1": "Bob",
        |      "line2": "Jones"
        |    },
        |    "data": {
        |      "email": "chandan.ray+M08aGIOSS@digital.hmrc.gov.uk",
        |      "issueDate": "2025-08-01",
        |      "language": "en",
        |      "subject": "Import One Stop Shop (IOSS)"
        |    }
        |  },
        |  "details": {
        |    "formId": "M08aGIOSS",
        |    "sourceData": "test-source-data",
        |    "batchId": "IOSSMessage",
        |    "issueDate": "2025-08-01"
        |  },
        |  "emailAddress": "chandan.ray+M08aGIOSS@digital.hmrc.gov.uk",
        |  "hash": "KA/sOJMYlhwTEZ9fwumq1NKVgB9/Wsk4H/ss4gu/3zg=",
        |  "status": "deferred",
        |  "verificationBrake": false
        |}
        |""".stripMargin,
      """
        |{
        |  "_id": {
        |    "$oid": "68e8de87e7ef516a478bd1e6"
        |  },
        |  "externalRef": {
        |    "id": "AJD761952280045704241",
        |    "source": "gmc"
        |  },
        |  "recipient": {
        |    "regime": "ioss",
        |    "identifier": {
        |      "name": "HMRC-IOSS-INT",
        |      "value": "IN9001234013"
        |    },
        |    "email": "chandan.ray+M08aGIOSS@digital.hmrc.gov.uk"
        |  },
        |  "messageType": "mailout-batch",
        |  "validFrom": {
        |    "$date": "2025-08-01T00:00:00.000Z"
        |  },
        |  "content": [
        |    {
        |      "lang": "en",
        |      "subject": "Import One Stop Shop (IOSS)",
        |      "body": "687080728092811347"
        |    }
        |  ],
        |  "alertDetails": {
        |    "templateId": "new_message_alert_ioss_netp",
        |    "recipientName": {
        |      "line1": "Bob",
        |      "line2": "Jones"
        |    },
        |    "data": {
        |      "email": "chandan.ray+M08aGIOSS@digital.hmrc.gov.uk",
        |      "issueDate": "2025-08-01",
        |      "language": "en",
        |      "subject": "Import One Stop Shop (IOSS)"
        |    }
        |  },
        |  "details": {
        |    "formId": "M08aGIOSS",
        |    "sourceData": "test-source-data",
        |    "batchId": "IOSSMessage",
        |    "issueDate": "2025-08-01"
        |  },
        |  "emailAddress": "chandan.ray+M08aGIOSS@digital.hmrc.gov.uk",
        |  "hash": "TCVpAgSf4Yc9C7kTkN6jfYKQJ2erFJoSxdVYPewItQo=",
        |  "status": "deferred",
        |  "verificationBrake": false
        |}
        |""".stripMargin,
      """
        |{
        |  "_id": {
        |    "$oid": "68e8e1cce7ef516a478bd1e7"
        |  },
        |  "externalRef": {
        |    "id": "AJD734185423270523504",
        |    "source": "gmc"
        |  },
        |  "recipient": {
        |    "regime": "ioss",
        |    "identifier": {
        |      "name": "HMRC-IOSS-INT",
        |      "value": "IN9001234567"
        |    },
        |    "email": "chandan.ray+M08aGIOSS@digital.hmrc.gov.uk"
        |  },
        |  "messageType": "mailout-batch",
        |  "validFrom": {
        |    "$date": "2025-08-01T00:00:00.000Z"
        |  },
        |  "content": [
        |    {
        |      "lang": "en",
        |      "subject": "Import One Stop Shop (IOSS)",
        |      "body": "942508840449861653"
        |    }
        |  ],
        |  "alertDetails": {
        |    "templateId": "new_message_alert_ioss_netp",
        |    "recipientName": {
        |      "line1": "Bob",
        |      "line2": "Jones"
        |    },
        |    "data": {
        |      "email": "chandan.ray+M08aGIOSS@digital.hmrc.gov.uk",
        |      "issueDate": "2025-08-01",
        |      "language": "en",
        |      "subject": "Import One Stop Shop (IOSS)"
        |    }
        |  },
        |  "details": {
        |    "formId": "M08aGIOSS",
        |    "sourceData": "test-source-data",
        |    "batchId": "IOSSMessage",
        |    "issueDate": "2025-08-01"
        |  },
        |  "emailAddress": "chandan.ray+M08aGIOSS@digital.hmrc.gov.uk",
        |  "hash": "yCQKvlJXseCjM4a9TR3txbQR7C7yhaRQ2an8lyh3Ucc=",
        |  "status": "deferred",
        |  "verificationBrake": false
        |}
        |""".stripMargin,
      """
        |{
        |  "_id": {
        |    "$oid": "68e8e1cee7ef516a478bd1e8"
        |  },
        |  "externalRef": {
        |    "id": "AJD814074561717750106",
        |    "source": "gmc"
        |  },
        |  "recipient": {
        |    "regime": "ioss",
        |    "identifier": {
        |      "name": "HMRC-IOSS-INT",
        |      "value": "IN9001234567"
        |    },
        |    "email": "chandan.ray+M08aGIOSS@digital.hmrc.gov.uk"
        |  },
        |  "messageType": "mailout-batch",
        |  "validFrom": {
        |    "$date": "2025-08-01T00:00:00.000Z"
        |  },
        |  "content": [
        |    {
        |      "lang": "en",
        |      "subject": "Import One Stop Shop (IOSS)",
        |      "body": "385238625928855044"
        |    }
        |  ],
        |  "alertDetails": {
        |    "templateId": "new_message_alert_ioss_netp",
        |    "recipientName": {
        |      "line1": "Bob",
        |      "line2": "Jones"
        |    },
        |    "data": {
        |      "email": "chandan.ray+M08aGIOSS@digital.hmrc.gov.uk",
        |      "issueDate": "2025-08-01",
        |      "language": "en",
        |      "subject": "Import One Stop Shop (IOSS)"
        |    }
        |  },
        |  "details": {
        |    "formId": "M08aGIOSS",
        |    "sourceData": "test-source-data",
        |    "batchId": "IOSSMessage",
        |    "issueDate": "2025-08-01"
        |  },
        |  "emailAddress": "chandan.ray+M08aGIOSS@digital.hmrc.gov.uk",
        |  "hash": "Leov7d/d6ygNrBReEor3Eob+p91alZVKjynxuN/ak7s=",
        |  "status": "deferred",
        |  "verificationBrake": false
        |}
        |""".stripMargin,
      """
        |{
        |  "_id": {
        |    "$oid": "68e8e1d0e7ef516a478bd1e9"
        |  },
        |  "externalRef": {
        |    "id": "AJD143155473258250554",
        |    "source": "gmc"
        |  },
        |  "recipient": {
        |    "regime": "ioss",
        |    "identifier": {
        |      "name": "HMRC-IOSS-INT",
        |      "value": "IN9001234567"
        |    },
        |    "email": "chandan.ray+M08aGIOSS@digital.hmrc.gov.uk"
        |  },
        |  "messageType": "mailout-batch",
        |  "validFrom": {
        |    "$date": "2025-08-01T00:00:00.000Z"
        |  },
        |  "content": [
        |    {
        |      "lang": "en",
        |      "subject": "Import One Stop Shop (IOSS)",
        |      "body": "886945229198734220"
        |    }
        |  ],
        |  "alertDetails": {
        |    "templateId": "new_message_alert_ioss_netp",
        |    "recipientName": {
        |      "line1": "Bob",
        |      "line2": "Jones"
        |    },
        |    "data": {
        |      "email": "chandan.ray+M08aGIOSS@digital.hmrc.gov.uk",
        |      "issueDate": "2025-08-01",
        |      "language": "en",
        |      "subject": "Import One Stop Shop (IOSS)"
        |    }
        |  },
        |  "details": {
        |    "formId": "M08aGIOSS",
        |    "sourceData": "test-source-data",
        |    "batchId": "IOSSMessage",
        |    "issueDate": "2025-08-01"
        |  },
        |  "emailAddress": "chandan.ray+M08aGIOSS@digital.hmrc.gov.uk",
        |  "hash": "jyPX4WfsvuLinO7DaQVEIwNpSn64zO5W89Dd8pG2t7U=",
        |  "status": "deferred",
        |  "verificationBrake": false,
        |  "readTime": {
        |    "$date": "2014-05-02T17:17:45.618Z"
        |  }
        |}
        |""".stripMargin
    )
}
