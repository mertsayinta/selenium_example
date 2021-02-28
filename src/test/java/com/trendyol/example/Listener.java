package com.trendyol.example;


import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test basladi");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test basarili bitti");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test hata aldi");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test calismadi");
    }

}
