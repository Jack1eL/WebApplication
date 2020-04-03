package com.ljackie.root.util.fileresolve.scan;

import com.ljackie.root.util.collect.StringUtils;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @PackageName: com.ljackie.root.util.fileresolve.scan
 * @Description: //scan class
 * @Author: ljackie
 * @Date: 2020/3/31 3:46 下午
 */
public class ScanUtils {

    private static class Inner {
        private static ScanUtils instance = new ScanUtils();
    }

    public static Collection<Class<?>> list = new ArrayList<>();

    public void resolvePackUrl(String packUrl) {
        if(StringUtils.isNotEmpty(packUrl))
        {
            packUrl = packUrl.replace(".","/");
            URL url = Thread.currentThread().getContextClassLoader().getResource(packUrl);
            try{
                URI uri = url.toURI();
                File file = new File(uri);
                dealDirectory(packUrl,file);
            }catch (URISyntaxException | ClassNotFoundException ue)
            {
                ue.printStackTrace();
            }
        }
    }

    private void dealDirectory(String packUrl,File curFile) throws ClassNotFoundException {
        File[] files = curFile.listFiles();
        for(File file:files)
        {
            if(file.isDirectory())
            {//if pack is directory
                dealDirectory(packUrl,file);
            }else if(file.isFile())
            {//if pack is file
                dealClass(packUrl,file);
            }
        }
    }

    private void dealClass(String packUrl, File file) throws ClassNotFoundException {
        //get file name
        String fileName = file.getName();
        if(fileName.endsWith(".class"))
        {//if file end string is .class we can read it to collection
            fileName = packUrl.replace("/",".")+"."+fileName.replaceAll(".class","");
            Class<?> clazz = Class.forName(fileName);
            list.add(clazz);
        }
    }

    public ScanUtils()
    {}

    public static ScanUtils init()
    {
        return Inner.instance;
    }
}
