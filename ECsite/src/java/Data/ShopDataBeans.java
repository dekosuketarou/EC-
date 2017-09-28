/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author DEKO
 */
public class ShopDataBeans {
    private String item;
    private String desc;
    private String price;
    private int type;
    private String itemCode;
    private String imageURL;
    
    static String hit="";
    public ShopDataBeans(){
        item="";
        desc="";
        price="";
        itemCode="";
        imageURL="";
        type=1;//初期値１　通常発送
    }
    


    public void setItem(String item){
        this.item=item;
    }
    public void setDesc(String desc){
        this.desc=desc;
    }
    public void setPrice(String price){
        this.price=price;
        
    }
    public void setItemCode(String itemCode){
        this.itemCode=itemCode;
        
    }
    public void setImageURL(String imageURL){
        this.imageURL=imageURL;
    }
    
    
    public String getItem(){
        return item;
    }
    public String getDesc(){
        return desc;
    }
    public String getPrice(){
        return price;
    }
    public String getItemCode(){
        return itemCode;
    }
    public String getImageURL(){
        return imageURL;
    }
    
    
    
}

