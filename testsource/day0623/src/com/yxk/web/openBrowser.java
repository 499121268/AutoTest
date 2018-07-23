package com.yxk.web;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class openBrowser {
	


public static void openbrowser() throws InterruptedException {
	// TODO Auto-generated method stub
	System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\cpx\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://sc.chupinxiu.com/web/user/home/");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取网页title
		System.out.println(driver.getTitle());
		System.out.println("网页加载成功！");
		// 制定浏览器打开位置
		/*
		 * Point position =new Point(0,0);
		 * 
		 * driver.manage().window().setPosition(position);
		 * System.out.println(driver.manage().window().getPosition());
		 */
		// 确定浏览器打开大小
		/*
		 * Dimension size= new Dimension(1024, 1080);
		 * driver.manage().window().setSize(size);
		 * System.out.println(driver.manage().window().getSize());
		 */
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// 输入用户名登录
		driver.findElement(By.id("username")).sendKeys("17610765068");
		driver.findElement(By.id("password")).sendKeys("123456");
		// 点击搜索操作
		driver.findElement(By.id("loginBtn")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("登录成功！");
		Thread.sleep(1000);
		
		
		//切换门店
		WebElement MDid = driver.findElement(By
				.xpath("//*[@id='cpxContainer']/div[1]/ul/li[3]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(MDid).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='cpxContainer']/div[1]/ul/li[3]/ul/li[16]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='confirm']")).click();
		Thread.sleep(1000);
		System.out.println("门店切换成功！");
		
}



}
