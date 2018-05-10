package com.gf.test07;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;
import com.gf.test02.Employee;
import com.gf.test02.Employee.Status;

public class TestStreamAPI3 {

	List<Employee> employees = Arrays.asList(
			new Employee(101, "张三", 18, 9999.99, Status.FREE), 
			new Employee(101, "李四", 59, 6666.66, Status.BUSY),
			new Employee(101, "王五", 28, 3333.33, Status.VOCATION),
			new Employee(101, "赵六", 8, 7777.77, Status.FREE),
			new Employee(101, "田七", 38, 5555.55, Status.BUSY)
		);
	
	/**
	 * 收集
	 * collect —— 将流转换为其他形式。接受一个 Collector 接口的实现，用于处理给Stream中元素汇总的方法
	 */
	@Test
	public void test10(){
		String str = employees.stream()
		         .map(Employee::getName)
		         .collect(Collectors.joining("," , "===" , "==="));
		
		System.out.println(str);
	}
	
	@Test
	public void test9(){
		DoubleSummaryStatistics dss = employees.stream()
		         .collect(Collectors.summarizingDouble(Employee::getSalary));
		
		System.out.println(dss.getSum());
		System.out.println(dss.getAverage());
		System.out.println(dss.getMax());
	}
	
	//分区
	@Test
	public void test8(){
		Map<Boolean, List<Employee>> map = employees.stream()
		         .collect(Collectors.partitioningBy((e) -> e.getSalary() > 8000));
		System.out.println(map);
	}
	
	//多级分组
	@Test
	public void test7(){
		Map<Status, Map<String, List<Employee>>> map = employees.stream()
		         .collect(Collectors.groupingBy(Employee::getStatus,Collectors.groupingBy((e) ->{
		        	 if(35 >= ((Employee)e).getAge()){
		        		 return "青年";
		        	 }else if(50 >= ((Employee)e).getAge()){
		        		 return "中年";
		        	 }else{
		        		 return "老年";
		        	 }
		         })));
		System.out.println(map);
	}
	
	//分组
	@Test
	public void test6(){
		Map<Status, List<Employee>> map = employees.stream()
		         .collect(Collectors.groupingBy(Employee::getStatus));
		System.out.println(map);
	}
	
	@Test
	public void test5(){
		//总数
		Long count = employees.stream()
				 .collect(Collectors.counting());
		System.out.println(count);
		
		System.out.println("--------------------");
		
		//平均值
		Double avg = employees.stream()
			     .collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println(avg);
		
		System.out.println("--------------------");
		
		//总和
		Double sum = employees.stream()
		         .collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println(sum);
		
		System.out.println("--------------------");
		
		//最大值
		Optional<Employee> max = employees.stream()
			     .collect(Collectors.maxBy((e1,e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
		System.out.println(max.get());
		
		//最小值
		Optional<Double> min = employees.stream()
			     .map(Employee::getSalary)
			     .collect(Collectors.minBy(Double::compare));
		System.out.println(min.get());
		
		
	}
	
	/**
	 * 收集
	 * collect——将流动换为其他形式。接受一个Collector接口的实现，用于给Stream中元素汇总的方法
	 */
	@Test
	public void test4(){
		List<String> list = employees.stream()
				 .map(Employee::getName)
				 .collect(Collectors.toList());
		
		list.forEach(System.out::println);
		
		System.out.println("--------------------------");
		
		Set<String> set = employees.stream()
				.map(Employee::getName)
				.collect(Collectors.toSet());
		
		set.forEach(System.out::println);
		
		System.out.println("--------------------------");
		
		HashSet<String> hs = employees.stream()
				 .map(Employee::getName)
				 .collect(Collectors.toCollection(HashSet::new));
		
		hs.forEach(System.out::println);
		
		
	}
	
	/**
	 * 规约
	 * reduce(T identity , BinaryOperator) / reduce(BinaryOperator) ——可以将流中的数据反复结合起来，得到一个值。
	 */
	@Test
	public void test3(){
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		Integer sum = list.stream()
			.reduce(0 , (x,y) -> x+y);
		System.out.println(sum);
		
		Optional<Double> op = employees.stream()
				 .map(Employee::getSalary)
				 .reduce(Double::sum);
		System.out.println(op.get());
		
	}
	
	/**
	 * 查找与匹配 
	 * allMatch —— 检查是否匹配所有元素
	 * anyMacth —— 检查是否匹配一个元素
	 * noneMacth —— 检查是否没有匹配所有元素
	 * findFirst —— 返回第一个元素
	 * findAny —— 返回当前流中的任意元素
	 * count —— 返回流中元素的总个数
	 * max —— 返回流中最大值
	 * min —— 返回流中的最小值
	 *  
	 */
	@Test
	public void test2(){
		long count = employees.stream()
				 .count();
		System.out.println(count);
		
		Optional<Employee> op1 = employees.stream()
				 .max((e1,e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
		System.out.println(op1.get());
		
		Optional<Double> op2 = employees.stream()
				 .map(Employee::getSalary)
				 .min(Double::compare);
		System.out.println(op2.get());
		
	}
	
	@Test
	public void test1(){
		boolean b1 = employees.stream()
				 .allMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(b1);
		
		boolean b2 = employees.stream()
		.anyMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(b2);
		
		boolean b3 = employees.stream()
				 .noneMatch((e) -> e.getStatus().equals(Status.BUSY));
		System.out.println(b3);
		
		Optional<Employee> op = employees.stream()
				 .sorted((e1,e2) -> -Double.compare(e1.getSalary(),e2.getSalary()))
				 .findFirst();
		System.out.println(op.get());
		
		Optional<Employee> op2 = employees.parallelStream()
				 .filter((e) -> e.getStatus().equals(Status.FREE))
				 .findAny();
		System.out.println(op2.get());
		
		
	}
	

}
