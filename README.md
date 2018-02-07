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

#### Playing with it

```
POST localhost:3000/diff

{
	"original": "Original content will come to here",
	"revised": "Revised content will come to here"
}

Response:

[
    {
        "operation": "DELETE",
        "text": "Or"
    },
    {
        "operation": "INSERT",
        "text": "Rev"
    },
    {
        "operation": "EQUAL",
        "text": "i"
    },
    {
        "operation": "DELETE",
        "text": "ginal"
    },
    {
        "operation": "INSERT",
        "text": "sed"
    },
    {
        "operation": "EQUAL",
        "text": " content will come to here"
    }
]

```

More options

```
POST localhost:3000/diff

{
	"original": "Original content will come to here",
	"revised": "Revised content will come to here",
	"checkLines": false,
	"cleanupSemantic": true,
	"cleanupSemanticLossless": false
}

Response:

[
    {
        "operation": "DELETE",
        "text": "Original"
    },
    {
        "operation": "INSERT",
        "text": "Revised"
    },
    {
        "operation": "EQUAL",
        "text": " content will come to here"
    }
]
```

### LICENSE

rest-diff project is distributed under the MIT license. See the complete license in the project.

This project uses diff_match_patch library licensed with Apache 2.0 license.
