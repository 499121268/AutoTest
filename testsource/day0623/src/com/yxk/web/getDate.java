package com.yxk.web;

import java.text.SimpleDateFormat;
import java.util.Date;

public class getDate {
	public static void main(String[] args) {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
		System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
		
		
	}

}
