package com.rent_car;
import java.util.Scanner;

public class Work {
	static int sum=0;
	static int manload=0;
	static int thingload=0;
	static Scanner in=new Scanner(System.in);
	static Car cars[]={
			new Carrage("奥迪A4",500,4),
			new Carrage("马自达6",400,4),
			new Pickup("皮卡雪6", 450,4,2),
			new Carrage("金龙",800,20),
			new Truck("松花江",400,20),
			new Truck("依维柯",1000,20),
	};
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("欢迎使用哒哒租车系统！\n您是否要租车：1是   2否");

		if (startRent(in.nextInt())){
			System.out.println("您可租车类型及价目表如下");
			listcars();
			System.out.print("请输入您要租车的数量：");
			int[] listnum=choosecars(in.nextInt());
			listdispaly(listnum);
			System.out.println("我运行完啦，表想我！");
		};	
	}
	private static boolean startRent(int start){
		switch(start){
		case 1: return true;
		case 2: System.out.println("欢迎再次使用！");return false;
		default :System.out.print("您的输入有误，请重新输入：");
		         return startRent(in.nextInt());
		         
		}
	}
	private static void listcars(){
		System.out.println("序号\t汽车名称\t租金\t容量");
		int i=0;
		for(Car car:cars){
			System.out.print(i+1+"\t"+car.getName()+"\t"+
		                       car.getPrice()+"元/天\t");
			if(car instanceof Carrage){
				System.out.println("载人："+car.getManload()+"人");
			}else if(car instanceof Truck){
				System.out.println("载货："+car.getThingload()+"吨");
			}else{
				System.out.print("载人："+car.getManload()+"人   ");
				System.out.println("载货："+car.getThingload()+"吨");
			}
			i++;
		}
	}
	private static int[] choosecars(int num){
		while (num<=0){
			System.out.println("您的输入有误，请重新输入：");
			num=in.nextInt();
		}
		int i=0;
		int listnum[]={0,0,0,0,0,0,0,0,0,0,0,0,};
		for(;i<num;i++){
			System.out.println("请输入第"+(i+1)+"辆车的序号");
			listnum[i]=in.nextInt();
			if(listnum[i]>6){
				System.out.println("您输入的数据有误，请重新输入所有序号");
				return choosecars(num);
			}
		}
		return listnum;
	}

	private static void listdispaly(int[] listnum){
		System.out.print("请输入租车天数：");
		int days=in.nextInt();
		System.out.println("\n您的账单");
		System.out.println("***可载人的车有：");
		for(int num:listnum){
			if(num==0) break;
			num--;
			if((cars[num] instanceof Truck)){
			}else {
				System.out.print("\t"+cars[num].getName());
				manload+=cars[num].getManload();
			}
			sum+=cars[num].getPrice();
		}
		System.out.println("\n共可载"+manload+"人");
		System.out.println("***可载货的车有：");
		for(int num:listnum){
			if(num==0) break;
			num--;
			if((cars[num] instanceof Carrage)){
			}else {
				System.out.print("\t"+cars[num].getName());
				thingload+=cars[num].getThingload();
			}
		}
		System.out.println("\n共可载货"+thingload+"吨");
		System.out.println("***租车总价格："+sum*days+"元");
		System.out.println("欢迎再次使用!");
	}
}