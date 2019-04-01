package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.yychat.model.Message;
import com.yychat.model.User;

public class StartServer {
	ServerSocket ss;
	Socket s;
	
	public StartServer(){
		try {
				ss=new ServerSocket(3456);//�������˿ڼ���3456�˿�
			 System.out.println("�������Ѿ�����������3456�˿�");
			 s=ss.accept();//�ȴ��ͻ��˽�������
			 System.out.println(s);//�������Socket����
			 
			 //�ֽ���������װ�� ����������
			 ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			 User user=(User)ois.readObject();
			 System.out.println(user.getUserName());
			 System.out.println(user.getPassword());
			 
			 //Server����֤�����Ƿ�123456��
			 Message mess=new Message();
			 mess.setSender("Server");
			 mess.setReceiver(user.getUserName());
			 if(user.getPassword().equals("123456")){//�����á�==��������Ƚ�
				//��Ϣ���� ����һ��Message����
				
				 mess.setMessageTapy("1");//��֤ͨ��
			 }
			 else{
				mess.setMessageTapy("0");//��֤��ͨ��
				 
			 }
			 ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			 oos.writeObject(mess);
			 
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

	}


}