package steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import utils.ConfigManager;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.notNullValue;


public class RegisterSteps {
    private static final String BASE_URL = ConfigManager.getBaseUrl();
    Response response;

    @Given("the registration API is available")
    public void the_registration_api_is_available() {
        baseURI = BASE_URL;
    }

    @When("I register with name {string} and password {string}")
    public void i_register_with_name_and_password(String name, String password) {

        Map<String, String> requestBody = new HashMap<>();

        if (!name.isEmpty()) requestBody.put("name", name);
        if (!password.isEmpty()) requestBody.put("password", password);

        response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/register");
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response should contain a user ID")
    public void the_response_should_contain_a_user_id() {
        assertThat(response.jsonPath().get("id"), notNullValue());
    }

    @Then("the response should contain error {string}")
    public void the_response_should_contain_error(String expectedError) {
        String actualError = response.jsonPath().getString("error");
        assertThat(actualError, containsString(expectedError));
    }

}
