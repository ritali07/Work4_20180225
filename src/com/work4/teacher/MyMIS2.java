package com.my.homework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;

public class MyMIS2 implements MISRule {
	
	public static final String PATH="d:\\config2.properties";
	PropertiesConfiguration conf=null;
	
	MyMIS2(){
		try {
			FileUtils.touch(new File(PATH));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("�����洢ϵͳ�쳣��");
			e1.printStackTrace();
		}
		
		 try {
			 
			 conf=new PropertiesConfiguration(PATH);
			 System.out.println("���Ӵ洢ϵͳ�ɹ���");
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			 System.out.println("���Ӵ洢ϵͳ�쳣��");
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
			
			String pwd=conf.getString(p_user);
			//Object pwd	=conf.getProperty(p_user);
			System.out.println("��ȡ�û�����ɹ���");
			return pwd;
			
		}
		System.out.println("��ȡ�û�����ʧ�ܣ�");
		return null;
		
	} 
	
	public boolean updatePassword(String p_user,String p_pwd){
		
		if(isUserExists(p_user)) 
		{
			conf.setProperty(p_user, p_pwd);
			try {
				conf.save();
				System.out.println("�����û�����ɹ�");
			} catch (ConfigurationException e) {
				// TODO Auto-generated catch block
				System.out.println("�����û���������쳣");
				e.printStackTrace();
				return false;
			}
			
			return true;
		}
		else 
		{
			System.out.println("�û������ڣ������û�����ʧ�ܣ�");
			return false;
		}
			
		
		
	}
	
	public boolean isUserExists(String p_user){
		
		if (conf.containsKey(p_user))
		{
			System.out.println("��Ϣϵͳ�д����û���"+p_user);
			return true;
		}
		 
		else 
		{
			System.out.println("��Ϣϵͳ�в������û���"+p_user);
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
	
	public static void main(String[] args) {
		MyMIS2 my=new MyMIS2();
		System.out.println(my.getPassword("kevin"));
		
	}

}
