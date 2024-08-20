package org.example;
import java.time.LocalDate;
import java.util.Scanner;
public class App
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        UserFunctionalities userFunc = new UserFunctionalities();
        categoryFunctionalities categoryFunc = new categoryFunctionalities();
        boolean running = true;
        while(running)
        {
            System.out.println("\n=== Task Management System ===");
            System.out.println("Do you have an account?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Select an option: ");
            int accountOption = scanner.nextInt();
            if(accountOption==1)
            {
                System.out.println("\n=== Log In ===");
                //userFuncs.viewAllUsers();
                System.out.print("Enter your User ID: ");
                int userId = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                boolean userMenuRunning = true;
                while(userMenuRunning)
                {
                    System.out.println("\n=== User Menu ===");
                    System.out.println("1. Create Task");
                    System.out.println("2. Update status");
                    System.out.println("3. Remove Task from User");
                    System.out.println("4. View All Users");
                    System.out.println("5. Log Out");
                    System.out.print("Select an option: ");
                    int userOption = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if(userOption == 1) {
                        System.out.println("Create Task");
                        System.out.print("Enter Task id: ");
                        int id = scanner.nextInt();
                        System.out.print("Enter Task Description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter Start Date (YYYY-MM-DD): ");
                        LocalDate fromDate = LocalDate.parse(scanner.nextLine());
                        System.out.print("Enter End Date (YYYY-MM-DD): ");
                        LocalDate toDate = LocalDate.parse(scanner.nextLine());
                        System.out.print("Enter Status (PENDING, IN_PROGRESS, COMPLETED): ");
                        String statusInput = scanner.nextLine();
                        Status status = Status.valueOf(statusInput.toUpperCase());
                        System.out.print("Enter Category id: ");
                        int categoryid = scanner.nextInt();
                        System.out.print("Enter category name : ");
                        String categoryname = scanner.nextLine();
                        Task task = new Task(id , description , fromDate , toDate ,status , categoryid , userId , categoryname );
                        userFunc.CreateTask(task);
                    }
                    else if(userOption==2)
                    {
                        System.out.println("Update status");
                        System.out.print("Enter Task id ");
                        int task_id = scanner.nextInt();
                        System.out.print("Enter Status (PENDING, IN_PROGRESS, COMPLETED): ");
                        String statusInput = scanner.nextLine();
                        Status status = Status.valueOf(statusInput.toUpperCase());
                        userFunc.UpdateStatus(task_id , userId , status);
                    }
                    else if(userOption==3)
                    {
                        System.out.println("Remove Task from User");
                        System.out.print("Enter Task id ");
                        int task_id = scanner.nextInt();
                        userFunc.DelteTask(task_id , userId);
                    }
                    else if(userOption == 4)
                    {
                        System.out.println("View All Users");
                        userFunc.ViewAllUsers();
                    }
                    else if(userOption == 5)
                    {
                        userMenuRunning = false;
                    }
                    else {
                        System.out.println("Invalid option. Please try again.");
                    }
                }
            }
            else if (accountOption==2) {
                System.out.print("Enter First Name: ");
                int id = scanner.nextInt();
                String firstName = scanner.nextLine();
                System.out.print("Enter Last Name: ");
                String lastName = scanner.nextLine();
                System.out.print("Enter Age: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                UserProfile userProfile = new UserProfile(id, firstName, lastName, age);
                userFunc.AddUser(userProfile);
            }
            else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
