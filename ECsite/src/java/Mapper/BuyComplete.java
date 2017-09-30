/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import Data.DAO;
import Data.ShopDataBeans;
import Data.UserDataDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DEKO
 */
public class BuyComplete extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session=request.getSession();
            request.setCharacterEncoding("UTF-8");
            
            try {
                /**
                 * DAOクラスメソッドbuyDataを使用し、購入した商品をデータベースに登録する
                 * session.getAttribute("login")によってユーザーの情報を取得
                 * Cart.jspでの商品情報表示のために変換したShopDataBeans配列をsessionから取得
                 * form情報からパラメータtypeを取得
                 * 上記を引数としてメソッドに渡す
                 */
                DAO.getInstance().buyData((UserDataDTO)session.getAttribute("login"),(ArrayList<ShopDataBeans>)session.getAttribute("sdbAL"),Integer.parseInt(request.getParameter("type")));
                /**
                 * 商品情報登録後、ユーザーの購入金額を更新する
                 */
                DAO.getInstance().setDBTotal((UserDataDTO)session.getAttribute("login"));
                /**
                 * ユーザー情報更新後、sessionに登録されたユーザー情報を更新するためデータベースにアクセスし、情報を上書きする
                 */
                UserDataDTO udd= DAO.getInstance().UDSelect((UserDataDTO)session.getAttribute("login"));
                session.setAttribute("login",udd);
                //購入した商品情報をsessionから除外する
                session.removeAttribute("sdbAL");
                session.removeAttribute("cartItem");
            } catch(SQLException e){
                System.out.println("DB接続に異常があります");
            }
            request.getRequestDispatcher("buy_complete.jsp").forward(request, response);
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
