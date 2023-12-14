package com.example.jdzx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFile {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
//        读取
        FileInputStream fis = new FileInputStream("config.properties");
        prop.load(fis);
        fis.close();

//        获取配置

        String val = prop.getProperty("key");

//        写配置文件
        FileOutputStream fos = new FileOutputStream("config.properties");
        prop.setProperty("key","value");
        prop.store(fos,null);
        fos.close();
    }
}
