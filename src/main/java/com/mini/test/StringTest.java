package com.mini.test;

import com.alibaba.fastjson.JSON;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

public class StringTest {
    public static void main(String[] args) throws UnknownHostException {
        /*String fullName = "我的天.啊.doc";
        int extensionIndex = fullName.lastIndexOf(".");
        String fileNameWithoutExtension = extensionIndex == -1 ? fullName : fullName.substring(0, extensionIndex);
        System.out.println(fileNameWithoutExtension);*/
        String uuid= UUID.randomUUID().toString().replaceAll("-","");
        System.out.println(uuid);

        InetAddress address = InetAddress.getByName("172.16.26.30");
        System.out.println(JSON.toJSONString(address.getHostName()));
    }
}
