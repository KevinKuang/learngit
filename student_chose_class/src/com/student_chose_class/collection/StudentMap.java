package com.student_chose_class.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class StudentMap {
	/**
	 * ������װѧ��������
	 * @param args
	 */
	private Map<String,Student>students;
	private Scanner in;
	
	/*
	 * ���췽���г�ʼ��students������
	 */
	public StudentMap(){
		this.students=new HashMap<String,Student>();
	}
	
	private void StudentPut(){
		in = new Scanner(System.in);
		for(int i=0;i<3;){
			System.out.print("�������"+(i+1)+"λѧ��ID:");
			String studentID=in.next();
			Student st=students.get(studentID);
			if(st==null){
				System.out.print("������ѧ������:");
				String studentName=in.next();
				Student newStudents=new Student(studentID, studentName);
				students.put(studentID, newStudents);
				System.out.println("�ɹ����ѧ����"+students.get(studentID).getName());
				i++;
			}else{
				System.out.println("��ѧ��ID�ѱ�ռ�ã��������������");
			}
		}
	}
	/*
	 * ͨ��KeySet��������
	 */
	private void studentKeySet(){
		Set<String> studentIDs=students.keySet();
		System.out.println("����"+students.size()+"��ѧ���Ѿ��Ǽ�");
		for (String IDs : studentIDs) {
			Student st=students.get(IDs);
			if(st!=null){
				System.out.println("������"+st.getName()+"\tѧ�ţ�"+st.getId());
			}
		}
	}
	/*
	 * ͨ��EntrySet��������
	 */
	private void studentEntrySet(){
		System.out.println("����"+students.size()+"��ѧ���Ѿ��Ǽ�");
		Set<Entry<String,Student>> entrySet=students.entrySet();
		for (Entry<String, Student> entry : entrySet) {
			System.out.println("������"+entry.getValue().getName()+"\tѧ�ţ�"+entry.getKey());
		}
	}
	
	private void studentRemove(){
		Boolean IDnotHere=true;
		while(IDnotHere){
			System.out.println("��������Ҫɾ����ѧ��ID");
			String Id=in.next();
			Student st=students.get(Id);
			if(st==null){
				System.out.println("�������ID�����������������");
			}else{
				System.out.println("�Ѿ��ɹ�ɾ��ѧ�� "+students.get(Id).getName());
				students.remove(Id);
				IDnotHere=false;
			}
		}
	}
	
	private void studentModify() {
		boolean IDnotHere=true;
		while(IDnotHere){
			System.out.println("������Ҫ�޸ĵ�ѧ��ID");
			String ID=in.next();
			Student  student=students.get(ID);
			if(student==null){
				System.out.println("��ID��Ӧ��ѧ�������ڣ��������������");
			}else{
				System.out.println("��ǰѧ��ID��Ӧ��ѧ������Ϊ:"+student.getName());
				System.out.println("�������µ�ѧ������");
				String name=in.next();
				Student newst=new Student(ID, name);
				students.put(ID, newst);
				System.out.println("�޸���ɣ�");
				System.out.println("ѧ��ID:"+students.get(ID).getId()+"\tѧ������:"+students.get(ID).getName());
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
