/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import Data.CartItem;
import Data.DAO;
import Data.ShopDataBeans;
import Data.UserDataDTO;
import ECsiteLogic.LogicBeans;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DEKO
 */
public class MyHistory extends HttpServlet {

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
            HttpSession session =request.getSession();
        try (PrintWriter out = response.getWriter()) {
            //ユーザー情報を引き渡すことにより、データベースにアクセスして購入履歴を調べる
            CartItem cartItem = DAO.getInstance().getMyHistory((UserDataDTO)session.getAttribute("login"));
            //ShopDataBeansの情報配列を作るためArrayListを宣言
            ArrayList<ShopDataBeans> sdbAL =new ArrayList<>();
            if(cartItem!=null){
                //データベースに購入履歴があればcartItemにitemCodeが入るので
                //その情報を利用してitemCodeを商品情報に変換する
                sdbAL=LogicBeans.getInstance().cartSearch(cartItem);
            }
            session.setAttribute("myhistory", sdbAL);
            
            request.getRequestDispatcher("myhistory.jsp").forward(request, response);
        } catch (SQLException ex) {
            System.out.println("DB接続に異常があります");
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
