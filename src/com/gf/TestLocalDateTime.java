package com.gf;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

import org.junit.Test;

public class TestLocalDateTime {
	
	//ZoneDate、ZoneTime、ZoneDateTime
	@Test
	public void test8(){
		LocalDateTime ldt = LocalDateTime.now(ZoneId.of("America/North_Dakota/New_Salem"));
		System.out.println(ldt);
	}
	
	@Test
	public void test7(){
		Set<String> set = ZoneOffset.getAvailableZoneIds();
		set.forEach(System.out::println);
	}
	
	//DateTimeFormatter : 格式化时间/日期
	@Test
	public void test6(){
		DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
		LocalDateTime ldt = LocalDateTime.now();
		
		String strDate = dtf.format(ldt);
		System.out.println(strDate);
		
		System.out.println("------------------------------");
		
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
		String strDate2 = dtf2.format(ldt);
		System.out.println(strDate2);
		
		LocalDateTime newDate = LocalDateTime.parse(strDate2,dtf2);
		System.out.println(newDate);
		
	}
	
	//TimporalAdjuster : 时间校正器
	@Test
	public void test5(){
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		
		LocalDateTime ldt2 = ldt.withDayOfMonth(10);
		System.out.println(ldt2);
		
		LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
		System.out.println(ldt3);
		
		//自定义：下一个工作日
		LocalDateTime ldt5 = ldt.with((e) -> {
			LocalDateTime ldt4 = (LocalDateTime) e;
			
			DayOfWeek dow = ldt.getDayOfWeek();
			System.out.println(dow);
			
			if(dow.equals(DayOfWeek.FRIDAY)){
				return ldt4.plusDays(3);
			}else if(dow.equals(DayOfWeek.SATURDAY)){
				return ldt4.plusDays(2);
			}else{
				return ldt4.plusDays(1);
			}
		});
		
		System.out.println(ldt5);
	}
	
	//3. Duration : 计算两个时间 之间的间隔
	//	 Period : 计算两个日期之间的间隔
	@Test
	public void test4(){
		LocalDate ld1 = LocalDate.of(2018, 4, 4);
		LocalDate ld2 = LocalDate.now();
		
		Period period = Period.between(ld1, ld2);
		System.out.println(period);
		
		System.out.println(period.getYears());
		System.out.println(period.getMonths());
		System.out.println(period.getDays());
		
	}
	
	@Test
	public void test3(){
		Instant ins1 = Instant.now();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Instant ins2 = Instant.now();
		
		Duration duration = Duration.between(ins1, ins2);
		System.out.println(duration.toMillis());
		
		System.out.println("-----------------------------");
		
		LocalTime lt1 = LocalTime.now();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		LocalTime lt2 = LocalTime.now();
		
		System.out.println(Duration.between(lt1, lt2).toMillis());
		
	}
	
	
	
	
	//2. instant : 时间戳 (以Unix 元年: 1970年1月1日00:00:00 到某个时间之间的毫秒数);
	@Test
	public void test2(){
		Instant ins1 = Instant.now();
		System.out.println(ins1);
		
		OffsetDateTime odt = ins1.atOffset(ZoneOffset.ofHours(8));
		System.out.println(odt);
		
		System.out.println(ins1.toEpochMilli());
		
		Instant ins2 = Instant.ofEpochSecond(60);
		System.out.println(ins2);
	}
	
	//1. LocalDate LocalTime LocalDateTime
	@Test
	public void test1(){
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		
		LocalDateTime ldt2 = LocalDateTime.of(2018, 2,9,13,33,33);
		System.out.println(ldt2);
		
		LocalDateTime ldt3 = ldt.plusYears(2);
		System.out.println(ldt3);
		
		LocalDateTime ldt4 = ldt.minusMonths(2);
		System.out.println(ldt4);
		
		System.out.println(ldt.getYear());
		System.out.println(ldt.getMonthValue());
		System.out.println(ldt.getDayOfMonth());
		System.out.println(ldt.getHour());
		System.out.println(ldt.getMinute());
		System.out.println(ldt.getSecond());
	}

}
