package com.bohui.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Properties文件读取文件
 * 1、默认初始化时读取classes下config.properties
 * 2、初始化该对象时默认可以传递properties文件
 * <p>
 * 特殊说明：
 * 1、可以设定解析文件名称
 * 2、该类只支持查询操作
 * 3、此类后续可以进行扩展
 * <p>
 * 调用方式：
 * PropertieFileUtil pro =  PropertieFileUtil.newInstance();
 * String val = pro.findVal(key);
 * User: liyangli
 * Date: 2014/6/4
 * Time: 15:23
 */
@Slf4j
public class ClassPathPropertiesUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassPathPropertiesUtil.class);
    private static final String DEFNAME = "config.properties";
    private Map<String, String> map = new HashMap<String, String>();//存放解析后的数据
    private String fileName = "";

    private ClassPathPropertiesUtil(String fileName) {
        parse(fileName);
    }


    /**
     * 供外界真正访问的方法
     * 默认解析classes下的config.properties文件
     *
     * @return properties解析文件对象
     */
    public static ClassPathPropertiesUtil newInstance() {
        return Builder.instance(null);
    }

    /**
     * 供外界真正访问的方法
     * 解析classes文件夹下的指定文件
     *
     * @return properties解析文件对象
     */
    public static ClassPathPropertiesUtil newInstance(String fileName) {
        return Builder.instance(fileName);
    }

    /**
     * 构建者
     */
    private static class Builder {
        private static Map<String, ClassPathPropertiesUtil> map = new ConcurrentHashMap<String, ClassPathPropertiesUtil>();

        private static ClassPathPropertiesUtil instance(String fileName) {
            if (fileName == null || fileName.isEmpty()) {
                fileName = DEFNAME;
            }
            if(map.get(fileName)==null){
                synchronized (ClassPathPropertiesUtil.class){
                    if(map.get(fileName)==null){
                        ClassPathPropertiesUtil pro = new ClassPathPropertiesUtil(fileName);
                        map.put(fileName, pro);
                    }
                }
            }
            return map.get(fileName);
        }
    }


    private boolean validate(String name) {
        if (name == null || name.isEmpty()) {
            fileName = DEFNAME;
        } else {
            fileName = name;
        }
        if (name.indexOf(File.separator) != -1) {
            LOGGER.error("不需要进行传入文件路径，只能传入对应文件名称,传入的文件名称为：{}", fileName);
            return false;
        }

        return true;
    }


    private void parse(String name) {
        if (validate(name)) {
            Properties pro = new Properties();
            try {
                File file = new File(fileName);
                if (!file.exists()) {
                    LOGGER.info("jar包同级不存在,开始加载config/下");
                    file = new File("config/" + fileName);
                }
                Resource resource = new FileSystemResource(file);
                if (!resource.exists()) {
                    LOGGER.info("jar包/config仍然不存在,开始加载classpath下");
                    resource = new DefaultResourceLoader().getResource("classpath:" + fileName);
                }
                pro.load(resource.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            Set<Map.Entry<Object, Object>> set = pro.entrySet();
            for (Map.Entry<Object, Object> entry : set) {
                map.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }


    /**
     * 获取制定键的值
     *
     * @param key
     * @return
     */
    public String findVal(String key) {
        return map.get(key);
    }

    public String findVal(String key, String defalutVal) {
        String val = map.get(key);
        if (val == null) {
            return defalutVal;
        }
        return val;
    }

    public  Map<String, String> getAllProperties(){
        return map;
    }

    /**
     * 将configMap集合中数据写出到filePath 指定文件中
     *
     * @param fileName
     * @param configMap
     * @throws IOException
     */
    public static void writeProperties(String fileName,
                                       Map<String, String> configMap) throws IOException {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                log.info("jar包同级不存在,开始加载config/下");
                file = new File("config/" + fileName);
            }
            Resource resource = new FileSystemResource(file);
            if (!resource.exists()) {
                log.info("jar包/config仍然不存在,请检查配置文件路径");
                //resource = new DefaultResourceLoader().getResource("classpath:" + fileName);
                throw new Exception("配置文件未找到,请检查文件路径");
            }
            PropertiesConfiguration configuration = new PropertiesConfiguration(resource.getURL());
            configuration.setAutoSave(true);
            //迭代访问集合，设置配置文件的值
            Set<String> keySet = configMap.keySet();
            Iterator<String> iterator = keySet.iterator();
            String key = null;
            String value = null;
            while (iterator.hasNext()) {
                key = iterator.next();
                // 如果key 为空，进行下一次循环
                if (StringUtils.isBlank(key)) {
                    continue;
                }
                value = configMap.get(key);

                if (StringUtils.isBlank(value)) {
                    continue;
                }
                configuration.setProperty(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
