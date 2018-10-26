package com.gndu.islabs0002.abstraction;

import java.util.Comparator;

public class TeacherSalaryComprator implements Comparator<Teacher> {

	@Override
	public int compare(Teacher teacher1, Teacher teacher2) {
		if(teacher1.salary == teacher2.salary)
			return 0;
		else if(teacher1.salary > teacher2.salary)
			return 1;
		return -1;
	}

}
