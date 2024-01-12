package testcases;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;

public class AppiumServerBasic {

    public AppiumDriverLocalService service;


    public  void ConfigureAppium() throws MalformedURLException
    {
        // start and stop the appium server automatically, prevent manual running of appium server
        service= new AppiumServiceBuilder()
                .withAppiumJS(new File("C://Users//GalinaYaneva//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();
    }
    public  void tearDown()
    {
        service.stop();
    }
}
