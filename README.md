FX Currency Widget

Simple REST API integration with `exchangeratesapi.io`

Prerequisites: Java 17

To run - checkout this project and at the base directory `fx-currency-widget` run `mvn spring-boot:run`

__You must have Java 17 set as your Java version so Maven picks up the correct version to avoid getting the error ` Fatal error compiling: invalid flag: --release`__

Swagger Documentation is available at - `http://localhost:8080/swagger-ui-custom.html`

Assumptions:

- provided only relevant endpoints for the frontend widget to use
- convert endpoint does not seem to work (probably need a subscription plan, or add custom logic handling the manual conversions - which might burn the free API usage, as well as the default base currency used by the API is GBP thus will need to do twice the conversions for `source currency` and `target currency`)
