package com.student_chose_class.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class StudentMap {
	/**
	 * 用来承装学生的属性
	 * @param args
	 */
	private Map<String,Student>students;
	private Scanner in;
	
	/*
	 * 构造方法中初始化students的属性
	 */
	public StudentMap(){
		this.students=new HashMap<String,Student>();
	}
	
	private void StudentPut(){
		in = new Scanner(System.in);
		for(int i=0;i<3;){
			System.out.print("请输入第"+(i+1)+"位学生ID:");
			String studentID=in.next();
			Student st=students.get(studentID);
			if(st==null){
				System.out.print("请输入学生姓名:");
				String studentName=in.next();
				Student newStudents=new Student(studentID, studentName);
				students.put(studentID, newStudents);
				System.out.println("成功添加学生："+students.get(studentID).getName());
				i++;
			}else{
				System.out.println("此学生ID已被占用，请检查后重新输入");
			}
		}
	}
	/*
	 * 通过KeySet方法遍历
	 */
	private void studentKeySet(){
		Set<String> studentIDs=students.keySet();
		System.out.println("共有"+students.size()+"名学生已经登记");
		for (String IDs : studentIDs) {
			Student st=students.get(IDs);
			if(st!=null){
				System.out.println("姓名："+st.getName()+"\t学号："+st.getId());
			}
		}
	}
	/*
	 * 通过EntrySet方法遍历
	 */
	private void studentEntrySet(){
		System.out.println("共有"+students.size()+"名学生已经登记");
		Set<Entry<String,Student>> entrySet=students.entrySet();
		for (Entry<String, Student> entry : entrySet) {
			System.out.println("姓名："+entry.getValue().getName()+"\t学号："+entry.getKey());
		}
	}
	
	private void studentRemove(){
		Boolean IDnotHere=true;
		while(IDnotHere){
			System.out.println("请输入您要删除的学生ID");
			String Id=in.next();
			Student st=students.get(Id);
			if(st==null){
				System.out.println("您输入的ID有误，请检查后重新输入");
			}else{
				System.out.println("已经成功删除学生 "+students.get(Id).getName());
				students.remove(Id);
				IDnotHere=false;
			}
		}
	}
	
	private void studentModify() {
		boolean IDnotHere=true;
		while(IDnotHere){
			System.out.println("请输入要修改的学生ID");
			String ID=in.next();
			Student  student=students.get(ID);
			if(student==null){
				System.out.println("该ID对应的学生不存在，请检查后重新输入");
			}else{
				System.out.println("当前学生ID对应的学生姓名为:"+student.getName());
				System.out.println("请输入新的学生姓名");
				String name=in.next();
				Student newst=new Student(ID, name);
				students.put(ID, newst);
				System.out.println("修改完成！");
				System.out.println("学生ID:"+students.get(ID).getId()+"\t学生姓名:"+students.get(ID).getName());
				IDnotHere=false;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentMap studentlist=new StudentMap();
		studentlist.StudentPut();
		studentlist.studentKeySet();
		studentlist.studentRemove();
		studentlist.studentModify();
		studentlist.studentEntrySet();
	}

}
