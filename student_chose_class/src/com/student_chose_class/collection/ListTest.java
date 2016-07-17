package com.student_chose_class.collection;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
//import java.util.Set;

public class ListTest {
	private List<Course> coursesToSelect;//	��ű�ѡ�γ�
	private static Scanner input;
//	��ӱ�ѡ�γ�
	public void TestAdd(){
		Course cr1=new Course("1","���ݽṹ");
		coursesToSelect.add(cr1);
		Course temp=coursesToSelect.get(0);
		System.out.println("����˿γ̣� "+temp.getId()+"-"+temp.getName());
		
		Course cr2=new Course("2","C����");
		coursesToSelect.add(0, cr2);
		temp=coursesToSelect.get(0);
		System.out.println("����˿γ̣� "+temp.getId()+"-"+temp.getName());
		
		Course cr3=new Course("3","Java����");
		coursesToSelect.add(cr3);
		temp=coursesToSelect.get(2);
		System.out.println("����˿γ̣� "+temp.getId()+"-"+temp.getName());
		
		Course[] crs={new Course("4","���Դ���"),
				      new Course("5", "��ɢ��ѧ"),
				      new Course("8", "���蹤����ͼ"),
				      new Course("7", "ͨ��ԭ��"),};
		coursesToSelect.addAll(1,Arrays.asList(crs));
		
	}
	
	private void testGet(){
		System.out.println("��ѡ�Ŀγ��У�");
		int size=coursesToSelect.size();
		for (int i=0;i<size;i++){
			Course crtest=(Course) coursesToSelect.get(i);
			System.out.println(crtest.getId()+"-"+crtest.getName());
		}
	}
	
//	private void testIterator() {
//		System.out.println("��ѡ�Ŀγ���(����������)��");
//		Iterator<Course> it=coursesToSelect.iterator();
//		while(it.hasNext()){
//			Course crtest=it.next();
//			System.out.println(crtest.getId()+"-"+crtest.getName());
//		}
//	}
	
	private void testForEach() {
		System.out.println("��ѡ�Ŀγ���(foreach����)��");
		for (Course crtest : coursesToSelect) {
			System.out.println(crtest.getId()+"-"+crtest.getName());
		}
	}
	
	private void testModify() {
		coursesToSelect.set(3, new Course("6", "English"));
	}
	
	private void testRemove() {
		Course cr=coursesToSelect.get(2);
		System.out.println("���ǿγ�"+cr.getId()+"-"+cr.getName()+",�ҽ���ɾ����");
		coursesToSelect.remove(2);
		System.out.println("�γ�ɾ���ɹ���");
		
	}
	
	private static void getStudentCourse(Student stu){
		System.out.println("����:"+stu.getName()+"\tѧ��:"+stu.getId()+"\n"
		                   +"��ѡ�������¿γ̣��γ�ID-�γ����ƣ�,һ����"+stu.couses.size()+"��");
		for(Course cr : stu.couses){
			System.out.println(cr.getId()+"-"+cr.getName());
		}
	}
	
	public static void main(String[] args){
		ListTest test=new ListTest();
		test.TestAdd();
//		test.testGet();
//		test.testIterator();
//		test.testForEach();
		test.testModify();
		test.testGet();
		test.testRemove();
		System.out.println("��ѡ�γ��޸ĺ�");
		test.testForEach();
		Student stu1=new Student("420984","����Т��");
		System.out.println("��ӭ"+stu1.getName()+"����ѡ��\n�����ѡ�����ſγ�");
		input = new Scanner(System.in);
		for(int i=0;i<3;i++){
			System.out.println("�������"+(i+1)+"�ſγ̵�ID");
			String courseId=input.next();
			Boolean noCourse=true;
			for(Course cr:test.coursesToSelect){
				if(cr.getId().equals(courseId)){
					stu1.couses.add(cr);
					noCourse=false;
					break;
				}
			}
			if(noCourse){
					System.out.println("������Ŀγ�ID��������������");
					i--;
			}
		}
		System.out.println("ѡ�����");
		getStudentCourse(stu1);
	}


	public ListTest(){
		this.coursesToSelect=new ArrayList<Course>();
	}

	
}
