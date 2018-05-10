package com.gf.test03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * Java8 内置的四大核心接口
 * 
 * Consumer<T> : 消费型接口
 * 		void accept (T t);
 * 
 * Supplier<T> : 供给型接口
 * 		T get();
 * 
 * Function<T> : 函数型接口
 * 		T apply(T t);
 * 
 * Predicate<T> : 断言型接口
 * 		boolean test(T t);
 *
 */
public class TestLambda3 {
	
	//Predicate<T> : 断言型接口
	@Test
	public void test4(){
		List<String> list = Arrays.asList("Hello" , "guofu" , "Lambda" ,"ok");
		List<String> strList = filterStr(list, (s) -> s.length() > 3);
		
		for (String str : strList) {
			System.out.println(str);
		}
		
	}
	
	//需求 : 将满足条件的字符串，放入集合中
	public List<String> filterStr(List<String> list , Predicate<String> pre){
		List<String> strList = new ArrayList<>();
		
		for (String str : list) {
			if(pre.test(str)){
				strList.add(str);
			}
		}
		
		return strList;
	}
	
	//Function<T> : 函数型接口
	@Test
	public void test3(){
		String newStr = strHandler("\t\t\t 今天是冬至，晚上去许舰家吃饺子", (str) -> str.trim());
		System.out.println(newStr);
		
		String sub = strHandler("今天是冬至，晚上去许舰家吃饺子", (str) -> str.substring(6, str.length()-1));
		System.out.println(sub);
	}
	
	//需求 : 用于处理字符串
	public String strHandler(String str, Function<String, String> fun){
		return fun.apply(str);
	}
	
	//Supplier<T> : 供给型接口
	@Test
	public void test2(){
		List<Integer> numList = getNumList(10, () -> (int)(Math.random() * 100));
		for (Integer num : numList) {
			System.out.println(num);
		}
		
	}
	//需求 : 产生指定个数的整数，并放入集合中
	public List<Integer> getNumList(int num, Supplier<Integer> su){
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < num; i++) {
			Integer n = su.get();
			list.add(n);
		}
		
		return list;
	}

	//Consumer<T> : 消费型接口
	@Test
	public void test1(){
		happy(10000, (m) -> System.out.println("今天是冬至，一碗饺子 " + m +"元"));
	}
	
	public void happy(double money,Consumer<Double> con){
		con.accept(money);
	}
	
	
}
