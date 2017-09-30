/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;

/**
 *
 * @author guest1Day
 */
public class CartItem {
    //カートに追加ボタンを押した後にcartItemにitemCodeが格納される
    private  ArrayList<String> cartItem=new ArrayList<>();
    
    
    public void setCartItem(String itemCode){
        cartItem.add(itemCode);
    }
    public ArrayList<String> getCartItem(){
        return cartItem;
    }
    public void deleteCartItem(int addNumber){
        cartItem.remove(addNumber);
    }
        
}
