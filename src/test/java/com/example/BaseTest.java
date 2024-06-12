package com.example;

import org.json.simple.parser.JSONParser;
import org.junit.BeforeClass;
import org.testng.annotations.AfterSuite;
import com.example.utils.ApplicationProperties;
import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {
    public Logger logger = LoggerFactory.getLogger(BaseTest.class);
    public String userName;
    public String password;

    public JSONParser jsonParser = new JSONParser();

    @BeforeClass

    public void beforeClass() {
        String env = System.getProperty("env");
        logger.info("Test suite started" + env);
        if (env.equals("stage")){
            RestAssured.baseURI = ApplicationProperties.INSTANSE.getStageBaseUrl();
            userName = ApplicationProperties.INSTANCE.getStageUserName();
            password = ApplicationProperties.INSTANCE.getStagePassword();

        } else if (env.equals("test")){
            RestAssured.baseURI = ApplicationProperties.INSTANSE.getTestBaseUrl();
            userName = ApplicationProperties.INSTANCE.getTestUserName();
            password = ApplicationProperties.INSTANCE.getTestPassword();
        } else if (env.equals("test repeat")) {
            RestAssured.baseURI = ApplicationProperties.INSTANSE.getTestBaseUrl();
            userName = ApplicationProperties.INSTANCE.getTestUserName();
            password = ApplicationProperties.INSTANCE.getTestPassword();

            logger.info(env + "By default choice stage env");
        }
    }

    @AfterSuite
    public void afterSuite(){
        logger.info("Test suite completed ");
    }

}
