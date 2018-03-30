package com.work4.teacher;

public class Login extends MyMIS {
	public boolean login(String p_usr,String p_pwd){
		if (!isUserExists(p_usr))
		{
			System.out.println("用户不存在请先注册！");
			return false;
		}
			
		if (checkPassword(p_usr, p_pwd))
		{
			System.out.println("登录成功！");
			return true;
		}
		    
		else  
		{
			 System.out.println("密码输入错误，请重新输入！");
			 return false;
		}
			
	}
	
	public boolean resetPwd(String p_user,String p_0ld_pwd,String p_new_pwd){
		return true;
	}

}
