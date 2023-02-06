package se.jensenyh.javacourse.saltmerch.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.service.CartService;

import java.util.List;

@CrossOrigin(origins="http://localhost:3010")
@RestController
public class CartController {

    @Autowired
    CartService cartService;

//    @PatchMapping("carts/{id}?action=remove")
//    public Object deleteOrRemove(@PathVariable("id") int id, @RequestBody CartItem item, @RequestParam String action) {
//        return cartService.deleteOrDecrementItem(item);
//
//    }
    @GetMapping ("/carts")
    public List<CartItem> getAllCartItem() {
        return cartService.getAllCartItem();
    }

    @PatchMapping("carts/{id}")
    public Object addOrDelete(@PathVariable(required = false) int id, @RequestParam String action,@RequestBody CartItem item) {
        if (action.equals("add")) {
            return cartService.addOrIncrementItem(item);
//            new ResponseEntity<>(cartService.addOrIncrementItem(item), HttpStatus.OK);
        } else if (action.equals("remove")){
            return cartService.deleteOrDecrementItem(item);
//            new ResponseEntity<>(cartService.deleteOrDecrementItem(item), HttpStatus.OK);
        }return null;
    }

    @DeleteMapping("carts/{id}")
    public void deleteAllCartItems(@PathVariable(required = false) int id, @RequestParam(defaultValue ="") String buyout){
        if (buyout.equals("true")){
            cartService.deleteAllCartItemsByeOut(true);
        } else if (buyout.equals("")) {
            cartService.deleteAllCartItemRestock(false);
        }
}
}