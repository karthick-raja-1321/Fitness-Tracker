package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import model.Categories;
import model.Workouts;
import utility.DbConnection;

public class WorkoutsDAO {

	public void addWorkout(Workouts work)throws SQLException {
		String query = "INSERT INTO workouts (workout_name,category_id,duration,calories_burned,workout_date) VALUES (?,?,SEC_TO_TIME(?*60),?,?)";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, work.getWorkoutName());
            statement.setInt(2, work.getCategoryId());
            statement.setLong(3, work.getDuration());
            statement.setInt(4, work.getCaloriesBurned());
//            statement.setDate(5, java.sql.Date.valueOf(work.getWorkoutDate()));
            statement.setTimestamp(5, new Timestamp(work.getWorkoutDate().getTime()));
            statement.executeUpdate();
        }	
		
	}

	public void updateWorkout(Workouts work)throws SQLException {
		String query = "UPDATE workouts SET workout_name = ?,category_id=?,duration= SEC_TO_TIME(?*60) WHERE workout_id = ?;";
		try (Connection connection = DbConnection.getConnection();
	             PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setString(1, work.getWorkoutName());
	            statement.setInt(2, work.getCategoryId());
	            statement.setInt(3, work.getCaloriesBurned());
	            statement.setInt(4, work.getWorkoutId());
	            statement.executeUpdate();
		}
		
	}

	public List<Workouts> getAllWorkouts()throws SQLException {
		List<Workouts> wk = new ArrayList<>();
		String query = "SELECT * FROM workouts";
		try (Connection connection = DbConnection.getConnection();
	             Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery(query)) {
	            while (resultSet.next()) {
	                Workouts work = new Workouts();
	                work.setWorkoutId(resultSet.getInt("workout_id"));
	                work.setWorkoutName(resultSet.getString("workout_name"));
	                work.setCategoryId(resultSet.getInt("category_id"));

	                String durations = resultSet.getString("duration");
	                LocalTime localTime = LocalTime.parse(durations);
                    int minutes = localTime.getHour() * 60 + localTime.getMinute();
                    work.setDuration(minutes);
	                work.setCaloriesBurned(resultSet.getInt("calories_burned"));
	                work.setWorkoutDate(resultSet.getDate("workout_date"));
	                wk.add(work);
	            }
	        }
		return wk;
	}

	public void deleteWorkout(int dwid)throws SQLException {
		String query = "DELETE FROM workouts WHERE workout_id = ?;";
		try (Connection connection = DbConnection.getConnection();
                PreparedStatement st = connection.prepareStatement(query)) {
			st.setInt(1, dwid);
			st.executeUpdate();
		} 
		
	}

	public List<Workouts> getWorkoutbyCategories()throws SQLException {
		List<Workouts> w = new ArrayList<>();
//		"SELECT b.*, c.category_name FROM bugs b " +
//        "JOIN categories c ON b.category_id = c.category_id";
        
		String query = "SELECT b.*,c.category_name FROM workouts b JOIN categories c ON b.category_id = c.category_id;";
		try (Connection connection = DbConnection.getConnection();
	             Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery(query)) {
	            while (resultSet.next()) {
	                Workouts work = new Workouts();
	                work.setWorkoutId(resultSet.getInt("workout_id"));
	                work.setWorkoutName(resultSet.getString("workout_name"));
	                work.setWorkoutName(work.getWorkoutName()+"Category Name: "+resultSet.getString("category_name"));
//	                bug.setDescription(bug.getDescription() + " (Category: " + resultSet.getString("category_name") + ")");

	                work.setCategoryId(resultSet.getInt("category_id"));

	                String durations = resultSet.getString("duration");
	                LocalTime localTime = LocalTime.parse(durations);
                    int minutes = localTime.getHour() * 60 + localTime.getMinute();
                    work.setDuration(minutes);
	                work.setCaloriesBurned(resultSet.getInt("calories_burned"));
	                work.setWorkoutDate(resultSet.getDate("workout_date"));
	                w.add(work);
	            }
	        }
	        return w;
	}
	 
}

