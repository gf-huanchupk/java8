package com.gf.test10;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

import org.junit.Test;

public class TestForkJoin {
	
	/**
	 * ForkJoin 框架
	 */
	@Test
	public void test1(){
		Instant start = Instant.now();
		
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Long> task = new ForkJoinCalculate(0, 1000000000L);
		Long sum = pool.invoke(task);
		System.out.println(sum);
		
		Instant end = Instant.now();
		
		System.out.println("耗费时间为: " + Duration.between(start, end).toMillis());
		
	}
	
	/**
	 * 普通 for
	 */
	@Test
	public void test2(){
		Instant start = Instant.now();
		
		long sum = 0L;
		
		for (long i = 0; i <= 1000000000L; i++) {
			sum = sum + i;
		}
		System.out.println(sum);
		
		Instant end = Instant.now();
		
		System.out.println(Duration.between(start, end).toMillis());
	}
	
	/** 
	 * java8 并行流
	 */
	@Test
	public void test3(){
		Instant start = Instant.now();
		
		long sum = LongStream.rangeClosed(0, 10000000000L)
				  .parallel()// 切换成并行流 //sequential() 切换成串行流
				  .reduce(0,Long::sum);
		System.out.println(sum);
		
		Instant end = Instant.now();
		
		System.out.println(Duration.between(start, end).toMillis());
	}

}
