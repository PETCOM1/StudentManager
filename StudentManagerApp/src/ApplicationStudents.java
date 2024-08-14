
import java.util.ArrayList;
import za.ac.tut.entities.Student;
import java.util.Scanner;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Munzhedzi Munyadziwa Petrus
 */
public class ApplicationStudents {
    
    
    
    private static int displayOptions(){
        int option;
        
        Scanner input  = new Scanner(System.in);
        
        System.out.println("Please select one of the following options: " + "\n"+
                "1 - add student" + "\n" +
                "2 - get student" + "\n" +
                "3 - get all students" + "\n" +
                "4 - delete student" + "\n" +
                "5 - update student" + "\n\n" +
                "Your options"
                
                );
        
        option = input.nextInt();
        return option;
    }
    
    private static void displayStudents(ArrayList<Student> students){
        
        String name, data = "";
        int age;
        System.out.println("List of students");
        System.out.println("------------------");
        
        for(Student student : students){
            
            name = student.getName();
            age = student.getAge();
            data = data + "Name: " + name + "\nAge: " + age + "\n\n";
        }
        
        System.out.println(data);
    }
    
    private static Student createStudent(){
        
        String name;
        Integer age;
        Student student;
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("\nEnter your name: ");
        name = input.nextLine();
        
        System.out.println("\nEnter your age: ");
        age = input.nextInt();
        
       student = new Student(name, age);
       
       return student;
    }
    
    public static void main(String[] args) {
      
        //Declare variables
        int option;
        Student student;
        StudentManager sm = new StudentManager();
        
        //display options
        option = displayOptions();
        
        while(option !=5){
            
            switch (option) {
                case 1:
                    student = createStudent();
                    if(sm.add(student)){
                        System.out.println("The student has been added.");
                    }
                    else System.out.println("The student was not added");
                        
                break;
                
                case 2:
                    student = createStudent();
                    if(sm.get(student) == null){
                        System.out.println("The student was not found");
                    }
                    else System.err.println("The student was not found");
                break;
                
                case 3:
                    ArrayList<Student> students = sm.getAll();
                    if(students == null){
                        System.out.println("The list is empty");
                    }
                    else displayStudents(students);
                break;
                
                case 4:
                    student = createStudent();
                    if(sm.delete(student)){
                        System.out.println("The student has been deleted");
                    }
                    
                    else System.err.println("The student was not deleted");
                    
                break;
                case 5:
                    student = createStudent();
                    if(sm.update(student)){
                        System.out.println("The student has been updated");
                    }
                    
                    else
                        System.err.println("The student was not updated");
                break;
                default:
                    System.err.println(option+ "is invalid. Please re-enter.");
            }
            option = displayOptions();
        }
        
        System.out.println("\nGoodBye!!!");
    }
    
    
}
