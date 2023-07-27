package com.iu.main.file;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import com.iu.main.MyTest;

public class FileTest extends MyTest{

	@Test
	public void test() {
		//File 
		File file = new File("C:\\study\\study.txt");
		
		System.out.println(file.exists());
		System.out.println(file.isFile());
		file = new File("C:\\study", "study.txt");
		
		file = new File("C:\\study");
		System.out.println(file.exists());
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		System.out.println("======================");
		file = new File(file, "ex");
		System.out.println(file.exists());
		System.out.println(file.isDirectory());
		file.delete();
		file = new File("C:\\study\\study.txt");
		file.delete();
		file = new File("C:\\study");
//		file.delete(); //파일안에 뭐가있으면 안지워짐
		String[] list = file.list();
		//향상된  for 문
		//for(Collection에 모은 타입 변수명: Collection 변수명)
		for(String str:list) {
			System.out.println(str);
		}
		file = new File(file,"t1");
		file.mkdir();
		
		file = new File(file,"sub1\\sub2"); 
		file.mkdir(); //중간 없는 폴더인경우면 생성되지않음
		file.mkdirs();
	}

}
