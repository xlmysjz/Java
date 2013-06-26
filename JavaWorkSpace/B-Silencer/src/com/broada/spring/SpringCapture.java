package com.broada.spring;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.broada.utils.Silencer;

/**
 * ͨ��WebDriverץȡ��ǰ��Ļ
 * 
 * @author chingsir
 * 
 */
class SpringCapture {

    /**
     * 
     * Function to take the screen shot and save it to the classpath dir.
     * 
     * Usually, you will find the png file under the project root.
     * 
     * @param driver
     *            Webdriver instance
     * 
     * @param desc
     *            The description of the png
     */
    static void screenShot(WebDriver driver, String title) {
        String dir_name = Silencer.getString("pngs"); // ���ﶨ���˽�ͼ���Ŀ¼��
        if (!(new File(dir_name).isDirectory())) { // �ж��Ƿ���ڸ�Ŀ¼
            new File(dir_name).mkdir(); // ������������½�һ��Ŀ¼
        }
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source_file = ts.getScreenshotAs(OutputType.FILE); // �ؼ����룬ִ����Ļ��ͼ��Ĭ�ϻ�ѽ�ͼ���浽tempĿ¼
            FileUtils.copyFile(source_file, new File(dir_name + File.separator
                    + title+ ".png")); // ���ｫ��ͼ��浽������Ҫ�����Ŀ¼������screenshot\20120406-165210.png
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
