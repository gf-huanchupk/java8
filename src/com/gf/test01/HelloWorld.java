package com.gf.test01;

import java.util.Comparator;

import org.junit.Test;

/**
 * 一、Lambda 表达式基础语法：java8中引入了一个新的操作符 "->" 该操作符称为箭头操作符或 Lambda 操作符
 * 
 * 左侧：Lambda 表达式的参数列表
 * 右侧：Lambda 表达式中所需要的执行的功能，即 Lambda 体
 * 
 * 语法格式一 : 无参数，无返回值
 * 		() -> System.out.println("Hello Lambda !");
 * 
 * 语法格式二 : 有一个参数，并且无返回值
 * 		(x) -> System.out.println(x);
 * 
 * 语法格式三 : 若只有一个参数。小括号可以省略不写
 * 		x -> System.out.peintln(x);
 * 
 * 语法格式四 : 有两个以上的参数，有返回值，并且Lambda 体中有多条语句
 * 		Comparator<Integer> com = (x,y) -> {
 *			System.out.println("函数式接口");
 *			return Integer.compare(x, y);
 *		};
 * 
 * 语法格式五 : 若Lambda 体中只有一条语句，return 和大括号都可以省略不写
 * 		Comparator<Integer> com = (Integer x,Integer y) -> Integer.compare(x, y);
 * 
 * 语法格式六 : Lambda 表达式的数据类型可以省略不写，因为JVM编译器通过上谢文推断出，数据类型，及 "类型推断"
 * 		Comparator<Integer> com = (x,y) -> Integer.compare(x, y);
 * 
 * 上联：左右遇一括号省
 * 下联：左侧推断类型省
 * 横批：能省则省
 * 
 */
public class HelloWorld {
	
	
	@Test
	public void test1(){
		SayParam2<String> s = () -> {
			System.out.println("hello lambda !");
		};
		s.say();
	}
	
	@Test
	public void test2(){
		SayParam<String> s = (x) -> System.out.println(x);
		s.say("hello test2");
	}
	
	@Test
	public void test3(){
		SayParam<String> s = x -> System.out.println(x);
		s.say("hello test3");
	}
	
	@Test
	public void test4(){
		Comparator<Integer> com = (x,y) -> {
			System.out.println("函数式接口");
			return Integer.compare(x, y);
		};
		com.compare(1, 2);
	}
	
	@Test
	public void test5(){
		Comparator<Integer> com = (Integer x,Integer y) -> Integer.compare(x, y);
		com.compare(1, 2);
	}

}
