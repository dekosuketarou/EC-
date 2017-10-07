/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import Data.CartItem;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DEKO
 */
public class Add extends HttpServlet {

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

            HttpSession session = request.getSession();

            request.setCharacterEncoding("UTF-8");

            //商品コードを格納するクラスCartItem
            CartItem cartItem = new CartItem();

            //ログインしていない場合 key"cartItem"で情報を登録
            if (session.getAttribute("login") == null) {
                //買い物かごの中身情報がある場合は取得し、買い物情報を追加する
                //その後追加した情報をsessionに上書きする
                if (session.getAttribute("cartItem") != null) {
                    cartItem = (CartItem) session.getAttribute("cartItem");
                }
                cartItem.setCartItem(request.getParameter("code"));
                session.setAttribute("cartItem", cartItem);
            //ログインしている場合 key"userID"で情報を登録
            //userIDはログイン時に登録している文字列である
            } else {
                String userID = (String) session.getAttribute("userID");
                if (session.getAttribute(userID) != null) {
                    cartItem = (CartItem) session.getAttribute(userID);
                }
                cartItem.setCartItem(request.getParameter("code"));

                session.setAttribute(userID, cartItem);

            }
            request.getRequestDispatcher("add.jsp").forward(request, response);
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
