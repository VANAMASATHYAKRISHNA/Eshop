package com.sathya.Daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sathya.model.Supplier;

@Component
public class SupplierDaoImpl {
@Autowired
SessionFactory sessionFactory;
public void supplierDaoAddData(Supplier supplier)
{
	
	Session session=sessionFactory.openSession();
	if(supplier.getSupplierId()==0)
	{
	int id=(int)(Math.random()*10000);
	supplier.setSupplierId(id);
	}
	session.saveOrUpdate(supplier);
	Transaction transaction=session.beginTransaction();
	transaction.commit();
	System.out.println(sessionFactory);
	session.close();
	
}

public List<Supplier> getSupplierDaoRetriveData()
{


Session session=sessionFactory.openSession();
Query query= session.createQuery("from Supplier");
List<Supplier> supplierlist=query.list();
for(Supplier supplier:supplierlist)
{
System.out.println(supplier.getSupplierName());
System.out.println(supplier.getSupplierDetails());
}
session.close();
return supplierlist;
}
public Supplier getsupplier(int supplierId)
{
Session session=sessionFactory.openSession();
Supplier supplier=session.get(Supplier.class, supplierId);
session.close();
	return supplier;
}
public void deletaSupplierData(Supplier supplier)
{
	Session session=sessionFactory.openSession();
	session.delete(supplier);
	Transaction transaction=session.beginTransaction();
	transaction.commit();
	session.close();
}
public void editSupplierData(Supplier supplier)
{
	Session session=sessionFactory.openSession();
	session.delete(supplier);
	Transaction transaction=session.beginTransaction();
	transaction.commit();
	session.close();
}
}

