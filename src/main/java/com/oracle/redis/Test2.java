package com.oracle.redis;

import java.util.concurrent.SynchronousQueue;

public class Test2 {

	public static void main(String[] args) {


		Long start=System.currentTimeMillis();
		System.out.println("��ʼ");
		long count=1000000000L;
		for(int i=0;i<count;i++) {
			for(int j=0;j<count;j++) {
				
			}
		}
		Long end=System.currentTimeMillis();
		
		System.out.println("�ܺ�ʱ��"+(end-start));
	}

}
