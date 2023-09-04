package unl.soc;

import java.time.LocalDate;

public class StudentDemo {
    
    public static void main( String[] args ){
        
        /* Instantiate an object of type Student */
    	LocalDate birthDate = LocalDate.of(1936, 8, 17);
        Student aHusker = new Student( "Margaret", "Hamilton", 12345678, birthDate );
        System.out.println(aHusker);
        
        /* Instantiate another student here, and print the result */
        
    } 
    
} 
