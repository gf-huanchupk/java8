package com.gf.test11;

import java.util.Optional;

import org.junit.Test;

import com.gf.test02.Employee;
import com.gf.test02.Employee.Status;

public class TestOptional {

	/*
	 * Optional 容器类的常用方法 :
	 * Optional.of(T t) : 创建一个Optionnal实例
	 * Optional.empty() : 创建一个空的Optional 实例
	 * Optional.ofNullable(T t) : 若 t 不为null,创建Optional 实例，否则创建空实例
	 * isPresent() : 判断是否包含值
	 * orElse(T t) : 如果调用对象包含值，返回该值，否则返回 t
	 * orElseGet(Supplier s) : 如果调用对象包含值，返回该值，否则返回Optional.empty()
	 * flatMap(Function mapper) : 与map 类似，要求返回值必须是Optional
	 */
	
	@Test
	public void test4(){
		Optional<Employee> op = Optional.ofNullable(new Employee("张三",18 ,888.88,Status.FREE));
		
		/*Optional<String> str = op.map((e) -> e.getName());
		System.out.println(str.get());*/
		Optional<String> str = op.flatMap((e) -> Optional.of(e.getName()));
		System.out.println(str.get());
		
	}
	
	@Test
	public void test3(){
		Optional<Employee> op = Optional.ofNullable(null);
		
		/*if(op.isPresent()){
			System.out.println(op.get());
		}*/
		
		/*Employee emp = op.orElse(new Employee("张三",18 ,888.88,Status.FREE));
		System.out.println(emp);*/
		
		Employee emp = op.orElseGet(() -> new Employee());
		System.out.println(emp);
		
	}
	
	@Test
	public void test2(){
		Optional<Employee> op = Optional.empty();
		System.out.println(op.get());
	}
	
	@Test
	public void test1(){
		Optional<Employee> op = Optional.of(null);
		System.out.println(op.get());
	}
	
	@Test
	public void test5(){
//		Man man = new Man();
//		String n = getGodnessName(man);
//		System.out.println(n);
		Optional<Godness> gn = Optional.ofNullable(new Godness("波多老师"));
		Optional<NewMan> op = Optional.ofNullable(new NewMan(gn));
		String str = getGodnessName2(op);
		System.out.println(str);
		
	}
	
	public String getGodnessName2(Optional<NewMan> man){
		return man.orElse(new NewMan())
				  .getGodness()
				  .orElse(new Godness("苍老师"))
				  .getName();
	}
	
	//需求 : 获取一个男人心中女神的名字
	public String getGodnessName(Man man){
		if(man != null){
			Godness gn = man.getGod();
			if(gn != null){
				return gn.getName();
			}
		}
		return "苍老师";
	}
	
}
