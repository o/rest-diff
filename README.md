## Rest Diff

This project is designed to provide diff functionality of famous google-diff-match-patch
library as a RESTful API. It's built top of Spring Boot and requires Java 7 installed on system.

#### Building and running

The following command produces fully executable jar file under `/target` folder.

```bash
./mvnw clean package
```

Running:

```bash
target/diff-0.0.1-SNAPSHOT.jar
```

For deployment under Cloud services and installing as a system service please read the [Spring Boot Deployment document](https://docs.spring.io/spring-boot/docs/current/reference/html/deployment.html).

#### Usage

Single diff

```bash
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ \ 
   "context": { \ 
     "original": "Zo schrijft u zich in als woningzoekende: U schrijft zich in bij de organisatie die zorgt vor de verdelin van sociaale huurwoningen.", \ 
     "revised": "U schrijft zich in bij de organisatie die zorgt voor de verdeling van sociale huurwoningen." \ 
   }, \ 
   "options": { \ 
     "checkLines": true, \ 
     "cleanupSemantic": true, \ 
     "timeout": 0 \ 
   } \ 
 }' 'http://localhost:3000/diff'
```
```json
[
  {
    "operation": "DELETE",
    "text": "Zo schrijft u zich in als woningzoekende: "
  },
  {
    "operation": "EQUAL",
    "text": "U schrijft zich in bij de organisatie die zorgt vo"
  },
  {
    "operation": "INSERT",
    "text": "o"
  },
  {
    "operation": "EQUAL",
    "text": "r de verdelin"
  },
  {
    "operation": "INSERT",
    "text": "g"
  },
  {
    "operation": "EQUAL",
    "text": " van socia"
  },
  {
    "operation": "DELETE",
    "text": "a"
  },
  {
    "operation": "EQUAL",
    "text": "le huurwoningen."
  }
]
```

It also supports single diff with html output and batch diff. This project comes with bundled Swagger UI,
you can access documentation of operations from <http://localhost:3000/swagger-ui.html>.

### LICENSE

The original Google Diff, Match and Patch Library is licensed under the [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0). The full terms of that license are included here in the [APACHE-LICENSE-2.0](/APACHE-LICENSE-2.0) file.

Diff, Match and Patch Library

> Written by Neil Fraser
> Copyright (c) 2006 Google Inc.
> <http://code.google.com/p/google-diff-match-patch/>

This project is licensed under the [MIT License](http://www.opensource.org/licenses/MIT) which is included here in the [LICENSE](/LICENSE) file.

rest-diff project

> Copyright (c) 2018 Osman Üngür
> <https://github.com/o/rest-diff>
