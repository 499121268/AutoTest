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
		
		
		//������
		WebElement settings = driver.findElement(By
				.xpath("//*[@id='leftNavList']/ul/li[1]/a"));
		// �����ͣ
		Actions action = new Actions(driver);
		action.moveToElement(settings).perform();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("��������");

		driver.findElement(By.xpath("//*[@id='leftNavList']/ul/li[1]/div/ul/li[1]/a")).click();

		Thread.sleep(2000);
		//iframe��ת
		driver.switchTo().frame("reimbursement-myExpenseApply");
		driver.findElement(By.xpath("//*[@id='create']")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		System.out.println("�½���������");
		
		
		Thread.sleep(2000);
		
		//ѡ������
		driver.switchTo().frame("reimbursement-createreim");
		
		//System.out.println("��д���ڣ���ʽΪ��20XX-XX-XX");
		//driver.findElement(By.id("start")).click();
		String js="document.getElementById('start').removeAttribute('readonly')";
		((JavascriptExecutor)driver).executeScript(js);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		driver.findElement(By.id("start")).sendKeys(df.format(new Date()));
		System.out.println("����ѡ��ɹ���"+df.format(new Date()));
        Thread.sleep(1000);
		/*
		driver.findElement(By.id("start")).click();
		String js="document.getElementById('start').removeAttribute('readonly')";
		((JavascriptExecutor)driver).executeScript(js);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		driver.findElement(By.id("start")).sendKeys(df.format(new Date()));
		System.out.println("ѡ�����ڳɹ�!");
		
		*/
		//��������ѡ��
		driver.findElement(By.xpath("//*[@id='reimType']/input")).click();
		driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[1]/div[1]/div[1]")).click();//�ɹ�����
		//driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[1]/div[1]/div[2]")).click();//��Դ����
		//driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[1]/div[1]/div[3]")).click();//���ý�ͨ����
		//driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[1]/div[1]/div[4]")).click();//�������
		//driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[1]/div[1]/div[5]")).click();//�ճ��������
		System.out.println("��������ѡ��ɹ�!");
		//String aa = driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[1]/div[1]/div[1]")).getText();
		//System.out.println(aa.getText());
		
		/*List<WebElement> list = driver.findElements(By.xpath("//*[@id='COMBO_WRAP']/div[1]"));
		
	    for (WebElement ele : list){  
	        
            if(ele.getAttribute("innerHTML").equals("�ɹ�����")){  
                ele.click();  
                break;  
            }  
        }  
		*/
		Thread.sleep(1000);
		
		//������
		driver.findElement(By.xpath("//*[@id='approvePerson']/i")).click();
		driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[2]/div/div")).click();
		System.out.println("������ѡ��ɹ�!");
		
		//��д��� 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='maingrid|2|r1001|c103']/div")).click();
		System.out.println("�����뱨����");
		BufferedReader bx =new BufferedReader(new InputStreamReader(System.in));
		String str2=bx.readLine();
		driver.findElement(By.xpath("//*[@id='maingrid']/div[6]/input")).sendKeys(str2);
		Thread.sleep(1000);
		
		//��ϸ����
		driver.findElement(By.xpath("//*[@id='maingrid|2|r1001|c104']/div")).click();
		/*
		System.out.println("������ϸ�������ݣ�");
		BufferedReader mx =new BufferedReader(new InputStreamReader(System.in));
		String str3=mx.readLine();
		driver.findElement(By.xpath("//*[@id='maingrid']/div[6]/div/input")).sendKeys(str3);
		Thread.sleep(1000);
		*/
		
		driver.findElement(By.xpath("//*[@id='maingrid']/div[6]/div/input")).sendKeys("�ɹ����á�");
		
		WebElement confirmButton = driver.findElement(By.xpath("//*[@id='maingrid|2|r1002|c103']/div"));
		confirmButton.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='create']")).click();
		
		Thread.sleep(2000);     
		driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr[3]/td/div[2]/button[1]")).click();
		System.out.println("�½��������ɹ���");
		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		

	}

	
}
