package com.gf.test05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.gf.test02.Employee;

/**
 * 一、Stream 的三个操作步骤:
 * 
 * 1. 创建Stream
 * 
 * 2. 中间操作
 * 
 * 3. 终止操作（终端操作）
 *
 */
public class TestStreamAPI1 {

	//创建Stream
	@Test
	public void test1(){
		//1. 可以通过 Collection 系列集合提供 stream() 或 parellelStream()
		List<String> list = new ArrayList<>();
		Stream<String> stream = list.stream();
		
		//2. 通过Arrays 中的静态方法 stream() 获取数组流
		Employee[] emps = new Employee[10];
		Stream<Employee> stream2 = Arrays.stream(emps);
		
		//3. 通过Stream 类中的静态方法 of()
		Stream<String> stream3 = Stream.of("aa","bb","cc");
		
		//4. 创建无限流
		Stream<Integer> stream4 = Stream.iterate(0, (x) -> x+2);
		//迭代
		stream4.limit(10).forEach(System.out::println);
		
		//生成
		Stream.generate(() -> Math.random())
			  .limit(5)
			  .forEach(System.out::println);
		
	}
	
}
