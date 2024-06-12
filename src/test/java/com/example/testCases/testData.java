package com.example.testCases;

import com.example.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

public class testData extends BaseTest {




    @Test(dataProvider = "excelData")
     public void test1(String username, String password){

        System.out.println(username + password);


    }

}
