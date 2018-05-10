package com.gf.test08;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import com.gf.test02.Employee;
import com.gf.test02.Employee.Status;

public class TestStreamAPI4 {

	/**
	 * 1. 给定的一个数字列表，如何返回一个有每个数平方构成的列表呢 ？
	 *    给定【1，2，3，4，5，】，应该返回【1，4，9，16，25】。
	 */
	@Test
	public void test1(){
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		
		list.stream()
		    .map((x) -> x*x)
		    .forEach(System.out::println);
	}
	
	/**
	 * 2. 怎么利用 map 和 reduce 方法数一数流中油多少个Employee
	 */
	List<Employee> employees = Arrays.asList(
			new Employee(101, "张三", 18, 9999.99, Status.FREE), 
			new Employee(101, "李四", 59, 6666.66, Status.BUSY),
			new Employee(101, "王五", 28, 3333.33, Status.VOCATION),
			new Employee(101, "赵六", 8, 7777.77, Status.FREE),
			new Employee(101, "田七", 38, 5555.55, Status.BUSY)
		);
	
	@Test
	public void test2(){
		Optional<Integer> sum = employees.stream()
		         .map((e) -> 1)
		         .reduce(Integer::sum);
		
		System.out.println(sum.get());
	}
	
}
