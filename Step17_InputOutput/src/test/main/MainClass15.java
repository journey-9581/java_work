package test.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainClass15 {
	public static void main(String[] args) {
		/*
		 * FileInputStream 객체를 이용해서
		 * c:/myFolder/1.jpg에서 byte 데이터를 읽어들여서
		 * 
		 * FileOutputStream 객체를 이용해서
		 * c:/myFolder/copied.jpg 파일에 출력하기
		 */
		//FileInputStream type의 참조값을 담을 지역변수 미리 만들기
		FileInputStream fis=null;
		//FileOutputStream type의 참조값을 담을 지역변수 미리 만들기
		FileOutputStream fos=null;
		try {
			//파일로부터 byte 알갱이를 읽어 들일 수 있는 객체 생성
			fis=new FileInputStream(new File("c:/myFolder/1.jpg"));
			//파일에 byte 알갱이를 출력할 수 있는 객체 생성
			fos=new FileOutputStream(new File("c:/myFolder/copied.jpg"));
			while(true) {
				int data=fis.read(); //1byte 읽어들이기
			if(data==-1) { //더 이상 읽을 데이터가 없으면
				break; //while 반복문 탈출
			}
			fos.write(data); //출력할 준비
			fos.flush(); //방출(실제 출력되는 시점)
			}
			
			System.out.println("파일을 성공적으로 복사했습니다");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally { //예외가 발생하든 안하든 실행이 보장되는 블럭
			//마무리 작업(새로 open한 스트림은 닫아주어야한다)
			try {
				fis.close();
				fos.close();
			}catch(Exception e) {
				
			}
		}
	}
}
