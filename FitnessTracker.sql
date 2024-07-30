create database FitnessTracker;
use FitnessTracker;
create table categories(category_id int auto_increment not null primary key, 
category_name varchar(50) not null);
create table workouts (workout_id int auto_increment not null primary key, workout_name varchar(50),
 category_id int , duration time, calories_burned int, workout_date datetime,
 foreign key (category_id) references categories(category_id));
 

 -- Inserting sample categories
INSERT INTO categories (category_name) VALUES
    ('Cardio'),
    ('Strength'),
    ('Yoga');
-- Inserting sample workouts
INSERT INTO workouts (workout_name, category_id, duration, calories_burned, workout_date) VALUES
    ('Running', 1, '30:00', 300, '2024-07-28 08:00:00'),
    ('Weightlifting', 2, '45:00', 200, '2024-07-28 10:30:00'),
    ('Yoga Flow', 3, '60:00', 150, '2024-07-28 17:00:00');
    
    select * from categories;
    
     select * from workouts;
-- select * from workouts where category_id =4;
update workouts set duration = "15:00:00" where workout_id = 3;
SELECT b.*,c.category_name FROM workouts b JOIN categories c ON b.category_id = c.category_id;