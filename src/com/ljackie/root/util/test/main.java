package com.ljackie.root.util.test;

import com.ljackie.root.annotation.BeanFactory;
import com.ljackie.root.util.collect.CollectorUtils;
import com.ljackie.root.util.fileresolve.scan.ScanUtils;
import com.sun.jndi.toolkit.url.Uri;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @PackageName: com.ljackie.root.util.test
 * @Description: //TODO
 * @Author: ljackie
 * @Date: 2020/3/28 5:48 下午
 */
public class main {

    private static List<String> classPaths = new ArrayList<>();

    //public static void main(String[] args) throws URISyntaxException, InvocationTargetException, IllegalAccessException {
        /*String name = "com.yonyou.iuap.identity.entity.BtdIdentityEntity";
        int i = name.lastIndexOf(".");
        String newObjectName = name.substring(i+1);
        System.out.print(toLowerCaseFirstOne(newObjectName));*/

        //XmlResources xmlResources = new XmlResources();

        /*String packName = "com.ljackie.root.util.fileresolve.factory";
        packName = packName.replace(".","/");
        URL url = Thread.currentThread().getContextClassLoader().getResource(packName);
        try {
            URI uri = url.toURI();
            File file = new File(uri);
            dealDirectory(packName,file);
        }catch (Exception e)
        {

        }
        System.out.print("1");*/

        /*ScanUtils.init().resolvePackUrl("com.ljackie.root.util.fileresolve.impl");
        Collection collection = ScanUtils.list;
        if(CollectorUtils.isNotEmpty(collection))
        {
            Iterator it = collection.iterator();
            while(it.hasNext())
            {
                Class clazz = (Class)it.next();
                if(clazz.getAnnotation(BeanFactory.class)!=null)
                {//if class contain this annotation we can do that
                    Annotation annotation = clazz.getAnnotation(BeanFactory.class);
                    Method[] methods = annotation.annotationType().getDeclaredMethods();
                    for (Method method:methods) {
                        String methodName = method.getName();
                        String value = (String)method.invoke(annotation);
                        System.out.print("草大母娘: "+value+" 嘻嘻");
                    }
                    System.out.print(1);
                }
            }
        }*/
    //}

    /*public static void dealDirectory(String packName,File curFile)
    {
        File[] files = curFile.listFiles();
        for(File file:files)
        {
            if(file.isDirectory())
            {
                packName = packName + "." +file.getName();
                dealDirectory(packName,file);
            }else if(file.isFile())
            {
                dealClass(packName,file);
            }
        }
    }

    public static void dealClass(String packName,File curFile)
    {
        String fileName = curFile.getName();
        if(fileName.endsWith(".class"))
        {
            fileName = fileName.replaceAll(".class","");
            try{

                Class<?> clazz = Class.forName(fileName);
                dealClass(packName,curFile);
            }catch (ClassNotFoundException e)
            {

            }
        }
    }*/



    /**
     * 首字母转小写
     * @param
     * @return

    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }
    */

    public static class BarWorker implements Runnable {

        private String name;

        private static boolean exists = false;

        public BarWorker(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            if (!exists) {
                try {
                    Thread thread = Thread.currentThread();
                    String threadName = thread.getName();
                    System.out.println(threadName);
                    TimeUnit.SECONDS.sleep(1);
                    Thread thread1 = Thread.currentThread();
                    String threadName1 = thread.getName();
                    System.out.println(threadName1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                exists = true;
                System.out.println(name + ":enter");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + ":leave");
                exists = false;
            } else {
                System.out.println(name + ":give up");
            }
        }
    }

        public static void main(String[] args) {
            BarWorker bar1 = new BarWorker("bar1");
            BarWorker bar2 = new BarWorker("bar2");
            new Thread(bar1).start();
            new Thread(bar2).start();

        }



}
