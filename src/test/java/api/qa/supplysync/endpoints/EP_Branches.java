package api.qa.supplysync.endpoints;

import api.qa.supplysync.pojos.branches.PJ_Branches;
import api.qa.supplysync.utils.APIJsonData;
import api.qa.supplysync.utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class EP_Branches {

    final String json = "application/json";
    final String contentType = "Content-Type";
    final String accept = "Accept";
    final String authorization = "Authorization";

    public void createNewBranchData(String name, String email, String address, String number, String regionId, String companyId) {

        RestAssured.baseURI = ConfigReader.readProperty("branch_url");
        RestAssured.basePath = ConfigReader.readProperty("create_branch");

        Response response = RestAssured.given().header(contentType, json).header(accept, json)
                .header(authorization, ConfigReader.readProperty("token"))
                .body(APIJsonData.createBranch(name, email, address, number, regionId, companyId))
                .when().post().then().log().body().statusCode(200).extract().response();

        PJ_Branches deserializeResponse = response.as(PJ_Branches.class);
        Assert.assertEquals(deserializeResponse.getName(), name);
        Assert.assertEquals(deserializeResponse.getEmail(), email);
        Assert.assertEquals(deserializeResponse.getAddress(), address);
        Assert.assertEquals(deserializeResponse.getPhoneNumber(), number);
        Assert.assertEquals(deserializeResponse.getRegion().getId(), regionId);
        Assert.assertEquals(deserializeResponse.getCompany().getId(), companyId);


    }

    public void getBranchData(String region, String companyName, String companyEmail, String companyAddress, String companyNumber) {

        RestAssured.baseURI = ConfigReader.readProperty("branch_url");
        RestAssured.basePath = ConfigReader.readProperty("get_branch");

        Response response = RestAssured.given().header(contentType, json).header(accept, json)
                .header(authorization, ConfigReader.readProperty("token"))
                .when().get().then().log().body().statusCode(200).extract().response();

        PJ_Branches deserializeResponse = response.as(PJ_Branches.class);
        Assert.assertEquals(deserializeResponse.getRegion().getRegion(), region);
        Assert.assertEquals(deserializeResponse.getCompany().getName(), companyName);
        Assert.assertEquals(deserializeResponse.getCompany().getEmail(), companyEmail);
        Assert.assertEquals(deserializeResponse.getCompany().getAddress(), companyAddress);
        Assert.assertEquals(deserializeResponse.getCompany().getPhoneNumber(), companyNumber);


    }

    public void updateBranchData(String name, String email, String address, String number, String regionId, String companyId) {

        RestAssured.baseURI = ConfigReader.readProperty("branch_url");
        RestAssured.basePath = ConfigReader.readProperty("get_branch");

        Response response = RestAssured.given().header(contentType, json).header(accept, json)
                .header(authorization, ConfigReader.readProperty("token"))
                .body(APIJsonData.createBranch(name, email, address, number, regionId, companyId))
                .when().put().then().log().body().statusCode(200).extract().response();

        PJ_Branches deserializeResponse = response.as(PJ_Branches.class);
        Assert.assertEquals(deserializeResponse.getName(), name);
        Assert.assertEquals(deserializeResponse.getEmail(), email);
        Assert.assertEquals(deserializeResponse.getAddress(), address);
        Assert.assertEquals(deserializeResponse.getPhoneNumber(), number);
        Assert.assertEquals(deserializeResponse.getRegion().getId(), regionId);
        Assert.assertEquals(deserializeResponse.getCompany().getId(), companyId);


    }

    public void blockBranchData(String block, String companyBlocked) {

        RestAssured.baseURI = ConfigReader.readProperty("branch_url");
        RestAssured.basePath = ConfigReader.readProperty("block_branch");

        Response response = RestAssured.given().header(contentType, json).header(accept, json)
                .header(authorization, ConfigReader.readProperty("token"))
                .when().put().then().log().body().statusCode(200).extract().response();

        PJ_Branches deserializeResponse = response.as(PJ_Branches.class);
        Assert.assertEquals(deserializeResponse.getBlock(), block);
        Assert.assertEquals(deserializeResponse.getCompany().getBlocked(), companyBlocked);


    }

    public void unBlockBranchData(String block, String companyBlocked) {

        RestAssured.baseURI = ConfigReader.readProperty("branch_url");
        RestAssured.basePath = ConfigReader.readProperty("unBlock_branch");

        Response response = RestAssured.given().header(contentType, json).header(accept, json)
                .header(authorization, ConfigReader.readProperty("token"))
                .when().put().then().log().body().statusCode(200).extract().response();

        PJ_Branches deserializeResponse = response.as(PJ_Branches.class);
        Assert.assertEquals(deserializeResponse.getBlock(), block);
        Assert.assertEquals(deserializeResponse.getCompany().getBlocked(), companyBlocked);


    }


    public void deleteBranchData(String name, String email, String address, String number, String regionId, String companyId) {

        RestAssured.baseURI = ConfigReader.readProperty("branch_url");
        RestAssured.basePath = ConfigReader.readProperty("get_branch");

        Response response = RestAssured.given().header(contentType, json).header(accept, json)
                .header(authorization, ConfigReader.readProperty("token"))
                .when().delete().then().log().body().statusCode(200).extract().response();

        PJ_Branches deserializeResponse = response.as(PJ_Branches.class);
        Assert.assertEquals(deserializeResponse.getName(), name);
        Assert.assertEquals(deserializeResponse.getEmail(), email);
        Assert.assertEquals(deserializeResponse.getAddress(), address);
        Assert.assertEquals(deserializeResponse.getPhoneNumber(), number);
        Assert.assertEquals(deserializeResponse.getRegion().getId(), regionId);
        Assert.assertEquals(deserializeResponse.getCompany().getId(), companyId);


    }

    public void getAllBranchData(String name, String email, String address, String number, String regionId, String companyId) {

        RestAssured.baseURI = ConfigReader.readProperty("branch_url");
        RestAssured.basePath = ConfigReader.readProperty("get_allBranch");

        Response response = RestAssured.given().header(contentType, json).header(accept, json)
                .header(authorization, ConfigReader.readProperty("token"))
                .when().get().then().log().body().statusCode(200).extract().response();

        PJ_Branches deserializeResponse = response.as(PJ_Branches.class);
        Assert.assertEquals(deserializeResponse.getName(), name);
        Assert.assertEquals(deserializeResponse.getEmail(), email);
        Assert.assertTrue(deserializeResponse.getAddress().contains(address));
        Assert.assertEquals(deserializeResponse.getPhoneNumber(), number);
        Assert.assertEquals(deserializeResponse.getRegion().getId(), regionId);
        Assert.assertEquals(deserializeResponse.getCompany().getId(), companyId);


    }

    // MUST DISCUSS BEFORE STARTING VALIDATION, MANUAL HAS INTERNAL ERROR
//    public void getDriverCount(String count){
//
//    }


    // MUST DISCUSS BEFORE STARTING VALIDATION, MANUAL HAS INTERNAL ERROR
//    public void getAllBranchCount(String count){
//
//    }


    public void getAllUnBlockBranchData(String block, String companyBlocked) {

        RestAssured.baseURI = ConfigReader.readProperty("branch_url");
        RestAssured.basePath = ConfigReader.readProperty("notBlock_branch");

        Response response = RestAssured.given().header(contentType, json).header(accept, json)
                .header(authorization, ConfigReader.readProperty("token"))
                .when().get().then().log().body().statusCode(200).extract().response();

        List<Map<String, Object>> deserializeResponse= response.as(new TypeRef<List<Map<String, Object>>>() {});

        for (int i = 0; i < deserializeResponse.size(); i++) {
            Map<String, Object> company= (Map<String, Object>) deserializeResponse.get(i).get("company");
            Assert.assertEquals(deserializeResponse.get(i).get("block"), block);
            Assert.assertEquals(company.get("blocked"), companyBlocked);
        }

    }


}
