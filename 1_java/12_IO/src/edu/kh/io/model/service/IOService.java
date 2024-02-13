package edu.kh.io.model.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.kh.io.dto.Student;

public class IOService {
	
	// IO
	
	// Input (입력) : 외부 -> 내부로 데이터를 들여오는 것
	// Output (출력) : 내부 -> 외부로 데이터를 내보내는 것
	
	// Stream : 입/출력 통로 역할(데이터가 흘러가는 통로)
	
	// 1) 파일 출력 (내부 == 프로그램, 외부 == 파일)
	public void output1() {
		
		FileOutputStream fos = null;
		// FileOutputStream 객체 생성 시
		// FileNotFoundExceptio 예외가 발생할 가능성이 있음 -> 예외 처리 필요
		
		try {
			fos = new FileOutputStream("test1.txt");
			// 현재 프로그램에서
			// test1.txt 파일로 출력하는 통로 객체 생성 
			
			// 파일에 "Hello" 내보내기
			String str = "Hello";
			
			for(int i=0; i<str.length(); i++) {
				
				System.out.println(str.charAt(i));
				
				// "Hello"를 한 문자씩 끊어서 파일로 출력하기
				fos.write( str.charAt(i) );
				
				// write() 는 IOException을 발생시킬 가능성이 있다.
			}
			
		}catch(IOException e) {
			System.out.println("예외 발생");
			e.printStackTrace(); // 예외 추적
			
		}finally {
			
			//  예외가 발생 하든 말든 무조건 수행
			
			// 사용한 스트림 자원 반환(통로 없앰) --> 필수 작성!
			// 프로그램 메모리 관리 차원에서 항상 다쓰면 끊어줌
			// -> 작성 안하면 문제점으로 꼽을 수 있다.
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	// 2) 파일 출력(문자 기반 스트림)
	public void output2() {
		
		FileWriter fw = null; // 프로그램 -> 파일로 쓰는 문자 기반 스트림
		
		try {
			fw = new FileWriter("test2.txt",true); // 외부 파일과 연결하는 스트림 객체 생성
		//  fw = new FileWriter("경로", 이어쓰기 옵션);
							// -> byte 기반 스트림도 사용 가능한 옵션
			
			String str = "안녕하세요. Hello. 1234 ~!@#$ ^^\n";
			
			// fw.write(int c)	  : 한 문자 씩
			// fw.write(String s) : 한 줄씩 출력
			
			fw.write(str);
			// 실행했는데 출력이 안된다.. 왜일까??
			// -> 한 줄을 통째로 보내기 위해 "버퍼"를 이용하는데
			// 아직 버퍼에 담겨 있음! -> 이걸 강제로 밀어넣어서 버퍼를 비워야함
			
			// close() 구문을 수행하면 통로에 남아있는 내용을 모두 내보내고
			// 통로를 없앤다!
			
			
		}catch(IOException e) {
			e.printStackTrace(); // 예외 추적
			
		}finally {
			
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	// 3) 파일 입력 : 외부(파일) -> 내부(프로그램)으로 읽어오기
	public void input1() {
		
		FileInputStream fis = null; // 파일 -> 프로그램으로 읽어오는 바이트 기반 스트림
		
		try {
			fis = new FileInputStream("test1.txt");
			
			// FileInputStream은 1byte씩만 읽어올 수 있다.
			while(true) {
				
				int data = fis.read(); // 다음 1byte를 읽어오는데 정수형임
									   // 다음 내용이 없으면 -1 반환
				
				if(data == -1) { // 다음 내용 없음 => 종료
					break;
				}
				
				// 반복 종료 안됐으면 char로 강제 형변환하여 문자로 출력
				System.out.print((char)data);
			}
		} catch(IOException e){
			e.printStackTrace();
			
		}finally {
			
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 4) 파일 입력(문자 기반 스트림)
	public void input2() {
		
		FileReader fr = null;
		
		try {
			
			fr = new FileReader("test2.txt");
			
			while(true) {
				
				int data = fr.read(); // 다음 한 문자를 읽어옴. 없으면 -1
				
				if(data == -1) {
					break;
				}
				System.out.print((char)data);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	// 5) 객체 출력 보조 스트림
	public void objectOutput() {
		
		// ObjectXXXStream : 객체를 파일 또는 네트워크를 통해
		//					 입/출력할 수 있는 스트림
		
		// ObjectOutputStream
		// -> 객체를 바이트 기반 스트림으로 출력할 수 있게하는 스트림
		//    조건 : 출력하려는 객체에 직렬화 가능 여부를 나타내는
		//			Serializable 인터페이스를 상속 받아야 한다.
		
		ObjectOutputStream oos = null;
		
		try {
			
			oos = new ObjectOutputStream(new FileOutputStream("object/Student.txt"));
			
			// 내보낼 학생 객체 생성
			Student s = new Student("홍길동", 3, 5, 7, '남');
			
			// 학생 객체를 파일로 출력
			oos.writeObject(s);
			
			System.out.println("학생 출력 완료");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(oos != null) oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	// 6) 객체 입력 보조 스트림
	public void objectInput() {
		
		ObjectInputStream ois = null;
		
		try {
			
			ois = new ObjectInputStream(new FileInputStream("object/Student.txt"));
			
			Student s = (Student) ois.readObject();
			// readObject() : 직렬화된 객체 데이터를 읽어와
			//				  역직렬화 시켜 정상적인 객체 형태로 반환
			// throws IOException, ClassNotFoundException
			
			System.out.println(s);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ois != null) ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 7) List에 Student 객체를 담아서 파일로 출력
	public void listOutput() {
		
		ObjectOutputStream oos = null;
		
		try {
			
			oos = new ObjectOutputStream(new FileOutputStream("object/studentList.ini"));
			
			List<Student> list = new ArrayList<>();
			
			list.add(new Student("A", 1, 1, 1, '여'));
			list.add(new Student("B", 2, 2, 2, '여'));
			list.add(new Student("C", 3, 3, 3, '남'));
			list.add(new Student("D", 1, 2, 3, '남'));
			
			oos.writeObject(list);
			// writeObject(객체) : 출력하려는 객체는 직렬화가 가능해야만 한다!
			//					  Serializable 인터페이스 구현 필수
			
			// 컬렉션은 모두 직렬화가 가능하도록 Serializable 인터페이스 구현 O
			// -> 단, 컬렉션에 저장하는 객체가 직렬화 가능하지 않다면
			//    출력되지 않는다. (NotSerializableException 발생)
			
			System.out.println("학생 출력 완료");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(oos != null) oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void listInput() {
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("object/StudentList.ini"));
			
			List<Student> list = (List<Student>)ois.readObject();
			
			for(Student std : list) {
				System.out.println(std);
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ois != null) ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
