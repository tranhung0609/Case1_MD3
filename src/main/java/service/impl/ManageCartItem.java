package service.impl;

import model.Account;
import model.CartItem;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ManageCartItem {
    ProductServiceImpl productService = new ProductServiceImpl();

    public List<CartItem> findByAccount(int accountId, List<CartItem> list) {
        List<CartItem> cartItems = new ArrayList<>();
        for (CartItem c : list) {
            if (c.getAccount().getId() == accountId) {
                cartItems.add(c);
            }
        }
        return cartItems;
    }

    public void addToCart(CartItem cartItem, List<CartItem> list, int quantity) {
        int count = 0;
        if (list.size() == 0) {
            list.add(cartItem);
        } else {
            for (CartItem c : list) {
                // xét theo cartItemId mà em lười sửa quá mn à
                if ((c.getProduct().getId() == cartItem.getProduct().getId()) && c.getAccount().getId() == cartItem.getAccount().getId()) {
                    c.setQuantity(c.getQuantity() + quantity);
                    c.setPrice(c.getPrice() + (cartItem.getProduct().getPrice() * quantity));
                    count = 1;
                    break;
                }
            }
            if (count == 0) {
                list.add(cartItem);
            }
        }
    }

    public void deleteProduct(int cartItemId, List<CartItem> list) {
        for (CartItem c : list) {
            if (c.cartItemId == cartItemId) {
                list.remove(c);
                break;
            }
        }
    }

}
