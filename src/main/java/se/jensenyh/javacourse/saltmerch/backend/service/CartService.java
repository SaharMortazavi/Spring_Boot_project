package se.jensenyh.javacourse.saltmerch.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.repository.CartRepository;

import java.util.List;
@Service
public class CartService {

    @Autowired
    CartRepository cartDb;

    public List<CartItem> getAllCartItem(){

        return cartDb.selectAllItems();
    }

//    public CartItem getCartItem(int id){
//        List <CartItem>allCartItems=cartDb.selectAllItems();
//        allCartItems.stream().filter(i ->i.productId.equals(id))
//    }
//    public int deleteOrAdd(String action,CartItem item){
//        if(action.equals("add")){
//            return cartDb.insertOrIncrementItem(item);
//        } else if (action.equals("remove")) {
//            return cartDb.deleteOrDecrementItem(item);
//        }
//        return -1;
//    }

    public int deleteOrDecrementItem (CartItem item){
        return cartDb.deleteOrDecrementItem(item);

    }
    public int addOrIncrementItem (CartItem item){
        return cartDb.insertOrIncrementItem(item);

    }
    public void deleteAllCartItemsByeOut (Boolean restock){
        cartDb.deleteAllItems(false);

    }
    public void deleteAllCartItemRestock(Boolean restock){
        cartDb.deleteAllItems(true);
    }
}
