/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import ECsiteLogic.DBManager;
import ECsiteLogic.LogicBeans;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 本クラスはデータベースとのアクセスに関するメソッドをまとめるクラスである
 * @kagoyume_db MySQLのデータベース名
 * @user_t kagoyume_dbのテーブル ユーザー情報
 * @buy_t kagoyume_dbのテーブル　購入された商品情報
 */
public class DAO {

    public static DAO getInstance() {
        return new DAO();
    }

    /**
     * データベースに対応したフィールドをもつUserDataDTO変数を引数として取得することで データベースに情報を登録することが出来るメソッド
     * 名前、パスワード、メールアドレス、住所のほか登録した日時をデータベースに登録する
     */
    public void UDInsert(UserDataDTO udd) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement("insert into user_t (name,password,mail,address,total,newDate,deleteFlg) value(?,?,?,?,0,?,0)");
            ps.setString(1, udd.getName());
            ps.setString(2, udd.getPassword());
            ps.setString(3, udd.getMail());
            ps.setString(4, udd.getAddress());
            ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            ps.executeUpdate();
            System.out.println("DBへの登録が完了しました");

            con.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println("DB接続に異常があります");
        } finally {
            if (con != null) {
                con.close();

            }
        }

    }
    /**
     * login.jspのフォームデータを利用してユーザー情報を取得するメソッド
     */
    public UserDataDTO login(String name, String password) {
        UserDataDTO udd = new UserDataDTO();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement("select * from user_t where name=? and password=?");
            ps.setString(1, name);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                udd.setUserID(rs.getInt("userID"));
                udd.setName(rs.getString("name"));
                udd.setPassword(rs.getString("password"));
                udd.setMail(rs.getString("mail"));
                udd.setAddress(rs.getString("address"));
                udd.setTotal(rs.getInt("total"));
                udd.setNewDate(rs.getTimestamp("newDate"));
                udd.setDeleteFlg(rs.getInt("deleteFlg"));

            }

        } catch (SQLException ex) {
            System.out.println("DB接続に異常があります");
        }
        return udd;
    }

    /**
     * ログイン時、登録したUserDataDTO変数を使用して session情報を更新するためのメソッド
     */
    public UserDataDTO UDSelect(UserDataDTO login) {
        UserDataDTO udd = new UserDataDTO();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement("select * from user_t where userID=?");
            ps.setInt(1, login.getUserID());
            rs = ps.executeQuery();
            if (rs.next()) {
                udd.setUserID(rs.getInt("userID"));
                udd.setName(rs.getString("name"));
                udd.setPassword(rs.getString("password"));
                udd.setMail(rs.getString("mail"));
                udd.setAddress(rs.getString("address"));
                udd.setTotal(rs.getInt("total"));
                udd.setNewDate(rs.getTimestamp("newDate"));
                udd.setDeleteFlg(rs.getInt("deleteFlg"));

            }

        } catch (SQLException e) {
            System.out.println("DB接続に異常があります");
        }
        return udd;
    }

    /**
     * データーベースに登録しているユーザーデータを使用停止状態にするメソッド
     * データベースカラム値DeleteFlgを使用停止状態(1)にすることでログイン不可にする なお、登録初期値は(0)であり、未登録時は(-1)である
     */
    public void UDDelete(UserDataDTO udd) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement("update  user_t set deleteFlg=1 where userID=?");
            ps.setInt(1, udd.getUserID());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("DB接続に異常があります");
        }
    }
    
    /**
     * 購入した商品のアイテムコード、配送手段、ユーザーIDを登録するメソッド
     * 引数 ArrayList<ShopDataBeans>はCartItemクラスによって格納された配列を使用している
     * なおCartItemクラスによって格納されているフィールド値はitemCodeである
     */
    public void buyData(UserDataDTO udd, ArrayList<ShopDataBeans> sdbAL, int type) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBManager.getConnection();
            for (ShopDataBeans sdb : sdbAL) {
                ps = con.prepareStatement("insert into buy_t (userID,itemCode,type,buyDate) value(?,?,?,?)");
                ps.setInt(1, udd.getUserID());
                ps.setString(2, sdb.getItemCode());
                ps.setInt(3, type);
                ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
                ps.executeUpdate();
            }
            System.out.println("DBへの登録が完了しました");

            con.close();
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("DB接続に異常があります");
        } finally {
            if (con != null) {
                con.close();

            }
        }

    }
    /**
     * ユーザーが購入した商品をデータベースで参照し、その商品の金額を計算、その後ユーザー情報 total を更新するメソッド 
     */
    public void setDBTotal(UserDataDTO udd) throws IOException, SQLException {
        int total = 0;

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement("select itemCode from buy_t where userID=?");
            ps.setInt(1, udd.getUserID());

            rs = ps.executeQuery();
            while (rs.next()) {
                total += LogicBeans.getInstance().oneSearch(rs.getString("itemCode")).getPrice();
            }
            ps = con.prepareStatement("update user_t set total=? where userID=?");
            ps.setInt(1, total);
            ps.setInt(2, udd.getUserID());
            ps.executeUpdate();
            System.out.println("DBへの登録が完了しました");

            con.close();
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("DB接続に異常があります");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
    /**
     * ユーザー情報の更新
     *  データベースに格納されているユーザー情報を上書きする
     */
    public void UDUpdate(UserDataDTO udd) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBManager.getConnection();

            ps = con.prepareStatement("update user_t set name=?,password=?,mail=?,address=? where userID=?");
            ps.setString(1, udd.getName());
            ps.setString(2, udd.getPassword());
            ps.setString(3, udd.getMail());
            ps.setString(4, udd.getAddress());
            ps.setInt(5, udd.getUserID());
            ps.executeUpdate();
            System.out.println("DBへの登録が完了しました");
            con.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("DB接続に異常があります");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
    
    /**
     * userIDを条件に検索することによってこれまでユーザーが購入した商品を検索
     * 該当する商品のアイテムコードを取得し、CartItemに格納
     * その後戻り値として返却する
     */
    public CartItem getMyHistory(UserDataDTO udd) throws IOException, SQLException {
        CartItem cartItem = new CartItem();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement("select itemCode from buy_t where userID=?");
            ps.setInt(1, udd.getUserID());

            rs = ps.executeQuery();
            while (rs.next()) {
                cartItem.setCartItem(rs.getString("itemCode"));
            }

            System.out.println("DB情報取得完了しました");

            con.close();
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("DB接続に異常があります");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
        return cartItem;
    }
}
