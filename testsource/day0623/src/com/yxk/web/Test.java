package com.yxk.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

class Test {
	public static void main(String[] args) throws InterruptedException, IOException, AWTException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\cpx\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://sc.chupinxiu.com/web/user/home");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ��ȡ��ҳtitle
		System.out.println(driver.getTitle());
		System.out.println("��ҳ���سɹ���");
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// �����û�����¼
		driver.findElement(By.id("username")).sendKeys("17610765068");
		driver.findElement(By.id("password")).sendKeys("123456");
		// �����������
		driver.findElement(By.id("loginBtn")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("��¼�ɹ���");
		Thread.sleep(1000);
		
		
		//�л��ŵ�
		WebElement MDid = driver.findElement(By
				.xpath("//*[@id='cpxContainer']/div[1]/ul/li[3]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(MDid).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='cpxContainer']/div[1]/ul/li[3]/ul/li[16]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='confirm']")).click();
		Thread.sleep(1000);
		System.out.println("�ŵ��л��ɹ���");
		
		
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
		Thread.sleep(2000);

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

	private static WebDriver ChromeDriver() {
		// TODO Auto-generated method stub
		return null;
	}
}
