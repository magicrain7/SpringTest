package com.yedam.app.ioc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUserContainer {

	public static void main(String[] args) {
		//AbstractApplicationContext beanfacotry 관리하는 객체
		AbstractApplicationContext  factory =
				new GenericXmlApplicationContext("applicationContext.xml");
		/*
		 * TV tv = (TV)factory.getBean("tv");
		 * 
		 * tv.powerOn(); tv.volumeUp(); tv.volumeDown(); tv.powerOff();
		 */
		
		//prototype speaker 1과 2는 다른 객체 결과 NO , singleton은 yes
		//prototype getbean 객체 주입받는것? 생성해서 받고 singleton은 있는것을 가지고 옴.                                                                                                                                                                                                                                                                                               
		Speaker speaker1 = (Speaker) factory.getBean("sony");
		Speaker speaker2 = (Speaker) factory.getBean("sony");
		System.out.println(speaker1 == speaker2 ? " yes " : " no ");
	}
}
