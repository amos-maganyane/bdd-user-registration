package steps;

import io.cucumber.java.en.*;

import static io.restassured.RestAssured.*;


public class RegisterSteps {

    String url = "http://localhost:5000";

    @Given("the registration API is available")
    public void the_registration_api_is_available() {
        baseURI = url;
    }

    @When("I register with name {string} and password {string}")
    public void i_register_with_name_and_password(String name, String password) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the response should contain a user ID")
    public void the_response_should_contain_a_user_id() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the response should contain error {string}")
    public void the_response_should_contain_error(String expectedError) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
