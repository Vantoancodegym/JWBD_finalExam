package service;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    private String url = "jdbc:mysql://localhost:3306/jwbd_final_exam";
    private String user = "root";
    private String password = "ss123123";
    private String findByJoin="select product.id,product.name,product.price,product.amount,product.color,product.description,c.type as type\n" +
            "from product join category c on c.id = product.category_id;";
    private String findByIdByJoin="select product.id,product.name,product.price,product.amount,product.color,product.description,c.type as type\n" +
            "from product join category c on c.id = product.category_id where product.id=?;";
    private String findByNameByJoin="select product.id,product.name,product.price,product.amount,product.color,product.description,c.type as type\n" +
            "from product join category c on c.id = product.category_id where product.name=?;";
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
    public String getTypeProduct(int typeId){
        String type="";
        Connection connection=getConnetion();
        try {
            CallableStatement callableStatement=connection.prepareCall("{call get_type_by_id(?,?)}");
            callableStatement.setInt(1,typeId);
            callableStatement.registerOutParameter(2, Types.VARCHAR);
            callableStatement.execute();
            type=callableStatement.getString(2);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return type;
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
    public List<Product> findAllByJoin(){
        List<Product> list=new ArrayList<>();
        Connection connection=getConnetion();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(findByJoin);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                int price=resultSet.getInt("price");
                int amount=resultSet.getInt("amount");
                String color=resultSet.getString("color");
                String description=resultSet.getString("description");
                String category_type=resultSet.getString("type");
                Product product=new Product(id,name,price,amount,color,description,category_type);
                list.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }
    public Product findByIdByJoin(int id) {
        Product product=null;
        Connection connection=getConnetion();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(findByIdByJoin);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String name=resultSet.getString("name");
                int price=resultSet.getInt("price");
                int amount=resultSet.getInt("amount");
                String color=resultSet.getString("color");
                String description=resultSet.getString("description");
                String category_type=resultSet.getString("type");
                product=new Product(id,name,price,amount,color,description,category_type);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public void create(Product product) {
        Connection connection=getConnetion();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("insert into " +
                    "product(name,price,amount,color,description,category_id) values (?,?,?,?,?,?)");
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getPrice());
            preparedStatement.setInt(3,product.getAmount());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDescription());
            preparedStatement.setInt(6,product.getCategory_id());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Product product) {
        Connection connection=getConnetion();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("update product set name=?,price=?," +
                    "amount=?, color=?, description=?, category_id=? where id=?;");
            preparedStatement.setString(1,product.getName());
            preparedStatement.setInt(2,product.getPrice());
            preparedStatement.setInt(3,product.getAmount());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDescription());
            preparedStatement.setInt(6,product.getCategory_id());
            preparedStatement.setInt(7,product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        Connection connection=getConnetion();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("delete from product where id=?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public Product findByName(String name){
        Product product =null;
        Connection connection=getConnetion();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select * from product where name=?");
            preparedStatement.setString(1,name);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
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
    public Product findByNameByJoin(String name){
        Product product =null;
        Connection connection=getConnetion();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(findByNameByJoin);
            preparedStatement.setString(1,name);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                int price=resultSet.getInt("price");
                int amount=resultSet.getInt("amount");
                String color=resultSet.getString("color");
                String description=resultSet.getString("description");
                String category_type=resultSet.getString("type");
                product=new Product(id,name,price,amount,color,description,category_type);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }
}
