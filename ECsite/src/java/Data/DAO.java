/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import ECsiteLogic.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guest1Day
 */
public class DAO {

    public static DAO getInstance() {
        return new DAO();
    }

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

    public UserDataDTO login(String name, String password) {
        UserDataDTO udd = new UserDataDTO();
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement("select * from user_t where name=? and password=? and deleteFlg=0");
            ps.setString(1, name);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if(rs.next()){
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

}
