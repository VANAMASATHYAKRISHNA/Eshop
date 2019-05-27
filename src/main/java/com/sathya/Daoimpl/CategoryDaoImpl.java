package com.sathya.Daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sathya.model.Category;

@Component
public class CategoryDaoImpl {
@Autowired
SessionFactory sessionFactory; 
public void categoryDao(Category c)
{
	Session s=sessionFactory.openSession();
	if(c.getCategoryId()==0)
	{
	int id=(int)(Math.random()*10000);
	c.setCategoryId(id);
	System.out.println("catergory"+id);
	}
	s.saveOrUpdate(c);
	Transaction t=s.beginTransaction();
	t.commit();
	System.out.println(sessionFactory);
	s.close();
}
public List<Category> getCategoryData() 
{
	Session session=sessionFactory.openSession();
Query query=session.createQuery("from Category");
List<Category>categorylist=query.list();
for(Category category:categorylist)
{
	System.out.println(category.getCategoryId());
	System.out.println(category.getCategoryName());
	System.out.println(category.getCategoryDiscription());
}
session.close();
	return categorylist ;
}
public Category getCategory(int categoryId)
{
	Session session=sessionFactory.openSession();
	Category category=session.get(Category.class,categoryId);
	session.close();
	return category;
	}
public void delCategoryData(Category category)
{
Session session=sessionFactory.openSession();
session.delete(category);
Transaction transaction=session.beginTransaction();
transaction.commit();
session.close();
}
public void editCategoryData(Category category)
{
Session session=sessionFactory.openSession();
session.saveOrUpdate(category);
Transaction transaction=session.beginTransaction();
transaction.commit();
session.close();
/*
public void delteCategoryData( int categoryId)
{
Session session=sessionFactory.openSession();
Category category=session.get(Category.class, categoryId );
session.delete(category);
Transaction transaction=session.beginTransaction();
transaction.commit();
}*/
}
}
