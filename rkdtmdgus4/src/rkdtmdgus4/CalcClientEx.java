import java.io.*;
import java.net.*;
import java.util.*;

public class CalcClientEx {
  public static void main(String[] args) {
	BufferedReader in = null;
	BufferedWriter out= null;
	Socket socket = null;
	Scanner scanner = new Scanner(System.in);
	try {
		socket = new Socket("localhost", 9999);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		while (true) {
		  System.out.print("����(��ĭ���� ��� �Է�,��:24 + 42)>>"); //������Ʈ
		  String outputMessage = scanner.nextLine();//Ű���忡�� ���� �б�
		  if (outputMessage.equalsIgnoreCase("bye")) {
			  out.write(outputMessage + "wn");//"bye"���ڿ� ����
			  out.flush();
			  break; // ����ڰ� "bye"�� �Է��� ��� ������ ���� �� ���� ����
		  }
		  out.write(outputMessage+"wn");//Ű���忡�� ���� ���� ���ڿ� ����
		  out.flush();
		  String inputMessage = in.readLine(); //�����κ��� ��� ��� ����
		  System.out.println("��� ���:" + inputMessage);
		}
	}catch (IOException e) {
	   System.out.println(e.getMessage());
	}finally {
	   try {
		  scanner.close();
		  if(socket != null) socket.close(); //Ŭ���̾�Ʈ ���ϴݱ�
	   }catch (IOException e) {
		 System.out.println("������ ä�� �� ������ �߻��߽��ϴ�.");
	   }
	}
  }
}