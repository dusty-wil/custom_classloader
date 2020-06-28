package com.dmw;

import com.projects.QuoteInterface;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class SimpleClassLoader extends ClassLoader {
    private ClassLoader parent;

    public SimpleClassLoader() {
        this(ClassLoader.getSystemClassLoader());
    }

    public SimpleClassLoader(ClassLoader parent)
    {
        super(parent);
        this.parent = parent;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class c = null;

        try {
            c = parent.loadClass(name);
        } catch (ClassNotFoundException e) {

            try {

                c = this.loadClassFromURL(
                    "file:////home/dustyw/projects/java/customClassloader/out/artifacts/implementation/implementation.jar",
                    name
                );

            } catch (MalformedURLException ex) {
                System.out.println("findClass - MalformedURLException");
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                System.out.println("findClass - ClassNotFoundException");
                ex.printStackTrace();
            }
        }

        return c;
    }

    private Class<?> loadClassFromURL(String urlString, String classToLoad)
            throws MalformedURLException, ClassNotFoundException {

        URL url;
        Class clazz = null;

        try {

            url = new URL(urlString);
            URLClassLoader ucl = new URLClassLoader(new URL[] { url });
            clazz = ucl.loadClass(classToLoad);

        } catch (MalformedURLException e) {
            throw new MalformedURLException(e.toString());
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException(e.toString());
        }

        return clazz;
    }

}
