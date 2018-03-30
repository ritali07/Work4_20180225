package com.work4.rita;

import java.io.IOException;

import org.apache.commons.configuration.*;

public class MyDB  {
//	String userName;
//	String passwd;
	
	public static void main(String args[]){
		MyDB db = new MyDB();
		db.register("rita11");
		db.updatePass("rita1", "aaaaaaa");
	}
	
	public void register(String userName){
		String path = "D:\\mydb.properties";
		Configuration config;
		try {
			config = new PropertiesConfiguration(path);
			if(config.containsKey(userName)){
				System.out.println("该用户已存在！");
//				System.out.println(config.getString(userName));
				return ;
			}else{
				System.out.println(userName + "不存在,注册为新用户，默认密码为123456");
				config.addProperty(userName, "123456");
				System.out.println("新注册用户信息为：" + userName + "=" +config.getString(userName));
			}
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void updatePass(String userName, String newPass){
		String path = "D:\\mydb.properties";
		try {
			Configuration config = new PropertiesConfiguration(path);
			if(!config.containsKey(userName)){
				System.out.println("用户名不存在！");
				return ;
			}else{
				System.out.println(userName + "旧密码：" + config.getString(userName));
				config.setProperty(userName, newPass);
				System.out.println(userName + "新密码：" + config.getString(userName));
			}
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
