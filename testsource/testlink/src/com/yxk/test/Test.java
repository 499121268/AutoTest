package com.yxk.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test {

	WebDriver driver;
	String Url;

	// �������
	public void setUp() {
		Url = "http://kufang.chupinxiu.com/web";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\cpx\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public void openGoogle() {

		driver.get(Url);
	}

	// �����û�����¼
	public void login() {
		driver.findElement(By.id("username")).sendKeys("17610765068");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("loginBtn")).click();
		System.out.println(driver.getTitle() + "��½�ɹ�!");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// �л��ŵ�
	public void switchStores() {
		WebElement MDid = driver.findElement(By
				.xpath("//*[@id='cpxContainer']/div[1]/ul/li[3]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(MDid).perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(
				By.xpath("//*[@id='cpxContainer']/div[1]/ul/li[3]/ul/li[3]/a"))
				.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id='confirm']")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("�ŵ��л��ɹ���");
	}

	// �½�������
	public void newBXdan() throws InterruptedException {
		// ������
		WebElement settings = driver.findElement(By
				.xpath("//*[@id='leftNavList']/ul/li[1]/a"));
		// �����ͣ
		Actions action = new Actions(driver);
		action.moveToElement(settings).perform();

		Thread.sleep(1000);

		System.out.println("��������");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(
				By.xpath("//*[@id='leftNavList']/ul/li[1]/div/ul/li[1]/a"))
				.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// iframe��ת
		driver.switchTo().frame("reimbursement-myExpenseApply");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id='create']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().defaultContent();
		System.out.println("�½���������");

		Thread.sleep(2000);

		// ѡ������
		driver.switchTo().frame("reimbursement-createreim");

		// System.out.println("��д���ڣ���ʽΪ��20XX-XX-XX");
		// driver.findElement(By.id("start")).click();
		String js = "document.getElementById('start').removeAttribute('readonly')";
		((JavascriptExecutor) driver).executeScript(js);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		driver.findElement(By.id("start")).sendKeys(df.format(new Date()));
		System.out.println("����ѡ��ɹ���" + df.format(new Date()));

		Thread.sleep(1000);

		/*
		 * driver.findElement(By.id("start")).click(); String
		 * js="document.getElementById('start').removeAttribute('readonly')";
		 * ((JavascriptExecutor)driver).executeScript(js); BufferedReader buf =
		 * new BufferedReader(new InputStereamReader(System.in)); String str1 =
		 * buf.readLine(); driver.findElement(BY.ID("start")).sendKeys(str1);
		 * System.out.println("ѡ�����ڳɹ�!");
		 */
		// ��������ѡ��
		driver.findElement(By.xpath("//*[@id='reimType']/input")).click();
		driver.findElement(
				By.xpath("//*[@id='COMBO_WRAP']/div[1]/div[1]/div[1]")).click();// �ɹ�����
		// driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[1]/div[1]/div[2]")).click();//��Դ����
		// driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[1]/div[1]/div[3]")).click();//���ý�ͨ����
		// driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[1]/div[1]/div[4]")).click();//�������
		// driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[1]/div[1]/div[5]")).click();//�ճ��������
		System.out.println("��������ѡ��ɹ�!");

		Thread.sleep(1000);

		// ������
		driver.findElement(By.xpath("//*[@id='approvePerson']/i")).click();
		driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[2]/div/div"))
				.click();
		System.out.println("������ѡ��ɹ�!");

		// ��д���

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id='maingrid|2|r1001|c103']/div"))
				.click();
		System.out.println("�����뱨����");
		BufferedReader bx = new BufferedReader(new InputStreamReader(System.in));
		String str2 = null;

		try {
			str2 = bx.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		driver.findElement(By.xpath("//*[@id='maingrid']/div[6]/input"))
				.sendKeys(str2);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ��ϸ����
		driver.findElement(By.xpath("//*[@id='maingrid|2|r1001|c104']/div"))
				.click();
		/*
		 * System.out.println("������ϸ�������ݣ�"); BufferedReader mx =new
		 * BufferedReader(new InputStreamReader(System.in)); String
		 * str3=mx.readLine();
		 * driver.findElement(By.xpath("//*[@id='maingrid']/div[6]/div/input"
		 * )).sendKeys(str3); Thread.sleep(1000);
		 */

		driver.findElement(By.xpath("//*[@id='maingrid']/div[6]/div/input"))
				.sendKeys("�ɹ����á�");

		WebElement confirmButton = driver.findElement(By
				.xpath("//*[@id='maingrid|2|r1002|c103']/div"));
		confirmButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id='create']")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(
				By.xpath("/html/body/div[4]/div/table/tbody/tr[3]/td/div[2]/button[1]"))
				.click();
		System.out.println("�½��������ɹ���");
		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();

	}

	// ���ݿ�
	class SqlTest {
		// �������ؼ���
		private List<String> list;

		// ִ��Ϊlist��ֵ
		public void connect() {
			ResultSet rs = null;
			Connection con;
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://rm-2ze365o9a863j227uio.mysql.rds.aliyuncs.com/cpx_prod";
			String user = "cpx";
			String password = "qH8tsdcmtYTzXr5R";

			try {
				Class.forName(driver);
				// 1.getConnection()����������MySQL���ݿ⣡��
				con = DriverManager.getConnection(url, user, password);

				if (!con.isClosed()) {
					System.out.println("Succeeded connecting to the Database!");
				}

				// 2.����statement���������ִ��SQL��䣡��
				Statement statement = con.createStatement();

				con.setAutoCommit(false);

				// Ҫִ�е�SQL���
				String sql = "SELECT * FROM material WHERE shopId = 2273";

				// 3.ResultSet�࣬������Ż�ȡ�Ľ��������
				ResultSet rs1 = statement.executeQuery(sql);

				con.commit(); // �����ύ
				con.setAutoCommit(true); // ����jdbc�����Ĭ���ύ��ʽ

				list = new ArrayList<String>();

				while (rs1.next()) {
					list.add(rs1.getString(6));
				}

				/*
				 * if ((list != null) && (list.size() > 0)) { String[] arr = new
				 * String[list.size()];
				 * 
				 * for (int i = 0; i < list.size(); i++) { arr[i] = list.get(i);
				 * }
				 * 
				 * }
				 */
				rs1.close();
				con.close();
			} catch (ClassNotFoundException e) {
				System.out.println("Sorry,can`t find the Driver!");
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				System.out.println("���ݿ����ݳɹ���ȡ����");
			}
		}

		public List<String> getList() {
			return this.list;
		}
	}

	// �½��ɹ���
	public void newCGdan() throws InterruptedException {
		WebElement settings = driver.findElement(By
				.xpath("//*[@id='leftNavList']/ul/li[2]/a"));
		// �����ͣ
		Actions action = new Actions(driver);
		action.moveToElement(settings).perform();

		Thread.sleep(1000);

		System.out.println("�ɹ�����");

		Thread.sleep(2000);

		driver.findElement(
				By.xpath("//*[@id='leftNavList']/ul/li[2]/div/ul/li[2]/a"))
				.click();

		System.out.println("�½��ɹ���");

		Thread.sleep(2000);

		driver.switchTo().frame("purchase-mypurchase");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='create']")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();

		driver.switchTo().frame("purchase-createpurchase");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='purchaseDepartment']/i")).click();
		driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[1]/div/div[4]"))
				.click();
		Thread.sleep(2000);
		// ��ȡ��ǰʱ��

		// System.out.println("��д���ڣ���ʽΪ��20XX-XX-XX");
		// driver.findElement(By.id("start")).click();
		String js = "document.getElementById('start').removeAttribute('readonly')";
		((JavascriptExecutor) driver).executeScript(js);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		driver.findElement(By.id("start")).sendKeys(df.format(new Date()));
		System.out.println("����ѡ��ɹ���" + df.format(new Date()));

		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='approvePerson']/i")).click();
		driver.findElement(By.xpath("//*[@id='COMBO_WRAP']/div[2]/div/div[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='maingrid|2|r1001|c103']/div"))
				.click();
		Thread.sleep(1000);
		// ��ȡ���ݿ�������Ϣ
		SqlTest sq = new SqlTest();
		sq.connect();
		List<String> result = sq.getList();
		driver.findElement(By.xpath("//*[@id='maingrid']/div[6]/input"))
				.sendKeys(result.get(0));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='autocompleter-1']/ul/li"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='maingrid|2|r1001|c106']/div"))
				.click();

		Thread.sleep(1000);
		System.out.println("������ɹ�����������");
		Scanner input = new Scanner(System.in);
		String num = input.next();
		driver.findElement(By.xpath("//*[@id='maingrid']/div[6]/input"))
				.sendKeys(num);
		driver.findElement(By.xpath("//*[@id='maingrid|2|r1002|c106']/div"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='create']")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("/html/body/div[4]/div/table/tbody/tr[3]/td/div[2]/button[1]"))
				.click();
		driver.switchTo().defaultContent();
		System.out.println("�½��ɹ������!");

	}

	// 5���ˢ��ҳ��
	public void rf() {
		System.out.println("5���ˢ��!");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().refresh();
		System.out.println("ˢ�����!");
	}

	public void cxCGdan() throws InterruptedException, IOException {
		WebElement settings = driver.findElement(By
				.xpath("//*[@id='leftNavList']/ul/li[2]/a"));
		// �����ͣ
		Actions action = new Actions(driver);
		action.moveToElement(settings).perform();

		Thread.sleep(1000);

		System.out.println("�ɹ�����");

		Thread.sleep(2000);

		driver.findElement(
				By.xpath("//*[@id='leftNavList']/ul/li[2]/div/ul/li[2]/a"))
				.click();

		Thread.sleep(2000);

		driver.switchTo().frame("purchase-mypurchase");
		Thread.sleep(2000);
		driver.findElement(By.id("start")).click();
		String js = "document.getElementById('start').removeAttribute('readonly')";
		((JavascriptExecutor) driver).executeScript(js);
		BufferedReader buf = new BufferedReader(
				new InputStreamReader(System.in));

		String str1 = buf.readLine();
		driver.findElement(By.id("start")).sendKeys(str1);
		System.out.println("ѡ�����ڳɹ�!");

		driver.switchTo().defaultContent();
	}
}
