package com.yxk.web;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class bxTest extends openBrowser {
	

	
	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		
		
		WebDriver driver = new ChromeDriver();
		
		
		//报销单
		WebElement settings = driver.findElement(By
				.xpath("//*[@id='leftNavList']/ul/li[1]/a"));
		// 鼠标悬停
		Actions action = new Actions(driver);
		action.moveToElement(settings).perform();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("报销单！");

		driver.findElement(By.xpath("//*[@id='leftNavList']/ul/li[1]/div/ul/li[1]/a")).click();

		Thread.sleep(2000);
		//iframe跳转
		driver.switchTo().frame("reimbursement-myExpenseApply");
		driver.findElement(By.xpath("//*[@id='create']")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		System.out.println("新建报销单！");
		
		
		Thread.sleep(2000);
		
		//选择日期
		driver.switchTo().frame("reimbursement-createreim");
		
		//System.out.println("填写日期，格式为：20XX-XX-XX");
		//driver.findElement(By.id("start")).click();
		String js="document.getElementById('start').removeAttribute('readonly')";
		((JavascriptExecutor)driver).executeScript(js);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		driver.findElement(By.id("start")).sendKeys(df.format(new Date()));
		System.out.println("日期选择成功："+df.format(new Date()));
        Thread.sleep(1000);
		/*
		driver.findElement(By.id("start")).click();
		String js="document.getElementById('start').removeAttribute('readonly')";
		((JavascriptExecutor)driver).executeScript(js);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		driver.findElement(By.id("start")).sendKeys(df.format(new Date()));
		System.out.println("选择日期成功!");
		
		*/
		//报销类型选择
		driver.findElement(By.xpath("//*[@id='reimType']/input")).click();
		driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[1]/div[1]/div[1]")).click();//采购费用
		//driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[1]/div[1]/div[2]")).click();//能源费用
		//driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[1]/div[1]/div[3]")).click();//差旅交通费用
		//driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[1]/div[1]/div[4]")).click();//财务费用
		//driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[1]/div[1]/div[5]")).click();//日常管理费用
		System.out.println("报销类型选择成功!");
		//String aa = driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[1]/div[1]/div[1]")).getText();
		//System.out.println(aa.getText());
		
		/*List<WebElement> list = driver.findElements(By.xpath("//*[@id='COMBO_WRAP']/div[1]"));
		
	    for (WebElement ele : list){  
	        
            if(ele.getAttribute("innerHTML").equals("采购费用")){  
                ele.click();  
                break;  
            }  
        }  
		*/
		Thread.sleep(1000);
		
		//审批人
		driver.findElement(By.xpath("//*[@id='approvePerson']/i")).click();
		driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[2]/div/div")).click();
		System.out.println("审批人选择成功!");
		
		//填写金额 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='maingrid|2|r1001|c103']/div")).click();
		System.out.println("请输入报销金额：");
		BufferedReader bx =new BufferedReader(new InputStreamReader(System.in));
		String str2=bx.readLine();
		driver.findElement(By.xpath("//*[@id='maingrid']/div[6]/input")).sendKeys(str2);
		Thread.sleep(1000);
		
		//明细描述
		driver.findElement(By.xpath("//*[@id='maingrid|2|r1001|c104']/div")).click();
		/*
		System.out.println("请输明细描述内容：");
		BufferedReader mx =new BufferedReader(new InputStreamReader(System.in));
		String str3=mx.readLine();
		driver.findElement(By.xpath("//*[@id='maingrid']/div[6]/div/input")).sendKeys(str3);
		Thread.sleep(1000);
		*/
		
		driver.findElement(By.xpath("//*[@id='maingrid']/div[6]/div/input")).sendKeys("采购费用。");
		
		WebElement confirmButton = driver.findElement(By.xpath("//*[@id='maingrid|2|r1002|c103']/div"));
		confirmButton.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='create']")).click();
		
		Thread.sleep(2000);     
		driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr[3]/td/div[2]/button[1]")).click();
		System.out.println("新建报销单成功！");
		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		

	}

	
}
