package com.work4.teacher;

public class LoginSys2 extends MyMIS{
	
	public static void main(String args[]){
		LoginSys2 ls = new LoginSys2();
		ls.login("rita1", "1234");
	}
	public void login(String userName, String pass){
		if(!isUserExists(userName)){
			System.out.println("用户名不存在，请先注册！");
		}else if(!checkPassword(userName, pass)){
			System.out.println("密码错误！");
		}else{
			System.out.println("登录成功");
		}
		
	}
	
}
