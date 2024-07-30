import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import controller.FitnessTrackingController;
import model.Categories;
import model.Workouts;



public class Main {
	
	private static Scanner sc;

	public static void main(String[] args) throws SQLException {
		
		FitnessTrackingController ftc = new FitnessTrackingController();
		
		System.out.println("****************************");
		System.out.println("Fitness Tracker");
		System.out.println("Choose the operation");
		System.out.println("*********************");
		System.out.println("Category Details");
		System.out.println("1.Add Category");
		System.out.println("2.Update Category");
		System.out.println("3.List Category");
		System.out.println("4.Delete Category");
		System.out.println("*********************");
		System.out.println("Workout Details");
		System.out.println("5.Add Wrokout Details");
		System.out.println("6.Update workout Details");
		System.out.println("7.List workout Details");
		System.out.println("8.Delete workout Details");
		System.out.println("9.List workout Details with Category Name");
		System.out.println(" ");
		System.out.println("Choose your option");
		System.out.println("****************************");
		
		sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
		case 1: 
			System.out.println("1.Add Category");
			sc.nextLine();
			System.out.print("Enter category name: ");
            String name =sc.nextLine();
            ftc.addCategory(new Categories(0,name));
            System.out.println("Category added.");
		break;
		
		case 2:
			System.out.println("2.Update Category");
			sc.nextLine();
			System.out.print("Enter category ID: ");
			int id =sc.nextInt();
			sc.nextLine();
			System.out.print("Enter new category name: ");
			String uname =sc.nextLine();
            ftc.updateCategory(new Categories(id,uname));
            System.out.println("Category updated.");
        break;
		
		case 3:
			System.out.println("3.List Category");
			List<Categories>c =ftc.getAllCategories();
			for(Categories cat: c) {
                System.out.println("ID: " + cat.getCategoryId() + ", Name: " + cat.getCategoryName());

			}
			break;
		
		case 4:
			System.out.println("4.Delete Category");
			System.out.print("Enter category ID: ");
			int catid =sc.nextInt();
			ftc.deleteCategory(catid);
            System.out.println("Category deleted.");
            break;
            
		case 5:
			System.out.println("5.Add Wrokout Details");
			sc.nextLine();
			System.out.print("Enter Workout name: ");
            String wname =sc.nextLine();
            System.out.print("Enter Category id: ");
            int cid =sc.nextInt();
            sc.nextLine();
//            System.out.print("Enter Workout Start time (yyyy-MM-dd HH:mm:ss): ");
//            String startTimeInput = sc.nextLine();
//            LocalDateTime startTime = LocalDateTime.parse(startTimeInput, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//            
//            String startTimeStr = sc.nextLine();
//            LocalTime startTime = LocalTime.parse(startTimeStr);
//
//            System.out.print("Enter end time (HH:mm:ss): ");
//            String endTimeStr = sc.nextLine();
//            LocalTime endTime = LocalTime.parse(endTimeStr);
//
//            Duration duration = Duration.between(startTime, endTime);
//            System.out.println("Duration: " + duration);
            System.out.println("Enter the Duration in Minutes");
            
            int duration = sc.nextInt();
                       
           	int calories = getcalories(cid);
//           	Date d = (Date) new java.util.Date();
            
           	ftc.addWorkout(new Workouts(0, wname, cid, duration, calories, new Date()));
            System.out.println("Workout details added.");

            break;
            
		case 6:
			System.out.println("6.Update workout Details");
			sc.nextLine();
			System.out.print("Enter Workout ID: ");
			int wid =sc.nextInt();
			sc.nextLine();
			System.out.print("Enter new Workout name: ");
			String uwname =sc.nextLine();
			System.out.println("Enter new Category ID:");
			int ucid = sc.nextInt();
			System.out.println("Enter the new Duration in Minutes");
            int uduration = sc.nextInt();
            int ucalories = getcalories(ucid);
            ftc.updateWorkout(new Workouts(wid,uwname,ucid,uduration, ucalories,null));
            System.out.println("Workout updated.");
            break;
            
		case 7:
			System.out.println("7.List workout Details");
			List<Workouts>w =ftc.getAllWorkouts();
			for(Workouts wrk: w) {
                System.out.println("ID: " + wrk.getWorkoutId() + ", Name: " + wrk.getWorkoutName()+", Category ID: "+ wrk.getCategoryId()+",Calories Burned: "+wrk.getCaloriesBurned()
                		+",Workout Duration: "+wrk.getDuration()+", Date of Workout: "+wrk.getWorkoutDate());

			}
			break;
		case 8:
			System.out.println("8.Delete workout Details");
			System.out.println("Enter the Workout ID to be deleted: ");
			int delete_id = sc.nextInt();
			ftc.deleteWorkout(delete_id);
			System.out.println("Workout Deleted");
			break;
		case 9:
			System.out.println("List workout with Category Name");
			List<Workouts>lw =ftc.getWorkoutbyCategories();
			for(Workouts works: lw) {
                System.out.println("Workout_ID: " + works.getWorkoutId() + ", Name: " + works.getWorkoutName()+", Category_ID: "+works.getCategoryId());

			}
			break;

		
			}
		
		}
	public static int getcalories(int categoryId) {
    	switch (categoryId) {
        case 1:
            return 100;
        case 2:
            return 500;
        case 3:
            return 300;
        case 4:
            return 200;
        case 5:
            return 150;
            
        default:
            return 10; 
    }
}
	

		
}

