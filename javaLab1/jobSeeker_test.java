/**
 * JobSeeker
 * Attributes :
•         Id ( DataType : String)
•         Name ( DataType : String)
•         Gender ( DataType : String)
•         Contact ( DataType : Integer)
•         E-mail ( DataType : String)
•         Address ( DataType : String)
•         DOB ( DataType : String)
•         Skills ( DataType : String)
 •         Experience ( DataType : Integer)
 Methods :
•Login()
    This method is used to initiate the login process for Job seeker.
•View_Job()
    This method is used to see available jobs provided by a job provider.
•Apply_job()
     This method is used to apply for available jobs provided by a     job provider.
•View_Confirmation()
    This method is used to view confirmation for the applied jobs.
•Add_Resume()
    This method is used to add a resume in their profile

 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
class JobSeeker{
    //scanner class object
    Scanner scan = new Scanner(System.in);
    // class attributes
    String seekerId = "";
    String seekerPassword = "";
    String seekerName = "";
    String SeekerGender = "";
    String SeekerContact  = "";
    String seekerEmail = "";
    String seekerAdd = "";
    String seekerDOB = "";
    //Creating a List  
    List<String> seekerSkills = new ArrayList<String>();
    int seekerExperience = 0;
    
    //default constructor
    JobSeeker(){
        seekerId = "NoID";
        seekerPassword = "password";
        seekerName = "SeekerName";
        SeekerGender = "gender";
        SeekerContact  = "0123456789";
        seekerEmail = "abcd@mail.com";
        seekerAdd = "address";
        seekerDOB = "00/00/0000";
        //seekerSkills[0] = "No_Skill";
        seekerExperience = 0; 
    }
    //for getting password
    public String getPassword(){
        String password = "";
        while(true){
            System.out.println("Enter JobSeeker Password : ");
            password = scan.nextLine();
            //reenter password
            System.out.println("Enter JobSeeker Password again : ");
            String tempPassword = scan.nextLine();
            if(password.equals(tempPassword)){// if both password are same then return
                return password;
            }
            else{
                System.out.println("!!! Both password are not same !!!");
                System.out.println("Please try again...");
                continue;
            }
        }    
    }
    // to get jobseeker details
    public void getSeekerDetails(){
       System.out.println("\n\nPlease enter the details of JobSeeker...........");
       
       System.out.println("Enter JobSeeker Id : ");
       seekerId = scan.nextLine();
       seekerPassword = getPassword();
       System.out.println("Enter SeekerName : ");
       seekerName =  scan.nextLine();
       System.out.println("Enter JobSeeker gender : ");
       SeekerGender = scan.nextLine();
       System.out.println("Enter JobSeeker ContactNo : ");
       SeekerContact  = scan.nextLine();
       System.out.println("Enter JobSeeker Email : ");
       seekerEmail = scan.nextLine();
       System.out.println("Enter JobSeeker address : ");
       seekerAdd  = scan.nextLine();
       System.out.println("Enter JobSeeker DOB : ");
       seekerDOB = scan.nextLine();
       //to get more than one skills
       while(true){
           System.out.println("Enter JobSeeker skill : ");
           seekerSkills.add(scan.nextLine());
           
           System.out.println("Do you want to enter more skill(Y/N) : ");
           if( scan.nextLine().toUpperCase().equals("Y")){
               continue;
           }
           else{
               break;
           }
       }
       
       System.out.println("Enter JobSeeker exprience in year : ");
       seekerExperience = scan.nextInt();
    }
    
    //to print jobseeker's details
    public void printSeekerDetails(){
       
       System.out.println("\n\n..........Details of JobSeeker..........");
       
       System.out.println("JobSeeker Id : " +seekerId);
       System.out.println("JobSeeker Password : " +seekerPassword);
       System.out.println("JobSeeker SeekerName : " +seekerName);
       System.out.println("JobSeeker gender : " +SeekerGender);
       System.out.println("JobSeeker ContactNo : " +SeekerContact);
       System.out.println("JobSeeker Email : " +seekerEmail);
       System.out.println("JobSeeker address : " +seekerAdd);
       System.out.println("JobSeeker DOB : " +seekerDOB);
       
       //to print skills
       System.out.println("JobSeeker skills : ");
       if(seekerSkills.isEmpty()){//if skillList is empty
           System.out.println("No Skills");
       }
       else{
            for(String skill : seekerSkills){
                System.out.println(skill);
            }
        }
       System.out.println("JobSeeker exprience in year : " +seekerExperience);
    }


}

public class jobSeeker_test {
    public static void main(String[] args){
        JobSeeker jobSeeker = new JobSeeker();//creating jobseker object
        //printing with default value
        jobSeeker.printSeekerDetails();
        
        jobSeeker.getSeekerDetails();
        //printing with entered value
        jobSeeker.printSeekerDetails();
        
    }
}
