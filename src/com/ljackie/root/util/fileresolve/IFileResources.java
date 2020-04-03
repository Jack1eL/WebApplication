package com.ljackie.root.util.fileresolve;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName: com.ljackie.root.util.fileresolve
 * @Description: //file reslove
 * @Author: ljackie
 * @Date: 2020/3/31 9:37 上午
 */
public interface IFileResources {

    Map map = new HashMap();

    void fileResolve() throws IOException, URISyntaxException;
}
