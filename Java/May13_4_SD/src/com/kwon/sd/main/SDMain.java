package com.kwon.sd.main;

import java.util.ArrayList;

import com.kwon.sd.student.Student;
import com.kwon.sd.student.StudentDAO;

// MVC
// DAO/DTO
// AOP

// C
public class SDMain {
	public static void main(String[] args) {
		int menu = 0;
		Student s = null;
		String result = null;
		ArrayList<Student> result2 = null;
		while (true) {
			menu = ConsoleScreen.showMainMenu();
			if (menu == 1) {
				s = ConsoleScreen.showRegStudentMenu();
				result = StudentDAO.getSdao().reg(s);
				ConsoleScreen.printResult(result);
			} else if (menu == 2) {
				s = ConsoleScreen.showDelStudentMenu();
				result = StudentDAO.getSdao().del(s);
				ConsoleScreen.printResult(result);
			} else if (menu == 3) {
				s = ConsoleScreen.showUpdateStudentMenu();
				result = StudentDAO.getSdao().update(s);
				ConsoleScreen.printResult(result);
			} else if (menu == 4) {
				result2 = StudentDAO.getSdao().getAllStudent();
				ConsoleScreen.printResult2(result2);
			} else if (menu == 5) {
				s = ConsoleScreen.showSearchStudentMenu();
				result2 = StudentDAO.getSdao().search(s);
				ConsoleScreen.printResult2(result2);
			} else if (menu == 9) {
				break;
			}
		}
	}
}
