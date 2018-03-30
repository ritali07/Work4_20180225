package com.work4.teacher;

import java.io.File;
import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;

public abstract class MyMIS implements MISRule {
	
	public static final String PATH="d:\\mydb.properties";
	PropertiesConfiguration conf=null;
	
	MyMIS(){
		try {
			FileUtils.touch(new File(PATH));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("构建存储系统异常！");
			e1.printStackTrace();
		}
		
		 try {
			 
			 conf=new PropertiesConfiguration(PATH);
			 System.out.println("连接存储系统成功！");
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			 System.out.println("连接存储系统异常！");
			e.printStackTrace();
		}
	
		
	}
	
	public boolean checkPassword(String p_user,String p_pwd){
		if(isUserExists(p_user)) {
			
			if (p_pwd.equals(getPassword(p_user)))
				return true;
			else 
				return false;		
			
		}
		return false;
	}
	
	private String getPassword(String p_user){
		
		if(isUserExists(p_user)) {
				
			return conf.getString(p_user);
			
		}
		return null;
		
	} 
	
	public boolean updatePassword(String p_user,String p_pwd){
		
		if(isUserExists(p_user)) 
		{
			conf.setProperty(p_user, p_pwd);
			try {
				conf.save();
				System.out.println("更新用户密码成功");
			} catch (ConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
			return true;
		}
		else 
		{
			System.out.println("更新用户密码失败");
			return false;
		}
			
		
		
	}
	
	public boolean isUserExists(String p_user){
		
		if (conf.containsKey(p_user))
		{
			System.out.println("信息系统中存在用户："+p_user);
			return true;
		}
		 
		else 
		{
			System.out.println("信息系统中不存在用户："+p_user);
			 return false;
		}
		  
	}

	public boolean getUserRule(String p_user) {
		// TODO Auto-generated method stub
		if(p_user.length()>5)
			return true;
		else
			return false;
	}

	public boolean getPwdRule(String p_pwd) {
		// TODO Auto-generated method stub
		if(p_pwd.length()>5)
			return true;
		else
			return false;
	}

}
