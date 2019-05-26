package com.oracle.redis;

import java.util.concurrent.SynchronousQueue;

public class Test2 {

	public static void main(String[] args) {


		Long start=System.currentTimeMillis();
		System.out.println("开始");

		long count=100000L;
		System.out.println(count);

		for(int i=0;i<count;i++) {
			for(int j=0;j<count;j++) {
				
			}
		}
		Long end=System.currentTimeMillis();
		
		System.out.println("总耗时："+(end-start));
		
		System.out.println("hello world");
		
		//这是一只小小鸟； 
		
		//这是一个新的分支 hot_fix;
		System.out.println("end");
		
		System.out.println("end2");
		
		System.out.println("end3");
	}

}
