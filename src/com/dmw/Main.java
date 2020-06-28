package com.dmw;

import com.projects.QuoteInterface;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {
    public static void main(String[] args) {

        SimpleClassLoader scl = new SimpleClassLoader();

        try {
            Class c = scl.findClass("com.projects.Quote");
            QuoteInterface q = (QuoteInterface)c.getDeclaredConstructor().newInstance();
            System.out.println(q.getQuote());
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        

        /*
        better, with interface on classpath, load implementation dynamically
        URL url;

        try {
            // load implementation jar
            url = new URL("file:////home/dustyw/projects/java/customClassloader/out/artifacts/implementation/implementation.jar");

            URLClassLoader ucl = new URLClassLoader(new URL[] { url });

            Class clazz = ucl.loadClass("com.projects.Quote");

            // cast based on interface
            QuoteInterface q = (QuoteInterface)clazz.getDeclaredConstructor().newInstance();
            System.out.println(q.getQuote());

            System.out.printf("");
        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            System.out.println("NoSuchMethodException");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("IllegalAccessException");
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.out.println("InstantiationException");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        */


        /*
        This works for loading a class but we can't do anything with it...

        URL url;
        try {
            url = new URL("file:////home/dustyw/projects/java/lib/quoter.jar");

            URLClassLoader ucl = new URLClassLoader(new URL[] { url });

            Class clazz = ucl.loadClass("com.projects.Quote");
            Object o = clazz.getDeclaredConstructor().newInstance();

            System.out.printf("");
        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            System.out.println("NoSuchMethodException");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("IllegalAccessException");
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.out.println("InstantiationException");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println("InvocationTargetException");
            e.printStackTrace();
        }
        */

    }
}
