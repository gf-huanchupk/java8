package com.gf.test02;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class TestLambda {

	List<Employee> emps = Arrays.asList(
				new Employee(101,"张三", 18 ,9999.99),
				new Employee(101,"李四", 59 ,6666.66),
				new Employee(101,"王五", 28 ,3333.33),
				new Employee(101,"赵六", 8  ,7777.77),
				new Employee(101,"田七", 38 ,5555.55)
			);
	
	@Test
	public void test1(){
		Collections.sort(emps,(e1,e2) -> {
			if(e1.getAge() == e2.getAge()){
				return e1.getName().compareTo(e2.getName());
			}else{
				return Integer.compare(e1.getAge(), e2.getAge());
			}
		});
		
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}
	
	@Test
	public void test2(){
		String trimStr = strHandler("\t\t\t 今天是冬至", (str) -> str.trim());
		System.out.println(trimStr);
		
		String upper = strHandler("abcdef", str -> str.toUpperCase());
		System.out.println(upper);
		
		String newStr = strHandler("今天是冬至，要不要吃饺子", str -> str.substring(3, str.length()-1));
		System.out.println(newStr);
		
	}
	
	@Test
	public void test3(){
		op(100L,200L,(x,y) -> x+y);
		op(100L,200L,(x,y) -> x*y);
	}
	
	//需求：用于处理字符串
	public String strHandler(String str , MyFunction mf){
		return mf.getValue(str);
	}
	
	//需求：对于两个Long 型数据进行处理
	public void op(Long l1 ,Long l2 , MyFunction2<Long, Long> mf){
		System.out.println(mf.getValue(l1, l2));
	}
	
}
