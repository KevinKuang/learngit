package com.student_chose_class.collection;

public class Course {
	private String id;
	private String name;
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
	public Course(String newId,String newName){
		setId(newId);
		setName(newName);
	}

}
