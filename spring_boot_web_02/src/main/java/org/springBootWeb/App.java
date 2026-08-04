package org.springBootWeb;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springBootWeb.Controller.HelloServlet;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws LifecycleException {
        System.out.println( "Hello World!" );
        Tomcat tomcat=new Tomcat();
        Context context=tomcat.addContext("",null);
        tomcat.addServlet(context,"HelloServlet",new HelloServlet());

        context.addServletMappingDecoded("/hello","HelloServlet");
        tomcat.setPort(8080);
        tomcat.getConnector();
        tomcat.start();
        tomcat.getServer().await();

    }
}
