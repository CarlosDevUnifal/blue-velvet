package dao;

import entitys.product.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private Connection connection;

    public ProductDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blue-velvet", "bluevelvet", "bluevelvet");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<Product>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String artistName = resultSet.getString("artist_name");
                double price = resultSet.getDouble("price");
                String musicList = resultSet.getString("music_list");
                String photo = resultSet.getString("photo");
                products.add(new Product(id, name, artistName, price, musicList, photo));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product getProductAt(int id) {
        Product product = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int productId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String artistName = resultSet.getString("artist_name");
                double price = resultSet.getDouble("price");
                String musicList = resultSet.getString("music_list");
                String photo = resultSet.getString("photo");
                product = new Product(productId, name, artistName, price, musicList, photo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public void removeProduct(Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM product WHERE id = ?");
            statement.setInt(1, product.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProduct(Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO product (name, artist_name, price, music_list, photo) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, product.getName());
            statement.setString(2, product.getArtistName());
            statement.setDouble(3, product.getPrice());
            statement.setString(4, product.getMusicList());
            statement.setString(5, product.getPhoto());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

