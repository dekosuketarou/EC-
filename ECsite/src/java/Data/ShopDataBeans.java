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
    private int price;
    private int type=1;//初期値１　通常発送
    private String itemCode;
    private String imageURL;
    private double  reviewRate;
    private int reviewCount;
    static String hit;
 
    


    public void setItem(String item){
        this.item=item;
    }
    public void setDesc(String desc){
        this.desc=desc;
    }
    public void setPrice(String price){
        try {
            this.price=Integer.parseInt(price);
		
	} catch (NumberFormatException e) {
            System.out.print(e);
	}
    }
    public void setItemCode(String itemCode){
        this.itemCode=itemCode;
        
    }
    public void setImageURL(String imageURL){
        this.imageURL=imageURL;
    }
    public void setReviewRate(String reviewRate){
        try{
            this.reviewRate=Double.parseDouble(reviewRate);
        } catch (NumberFormatException e) {
            System.out.print(e);
	}
    }
    public void setReviewCount(String reviewCount){
        try{
            this.reviewCount=Integer.parseInt(reviewCount);
        }catch(NumberFormatException e){
            System.out.print(e);
        }
    }
    public String getItem(){
        return item;
    }
    public String getDesc(){
        return desc;
    }
    public int getPrice(){
        return price;
    }
    public String getItemCode(){
        return itemCode;
    }
    public String getImageURL(){
        return imageURL;
    }
    public double getReviewRate(){
        return reviewRate;
    }
    public int getReviewCount(){
        return reviewCount;
    }
    
    
}

