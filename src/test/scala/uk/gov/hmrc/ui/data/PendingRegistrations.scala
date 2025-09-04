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

package uk.gov.hmrc.ui.data

import java.time.LocalDate

object PendingRegistrations {
  val yesterday  = LocalDate.now().minusDays(1)
  val twoDaysAgo = LocalDate.now().minusDays(2)

  val data: List[String] =
    List(
      s"""
        |{
        |  "_id": {
        |    "$$oid": "68b6f0801ca3d6d1c1bade84"
        |  },
        |  "journeyId": "4aa0d14f-4737-45a6-a3b4-051c95cc8cfe",
        |  "uniqueUrlCode": "BRJRZF",
        |  "data": "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",
        |  "lastUpdated": {
        |    "$$date": "${yesterday}T13:26:24.550Z"
        |  },
        |  "uniqueActivationCode": "b2OBU6fosDFRW1YPVUVPSt2NxsCNDEM4HYA/OdsquYylBuOO4rQ=",
        |  "intermediaryDetails": {
        |    "intermediaryNumber": "IN9001112223",
        |    "intermediaryName": "Intermediary Company Name"
        |  }
        |}
        |""".stripMargin,
      s"""
        |{
        |  "_id": {
        |    "$$oid": "68b7025e1ca3d6d1c1bd1b53"
        |  },
        |  "journeyId": "cd232c89-90ea-4d5f-b589-94dadc54ec51",
        |  "uniqueUrlCode": "FXKQXQ",
        |  "data": "jfoLxAx6OHtAhV7nWOzeCwxY0/+MKrKTQCXjMZJdo+tEljhcq//jI2ji3QwUaQqLbdJqJLzGqaKW1mSVThas7gkO0zR5p4JJYc5nH8qR5R7wy+SwGr1o8LCVN3evoFNvP4qPxzGUIQhc4GDNl3NMPmsci4sbtHCnvTyHi+ERp4sAYrm8mg8ZnCHqhkRZVzU+VkoQUbL7CN2ort0V3C3FbsZ93OxO2i1+NaJVCH9UFQPx7Q2QWZmflIptxTcVhkP/hp/s/El941iqYBXUUWS+z9TaEd5aeIXrQD9rivSKJdEmbuaIZf3jugEdeLlho0areJwXpfz11FR02Z5hA2krLQfoe3mEiRj1ZDytMsf39v+2175I4eRRJPboLC9nlYMX9iImfXEcKR1bbsaYt75noyFiwez6Dsgfpg1pBCKvx0mMEHwT9XSqVq9CrCSmbv7cMhi6mj+ncBEcDOKAuDfX3ipdiFga3KOQV8mCG+7YJZJcksVjttXTw8U4cJCyICOPT/QREM+M4jS+rNycPpKdV+TtYU9U4cE+GariQfbS5kTRb4WZ32Kq/cU1UcFL29VIqzPMuPMKtPPc/RM/0kc4ygpvVGY/Pcd0Zcua72gDT4UZi8lf3oD0nSYzukVBZKrU8ACM1KtiQUVOLpYhHxPRmqN1tyDRCDvI509Ia4DM7HjPsC0sWp0L/Q9Y4R03sieGyCkeCC83iU1JniJRDZWc8U6pSMfOSpH0N5AIMxmpub6pindtjMEJ7P+1hnXjqqhtiQhwhWyvWnIxpus0h5cCGwOqtwhzLhLwbyj742seRwD6vXN8/ZBt7knJMTYetF9W25uKP6/zezhafbmH1rGI/l7Giq/6fHVQRg3HVwAlL2KHn/76GdQRecWI1kYcmN6Tory0slJ9nwtNsSx3AZs4tEgVO4m3gX8YL+wSrU2MzlTx5VGPngD/cmKq9mQVrBCmI0ngmroaW0HDWDSjuwZqQy6y842ahNz8q5uDW5RYqsCfd6Ndue5KZacIhcqwgl4i7qXn1EPh4UUBe6W6VG5e9Q8xccK23Itu4TmVFCD9JaX3BBvX",
        |  "lastUpdated": {
        |    "$$date": "${twoDaysAgo}T14:42:38.050Z"
        |  },
        |  "uniqueActivationCode": "Pj/Iz1jMw4JpvnkGRB4NP9F5y/mFm5eUU1iuTrwidPYwgumyolA=",
        |  "intermediaryDetails": {
        |    "intermediaryNumber": "IN9001112223",
        |    "intermediaryName": "Intermediary Company Name"
        |  }
        |}
        |""".stripMargin,
      s"""
        |{
        |  "_id": {
        |    "$$oid": "68b702e61ca3d6d1c1bd2d4d"
        |  },
        |  "journeyId": "f97dc31b-5234-4f6c-94a7-b8bec5841a28",
        |  "uniqueUrlCode": "YXKQBG",
        |  "data": "WeBI8t62uuzl2oAlj7GiPrw6iOuJeOiQkMefmfXqHViT16ODj1No4vBTXiXpqxZ6y7YPptlZhP5oHI0VaGOTq2lXDTvpsqP+MXq016sZr9NdzPiPk4AxmsNicMlXvZbR9yf5dt+KOl7iGWqLQPU0crEtCAXxlE5gW5xJpbksczbJ5YMuLLrmQNWFLFiC5gmQHpg+A2MmdXZypkkeC6kdxlfePrQVr52cqit8mbfWCwFKZQUtRpJV7rgGFewgGHpPLG5MMABqQ1TwH4/AQoiJ0hHkHNs7IhSdoUiICwmnaEkk+OJ5ZzME5GSDD5z+LTHAtnykYubiSR+9rlpGDIQT0W4S3TjNYIs754GlQ8tzcXKO0aKhq1pptpP9oozvoQ2Qt1lQukWI0M8AhCOtRPJ5YpHxTWVZG/dOtJCVlICH1fGjBgAilrWIYB2CBNuxHD2kxbAuNULaOL9oQOJ1aPLt2IScEBLnSi02SUReVq50mPUkpjJRkSKl64UY/xNfanHdVRivIeEYnUfbMP8kFFyZ9ZIRDPAqfNgcYp0K3vmejg/avz2FxS8d9IrF/9C8EEcFNVfJ9l15c4uR4h3r7iNNWOr6jwT8hM54qUgpuL3VCzRlN/DjdGrqUdftyiaLpryJe0xQwQauKTKbD6y/Td7yiFulJqK5FAlPFjtypVigPKw0gTkhltC77iYIIdaKjjAcxrhYVg0bW3MRkOv4kJHKqQhXE1s1vgHM9OgQBams2r21POOBXGZa6ca21+HCEOVH8MpfDYc7dumvG41n+V1NnQud/S1ipF34zL8SJTee96gLVI7+GmH8H116q9uGbs6iXVBQlhs7z3gwEieg66k8nKGHOo6fe4Mk/VwXizUZvYMjzuVDmh2/8V63J4yRggjXcy2zVNQc/gCcY8DckvMSlO41G4HeUGQgSEohbqFuZRki2zG+wSw8YcXt+sHuyd6BgFuei8nLx3mLlIud/sNcfQj7JacBOO+ZeasvduUM14WiDxrke1yA+WmSxZZKXx10rf/l3Y9H3fgW1eAS/owWQ4Tn4vx96ylqI+Hr/tE0ECurQnUQc9+6JY1F5ItMZSKNy17XKPbAhrxU7lOmH1JqeqzXtXpisybWf+YAfT3jcFH480yDHyV2d51WvZP6U0m4qsqJlJ4b/Qx7eHEbI/aAnENPfXlQCmuPqYLfBMf/clrGyMjB20cbN641eTRkNFQFcD3NqwaFvXom7MVmDCFSQ3x3O9yo9eUrBatSsndy42dszFpYSj5Lu4ty3v4is/CyQDZd3JilXPoX41qvJTeqTSjue7UpPeX9k/dbmeGuCWPDO30mw07h4NcekNMM",
        |  "lastUpdated": {
        |    "$$date": "${yesterday}T14:44:54.715Z"
        |  },
        |  "uniqueActivationCode": "25zh4fX6ConWlzVV6hOb9/Nj0AwSw1daNzIICbJmyIWmZ12J548=",
        |  "intermediaryDetails": {
        |    "intermediaryNumber": "IN9001112223",
        |    "intermediaryName": "Intermediary Company Name"
        |  }
        |}
        |""".stripMargin,
      s"""
        |{
        |  "_id": {
        |    "$$oid": "68b7032a1ca3d6d1c1bd3688"
        |  },
        |  "journeyId": "08c11d8b-e3e7-47b1-9fb1-d4efab81821d",
        |  "uniqueUrlCode": "JMMSZQ",
        |  "data": "isY7MlNiK8gynfkjNcIOhD5WZRJaHU6SGNkxN2T8V3Nd4O3bIfurgG645RCa98aE/H7NNgNx+CbB3U1eAV8AmR/gwXgp1SGtkkiEXmeE4SRZYjfI8XW25YycVmAX8f3PtEfCUBpfX6wdzhjESFZ7RZzL8/LxVQXCOAp3f2txCpl5DE7MERizvhcoMHW0aejesL70TeipFJxg3f+UY+7mhpY3dhyf9bF2XfWDOFok8nEWDvtf4TwbqPivNOURaapCmKFnPHBZMRd+BYRz+AA8ej1Pt0TCHynhBz0Bd180ZxR9SzboHc+NEDFK21gphJ11eUiVoo3fg/01dS48h9ND43AeafFVo8rh7YDhgy0fsyA8msyARyzwkPM0CeOyEsXia1O9gfL+Qz2nXuz+McsBjYe7lTScl40kAUi6d1QXFbccNc5vgYj9mD3umr+HdccjeXpgaVFCgKxvEeutpPRwBVZNU+F/fhXQP6syrLrc/NlMiw9/YGoWKSV4Qi1ZZECCQ3EagVdYFE3l63RtBTNOwVXoTf+q9PXjJJmtFvpuCbkoyEmnM/Qw0IsJ06gM8aoTz5JwuukZofeDHSKVg3xRXPvhC2xq5dTMYjJrMd1YT41/o0nDu8XSxWPK3eHtVaYSjoLIRv/apVSyfbfqlYq8qjfwthm5+ADQsH7WfRATu5ZPnh6ZnEcfDwu98X/8KSxkzNXeHo2Q3ehbvi+ieI2kkxOUnfRNw2P0XixnWBPkJIiHOkRtv6zOMLNTFO6vtOyPhb3fM+XTB+s+nxHN1ufDsc85uE+N0WTQlGjJmLLL1XfP0RQyPhen1gAKMAKpE4BoNmfcoMA/VG42iOOF2F+u8vm21KW+wXYTUXbh/16Ml1MgBcu4ycSW0HV0MerNt0TVsIslrELqhfjPpuP/XAlLoXLUKGbl92cNmOsoQmxGqxwWr4sT6hclGmWatuTUMPjW6z69drReZd8QqL9DsrFFR0YD4T8ncOPqjg61/SpTtFl9rYwnEfplcFBcK0ZYnr3UduoHDf6OItgFtPUkaikr2u/1qjrfWlcgET3F9IiC4HapTejtDF0DcWvLq+XdP8n1cAaLaXWj/hr/jt6oieFvflkkzdmvdHd0sQgyoFJIgMyuYqj2uV1MLd6i9EcMbuJLiXPtSzWlJda62ko45+WO5x3aWUoNjgxuBc6114f5aw6/0BjfLePsBUk5uj/oUkF24EXSOHl0cDHX7J4XPCJJbT1kBUk+ajYM3Cy2ZMH4TivinA75MSHGghuwK1M=",
        |  "lastUpdated": {
        |    "$$date": "${twoDaysAgo}T14:46:01.936Z"
        |  },
        |  "uniqueActivationCode": "0ysgi197juopaLLikYZshkhoBqrYVdgSaQ9zH+H3FUP3zOavQP0=",
        |  "intermediaryDetails": {
        |    "intermediaryNumber": "IN9001112223",
        |    "intermediaryName": "Intermediary Company Name"
        |  }
        |}
        |""".stripMargin,
      s"""
        |{
        |  "_id": {
        |    "$$oid": "68b703a61ca3d6d1c1bd46b8"
        |  },
        |  "journeyId": "9a12d762-3fff-455e-be1b-d7036403f200",
        |  "uniqueUrlCode": "TRYRQW",
        |  "data": "YZIq5BWC8BOpR9bxC7WT06yHuZgF7IQMpPA5fRMc/DICex9vc7t6dZ3iINjrVUiohPo/qOCnbUgxEc9QIOhJKNJ6HvRZCWokRssupzttWRy7AM/go8+/uKKCM3JkNldAbc/gpDc3uU+2M0WOQYNC2Bo/jW4VWXDcQuPnA2hO/bRq2CwxcJdkY0AQj6uJpIU0H0q+Z7BytKIo5/xoG6kksJm3x+LoCH+dY0EKIQZhyTgEyV29c4PAwRo6XQYzRMQiboXH1S1waSt/R26xTB0GCm/vzwfeSgYXwyyGYka4puCNLHs50LMZNgcba+dhHKqD98La4xQBMpOYH4ysEQB0IM2TPNhthaoGdjNz6qqZK6KtWqMhhFaQ9HCbyBiHBPPD0lCxyuqJK9elLxkaK23o0TiWSjhsGUjxs+c8cCQdBl0Z7o3jnPOS3hwlM3U6lSsD+p6Qqm3yUex5unN8jJp8q2WhsoHOfE7zA5hUI3v4vXg8YvFcRrZrl2Sxw/4SmUuF++q5tp5AC0aBEvnB2+VqdaERt6qnedq+pVd2ta8pxfwIu5ScYACIBMq7vp5CExsxsEfUz0TQPy/Jtf286JxQ/ci/3Lc8j9ya7J0Qr4EBQ1rVq3tQ8hyfkOKh+0IbNoPx49vwj8CsWXxRKa/mG6I+4uWX5zzpLztmIeurur98kzRaF5kqkFqcH5qa3mTGraNEcWrMWe1CLmumgaBpiCR1Sk4eKbR3Y6yphR5/j//HNIsTy7uYlYCJVSF5kpsq0kbLSkC4zTa7c1aa1cig7wSRkNHTEWoYsXHeA1lWg+hdHrAmKVUfZ3ttiAKbRSM55TRRsgH8/XAMnYnL2gZHVdF9s7d05BWcSxhGwO4iw9a7puZnVaAB4Qt7afW2Z1zQ5zvx38hIpafVOh22KhOIJqFkxWFljXqX1fO1SBXpAw7yd9RCcDxYFcBrG0oHQEDoKVLM2RG+8X7ppQp9m6IUyEvXqfam7FtD0udBc5YQ5BP4xME7ETMP",
        |  "lastUpdated": {
        |    "$$date": "${yesterday}T14:48:06.253Z"
        |  },
        |  "uniqueActivationCode": "5rz0KbitVWe5fIQizCMYx8kxSTGCN7ouUA1i4E4hpkMHmJTLmIU=",
        |  "intermediaryDetails": {
        |    "intermediaryNumber": "IN9001112223",
        |    "intermediaryName": "Intermediary Company Name"
        |  }
        |}
        |""".stripMargin,
      s"""
        |{
        |  "_id": {
        |    "$$oid": "68b855a41ca3d6d1c1cb6e4a"
        |  },
        |  "journeyId": "6bf0b5aa-c9f1-4860-8bf4-a428c033c954",
        |  "uniqueUrlCode": "GBVKFL",
        |  "data": "uVAG0e+TN1UvMUqILMfaTgglSAo3/vWEkpr4+iwigZe/t5jf/s8jyioIXbN8OC/fBqTzHR13rgHvHr+zvkEq8N/njpNC88okeNETzOykDTjQSOtmrmDCtB9Y2/AzDnVZcMGOSTibNAdceg2CyVqtwj8E2YZlL6QqF7Ng+mbhxc50yvtruzN3JY57vSWE0EyKF5lrddlUNXUKd5kGROezpEEiT2vJlAPkN/9RkL0UhZYWA91BghaqALFOKIC4nitcaDvqA3aeyh7iHJeMDyDNHkLtWpwnzBfjjtSOjzoMQtxAVxDI6RAaOMkNyAAMkKau/Q4+vWvul4lofEy5SdD/Y0MbPTeAMTd0wtyobya32TJH47bwoNdQm01Fe9cAgYMqCE0lLE3BUGtDL98CFMSJV/h/pWPr+P+QIwEgtr1h5vv52C00LHyOuhv8cM+Gs6q5g2K1gnik+Wt6Wm3LtI8R6mAp57zrnVZQG+sh33MMkgmzG+iV2ivxOy/xAnT8ksggJYZ8zmxl3jwv1XRT0GZP/SLuKhPzYKQDEZ759PF4DHJmETiUWKc0rshqtoJbetIsN29VgNVAlu4vNN2ZI7pgg3w6CKYJ0Mb2PgZTK8QRoIFhC6bKTngG8ac3b/51z4htJJsAERbouVRR9ZpV74mSP2mpmpmQjb7IV8fHIRL2ku846wiy6TJ4GO+tQrOwMoiCTgHiN730ORFitCfe/9ffDcAXVxQtYBiLQ3jubia6Z9fraKmLX4/UbttN6bKzJAJ1uw87pZoMolVXkd6+8Zm+zK4sG/V6rEAIouww7lRPTZBXqqqW/JcKm5Oi/eTRRBeg/QEO1wz3kcnLMvkeVTqnn14u3ySIheFtEUO0f/U5P5GGsvmH3mPeMcLpNnEudacubRIIzi9hgpKiKJk6Ycxc34ygzQsaMwu9wXA=",
        |  "lastUpdated": {
        |    "$$date": "${yesterday}T14:50:12.589Z"
        |  },
        |  "uniqueActivationCode": "GFkDVR/GuyigCoYJTsb7OrjCGF4biV6h4OdxqlnKsMxXf6u8LUY=",
        |  "intermediaryDetails": {
        |    "intermediaryNumber": "IN9001112225",
        |    "intermediaryName": "Intermediary Company Name"
        |  }
        |}
        |""".stripMargin
    )
}
