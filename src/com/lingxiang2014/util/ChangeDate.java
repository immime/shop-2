package com.lingxiang2014.util;

import org.joda.time.DateTime;

public class ChangeDate {

	// 当天
	public static DateTime getThisDay() {
		DateTime now = new DateTime();
		return now;
	}

	// 上一天
	public static DateTime getPrevDay(int year, int month, int day,int index) {
		DateTime now = new DateTime();
		now = now.withYear(year);
		now = now.withMonthOfYear(month);
		now = now.withDayOfMonth(day);
		now = now.plusDays(-1*index);
		return now;
	}

	// 下一天
	public static DateTime getNextDay(int year, int month, int day,int index) {
		DateTime now = new DateTime();
		now = now.withYear(year);
		now = now.withMonthOfYear(month);
		now = now.withDayOfMonth(day);
		now = now.plusDays(index);
		return now;
	}

	// 本月
	public static DateTime getThisMonth() {
		DateTime now = new DateTime();
		now = now.withTime(0, 0, 0, 0);
		now = now.withDayOfMonth(1);
		return now;
	}

	// 上一个月
	public static DateTime getPrevMonth(int year, int month,int index) {
		DateTime now = new DateTime();
		now = now.withYear(year);
		now = now.withMonthOfYear(month);
		now = now.plusMonths(-1*index);
		now = now.withTime(0, 0, 0, 0);
		now = now.withDayOfMonth(1);
		return now;
	}

	// 下一个月
	public static DateTime getNextMonth(int year, int month,int index) {
		DateTime now = new DateTime();
		now = now.withYear(year);
		now = now.withMonthOfYear(month);
		now = now.plusMonths(index);
		now = now.withTime(0, 0, 0, 0);
		now = now.withDayOfMonth(1);
		return now;
	}

	// 本年
	public static DateTime getThisYear() {
		DateTime now = new DateTime();
		;
		return now;
	}

	// 上一年
	public static DateTime getPrevYear(int year,int index) {
		DateTime now = new DateTime();
		now = now.withYear(year);
		now = now.plusYears(-1*index);
		return now;
	}

	// 下一年
	public static DateTime getNextYear(int year,int index) {
		DateTime now = new DateTime();
		now = now.withYear(year);
		now = now.plusYears(1*index);
		return now;
	}

}
