package example2;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
	public static void main(String[] args) {
		//1. Socket을 통해서 출력할 문자열을 입력 받아서
		Scanner scan=new Scanner(System.in);
		System.out.println("전송할 문자열 입력: ");
		String msg=scan.nextLine();
		
		Socket socket=null;
		try {
			//new Socket("접속할 ip 주소", 포트번호);
			socket=new Socket("127.0.0.1", 5000);
			System.out.println("서버에 Socket 접속 성공");
			//2. Socket을 통해서 출력하기
			OutputStream os=socket.getOutputStream();
			OutputStreamWriter osw=new OutputStreamWriter(os);
			osw.write(msg);
			osw.write("\r\n");
			osw.flush();
			osw.close();
			socket.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
