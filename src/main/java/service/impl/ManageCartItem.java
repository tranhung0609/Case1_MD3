package service.impl;

import model.Account;
import model.CartItem;

import java.util.ArrayList;
import java.util.List;

public class ManageCartItem {
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
                if (c.getProduct().getId() == cartItem.getProduct().getId()) {
                    c.setQuantity(c.getQuantity() + quantity);
                    c.setPrice(c.getPrice() + (cartItem.getProduct().getPrice() * quantity));
                    count = 1;
                    break;
                }
            }
            if (count == 0){
                list.add(cartItem);
            }
        }
    }
}
