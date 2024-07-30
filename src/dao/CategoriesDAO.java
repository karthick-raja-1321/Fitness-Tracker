package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Categories;
import utility.DbConnection;

public class CategoriesDAO {

	public void addCategory(Categories category) throws SQLException {
        String query = "INSERT INTO categories (category_name) VALUES (?)";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, category.getCategoryName());
            statement.executeUpdate();
        }
    }

	public void updateCategory(Categories categories)throws SQLException {
		String query = "UPDATE categories SET category_name = ? WHERE category_id = ?;";
		try (Connection connection = DbConnection.getConnection();
	             PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setString(1, categories.getCategoryName());
	            statement.setInt(2, categories.getCategoryId());
	            statement.executeUpdate();
		}
	}

	public List<Categories> getAllCategories() throws SQLException {
		List<Categories> c = new ArrayList<>();
		String query = "SELECT * FROM categories";
		 try (Connection connection = DbConnection.getConnection();
	             Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery(query)) {
	            while (resultSet.next()) {
	                Categories category = new Categories();
	                category.setCategoryId(resultSet.getInt("category_id"));
	                category.setCategoryName(resultSet.getString("category_name"));
	                c.add(category);
	            }
	        }
	        return c;
	}

	public void deleteCategory(int catid) throws SQLException {
        String query = "DELETE FROM categories WHERE category_id = ?;";
        try (Connection connection = DbConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
               statement.setInt(1, catid);
               statement.executeUpdate();
           }
		
	}

	
	
		
}
