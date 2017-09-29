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
    final String login="<ul><li><form action=\"Logout\" method=\"POST\"><input type=\"submit\" value=\"ログアウト\"></form></li>";
    final String cart="<li><form action=\"Cart\" method=\"POST\"><input type=\"submit\" value=\"買い物カゴ\"></form></li></ul>";
    public static MenuHelper getInstance(){
        return new MenuHelper();
    }  
//    <ul><li><form action="Logout" method="POST"><input type="submit" value="ログアウト"></form></li>
//    <li><form action="Cart" method="POST"><input type="submit" value="買い物かご"></form></li></ul>
    public String getUpMenu(){
        return login+cart;
    }
}
