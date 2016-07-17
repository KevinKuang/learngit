package com.rent_car;
import java.util.Scanner;

public class Work {
	static int sum=0;
	static int manload=0;
	static int thingload=0;
	static Scanner in=new Scanner(System.in);
	static Car cars[]={
			new Carrage("�µ�A4",500,4),
			new Carrage("���Դ�6",400,4),
			new Pickup("Ƥ��ѩ6", 450,4,2),
			new Carrage("����",800,20),
			new Truck("�ɻ���",400,20),
			new Truck("��ά��",1000,20),
	};
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("��ӭʹ�������⳵ϵͳ��\n���Ƿ�Ҫ�⳵��1��   2��");

		if (startRent(in.nextInt())){
			System.out.println("�����⳵���ͼ���Ŀ������");
			listcars();
			System.out.print("��������Ҫ�⳵��������");
			int[] listnum=choosecars(in.nextInt());
			listdispaly(listnum);
			System.out.println("�����������������ң�");
		};	
	}
	private static boolean startRent(int start){
		switch(start){
		case 1: return true;
		case 2: System.out.println("��ӭ�ٴ�ʹ�ã�");return false;
		default :System.out.print("���������������������룺");
		         return startRent(in.nextInt());
		         
		}
	}
	private static void listcars(){
		System.out.println("���\t��������\t���\t����");
		int i=0;
		for(Car car:cars){
			System.out.print(i+1+"\t"+car.getName()+"\t"+
		                       car.getPrice()+"Ԫ/��\t");
			if(car instanceof Carrage){
				System.out.println("���ˣ�"+car.getManload()+"��");
			}else if(car instanceof Truck){
				System.out.println("�ػ���"+car.getThingload()+"��");
			}else{
				System.out.print("���ˣ�"+car.getManload()+"��   ");
				System.out.println("�ػ���"+car.getThingload()+"��");
			}
			i++;
		}
	}
	private static int[] choosecars(int num){
		while (num<=0){
			System.out.println("���������������������룺");
			num=in.nextInt();
		}
		int i=0;
		int listnum[]={0,0,0,0,0,0,0,0,0,0,0,0,};
		for(;i<num;i++){
			System.out.println("�������"+(i+1)+"���������");
			listnum[i]=in.nextInt();
			if(listnum[i]>6){
				System.out.println("��������������������������������");
				return choosecars(num);
			}
		}
		return listnum;
	}

	private static void listdispaly(int[] listnum){
		System.out.print("�������⳵������");
		int days=in.nextInt();
		System.out.println("\n�����˵�");
		System.out.println("***�����˵ĳ��У�");
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
		System.out.println("\n������"+manload+"��");
		System.out.println("***���ػ��ĳ��У�");
		for(int num:listnum){
			if(num==0) break;
			num--;
			if((cars[num] instanceof Carrage)){
			}else {
				System.out.print("\t"+cars[num].getName());
				thingload+=cars[num].getThingload();
			}
		}
		System.out.println("\n�����ػ�"+thingload+"��");
		System.out.println("***�⳵�ܼ۸�"+sum*days+"Ԫ");
		System.out.println("��ӭ�ٴ�ʹ��!");
	}
}