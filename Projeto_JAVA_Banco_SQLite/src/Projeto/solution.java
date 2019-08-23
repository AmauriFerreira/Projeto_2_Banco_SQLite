package Projeto;



import java.io.File;
import java.io.IOException;
import java.io.File;
import java.io.IOException;
import Projeto.Upload;



import java.io.*; 

public class solution { 
    public static void main(String args[]) 
    { 
  
        // try-catch block to handle exceptions 
        try { 
  
            // Create a file object 
            File f = new File("C:/Users/Amauri/Desktop.pdf"); 
  
            // Get the Name of the given file f 
            String Name = f.getName();
            
            
  
            // Display the file Name of the file object 
            System.out.println("File Name : " + Name); 
        } 
        catch (Exception e) { 
            System.err.println(e.getMessage()); 
        } 
    } 
}