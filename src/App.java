import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String[] courses = new String[10]; //These array are used to save the user inputs
        String[] coursecodes = new String[10];
        int i = 0;
        float payment = 0; 
        int units = 0;

        System.out.println("                    ENROLLMENT SYSTEM");

        System.out.println("*~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*");
        System.out.print("What is your name? "); //Inputting for the StudentName variable
        String StudentName = input.nextLine();

        while (true){ //Inputting for the amount units wanted by the user
            System.out.print("How many units do you want to have?  ");
            units = input.nextInt();
            input.nextLine();

            if (units < 0 || units > 10){ //If input is less than 0 or over 10 it will ask the user to input another value
                System.out.println("Invalid Input. Please Try Again");
                continue;
            } else {
                break;
            }
        }
        System.out.println("*~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*");

        while (i < units) { //Adding courses according to the number of units inputted
            System.out.print("Please add a course:");
            courses[i] = input.nextLine();
            System.out.print("Please add the course code:");
            coursecodes[i] = input.nextLine();

            System.out.println("Added Course: "+ coursecodes[i]+" - "+courses[i]+"\n"); 

            i+=1;
        }

        float Fee = i*1000; //Calculation for the Enrollment Fee

        System.out.println("*~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*");
        System.out.println("Welcome "+StudentName+"!");// Displaying the Student Name and the Enrollment Fee of the user
        System.out.println("Enrollment Fee: P"+Fee);
        System.out.println("*~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*");

        while (true){ //Asking for payment and checking if payment is valid
            System.out.print("How much will you be paying? P");
            payment = input.nextFloat();
            input.nextLine();

            if (payment < 0) { //Invalidating Negative Values
                System.out.println("Invalid input. Please try again.");
                continue;
            } else if (payment < Fee){ //Payment is lower than fee
                System.out.println("Partial Payment: P"+ payment);
                System.out.println("Original Fee: P"+ Fee);
                System.out.println("New Fee: P"+ (Fee-payment));
                break;
            } else if (payment == Fee){ //Exact Payment
                System.out.println("Fully Paid");
                break;
            } else if (payment > Fee){ //Payment is higher than fee
                System.out.println("Over Charged: P"+ payment);
                System.out.println("Original Fee: P"+ Fee);
                System.out.println("Payment Returns: P"+ (payment-Fee));
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
                continue;
            }
        }
        while (true){
            System.out.println("*~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*");
            System.out.print("Would you like to see your enrollment statues? (Y/N): "); //Just showing all the user inputs (Optional)
            String choice1 = input.nextLine();
            System.out.println("*~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*");

                if (choice1.equalsIgnoreCase("y")){
                    System.out.println("Enrollee Name: "+StudentName);

                    System.out.println("\nEnrolled Courses:");
                    for (int j=0; j<i; j++){
                        System.out.println("Course: "+coursecodes[j]+" - "+courses[j]);
                    }

                    System.out.print("\nPayment Status: "); 
                    if (payment < Fee){
                        System.out.println("Partial Payment: P"+ payment);
                        System.out.println("Original Fee: P"+ Fee);
                        System.out.println("New Fee: P"+ (Fee-payment));
                    } else if (payment == Fee){
                        System.out.println("Fully Paid");
                    } else if (payment > Fee){
                        System.out.println("Over Paid: P"+ payment);
                        System.out.println("Original Fee: P"+ Fee);
                        System.out.println("Payment Returns: P"+ (payment-Fee));
                    }
                    break;
                    
                } else if (choice1.equalsIgnoreCase("n")) { //Does not need code and skips to the end
                    break;
                }else {
                    System.out.println("Invalid Input. Please Try Again."); //If invalid it starts the question over again
                    continue;
                }
        }

        System.out.println("*~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*~~~~~~*");
        input.close();
    }
}
