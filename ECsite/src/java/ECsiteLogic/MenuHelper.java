/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ECsiteLogic;

/**
 *
 * @author guest1Day
 */
public class MenuHelper {
    final String login="<form action=\"Login\" method=\"POST\"><input type=\"submit\" value=\"ログインページ\"></form>";
    final String logout="<form action=\"Logout\" method=\"POST\"><input type=\"submit\" value=\"ログアウト\"></form>";
    final String top="<form action=\"top.jsp\" method=\"POST\"><input type=\"submit\" value=\"検索ページ\"></form>";
    final String cart="<form action=\"Cart\" method=\"POST\"><input type=\"submit\" value=\"買い物カゴ\"></form>";
    final String mydata="<form action=\"mydata.jsp\" method=\"POST\"><input type=\"submit\" value=\"会員情報\"></form>";
    final String myhistory="<form action=\"MyHistory\" method=\"POST\"><input type=\"submit\" value=\"購入履歴\"></form>";
    final String myupdate="<form action=\"myupdate.jsp\" method=\"POST\"><input type=\"submit\" value=\"会員情報変更\"></form>";
    final String mydelete="<form action=\"mydelete.jsp\" method=\"POST\"><input type=\"submit\" value=\"退会申請\"></form>";
    
    public static MenuHelper getInstance(){
        return new MenuHelper();
    }  
//    <ul><li><form action="Logout" method="POST"><input type="submit" value="ログアウト"></form></li>
//    <li><form action="Cart" method="POST"><input type="submit" value="買い物かご"></form></li></ul>

    public String getLoginMenu(){
        return login;
    }
    public String getLogoutMenu(){
        return logout;
    }
    public String getTopMenu(){
        return top;
    }
    public String getCartMenu(){
        return cart;
    }
    public String getMyDataMenu(){
        return mydata;
    }
    public String getMyUpdateMenu(){
        return myupdate;
    }
    public String getMyHistoryMenu(){
        return myhistory;
    }
    public String getMyDeleteMenu(){
        return mydelete;
    }
}
