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
     * 
     * 
     * 
     */
    public Paper(String _customerName, String _customerCell, String _customerEmail, String _projectNum, String _projectColor){
        customerName=_customerName;
        customerCell=_customerCell;
        customerEmail=_customerEmail;
        projectNum=_projectNum;
        projectColor=_projectColor;
    }

    /**
     * 
     * 
     * 
     */
    public String getName(){
        return customerName;

    }

    /**
     * 
     * 
     * 
     */
    public String getCell(){
        return customerCell;

    }

    /**
     * 
     * 
     * 
     */
    public String getEmail(){
        return customerEmail;

    }

    /**
     * 
     * 
     * 
     */
    public String getNum(){
        return projectNum;

    }

    /**
     * 
     * 
     * 
     */
    public String getColor(){
        return projectColor;

    }

    /**
     * 
     * 
     * 
     */
    public String toString(){
        return customerName + "\t\t" + customerCell + "\t\t" + customerEmail+ "\t\t" + projectNum + "\t\t" + projectColor;
        //String.format("%-10s %d %10s %5s", customerName, customerCell, customerEmail);
        
        //customerName + "\t\t" + customerCell + "\t\t" + customerEmail+ "\t\t" + projectNum + "\t\t" + projectColor;

    }
}
 