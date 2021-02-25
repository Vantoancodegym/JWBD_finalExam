package service;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    private String url = "jdbc:mysql://localhost:3306/jwbd_final_exam";
    private String user = "root";
    private String password = "ss123123";
    public ProductService() {
    }
    public Connection getConnetion(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,
                    user,
                    password
            );
        } catch (ClassNotFoundException e) {
            System.out.println("không có driver");
        } catch (SQLException throwables) {
            System.out.println("Không kết nối được");
        }
        System.out.println("ket noi thanh cong");

        return connection;
    }

    @Override
    public List<Product> findAll() {
        List<Product> list=new ArrayList<>();
        Connection connection=getConnetion();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select * from product");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                int price=resultSet.getInt("price");
                int amount=resultSet.getInt("amount");
                String color=resultSet.getString("color");
                String description=resultSet.getString("description");
                int category_id=resultSet.getInt("category_id");
                Product product=new Product(id,name,price,amount,color,description,category_id);
                list.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public Product findById(int id) {
        Product product=null;
        Connection connection=getConnetion();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select * from product where id=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String name=resultSet.getString("name");
                int price=resultSet.getInt("price");
                int amount=resultSet.getInt("amount");
                String color=resultSet.getString("color");
                String description=resultSet.getString("description");
                int category_id=resultSet.getInt("category_id");
                product=new Product(id,name,price,amount,color,description,category_id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public void create(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(int id) {

    }
}
