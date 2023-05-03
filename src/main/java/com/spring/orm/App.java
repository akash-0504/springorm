package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import javax.persistence.Id;

import org.springframework.aop.support.Pointcuts;
import org.springframework.cglib.core.TinyBitSet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entites.Student;

import net.bytebuddy.description.field.FieldDescription.InGenericShape;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//    	Student student = new Student(444,"akash bairagi", "indore");
//    	int r = studentDao.insert(student);
//    	System.out.println("done" + r);
//    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean go = true;

		while (go) {
			System.out.println("press 1 for the add new student");
			System.out.println("press 2 for disply all student");
			System.out.println("press 3 for get details of single student");
			System.out.println("press 4 for delete students");
			System.out.println("press 5 for update student");
			System.out.println("press 6 for exit");

			try {
				int input = Integer.parseInt(br.readLine());

//                (input ==1) {
//    				  //add a new student 
//    			  }else  if(input ==2d) 
//    			  {
//    				  //display	
//				  }
//    			  
				switch (input) {
				case 1:
					// add a new student
					// taking user inputs from user
					System.out.println("enter user id");
					int uid = Integer.parseInt(br.readLine());

					System.out.println("enter user name");
					String uName = br.readLine();

					System.out.println("enter user city");
					String uCity = br.readLine();

					// creating user object and setting values
					Student s = new Student();
					s.setStudentId(uid);
					s.setStudentName(uName);
					s.setStudentCity(uCity);

					// saving student object to database by calling insert of student dao
					int r = studentDao.insert(s);
					System.out.println(r + "student added");
					System.out.println("************************************");
					System.out.println();

					break;
				case 2:
					// display all student
					System.out.println("**************************************");
					List<Student> allStudents = studentDao.getallstudentsList();
					for (Student st : allStudents) {
						System.out.println("Id : " + st.getStudentId());
						System.out.println("Name : " + st.getStudentName());
						System.out.println("City : " + st.getStudentCity());
						System.out.println("----------------------------------------");
					}
					System.out.println("******************************************");
					break;
				case 3:
					// get single student data
					System.out.println("enter user id");
					int userId = Integer.parseInt(br.readLine());
					Student student = studentDao.getStudent(userId);
					System.out.println("Id : " + student.getStudentId());
					System.out.println("Name : " + student.getStudentName());
					System.out.println("City : " + student.getStudentCity());
					System.out.println("----------------------------------------");
					break;
				case 4:
					// delete student
					System.out.println("enter user id");
					int id = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(id);
					System.out.println("Student deleted...");
					break;
				case 5:
					// update the student
					System.out.println("enter the student id to be updated");
					int updid = Integer.parseInt(br.readLine());
					System.out.println("press 1 for update the name");
					System.out.println("press 2 for update the city");
					int nameorcity = Integer.parseInt(br.readLine());
					Student student2 = studentDao.getStudent(updid);
					String updateName = student2.getStudentCity();
					String updateCity = student2.getStudentCity();

					switch (nameorcity) {
					case 1:
						System.out.println("enter the name to updated");
						updateName = br.readLine();
						student2 = new Student(updid, updateName, updateCity);
						break;
					case 2:
						System.out.println("enter the city to updated");
						updateCity = br.readLine();
						student2 = new Student(updid, updateName, updateCity);
						break;

					}
					studentDao.upadteStudent(student2);
					System.out.println("Student updated...");
					break;

				  case 6:
					// exit
					go = false;
					break;

				}

			} catch (Exception e) {
				System.out.println("invalid input try with another one");

				System.err.println(e.getMessage());
			}
			// TODO: handle exception
		}

		System.out.println("thank you using my appliction");
		System.out.println("see you soon!!");

	}
}
