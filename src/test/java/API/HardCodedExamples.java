package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
@FixMethodOrder
public class HardCodedExamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9." +
            "eyJpYXQiOjE2ODUxMjM1NjEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTE2Njc2MSwidXNlcklkIjoiNTM3NCJ9." +
            "GNqiaZVysFGVWNWVYZ-DfFvclnykiYenQmracZI4p10";
    static String employee_id;
    @Test
    public void bgetCreatedEmployee(){
        RequestSpecification preparedRequest = given().
                header("Content-Type","application/json").
                header("Authorization", token).
                queryParam("employee_id",employee_id);

        //hitting the endPoint
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        //verify the response
        response.then().assertThat().statusCode(200);
        String tempEmpId=response.jsonPath().getString("employee.employee_id");

        //we have 2 emp id, one is in global and second in local
        Assert.assertEquals(employee_id,tempEmpId); //comparing two strings together
    }

    @Test
    public void acreateEmployee(){
        // prepare the request
        RequestSpecification preparedRequest = given().
                header("Content-Type","application/json").
                header("Authorization", token).
                body("{\n" +
                        "  \"emp_firstname\": \"Dior\",\n" +
                        "  \"emp_lastname\": \"Novales\",\n" +
                        "  \"emp_middle_name\": \"M\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"1989-09-11\",\n" +
                        "  \"emp_status\": \"Confirmed\",\n" +
                        "  \"emp_job_title\": \"Engineer\"\n" +
                        "}");


        // hitting the endpoint/send the request
        Response response = preparedRequest.when().post("/createEmployee.php");
        response.prettyPrint();// it will print the API info in the console

        // verifying the assertions/get response
        response.then().assertThat().statusCode(201);

        //we are capturing employee id from the response
       employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);

        //verifying the firstName in the response body
        response.then().assertThat().
                body("Employee.emp_firstname", equalTo("Dior"));
        //verifying the lastName from the response
        response.then().assertThat().
                body("Employee.emp_lastname", equalTo("Novales"));
        //Verifying the response header
        response.then().assertThat().header("Content-Type", "application/json");
        System.out.println("My test case is passed");
    }
    // homework get all employee status and job title

    @Test
    public void cupdateEmployee(){
        RequestSpecification preparedRequest = given().
                header("Content-Type","application/json").
                header("Authorization",token).body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"Dior\",\n" +
                        "  \"emp_lastname\": \"Novales\",\n" +
                        "  \"emp_middle_name\": \"M\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\":\"1989-09-11\",\n" +
                        "  \"emp_status\": \"Fulltime\",\n" +
                        "  \"emp_job_title\": \"Confirmed\"\n" +
                        "}\n");

        Response response = preparedRequest.when().put("/updateEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("Message",equalTo("Employee record Updated"));

    }
    @Test
    public void dgetUpdatedEmployee(){
        RequestSpecification preparedRequest = given().
                header("Content-Type","application/json").
                header("Authorization", token).
                queryParam("employee_id",employee_id);
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("Message",equalTo("Employee record Updated"));

    }
    @Test
    public void employeeStatus(){
        RequestSpecification prepareRequest = given().header("Authorization",token);
        Response response = prepareRequest.when().get("/employeementStatus.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    @Test
    public void getJobTitle(){
        RequestSpecification prepareRequest = given().header("Authorization",token);
        Response response = prepareRequest.when().get("/jobTitle.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

}
