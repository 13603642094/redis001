package com.oracle.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.vo.Student;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

public class TestRedis {

	public static void main(String[] args) throws Exception {

		JedisPool pool=RedisPool.getJedis();
		
		for(int i=0;i<10;i++) {
			Jedis e=pool.getResource();
			e.close();			
		}
	//	Jedis edis=new Jedis("192.168.50.14",6379);
//		edis.auth("tiger");
		Jedis edis=pool.getResource();
		System.out.println(edis.ping());
		edis.ping();
		
		System.out.println("end");
		
		edis.select(0);
		

//		edis.set("location", "哈尔滨");
//		
//		System.out.println(edis.get("location"));
//		
//		String str="我的人史； ";
//		byte[] s=toBytes(str);
//		edis.set("name1".getBytes(), s);
//		
//		s=edis.get("name1".getBytes());
//		System.out.println(toObject(s));
		edis.watch("balance","debt");
		System.out.println("监控了");
//		Thread.sleep(10000);
		System.out.println("监。。。。。");
		Transaction t=edis.multi();
	//	t.set("balance", "180");
		t.decrBy("balance", 20);
	//	t.set("debt", "0");
		t.incrBy("debt", 20);
		System.out.println(t.exec());
		
		edis.set("k1", "v2");
		
		ObjectMapper mapper=new ObjectMapper();
		Student stu=new Student(2,"李大明","男");
		
		System.out.println(stu);
		
		String str=mapper.writeValueAsString(stu);
		
		//System.out.println(mapper.writeValueAsString(stu));
		
	//	edis.set("stu", mapper.writeValueAsString(stu));
		
		
		String s=edis.get("stu");
		
		Student stu1=mapper.readValue(s, Student.class);
		System.out.println(stu1);
		
		System.out.println("end");
		
		RedisPool.test();
		edis.close();
		RedisPool.test();
		System.out.println("out..");
		
		RedisPool.close();
	}

	
	public static Object toObject(byte[] bs) throws IOException, ClassNotFoundException {
		ObjectInputStream ois=new ObjectInputStream(new ByteArrayInputStream(bs));
		return ois.readObject();
	//	return null;
	}
	
	public static byte[] toBytes(Object obj) throws IOException {
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(bos);
		oos.writeObject(obj);
		return bos.toByteArray();
	}
	
}
