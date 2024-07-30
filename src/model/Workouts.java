package model;

import java.util.Date;

public class Workouts {
	private int workoutId;
	private String workoutName;
	private int	categoryId;
	private int duration;
	private int caloriesBurned;
	private Date workoutDate;
	public Workouts() {
		super();
	}
	public Workouts(int workoutId, String workoutName, int categoryId, int durations, int caloriesBurned,
			Date date) {
		super();
		this.workoutId = workoutId;
		this.workoutName = workoutName;
		this.categoryId = categoryId;
		this.duration = durations;
		this.caloriesBurned = caloriesBurned;
		this.workoutDate = date;
	}
	public int getWorkoutId() {
		return workoutId;
	}
	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
	}
	public String getWorkoutName() {
		return workoutName;
	}
	public void setWorkoutName(String workoutName) {
		this.workoutName = workoutName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getCaloriesBurned() {
		return caloriesBurned;
	}
	public void setCaloriesBurned(int caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}
	public Date getWorkoutDate() {
		return workoutDate;
	}
	public void setWorkoutDate(Date workoutDate) {
		this.workoutDate = workoutDate;
	}
	
	
	
}
