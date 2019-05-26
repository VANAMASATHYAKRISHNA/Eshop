package com.sathya.Daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sathya.model.Cart;
import com.sathya.model.Product;
@Component
public class CartDaoImpl 
{
	@Autowired
	SessionFactory sessionFactory;
	public Cart getsavetocart(Product product ,int quantity)
	{
	Cart cart=new Cart(); 
		Session session=sessionFactory.openSession();
		if(cart.getCartid()==0)
	     {
	  int cartid=(int)(Math.random()*10000);
	   cart.setCartid(cartid);
	  }
		cart.setProductId(product.getProductId());
	    cart.setProductName(product.getProductName());
		cart.setProductPrice(product.getProductPrice());
		cart.setProductSupplier(product.getProductSupplier());
		cart.setQuantity(quantity);
		cart.setTotalprice(cart.getProductPrice()*cart.getQuantity());
		session.save(cart);
	    Transaction transaction	=session.beginTransaction();
	    transaction.commit();
	    session.close();
		return cart;
	}
public List<Cart>	Displaycart()
{
Session session = sessionFactory.openSession();
 Query query    =   session.createQuery("from Cart");
List<Cart> cartlist= query.list();
for(Cart cart:cartlist)
{
	System.out.println(cart.getCartid());
	System.out.println(cart.getProductId());
}
session.close();
return cartlist;
}
}
