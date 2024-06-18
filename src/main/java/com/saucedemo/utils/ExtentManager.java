package com.saucedemo.utils;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentReports getInstance(){

        if(extent==null){
            extent = new ExtentReports(System.getProperty("user.dir")+"/src/main/resources/Reports/Report.html",true, DisplayOrder.OLDEST_FIRST);
            extent.loadConfig(new File(System.getProperty("user.dir")+"/src/main/resources/extentconfig/ReportsConfig.xml"));
        }
        return extent;
    }
}
