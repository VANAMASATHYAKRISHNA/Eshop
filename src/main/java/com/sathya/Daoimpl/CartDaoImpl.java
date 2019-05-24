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
	Cart addTOCart=new Cart(); 
		Session session=sessionFactory.openSession();
		if(addTOCart.getCartid()==0)
	     {
	  int cartid=(int)(Math.random()*10000);
	   addTOCart.setCartid(cartid);
	  }
		addTOCart.setProductId(product.getProductId());
		addTOCart.setProductName(product.getProductName());
		addTOCart.setProductPrice(product.getProductPrice());
		addTOCart.setProductSupplier(product.getProductSupplier());
		addTOCart.setQuantity(quantity);
		addTOCart.setTotalprice(addTOCart.getProductPrice()*addTOCart.getQuantity());
		session.save(addTOCart);
	    Transaction transaction	=session.beginTransaction();
	    transaction.commit();
	    session.close();
		return addTOCart;
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
