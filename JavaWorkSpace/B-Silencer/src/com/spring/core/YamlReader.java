package com.spring.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.ho.yaml.Yaml;
/**
 * 
 * @author chingsir
 *
 */
public class YamlReader {

    private File file;
    private Log log;

    public YamlReader(File f, Log log) {
        this.file = f;
        this.log = log;
    }

    /**
     * 获取元素的标示序列
     * 
     * @param key
     *            yaml文件中的首选定为序列
     * @return 返回元素标示
     */
    @SuppressWarnings("rawtypes")
    public HashMap getDataMap() {
        String encoding = "GBK";
        InputStreamReader read = null;
        try {
            read = new InputStreamReader(new FileInputStream(file), encoding);
        } catch (UnsupportedEncodingException e) {
            this.log.error("元素页面文件 " + file.getAbsolutePath()
                    + "的编码方式不符合，请用GBK统一编码。");
            this.log.info("执行结束");
//            System.exit(0);
        } catch (FileNotFoundException e) {
            this.log.error("元素页面文件" + file.getAbsolutePath() + "不存在。");
//            System.exit(0);
        }
        if (read != null) {
            HashMap map = Yaml.loadType(read, HashMap.class);
            // HashMap selecter = (HashMap) ml.get(key);
            return map;
        }
        return null;
    }
}
