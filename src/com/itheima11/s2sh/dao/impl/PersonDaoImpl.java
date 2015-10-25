package com.itheima11.s2sh.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.itheima11.s2sh.dao.PersonDao;
import com.itheima11.s2sh.domain.Person;

public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao{

	@Override
	public void savePerson(Person person) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(person);
	}
	
}
