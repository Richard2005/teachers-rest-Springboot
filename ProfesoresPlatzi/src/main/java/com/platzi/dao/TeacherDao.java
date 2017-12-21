package com.platzi.dao;

import java.util.List;

import com.platzi.model.Teacher;


public interface TeacherDao {

	void saveTeacher(Teacher teacher);

	void deleteTeacherById(Long idTeacher);
	
	void updateTeacher(Teacher teacher);
	
	List<Teacher> findAllTeachers();
	
	Teacher findById(Long idTeacher);
	
	Teacher findByName(String name);
	
	

}
