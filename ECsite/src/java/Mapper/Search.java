/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import ECsiteLogic.LogicBeans;
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
public class Search extends HttpServlet {

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
            //検索キーワードqueryを取得しsessionに登録
            session.setAttribute("keyword", request.getParameter("query"));
            //クエストリングから取得するページを登録
            session.setAttribute("page", request.getParameter("offset"));
            //検索キーワードが入力されていた場合、LogicBeansクラスメソッドsearchItemに検索キーワードqueryを引き渡し、商品情報を取得する
            //検索結果の該当データが０の場合はsessionにkey"hit"でvalue"0"が登録される、該当したデータがある場合は該当数を登録する
            //その後該当した商品情報をArrayList<ShopDataBeans>としてsessionにkey"searchResult"で登録される
            //
            
            if (!request.getParameter("query").equals("")) {
                
                LogicBeans.getInstance().searchItem(request);
                request.getRequestDispatcher("search.jsp").forward(request, response);
            } else {
                //検索キーワードが入力されていなかった場合、requestScopeに検索キーワードの状況を登録し検索ページへ戻す
                request.setAttribute("error", "キーワードが未入力です");
                request.getRequestDispatcher("top.jsp").forward(request, response);
            }

        } catch (Exception e) {
            System.out.println(e);
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
