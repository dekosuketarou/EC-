/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Timestamp;

/**
 *
 * @author guest1Day
 */
public class UserDataDTO {
        private int userID;
        private String name;
        private String password;
        private String mail;
        private String address;
        private int total=0;
        private Timestamp newDate;
        private int deleteFlg=1;

        public void setUserID(int userID){
            this.userID=userID;
        }
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
        public void setTotal(int total){
            this.total=total;
        }
        public void setNewDate(Timestamp newDate){
            this.newDate=newDate;
        }
        public void setDeleteFlg(int deleteFlg){
            this.deleteFlg=deleteFlg;
        }
        
        public int getUserID(){
            return userID;
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
        public int getTotal(){
            return total;
        }
        public Timestamp getNewDate(){
            return newDate;
        }
        public int getDeleteFlg(){
            return deleteFlg;
        }
}
