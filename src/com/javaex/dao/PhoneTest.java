package com.javaex.dao;

import java.util.List;

import com.javaex.vo.PersonVo;

public class PhoneTest {
	public static void main(String[] args) {
		PhoneDao phoneDao = new PhoneDao();

		List<PersonVo> list = phoneDao.getPersonList();
		System.out.println(list.toString());
		
		
		/*
		PersonVo personVo = new PersonVo("강호동", "0110-9999-9999", "02-1234-1234");
		phoneDao.personInsert(personVo);
		
		
		PersonVo pVo = phoneDao.getPerson(4);
		System.out.println(pVo.toString());
		*/
	}
}
