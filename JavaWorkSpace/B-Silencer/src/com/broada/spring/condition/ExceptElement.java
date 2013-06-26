package com.broada.spring.condition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * ����Ԫ�ز��ң�Ԫ�ش���
 * @author Administrator
 *
 */
public class ExceptElement implements ExpectedCondition<WebElement> {
    private By by;

    public ExceptElement(By by) {
        this.by = by;
    }

    public WebElement apply(WebDriver d) {
        WebElement element = null;
        element = d.findElement(by);
        return element;
    }
}