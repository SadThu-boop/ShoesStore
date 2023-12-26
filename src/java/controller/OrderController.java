package controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Cart;
import Model.User;
import Model.CartItem;
import Service.CartItemService;
import Service.CartService;
import Service.UserService;
import Service.impl.CartServiceImpl;
import Service.impl.CartServiceItemImpl;
import Service.impl.UserServiceImpl;
import Utility.RandomUUID;
@WebServlet(urlPatterns = "/member/order")
public class OrderController extends HttpServlet {
	UserService userService = new UserServiceImpl();
	CartService cartService = new CartServiceImpl();
	CartItemService cartItemService = new CartServiceItemImpl();
	long time = System.currentTimeMillis();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("account");
		User buyer = (User) obj;
		Cart cart = new Cart();
		cart.setBuyer(buyer);
		cart.setBuyDate(new java.sql.Date(time));
		cart.setId(RandomUUID.getRandomID());
		cartService.insert(cart);

		Object objCart = session.getAttribute("cart");
		if (objCart != null) {
			// ep ve dung kieu cua no khi them vao o phan them vao gio hang controller
			Map<Integer, CartItem> map = (Map<Integer, CartItem>) objCart;

			for (CartItem cartItem : map.values()) {
				cartItem.setCart(cart);
				cartItem.setId(RandomUUID.getRandomID());
				cartItemService.insert(cartItem);
				
			}

		}
		session.removeAttribute("cart");
		resp.sendRedirect(req.getContextPath() + "/home");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
