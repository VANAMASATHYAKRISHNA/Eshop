package com.sathya.Daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class TestingSessionfactory
{ 
	@Autowired
	SessionFactory sessionFactory;
public void testingsessionfactory()
{
	System.out.println(sessionFactory);
}

}
