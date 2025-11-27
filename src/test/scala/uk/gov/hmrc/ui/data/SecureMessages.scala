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
        |    "$oid": "692719481649fd80102e005a"
        |  },
        |  "externalRef": {
        |    "id": "AJD170707775830740958",
        |    "source": "gmc"
        |  },
        |  "recipient": {
        |    "regime": "ioss",
        |    "identifier": {
        |      "name": "HMRC-IOSS-INT",
        |      "value": "IN9001234012"
        |    },
        |    "email": "test@test.com"
        |  },
        |  "messageType": "mailout-batch",
        |  "validFrom": {
        |    "$date": "2025-11-26T00:00:00.000Z"
        |  },
        |  "content": [
        |    {
        |      "lang": "en",
        |      "subject": "We have removed your client from the VAT IOSS scheme",
        |      "body": "PHAgY2xhc3M9ImdvdnVrLWJvZHkiPlRyaWNrZXkgVHJvdXNlIElPU1MgbnVtYmVyIElNMTExMTExMTExMSBpcyBubyBsb25nZXIgZWxpZ2libGUgdG8gdXNlIHRoZSBWQVQgSW1wb3J0IE9uZSBTdG9wIFNob3AgKElPU1MpIHNjaGVtZS48L3A+DQo8cCBjbGFzcz0iZ292dWstYm9keSI+WW91IG11c3QgY29tcGxldGUgYW55IG9mIHRoZWlyIG91dHN0YW5kaW5nIElPU1MgVkFUIFJldHVybnMgYW5kIGEgZmluYWwgcmV0dXJuIGZvciBKYW51YXJ5IDIwMjQuPC9wPg0KPHAgY2xhc3M9ImdvdnVrLWJvZHkiPklmIHlvdSBiZWxpZXZlIHRoaXMgaXMgYW4gZXJyb3IsIGNvbnRhY3QgdXMgYXQgPGEgaHJlZj1tYWlsdG86IlZBVE9TUy5Db250YWN0QGhtcmMuZ292LnVrIiBjbGFzcz0iZ292dWstbGluayI+VkFUT1NTLkNvbnRhY3RAaG1yYy5nb3YudWs8L2E+IGFuZCBxdW90ZSB5b3VyIElPU1MgaW50ZXJtZWRpYXJ5IG51bWJlci48L3A+DQo8cCBjbGFzcz0iZ292dWstYm9keSI+WW91ciBJT1NTIGludGVybWVkaWFyeSBudW1iZXIgaXM6IElNMTExMTExMTExMTwvcD4="
        |    }
        |  ],
        |  "alertDetails": {
        |    "templateId": "new_message_alert_ioss_netp",
        |    "recipientName": {
        |      "line1": "Test",
        |      "line2": "Test"
        |    },
        |    "data": {
        |      "email": "test@test.com",
        |      "issueDate": "2025-11-26",
        |      "language": "en",
        |      "subject": "We have removed your client from the VAT IOSS scheme"
        |    }
        |  },
        |  "details": {
        |    "formId": "M08aGIOSS",
        |    "sourceData": "test-source-data",
        |    "batchId": "IOSSMessage"
        |  },
        |  "emailAddress": "test@test.com",
        |  "hash": "sKFqHpkFf62xA/qPHH9WIEcgDAP6xNAs8QfBzjN00pc=",
        |  "status": "deferred",
        |  "verificationBrake": false
        |}
        |
         |""".stripMargin,
      """
        |{
        |  "_id": {
        |    "$oid": "69271ca31649fd80102e005c"
        |  },
        |  "externalRef": {
        |    "id": "AJD608632864729486668",
        |    "source": "gmc"
        |  },
        |  "recipient": {
        |    "regime": "ioss",
        |    "identifier": {
        |      "name": "HMRC-IOSS-INT",
        |      "value": "IN9001234012"
        |    },
        |    "email": "test@test.com"
        |  },
        |  "messageType": "mailout-batch",
        |  "validFrom": {
        |    "$date": "2025-11-26T00:00:00.000Z"
        |  },
        |  "content": [
        |    {
        |      "lang": "en",
        |      "subject": "Your IOSS VAT Return for Trick Trouse is late",
        |      "body": "PHAgY2xhc3M9ImdvdnVrLWJvZHkiPldlIGhhdmUgbm90IHJlY2VpdmVkIHlvdXIgSmFudWFyeSAyMDI0IEltcG9ydCBPbmUgU3RvcCBTaG9wIChJT1NTKSBWQVQgUmV0dXJuIGZvciBUcmljayBUcm91c2UgKElPU1MgbnVtYmVyOiBJTTExMTExMTExMTEpLiBUaGlzIHdhcyBkdWUgYnnigK8yOSBKYW51YXJ5IDIwMjQuIDwvcD4NCjxwIGNsYXNzPSJnb3Z1ay1ib2R5Ij5Zb3UgbXVzdCBzdWJtaXQgcmV0dXJucyBieSB0aGUgZHVlIGRhdGUsIGV2ZW4gaWYgeW91ciBjbGllbnQgZGlkIG5vdCBtYWtlIGFueSBzYWxlcyB0aGF0IG1vbnRoLjwvcD7igK8NCjxwIGNsYXNzPSJnb3Z1ay1ib2R5Ij5Zb3UgaGF2ZSAxMCBkYXlzIGZyb20gdGhpcyByZW1pbmRlciB0byBzdWJtaXQgYW55IG91dHN0YW5kaW5nIHJldHVybnMuPC9wPg0KPHAgY2xhc3M9ImdvdnVrLWJvZHkiPklmIHlvdSBtaXNzIHRoaXMgZGVhZGxpbmUsIHdlIG1heSByZW1vdmUgeW91IGZyb20gdGhlIElPU1Mgc2NoZW1lLjwvcD4NCjxwIGNsYXNzPSJnb3Z1ay1ib2R5Ij5Zb3UgbWF5IGFsc28gYmUgY2hhcmdlZCBpbnRlcmVzdCBvciBwZW5hbHRpZXMgZm9yIG5vdCBkZWNsYXJpbmcgYW5kIHBheWluZyBWQVQgZHVlLjwvcD4NCjxwIGNsYXNzPSJnb3Z1ay1ib2R5Ij5JZiB5b3UgYmVsaWV2ZSB0aGF0IHlvdeKAmXZlIGFscmVhZHkgc3VibWl0dGVkIGFsbCB5b3VyIHJldHVybnMsIGNvbnRhY3QgPGEgaHJlZj1tYWlsdG86IlZBVE9TUy5Db250YWN0QGhtcmMuZ292LnVrIiBjbGFzcz0iZ292dWstbGluayI+VkFUT1NTLkNvbnRhY3RAaG1yYy5nb3YudWs8L2E+IGFuZCBxdW90ZSB5b3VyIElPU1MgaW50ZXJtZWRpYXJ5IG51bWJlci4NCjwvcD4NCjxwIGNsYXNzPSJnb3Z1ay1ib2R5Ij5Zb3VyIGludGVybWVkaWFyeSBudW1iZXIgaXM6IElNMTExMTExMTExMSA8L3A+"
        |    }
        |  ],
        |  "alertDetails": {
        |    "templateId": "new_message_alert_ioss_netp",
        |    "recipientName": {
        |      "line1": "Test",
        |      "line2": "Test"
        |    },
        |    "data": {
        |      "email": "test@test.com",
        |      "issueDate": "2025-11-26",
        |      "language": "en",
        |      "subject": "Your IOSS VAT Return for Trick Trouse is late"
        |    }
        |  },
        |  "details": {
        |    "formId": "M08aGIOSS",
        |    "sourceData": "test-source-data",
        |    "batchId": "IOSSMessage"
        |  },
        |  "emailAddress": "test@test.com",
        |  "hash": "NtylfVMh9WabAjSjOJAVXXmn0nfTRyqc+DqNqoOCDmA=",
        |  "status": "deferred",
        |  "verificationBrake": false
        |}
        |
        |""".stripMargin,
      """
        |{
        |  "_id": {
        |    "$oid": "69271d701649fd80102e005d"
        |  },
        |  "externalRef": {
        |    "id": "AJD836877862588817401",
        |    "source": "gmc"
        |  },
        |  "recipient": {
        |    "regime": "ioss",
        |    "identifier": {
        |      "name": "HMRC-IOSS-INT",
        |      "value": "IN9001234013"
        |    },
        |    "email": "test@test.com"
        |  },
        |  "messageType": "mailout-batch",
        |  "validFrom": {
        |    "$date": "2025-11-26T00:00:00.000Z"
        |  },
        |  "content": [
        |    {
        |      "lang": "en",
        |      "subject": "We have removed your client from the VAT IOSS scheme",
        |      "body": "PHAgY2xhc3M9ImdvdnVrLWJvZHkiPllvdSB0b2xkIHVzIHlvdSB3YW50IHRvIHJlbW92ZSBUcmlja2V5IFRyb3VzZSAoSU9TUyBudW1iZXIgSU0xMTExMTExMTExKSBmcm9tIHRoZSBWQVQgSW1wb3J0IE9uZSBTdG9wIFNob3AgKElPU1MpIHNjaGVtZS48L3A+DQo8cCBjbGFzcz0iZ292dWstYm9keSI+WW91IG11c3QgY29tcGxldGUgYW55IG9mIHRoZWlyIG91dHN0YW5kaW5nIElPU1MgVkFUIFJldHVybnMgYW5kIGEgZmluYWwgcmV0dXJuIGZvciBKYW51YXJ5IDIwMjQuPC9wPg0KPHAgY2xhc3M9ImdvdnVrLWJvZHkiPklmIHlvdSBiZWxpZXZlIHRoaXMgaXMgYW4gZXJyb3IsIGNvbnRhY3QgdXMgYXQgPGEgaHJlZj1tYWlsdG86IlZBVE9TUy5Db250YWN0QGhtcmMuZ292LnVrIiBjbGFzcz0iZ292dWstbGluayI+VkFUT1NTLkNvbnRhY3RAaG1yYy5nb3YudWs8L2E+IGFuZCBxdW90ZSB5b3VyIElPU1MgaW50ZXJtZWRpYXJ5IG51bWJlci48L3A+DQo8cCBjbGFzcz0iZ292dWstYm9keSI+WW91ciBJT1NTIGludGVybWVkaWFyeSBudW1iZXIgaXM6IElNMTExMTExMTExMTwvcD4="
        |    }
        |  ],
        |  "alertDetails": {
        |    "templateId": "new_message_alert_ioss_netp",
        |    "recipientName": {
        |      "line1": "Test",
        |      "line2": "Test"
        |    },
        |    "data": {
        |      "email": "test@test.com",
        |      "issueDate": "2025-11-26",
        |      "language": "en",
        |      "subject": "We have removed your client from the VAT IOSS scheme"
        |    }
        |  },
        |  "details": {
        |    "formId": "M08aGIOSS",
        |    "sourceData": "test-source-data",
        |    "batchId": "IOSSMessage"
        |  },
        |  "emailAddress": "test@test.com",
        |  "hash": "zd4LuNEuOByoT5rLCccykuLseK/Bh6+T2f4pq9LJJ+c=",
        |  "status": "deferred",
        |  "verificationBrake": false
        |}
        |""".stripMargin,
      """
        |{
        |  "_id": {
        |    "$oid": "69271e121649fd80102e005f"
        |  },
        |  "externalRef": {
        |    "id": "AJD673516232506833969",
        |    "source": "gmc"
        |  },
        |  "recipient": {
        |    "regime": "ioss",
        |    "identifier": {
        |      "name": "HMRC-IOSS-INT",
        |      "value": "IN9001234567"
        |    },
        |    "email": "test@test.com"
        |  },
        |  "messageType": "mailout-batch",
        |  "validFrom": {
        |    "$date": "2025-11-26T00:00:00.000Z"
        |  },
        |  "content": [
        |    {
        |      "lang": "en",
        |      "subject": "We have removed your client from the VAT IOSS scheme",
        |      "body": "PHAgY2xhc3M9ImdvdnVrLWJvZHkiPllvdSB0b2xkIHVzIHlvdSB3YW50IHRvIHJlbW92ZSBUcmlja2V5IFRyb3VzZSAoSU9TUyBudW1iZXIgSU0xMTExMTExMTExKSBmcm9tIHRoZSBWQVQgSW1wb3J0IE9uZSBTdG9wIFNob3AgKElPU1MpIHNjaGVtZS48L3A+DQo8cCBjbGFzcz0iZ292dWstYm9keSI+WW91IG11c3QgY29tcGxldGUgYW55IG9mIHRoZWlyIG91dHN0YW5kaW5nIElPU1MgVkFUIFJldHVybnMgYW5kIGEgZmluYWwgcmV0dXJuIGZvciBKYW51YXJ5IDIwMjQuPC9wPg0KPHAgY2xhc3M9ImdvdnVrLWJvZHkiPklmIHlvdSBiZWxpZXZlIHRoaXMgaXMgYW4gZXJyb3IsIGNvbnRhY3QgdXMgYXQgPGEgaHJlZj1tYWlsdG86IlZBVE9TUy5Db250YWN0QGhtcmMuZ292LnVrIiBjbGFzcz0iZ292dWstbGluayI+VkFUT1NTLkNvbnRhY3RAaG1yYy5nb3YudWs8L2E+IGFuZCBxdW90ZSB5b3VyIElPU1MgaW50ZXJtZWRpYXJ5IG51bWJlci48L3A+DQo8cCBjbGFzcz0iZ292dWstYm9keSI+WW91ciBJT1NTIGludGVybWVkaWFyeSBudW1iZXIgaXM6IElNMTExMTExMTExMTwvcD4="
        |    }
        |  ],
        |  "alertDetails": {
        |    "templateId": "new_message_alert_ioss_netp",
        |    "recipientName": {
        |      "line1": "Test",
        |      "line2": "Test"
        |    },
        |    "data": {
        |      "email": "test@test.com",
        |      "issueDate": "2025-11-26",
        |      "language": "en",
        |      "subject": "We have removed your client from the VAT IOSS scheme"
        |    }
        |  },
        |  "details": {
        |    "formId": "M08aGIOSS",
        |    "sourceData": "test-source-data",
        |    "batchId": "IOSSMessage"
        |  },
        |  "emailAddress": "test@test.com",
        |  "hash": "QXK84NYORnnSWWpyyZDoiHstP+ywRhevvyFZwr76/NI=",
        |  "status": "deferred",
        |  "verificationBrake": false
        |}
        |""".stripMargin,
      """
        |{
        |  "_id": {
        |    "$oid": "69271e301649fd80102e0060"
        |  },
        |  "externalRef": {
        |    "id": "AJD858421808596462907",
        |    "source": "gmc"
        |  },
        |  "recipient": {
        |    "regime": "ioss",
        |    "identifier": {
        |      "name": "HMRC-IOSS-INT",
        |      "value": "IN9001234567"
        |    },
        |    "email": "test@test.com"
        |  },
        |  "messageType": "mailout-batch",
        |  "validFrom": {
        |    "$date": "2025-11-26T00:00:00.000Z"
        |  },
        |  "content": [
        |    {
        |      "lang": "en",
        |      "subject": "Your IOSS VAT Return for Trick Trouse is late",
        |      "body": "PHAgY2xhc3M9ImdvdnVrLWJvZHkiPldlIGhhdmUgbm90IHJlY2VpdmVkIHlvdXIgSmFudWFyeSAyMDI0IEltcG9ydCBPbmUgU3RvcCBTaG9wIChJT1NTKSBWQVQgUmV0dXJuIGZvciBUcmljayBUcm91c2UgKElPU1MgbnVtYmVyOiBJTTExMTExMTExMTEpLiBUaGlzIHdhcyBkdWUgYnnigK8yOSBKYW51YXJ5IDIwMjQuIDwvcD4NCjxwIGNsYXNzPSJnb3Z1ay1ib2R5Ij5Zb3UgbXVzdCBzdWJtaXQgcmV0dXJucyBieSB0aGUgZHVlIGRhdGUsIGV2ZW4gaWYgeW91ciBjbGllbnQgZGlkIG5vdCBtYWtlIGFueSBzYWxlcyB0aGF0IG1vbnRoLjwvcD7igK8NCjxwIGNsYXNzPSJnb3Z1ay1ib2R5Ij5Zb3UgaGF2ZSAxMCBkYXlzIGZyb20gdGhpcyByZW1pbmRlciB0byBzdWJtaXQgYW55IG91dHN0YW5kaW5nIHJldHVybnMuPC9wPg0KPHAgY2xhc3M9ImdvdnVrLWJvZHkiPklmIHlvdSBtaXNzIHRoaXMgZGVhZGxpbmUsIHdlIG1heSByZW1vdmUgeW91IGZyb20gdGhlIElPU1Mgc2NoZW1lLjwvcD4NCjxwIGNsYXNzPSJnb3Z1ay1ib2R5Ij5Zb3UgbWF5IGFsc28gYmUgY2hhcmdlZCBpbnRlcmVzdCBvciBwZW5hbHRpZXMgZm9yIG5vdCBkZWNsYXJpbmcgYW5kIHBheWluZyBWQVQgZHVlLjwvcD4NCjxwIGNsYXNzPSJnb3Z1ay1ib2R5Ij5JZiB5b3UgYmVsaWV2ZSB0aGF0IHlvdeKAmXZlIGFscmVhZHkgc3VibWl0dGVkIGFsbCB5b3VyIHJldHVybnMsIGNvbnRhY3QgPGEgaHJlZj1tYWlsdG86IlZBVE9TUy5Db250YWN0QGhtcmMuZ292LnVrIiBjbGFzcz0iZ292dWstbGluayI+VkFUT1NTLkNvbnRhY3RAaG1yYy5nb3YudWs8L2E+IGFuZCBxdW90ZSB5b3VyIElPU1MgaW50ZXJtZWRpYXJ5IG51bWJlci4NCjwvcD4NCjxwIGNsYXNzPSJnb3Z1ay1ib2R5Ij5Zb3VyIGludGVybWVkaWFyeSBudW1iZXIgaXM6IElNMTExMTExMTExMSA8L3A+"
        |    }
        |  ],
        |  "alertDetails": {
        |    "templateId": "new_message_alert_ioss_netp",
        |    "recipientName": {
        |      "line1": "Test",
        |      "line2": "Test"
        |    },
        |    "data": {
        |      "email": "test@test.com",
        |      "issueDate": "2025-11-26",
        |      "language": "en",
        |      "subject": "Your IOSS VAT Return for Trick Trouse is late"
        |    }
        |  },
        |  "details": {
        |    "formId": "M08aGIOSS",
        |    "sourceData": "test-source-data",
        |    "batchId": "IOSSMessage"
        |  },
        |  "emailAddress": "test@test.com",
        |  "hash": "QazJLpS+SW5Pj1/b6GLhUgA0Y2UGQV85UQCIZO3qfvE=",
        |  "status": "deferred",
        |  "verificationBrake": false
        |}
        |""".stripMargin,
      """
       {
        |  "_id": {
        |    "$oid": "69271e481649fd80102e0061"
        |  },
        |  "externalRef": {
        |    "id": "AJD573311280816648316",
        |    "source": "gmc"
        |  },
        |  "recipient": {
        |    "regime": "ioss",
        |    "identifier": {
        |      "name": "HMRC-IOSS-INT",
        |      "value": "IN9001234567"
        |    },
        |    "email": "test@test.com"
        |  },
        |  "messageType": "mailout-batch",
        |  "validFrom": {
        |    "$date": "2025-11-26T00:00:00.000Z"
        |  },
        |  "content": [
        |    {
        |      "lang": "en",
        |      "subject": "Your IOSS VAT Return for Another Client is late",
        |      "body": "PHAgY2xhc3M9ImdvdnVrLWJvZHkiPldlIGhhdmUgbm90IHJlY2VpdmVkIHlvdXIgSmFudWFyeSAyMDI0IEltcG9ydCBPbmUgU3RvcCBTaG9wIChJT1NTKSBWQVQgUmV0dXJuIGZvciBBbm90aGVyIENsaWVudCAoSU9TUyBudW1iZXI6IElNMTExMTExMTExMikuIFRoaXMgd2FzIGR1ZSBieeKArzI5IEphbnVhcnkgMjAyNC4gPC9wPg0KPHAgY2xhc3M9ImdvdnVrLWJvZHkiPllvdSBtdXN0IHN1Ym1pdCByZXR1cm5zIGJ5IHRoZSBkdWUgZGF0ZSwgZXZlbiBpZiB5b3VyIGNsaWVudCBkaWQgbm90IG1ha2UgYW55IHNhbGVzIHRoYXQgbW9udGguPC9wPuKArw0KPHAgY2xhc3M9ImdvdnVrLWJvZHkiPllvdSBoYXZlIDEwIGRheXMgZnJvbSB0aGlzIHJlbWluZGVyIHRvIHN1Ym1pdCBhbnkgb3V0c3RhbmRpbmcgcmV0dXJucy48L3A+DQo8cCBjbGFzcz0iZ292dWstYm9keSI+SWYgeW91IG1pc3MgdGhpcyBkZWFkbGluZSwgd2UgbWF5IHJlbW92ZSB5b3UgZnJvbSB0aGUgSU9TUyBzY2hlbWUuPC9wPg0KPHAgY2xhc3M9ImdvdnVrLWJvZHkiPllvdSBtYXkgYWxzbyBiZSBjaGFyZ2VkIGludGVyZXN0IG9yIHBlbmFsdGllcyBmb3Igbm90IGRlY2xhcmluZyBhbmQgcGF5aW5nIFZBVCBkdWUuPC9wPg0KPHAgY2xhc3M9ImdvdnVrLWJvZHkiPklmIHlvdSBiZWxpZXZlIHRoYXQgeW914oCZdmUgYWxyZWFkeSBzdWJtaXR0ZWQgYWxsIHlvdXIgcmV0dXJucywgY29udGFjdCA8YSBocmVmPW1haWx0bzoiVkFUT1NTLkNvbnRhY3RAaG1yYy5nb3YudWsiIGNsYXNzPSJnb3Z1ay1saW5rIj5WQVRPU1MuQ29udGFjdEBobXJjLmdvdi51azwvYT4gYW5kIHF1b3RlIHlvdXIgSU9TUyBpbnRlcm1lZGlhcnkgbnVtYmVyLg0KPC9wPg0KPHAgY2xhc3M9ImdvdnVrLWJvZHkiPllvdXIgaW50ZXJtZWRpYXJ5IG51bWJlciBpczogSU0xMTExMTExMTEyIDwvcD4="
        |    }
        |  ],
        |  "alertDetails": {
        |    "templateId": "new_message_alert_ioss_netp",
        |    "recipientName": {
        |      "line1": "Test",
        |      "line2": "Test"
        |    },
        |    "data": {
        |      "email": "test@test.com",
        |      "issueDate": "2025-11-26",
        |      "language": "en",
        |      "subject": "Your IOSS VAT Return for Another Client is late"
        |    }
        |  },
        |  "details": {
        |    "formId": "M08aGIOSS",
        |    "sourceData": "test-source-data",
        |    "batchId": "IOSSMessage"
        |  },
        |  "emailAddress": "test@test.com",
        |  "hash": "6qRiBvxaC6rpWX3ZlBGc3VtkSDjxkdw8/98Bnk8ylSI=",
        |  "status": "deferred",
        |  "verificationBrake": false,
        |  "readTime": {
        |    "$date": "2025-11-26T15:37:14.893Z"
        |  }
        |}
        |""".stripMargin
    )
}
