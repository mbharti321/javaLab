
package oct_14_javabeans;

import java.util.Scanner;
class Student implements java.io.Serializable 
{ 
private int id; 
private String name; 
private int sem; 
private String dept; 
Student(){
    System.out.println("Enter student Details ");
}
 
public void setId(int id) 
    { 
        this.id = id; 
    } 
public int getId() 
    { 
        return id; 
    } 
public void setName(String name) 
    { 
        this.name = name; 
    } 
public String getName() 
    { 
        return name; 
    } 
public void setSem(int sem) 
    { 
        this.sem = sem; 
    } 
public int getSem() 
    { 
        return sem; 
    } 
public void setDept(String dept) 
    { 
        this.dept = dept; 
    } 
public String getDept() 
    { 
        return dept; 
    } 

}
public class Bean {
    public static void main(String args[]) 
    { 
        Student s = new Student(); // object is created 
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter the ID :");
        int id= scan.nextInt();
        System.out.println("Enter the name :");
        String name = scan.next();
        System.out.println("Enter the Semester :");
        int sem = scan.nextInt();
        System.out.println("Enter the Department :");
        String dept = scan.next();
        
       
        s.setId(id); // setting value to the object 
        s.setName(name); // setting value to the object 
        s.setSem(sem); // setting value to the object 
        s.setDept(dept); // setting value to the object
        
        System.out.println("____________________________");
        System.out.println("ID : "+s.getId());
        System.out.println("Name : "+s.getName()); 
        System.out.println("Semester : "+s.getSem());
        System.out.println("Department : "+s.getDept());
        System.out.println("____________________________");
        
    } 
   
    
}
