
package Service.impl;

import java.io.File;
import java.util.List;

import DAO.CartDao;
import DAO.CartItemDao;
import DAO.ProductDao;
import DAO.UserDao;
import DAO.impl.CartDaoImpl;
import DAO.impl.CartItemDaoImpl;
import DAO.impl.ProductDaoImpl;
import DAO.impl.UserDaoImpl;
import Model.Cart;
import Model.CartItem;
import Model.Product;
import Model.User;
import Service.CartItemService;
import Service.CartService;
import Service.ProductService;
import Service.UserService;

public class CartServiceItemImpl implements CartItemService {
	CartItemDao cartItemDao = new CartItemDaoImpl();

	@Override
	public void insert(CartItem cartItem) {
		cartItemDao.insert(cartItem);
		
	}

	@Override
	public void edit(CartItem newCartItem) {
		CartItem oldCartItem = cartItemDao.get(newCartItem.getId());
		oldCartItem.setCart(newCartItem.getCart());
		oldCartItem.setProduct(newCartItem.getProduct());
		oldCartItem.setQuantity(newCartItem.getQuantity());
		oldCartItem.setUnitPrice(newCartItem.getUnitPrice());
		
		cartItemDao.edit(oldCartItem);
	}

	@Override
	public void delete(String id) {
		cartItemDao.delete(id);
	}

	@Override
	public CartItem get(int id) {
		return cartItemDao.get(id);
	}

	@Override
	public List<CartItem> getAll() {
		return cartItemDao.getAll();
	}

	@Override
	public List<CartItem> search(String keyword) {
		return cartItemDao.search(keyword);
	}

	
}
