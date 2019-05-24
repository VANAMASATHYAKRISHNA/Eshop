package com.sathya.Daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sathya.model.Product;

@Component
public class ProductDaoImpl 
{    @Autowired
	SessionFactory sessionFactory;
	public void productDao(Product product)
	{
		Session session=sessionFactory.openSession();
//		if(product.getProductId()==0)
//	       {
//	    int id=(int)(Math.random()*10000);
//	    product.setProductId(id);
//	       }
		session.saveOrUpdate(product);
        Transaction transaction	=session.beginTransaction();
        transaction.commit();
        session.close();
		
	}
public List<Product>getproductData()
{
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("from Product");
	List<Product>productlist=query.list();
	for(Product product: productlist)
	{
		System.out.println(product.getProductId());
		System.out.println(product.getProductName());
		System.out.println(product.getProductDescription());
		System.out.println(product.getProductPrice());
		System.out.println(product.getProductCategory());
		System.out.println(product.getProductSupplier());
	}
	session.close();
	return productlist;
	}
public Product getProduct(int productId)
{
	Session session=sessionFactory.openSession();
Product product=session.get(Product.class,productId );
session.close();
	return product;
}
public void delProductData(Product product)
{
	Session session=sessionFactory.openSession();
	session.delete(product);
	Transaction transaction=session.beginTransaction();
	transaction.commit();
	session.close();
}
public void editCategoryData(Product product)
{
Session session=sessionFactory.openSession();
session.saveOrUpdate(product);
Transaction transaction=session.beginTransaction();
transaction.commit();
session.close();
}
}

