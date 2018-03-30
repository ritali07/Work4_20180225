package com.work4.rita;

import org.apache.commons.configuration.*;
public class LoginSys {
	
	public static void main(String args[]){
		LoginSys ls = new LoginSys();
		ls.login("rita1", "123456");
	}
	
	public void login(String userName, String passwd){
		String path = "D:\\mydb.properties";
		try {
			Configuration config = new PropertiesConfiguration(path);
			if(!config.containsKey(userName)){
				System.out.println("用户名不存在，请先注册！");
			}else if(!passwd.equals(config.getString(userName))){
				System.out.println("密码错误");
			}else{
				System.out.println("登录成功");
			}
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

