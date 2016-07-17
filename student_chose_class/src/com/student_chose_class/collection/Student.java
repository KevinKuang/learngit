package com.student_chose_class.collection;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private String id;
	private String name;
	public Set<Course> couses;

	public String getId() {
		return id;
	}
	private void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	public Student(String newId,String newName){
		setId(newId);
		setName(newName);
		this.couses=new HashSet<Course>();
	}

}
