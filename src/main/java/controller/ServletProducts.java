package controller;

import model.Product;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletProducts", urlPatterns = "/products")

public class ServletProducts extends HttpServlet {
    ProductService productService=new ProductService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null) action="";
        switch (action){
            case "create":
                showFormCreate(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            case "edit":
                showFormEdit(request,response);
                break;
            default:
                showList(request,response);
                break;
        }

    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        Product product=productService.findById(id);
        request.setAttribute("product",product);
        RequestDispatcher dispatcher=request.getRequestDispatcher("edit.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        productService.delete(id);
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher=request.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Product> list=productService.findAll();
        request.setAttribute("list",list);
        RequestDispatcher dispatcher=request.getRequestDispatcher("list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action=request.getParameter("action");
        if (action==null) action="";
        switch (action){
            case "create":
                create(request,response);
                break;

        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("name");
        int price= Integer.parseInt(request.getParameter("price"));
        int amount=Integer.parseInt(request.getParameter("amount"));
        String color=request.getParameter("color");
        String description=request.getParameter("description");
        String category=request.getParameter("category");
        int category_id=0;
        switch (category){
            case "computer":
                category_id=2;
                break;
            case "TV":
                category_id=3;
                break;
            case "mobile":
                category_id=1;
                break;
        }
        Product product=new Product(name,price,amount,color,description,category_id);
        productService.create(product);
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
