package com.example.utils;

import java.io.IOException;
import java.util.Properties;

public enum ApplicationProperties {
    INSTANCE, INSTANSE;
    public Properties properties;

    ApplicationProperties(){
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getTestBaseUrl(){ return properties.getProperty("testBaseUrl"); }

    public String getTestUserName(){ return properties.getProperty("testUserName");}

    public String getTestPassword(){ return properties.getProperty("testPassword");}

    public String getStageBaseUrl(){
        return properties.getProperty("stageBaseUrl");
    }
    public String getStageUserName(){ return properties.getProperty("stageUserName");}

    public String getStagePassword(){ return properties.getProperty("stageUserName");}

}
