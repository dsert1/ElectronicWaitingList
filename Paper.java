import java.io.Serializable;
import java.text.StringCharacterIterator;
import java.util.*;
import java.io.*;
/**
 * Paper.java
 * Represents an information slip that holds the info of the project.
 * @author Deniz Sert
 * @version January 3, 2018
 */
public class Paper implements Serializable{

    private String customerName;
    private String customerCell;
    private String customerEmail;
    private String projectNum;
    private String projectColor;

    /**
     * Initializes a Paper object with a name, cell phone, email, project number, and project color
     * @param _customerName the name of the customer
     * @param _customerCell the cell phone number of the customer
     * @param _customerEmail the email of the customer
     * @param _projectNum
     * @param _projectColor
     */
    public Paper(String _customerName, String _customerCell, String _customerEmail, String _projectNum, String _projectColor){
        customerName=_customerName;
        customerCell=_customerCell;
        customerEmail=_customerEmail;
        projectNum=_projectNum;
        projectColor=_projectColor;
    }

    /**
     * @return returns name
     */
    public String getName(){
        return customerName;

    }

    /**
     * @return returns cell phone number
     */
    public String getCell(){
        return customerCell;

    }

    /**
     * @return returns customer email
     */
    public String getEmail(){
        return customerEmail;

    }

    /**
     * @return returns project number
     */
    public String getNum(){
        return projectNum;

    }

    /**
     * @return returns project color
     */
    public String getColor(){
        return projectColor;

    }

    /**
     * @return returns String representation of Paper object
     */
    public String toString(){
        return customerName + "\t\t" + customerCell + "\t\t" + customerEmail+ "\t\t" + projectNum + "\t\t" + projectColor;
        //String.format("%-10s %d %10s %5s", customerName, customerCell, customerEmail);
        
        //customerName + "\t\t" + customerCell + "\t\t" + customerEmail+ "\t\t" + projectNum + "\t\t" + projectColor;

    }
}
 
