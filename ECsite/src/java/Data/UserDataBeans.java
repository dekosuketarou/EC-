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
public class UserDataBeans {
    private String name="";
    private String password="";
    private String mail="";
    private String address="";

    
    
    public void setName(String name){
        this.name=name;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setMail(String mail){
        this.mail=mail;
    }
    public void setAddress(String address){
        this.address=address;
    }
    
    
    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public String getMail(){
        return mail;
    }
    public String getAddress(){
        return address;
    }
    public void DTOMapping(UserDataDTO udd){
        udd.setName(this.name);
        udd.setPassword(this.password);
        udd.setMail(this.mail);
        udd.setAddress(this.address);
        
    }
}