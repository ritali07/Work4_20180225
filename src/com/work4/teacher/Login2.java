package com.my.homework;

public class Login2 {
	
	 MyMIS my=new MyMIS();
	 MyMIS2 my2=new MyMIS2();
	
	public boolean login(String p_usr,String p_pwd){
		if (!my.isUserExists(p_usr))
		{
			System.out.println("�û�����������ע�ᣡ");
			return false;
		}
			
		if (my.checkPassword(p_usr, p_pwd))
		{
			System.out.println("��¼�ɹ���");
			return true;
		}
		    
		else  
		{
			 System.out.println("��������������������룡");
			 return false;
		}
			
	}
	
	public boolean resetPwd(String p_user,String p_0ld_pwd,String p_new_pwd){
		return true;
	}

}
