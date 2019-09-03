import java.io.Serializable;
import java.text.StringCharacterIterator;
import java.util.*;
import java.io.*;
/**
 * Stack.java
 * This class represents a stack of filled information cards.
 * @author Deniz Sert
 * @version January 3, 2018
 */
public class Stack implements Serializable{
    public static void main (String[] args) throws Exception {  
        System.out.println("\f");
        File f = new File("Stack.txt");
        ArrayList<Paper> stack = new ArrayList<Paper>();

        /*
        File f1 = new File("CompletedStack.txt");
        ArrayList<Paper> completedStack = new ArrayList<Paper>();
        */

        //for stack.txt
        FileInputStream fis = new FileInputStream(f); 
        ObjectInputStream ois = new ObjectInputStream(fis);
        stack=(ArrayList<Paper>)ois.readObject();

        /*
        //for CompletedStack.txt
        FileInputStream fis1 = new FileInputStream(f1); 
        ObjectInputStream ois1 = new ObjectInputStream(fis1);
        completedStack=(ArrayList<Paper>)ois1.readObject();
        */

        System.out.println("Welcome to the 3D Printing Waiting List!");
        System.out.println("****************************************\n\n\n");

        Scanner input = new Scanner(System.in);
        String com="";
        boolean decision = false, running=true, correctInfo=false, valid=false, valid1=false, valid2=false, valid3=false;
        String tempName="";
        String tempCell="";
        String tempEmail="";
        String tempNum="";
        String tempColor="";

        while(running){
            System.out.println("Enter \"end\" to end program when prompted a question\nEnter \"c\" to see the completed list at any time");

            //prints out the waiting list if there are people waiting
            if(stack.size()==0)
                System.out.println("There is currently nobody in the waiting list. \n");
            else{
                System.out.println("Here is a list of projects currently in the waiting list");
                System.out.println("\nWaiting list");
                System.out.println("---------------------");
                System.out.println("Customer Name\t\tCustomer Cell Number\tCustomer Email\t\t\tProject Number\tProject Color\n");
                for(int i=0;i<stack.size();i++){
                    System.out.println(stack.get(i));
                }
            }
            //prompts user to add to the waiting list
            System.out.print("\nWould you like to add your project to the waiting list? (y/n): ");
            com=input.nextLine();
            valid=false;
            while(!valid){
                if (!com.equalsIgnoreCase("end")&&!com.equalsIgnoreCase("n")&&!com.equalsIgnoreCase("no")&&!com.equalsIgnoreCase("nope")&&!com.equalsIgnoreCase("y")&&!com.equalsIgnoreCase("yes")){
                    System.out.println("Sorry, that is not a valid answer, please try again.");
                    com=input.nextLine();
                    valid=false;
                }
                else if(com.equalsIgnoreCase("end")){
                    valid=true;
                    running=false;
                }
                /*
                else if(com.equalsIgnoreCase("c")){
                    if(completedStack.size()==0)
                        System.out.println("There is currently nobody in the completed list. \n");
                    else{
                        System.out.println("Here is a list of finished projects");
                        System.out.println("\nFinished Projects");
                        System.out.println("---------------------");
                        System.out.println("Customer Name\t\tCustomer Cell Number\tCustomer Email\t\t\tProject Number\tProject Color\n");
                        for(int i=0;i<completedStack.size();i++){
                            System.out.println(completedStack.get(i));
                        }
                    }   
                }
                */
                

                else if (com.equalsIgnoreCase("n") || com.equalsIgnoreCase("no") || com.equalsIgnoreCase("nope")){
                    valid=true;
                    System.out.println("Okay, the option will remain here for future use.");

                    System.out.println("Volunteer, would you like to remove the first project in line? (y/n)");
                    com=input.nextLine();
                    System.out.println("Reminder, this question is for the 3D printer operator ONLY.");

                    if(com.equalsIgnoreCase("end"))
                        running=false;

                    else if(com.equalsIgnoreCase("n") || com.equalsIgnoreCase("no") || com.equalsIgnoreCase("nope")){
                        System.out.println("Come back to this question and answer yes when you're ready.");
                    }
                    else {
                        System.out.println("Are you sure you want to remove the first project in the waiting list?");       
                        com=input.nextLine();
                        if(com.equalsIgnoreCase("end"))
                            running=false;
                        else if (com.equalsIgnoreCase("n") || com.equalsIgnoreCase("no") || com.equalsIgnoreCase("nope")){
                            System.out.println("Okay, that's fine. No changes have been made.");
                        }
                        else {
                            //completedStack.add(stack.get(0));
                            stack.remove(0);
                            System.out.println("First in line removed.");
                        }
                    }
                }
                else{
                    while(!correctInfo){
                        System.out.print("What is your name?: ");
                        tempName=input.nextLine();
                        System.out.print("\n");
                        System.out.print("What is your cell phone number?: ");
                        tempCell=input.nextLine();
                        System.out.print("\n");
                        System.out.print("What is your email?: ");
                        tempEmail=input.nextLine();
                        System.out.print("\n");
                        System.out.print("What is the project number? (get this from the last 6 digits of the URL on the project you'd like to print: ");
                        tempNum=input.nextLine();
                        System.out.print("\n");
                        System.out.print("What color would you like your project to be?: ");
                        tempColor=input.nextLine();
                        System.out.print("\n");

                        System.out.println("Please confirm your information was entered correctly (y/n)");
                        com=input.nextLine();
                        while(!valid2){
                            if (!com.equalsIgnoreCase("end")&&!com.equalsIgnoreCase("n")&&!com.equalsIgnoreCase("no")&&!com.equalsIgnoreCase("y")&&!com.equalsIgnoreCase("yes")){
                                System.out.println("Sorry, that is not a valid answer, please try again.");
                                com=input.nextLine();
                                valid2=false;
                            }
                            else if (com.equalsIgnoreCase("y") || com.equalsIgnoreCase("yes") || com.equalsIgnoreCase("correct") || com.equalsIgnoreCase("confirm") || com.equalsIgnoreCase("confirmed")){
                                valid2=true;
                                correctInfo=true;
                                Paper paper = new Paper(tempName, tempCell, tempEmail, tempNum, tempColor);
                                stack.add(paper);
                                System.out.println("Thank you, your project has been added to the waiting list.\n\n");                 
                            }
                            else{
                                valid=true;
                                System.out.println("Okay, let's try again\n");
                            }
                        }

                    }

                    //prompts volunteer to remove the first in line
                    System.out.println("Volunteer, would you like to remove the first in line? (y/n)");
                    valid1=false;

                    com=input.nextLine();
                    System.out.println("Reminder, this question is for the 3D printer operator ONLY.");
                    while(!valid1){
                        if (!com.equalsIgnoreCase("end")&&!com.equalsIgnoreCase("n")&&!com.equalsIgnoreCase("no")&&!com.equalsIgnoreCase("y")&&!com.equalsIgnoreCase("yes")){
                            System.out.println("Sorry, that is not a valid answer, please try again.");
                            com=input.nextLine();
                            valid1=false;
                        }
                        else if(com.equalsIgnoreCase("end")){
                            valid=true;
                            running=false;
                        }
                        /*
                        else if(com.equalsIgnoreCase("c")){
                            if(completedStack.size()==0)
                                System.out.println("There is currently nobody in the completed list. \n");
                            else{
                                System.out.println("Here is a list of finished projects");
                                System.out.println("\nFinished Projects");
                                System.out.println("---------------------");
                                System.out.println("Customer Name\t\tCustomer Cell Number\tCustomer Email\t\t\tProject Number\tProject Color\n");
                                for(int i=0;i<completedStack.size();i++){
                                    System.out.println(completedStack.get(i));
                                }
                            }   
                        }
                        */

                        else if(com.equalsIgnoreCase("n") || com.equalsIgnoreCase("no") || com.equalsIgnoreCase("nope")){
                            valid1=true;
                            System.out.println("Come back to this question and answer yes when you're ready.");
                        }
                        else {
                            valid1=true;

                            System.out.println("Are you sure you want to delete the first person in line? You won't be able to get the information" 
                                + " back if you confirm");
                            com=input.nextLine();
                            valid3=false;
                            while(!valid3){
                                if (!com.equalsIgnoreCase("end")&&!com.equalsIgnoreCase("n")&&!com.equalsIgnoreCase("no")&&!com.equalsIgnoreCase("y")&&!com.equalsIgnoreCase("yes")){
                                    System.out.println("Sorry, that is not a valid answer, please try again.");
                                    com=input.nextLine();
                                    valid3=false;
                                }
                                else if(com.equalsIgnoreCase("end")){
                                    valid3=true;
                                    running=false;
                                }
                                else if (com.equalsIgnoreCase("n") || com.equalsIgnoreCase("no") || com.equalsIgnoreCase("nope")){
                                    valid3=true;
                                    System.out.println("Okay, that's fine. No changes have been made.");
                                }
                                else {
                                    valid3=true;
                                    stack.remove(0);
                                    System.out.println("First in line removed.");
                                }
                            }
                        }
                    }
                }
            }

            correctInfo=false;
        }
        System.out.println("\n\nOkay, have a nice day!");

        //saves the waiting list
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(stack);
        
        /*
        //saves the completed stack
        FileOutputStream fos1 = new FileOutputStream(f1);
        ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
        oos.writeObject(completedStack);
        */

        System.out.println("\n\nThe waiting list has been saved to Stack.txt in memory");
        //System.out.println("\n\nThe completed stack has been saved to CompletedStack.txt in memory");

    }
}

