/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ECsiteLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author guest1Day
 */
public class DBManager {
    static String dburl="jdbc:mysql://localhost:3306/ECsite";
    static String jdbc="com.mysql.jdbc.Driver";
    static String dbuser="root";
    static String dbpassword="";
    
    public static DBManager getInstance(){
        return new DBManager();
    }
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName(jdbc).newInstance();
            con=DriverManager.getConnection(dburl, dbuser, dbpassword);
            System.out.println("接続かんりょうしました");
            
        }catch(ClassNotFoundException e){
            System.out.println("JDBCが見つかりません");
        }catch(InstantiationException e){ 
            System.out.println("インスタンス作成に失敗しました");
        
        }catch(IllegalAccessException e){
            System.out.println("予期せぬアクセス異常が発生しました");
            
        }catch(SQLException e){
            System.out.println("DB接続に異常があります");
            
        }
        return con;
    }
}
