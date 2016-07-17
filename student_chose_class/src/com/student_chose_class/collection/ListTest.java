package com.student_chose_class.collection;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
//import java.util.Set;

public class ListTest {
	private List<Course> coursesToSelect;//	存放备选课程
	private static Scanner input;
//	添加备选课程
	public void TestAdd(){
		Course cr1=new Course("1","数据结构");
		coursesToSelect.add(cr1);
		Course temp=coursesToSelect.get(0);
		System.out.println("添加了课程： "+temp.getId()+"-"+temp.getName());
		
		Course cr2=new Course("2","C语言");
		coursesToSelect.add(0, cr2);
		temp=coursesToSelect.get(0);
		System.out.println("添加了课程： "+temp.getId()+"-"+temp.getName());
		
		Course cr3=new Course("3","Java语言");
		coursesToSelect.add(cr3);
		temp=coursesToSelect.get(2);
		System.out.println("添加了课程： "+temp.getId()+"-"+temp.getName());
		
		Course[] crs={new Course("4","线性代数"),
				      new Course("5", "离散数学"),
				      new Course("8", "建设工程制图"),
				      new Course("7", "通信原理"),};
		coursesToSelect.addAll(1,Arrays.asList(crs));
		
	}
	
	private void testGet(){
		System.out.println("待选的课程有：");
		int size=coursesToSelect.size();
		for (int i=0;i<size;i++){
			Course crtest=(Course) coursesToSelect.get(i);
			System.out.println(crtest.getId()+"-"+crtest.getName());
		}
	}
	
//	private void testIterator() {
//		System.out.println("待选的课程有(迭代器访问)：");
//		Iterator<Course> it=coursesToSelect.iterator();
//		while(it.hasNext()){
//			Course crtest=it.next();
//			System.out.println(crtest.getId()+"-"+crtest.getName());
//		}
//	}
	
	private void testForEach() {
		System.out.println("待选的课程有(foreach访问)：");
		for (Course crtest : coursesToSelect) {
			System.out.println(crtest.getId()+"-"+crtest.getName());
		}
	}
	
	private void testModify() {
		coursesToSelect.set(3, new Course("6", "English"));
	}
	
	private void testRemove() {
		Course cr=coursesToSelect.get(2);
		System.out.println("我是课程"+cr.getId()+"-"+cr.getName()+",我将被删除。");
		coursesToSelect.remove(2);
		System.out.println("课程删除成功！");
		
	}
	
	private static void getStudentCourse(Student stu){
		System.out.println("姓名:"+stu.getName()+"\t学号:"+stu.getId()+"\n"
		                   +"你选择了如下课程（课程ID-课程名称）,一共有"+stu.couses.size()+"门");
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
		System.out.println("待选课程修改后：");
		test.testForEach();
		Student stu1=new Student("420984","湖北孝感");
		System.out.println("欢迎"+stu1.getName()+"进行选课\n你可以选择三门课程");
		input = new Scanner(System.in);
		for(int i=0;i<3;i++){
			System.out.println("请输入第"+(i+1)+"门课程的ID");
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
					System.out.println("您输入的课程ID有误，请重新输入");
					i--;
			}
		}
		System.out.println("选课完成");
		getStudentCourse(stu1);
	}


	public ListTest(){
		this.coursesToSelect=new ArrayList<Course>();
	}

	
}
