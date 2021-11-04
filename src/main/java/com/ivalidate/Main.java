package com.ivalidate;

import java.io.File;

import org.apache.catalina.LifecycleException;

import javax.servlet.ServletException;

import org.apache.catalina.startup.Tomcat;

public class Main {

    public static void main(String[] args) throws LifecycleException, InterruptedException, ServletException {

        String docBase = "src/main/webapp/";
        Tomcat tomcat = new Tomcat();
        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }
        tomcat.setPort(Integer.valueOf(webPort));

        tomcat.addWebapp("/", new File(docBase).getAbsolutePath());
        System.out.println("configuring app with basedir: " + new File("./" + docBase).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}