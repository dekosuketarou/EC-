/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import Data.DAO;
import Data.UserDataDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DEKO
 */
public class LoginResult extends HttpServlet {

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
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession(true);
            request.setCharacterEncoding("UTF-8");
            
            //フォームよりパラメーターname,passwordを取得し、データベースにアクセスして該当するユーザー情報があるか検索
            
            UserDataDTO udd = DAO.getInstance().login(request.getParameter("name"), request.getParameter("password"));
            
            //検索したユーザー情報のDeleteFlgが 1（退会済みユーザー） の場合、またはユーザーが該当しなかった場合（初期値 -1 ）
            
            if (udd.getDeleteFlg() == 1 || udd.getDeleteFlg() == -1) {
                
                //requestScopeにDeleteFlgを登録し、その後のメッセージに繁栄させる
                
                request.setAttribute("Flg", udd.getDeleteFlg());
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else if (udd.getDeleteFlg() == 0) {
                //cookie情報を登録するかチェックボックスへチェックを入れている場合
                if (request.getParameter("cookie") != null) {
                    //それぞれの情報を登録する
                    Cookie c1 = new Cookie("name", udd.getName());
                    Cookie c2 = new Cookie("password", udd.getPassword());
                    response.addCookie(c1);
                    response.addCookie(c2);
                }
                //loginメソッドにより取得したユーザー情報をsessionに登録
                session.setAttribute("login", udd);
                
                //Loginサーブレットにアクセスしたときに登録したsession情報returnがある場合、引数としてパスを指定する
                if (session.getAttribute("return") != null) {
                    request.getRequestDispatcher(session.getAttribute("return").toString()).forward(request, response);
                } else {
                    request.getRequestDispatcher("top.jsp").forward(request, response);
                }
            }

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
