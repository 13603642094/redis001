package com.oracle.redis;

import java.util.concurrent.SynchronousQueue;

public class Test2 {

	public static void main(String[] args) {


		Long start=System.currentTimeMillis();
		System.out.println("��ʼ");

		long count=100000L;
		System.out.println(count);

		for(int i=0;i<count;i++) {
			for(int j=0;j<count;j++) {
				
			}
		}
		Long end=System.currentTimeMillis();
		
		System.out.println("�ܺ�ʱ��"+(end-start));
		
		System.out.println("hello world");
		
		//����һֻСС�� 
		
		//����һ���µķ�֧ hot_fix;
		System.out.println("end");
		
		System.out.println("end2");
		
		System.out.println("end3");
	}

}
