package com.ljackie.root.listener;

import com.ljackie.root.annotation.Autowrite;
import com.ljackie.root.util.fileresolve.IFileResources;
import com.ljackie.root.util.fileresolve.factory.IFileResourcesFactory;
import com.ljackie.root.util.fileresolve.impl.XmlResources;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @PackageName: com.ljackie.root.listener
 * @Description: 项目启动加载配置
 * @Author: ljackie
 * @Date: 2020/3/25 11:43 上午
 */
public class ApplicationStarter extends BaseApplicationStarter implements ServletContextListener {

    @Autowrite(value = "propertiesResources")
    private IFileResources iFileResources;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        XmlResources.init();
        try {
            iFileResources = (IFileResources) IFileResourcesFactory.getFileResourcesInstance(this.getClass());
            iFileResources.fileResolve();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
