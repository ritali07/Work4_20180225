package com.work4.teacher;

import org.apache.commons.configuration.ConfigurationException;

public class Register extends MyMIS {


	
	public  boolean addInfo(String p_usr,String p_pwd){
		
		if (super.conf.containsKey(p_usr))
		{
			System.out.println("用户 "+p_usr+"已经存在，请登录!");
			return false;
		}
		
		if(super.getUserRule(p_usr)&&super.getPwdRule(p_pwd)){
			super.conf.addProperty(p_usr, p_pwd);
			try {
				super.conf.save();
			} catch (ConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
		}
		else 
		{
			System.out.println("注册失败！设置的用户名或者密码长度必须大于6位！");
			return false;
		}
		
		System.out.println("注册用户："+p_usr+"成功！");
		return true;
		
	}
	public  boolean changeinfo(String p_usr,String p_pwd){
		return true;
	}
	
	public  boolean deleteinfo(String p_usr,String p_pwd){
		return true;
	}
	
	
}
