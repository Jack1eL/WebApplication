package com.ljackie.root.util.fileresolve.impl;

import com.ljackie.root.annotation.BeanFactory;
import com.ljackie.root.util.collect.CollectorUtils;
import com.ljackie.root.util.fileresolve.IFileResources;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

/**
 * @PackageName: com.ljackie.root.util
 * @Description: //解读resources目录下的.properties
 * @Author: ljackie
 * @Date: 2020/3/27 9:59 上午
 */
@BeanFactory
public class PropertiesResources implements IFileResources {

    List<String> propertiesUrls = XmlResources.FILENAMEURLS;

    /**
     * properties-keys,to get properties value
     */
    private static String[] KEYS = new String[]{"jdbc-driver-class-name","jdbc-url","jdbc-username","jdbc-password","pack"};


    @Override
    public void fileResolve() throws IOException, URISyntaxException {
        if(CollectorUtils.isNotEmpty(propertiesUrls))
        {
            String basePathUrl = PropertiesResources.class.getClassLoader().getResource("").toURI().getPath();
            //if properties resources read success;
            for(String url:propertiesUrls)
            {
                FileInputStream fileInputStream = new FileInputStream(basePathUrl+url);
                Properties properties = new Properties();
                properties.load(fileInputStream);
                fileInputStream.close();
                for(String key:KEYS)
                {
                    map.put(key,properties.get(key));
                }
            }
        }
    }
}
