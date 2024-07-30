package controller;

import java.sql.SQLException;
import java.util.List;

import dao.CategoriesDAO;
import dao.WorkoutsDAO;
import model.Categories;
import model.Workouts;

public class FitnessTrackingController {
	private final CategoriesDAO cda;
	private final WorkoutsDAO wda;
	
	
	public FitnessTrackingController() {
		this.cda = new CategoriesDAO();
		this.wda = new WorkoutsDAO();
	}

	public void addCategory(Categories c) throws SQLException {
		// TODO Auto-generated method stub
		cda.addCategory(c);
	}

	public void updateCategory(Categories categories)throws SQLException {
		// TODO Auto-generated method stub
		cda.updateCategory(categories);
	}

	public List<Categories> getAllCategories()throws SQLException {
		
		return cda.getAllCategories();
	}

	public void deleteCategory(int catid)throws SQLException {
		cda.deleteCategory (catid);		
	}

	public void addWorkout(Workouts workouts)throws SQLException {
		wda.addWorkout(workouts);
	}

	public void updateWorkout(Workouts workouts)throws SQLException {
		wda.updateWorkout(workouts);
	}

	public List<Workouts> getAllWorkouts()throws SQLException {
		
		return wda.getAllWorkouts();
	}

	public void deleteWorkout(int dwid)throws SQLException {
		wda.deleteWorkout(dwid);
		
	}

	public List<Workouts> getWorkoutbyCategories()throws SQLException {
		return wda.getWorkoutbyCategories();
	}

	

}
