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
     * ��ȡԪ�صı�ʾ����
     * 
     * @param key
     *            yaml�ļ��е���ѡ��Ϊ����
     * @return ����Ԫ�ر�ʾ
     */
    @SuppressWarnings("rawtypes")
    public HashMap getDataMap() {
        String encoding = "GBK";
        InputStreamReader read = null;
        try {
            read = new InputStreamReader(new FileInputStream(file), encoding);
        } catch (UnsupportedEncodingException e) {
            this.log.error("Ԫ��ҳ���ļ� " + file.getAbsolutePath()
                    + "�ı��뷽ʽ�����ϣ�����GBKͳһ���롣");
            this.log.info("ִ�н���");
//            System.exit(0);
        } catch (FileNotFoundException e) {
            this.log.error("Ԫ��ҳ���ļ�" + file.getAbsolutePath() + "�����ڡ�");
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
