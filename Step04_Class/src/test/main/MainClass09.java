package test.main;

import test.mart.Computer;
import test.mart.Cpu;
import test.mart.HardDisk;
import test.mart.Memory;

public class MainClass09 {
	public static void main(String[] args) {
		
		/*
		 *  [ 프로그래밍의 목적 ]
		 *  
		 *  test.mart 패키지 안에 있는 클래스를 활용하여 
		 *  1. 게임을 한다
		 *  2. oli999@naver.com 으로 이메일을 보낸다
		 */
		
		Cpu cpu1=new Cpu();
		HardDisk hardDisk1=new HardDisk();
		Memory memory1=new Memory();
		Computer com1=new Computer(cpu1, memory1, hardDisk1);
		com1.playGame();
		com1.sendEmail("oli999@naver.com");
		
		Computer c=new Computer(new Cpu(), new Memory(), new HardDisk());
		c.playGame();
		c.sendEmail("oli999@naver.com");
	}
}
