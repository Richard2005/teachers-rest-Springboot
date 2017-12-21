package com.platzi.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.platzi.model.Teacher;
import com.platzi.model.TeacherSocialMedia;

@Repository
@Transactional
public class TeacherDaoImpl extends AbstractSession implements TeacherDao {

	public TeacherDaoImpl() {
	}

	public void saveTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		getSession().persist(teacher);
	}

	public void deleteTeacherById(Long idTeacher) {
		// TODO Auto-generated method stub
		Teacher teacher = findById(idTeacher);
		if (teacher != null ) {
			
			Iterator<TeacherSocialMedia> i= teacher.getTeacherSocialMedias().iterator();
			while (i.hasNext()) {
				TeacherSocialMedia teacherSocialMedia = i.next();
				i.remove();
				getSession().delete(teacherSocialMedia);
			}
			teacher.getTeacherSocialMedias().clear();
			getSession().delete(teacher);
		}
	}

	public void updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		getSession().update(teacher);
	}

	public List<Teacher> findAllTeachers() {
		return getSession().createQuery("from Teacher").list();
	}

	public Teacher findById(Long idTeacher) {
		// TODO Auto-generated method stub
		return (Teacher) getSession().get(Teacher.class, idTeacher);
	}

	public Teacher findByName(String name) {
		// hql with a filter :name define el parametro de entrada query con filtro
		return (Teacher) getSession().createQuery("from Teacher where name = :name ").setParameter("name", name)
				.uniqueResult();
	}

}
