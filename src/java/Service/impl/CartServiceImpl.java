
package Service.impl;

import java.io.File;
import java.util.List;

import DAO.CartDao;
import DAO.ProductDao;
import DAO.UserDao;
import DAO.impl.CartDaoImpl;
import DAO.impl.ProductDaoImpl;
import DAO.impl.UserDaoImpl;
import Model.Cart;
import Model.Product;
import Model.User;
import Service.CartService;
import Service.ProductService;
import Service.UserService;

public class CartServiceImpl implements CartService {
	CartDao cartDao = new CartDaoImpl();

	@Override
	public List<Cart> search(String name) {
		return cartDao.search(name);
	}

	@Override
	public void insert(Cart cart) {
		cartDao.insert(cart);

	}

	@Override
	public List<Cart> getAll() {
		return cartDao.getAll();
	}

	@Override
	public Cart get(int id) {
		return cartDao.get(id);
	}

	@Override
	public void edit(Cart newCart) {
		Cart oldCart = cartDao.get(newCart.getId());

		oldCart.setBuyDate(newCart.getBuyDate());
		oldCart.setBuyer(newCart.getBuyer());
		
		
		cartDao.edit(oldCart);

	}

	@Override
	public void delete(int id) {
		cartDao.delete(id);
	}
}

