package unl.cse.student;

/*
 * Student.java
 * Carden Reichert
 * 
 * A class that represents a student, with appropriate fields and methods.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Student {
    
    /* Input pattern constant */
    private final String PATTERN = "MM/dd/yyyy";
    
    /* Class variables */
    private String firstName;   // Student first name
    private String lastName;    // Student last name
    private Integer nuid;           // Student ID
    private Date birthDate;             // Student date of birth
    
    /* Prepare date functionality */
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat( PATTERN );
    
    /**
     * Default constructor
     */
    public Student(){
        
        firstName = null;
        lastName = null;
        nuid = null;
        birthDate = null;
        
    } // End default constructor
    
    /**
     * Constructor that requires users to provide all fields.
     * @param fName
     * @param lName
     * @param id
     * @param dob
     */
    public Student( String fName, String lName, Integer id, String dob ){
        
        firstName = fName;
        lastName = lName;
        nuid = id;
        
        birthDate = parseDateString( dob );
        calendar.setTime( birthDate );
        
    } // End class constructor
    
    
    /**
     * Parses String input representing a specific date into an instance of 
     * class Date.
     * @param dateOfBirth String the student's date of birth.
     * @return Date object date, the student's date of birth.
     */
    private Date parseDateString( String dateOfBirth ){
        
        Date date = new Date();
        try{
            
            date = dateFormat.parse( dateOfBirth );
            
        }catch( ParseException parseErr ){
            parseErr.printStackTrace();
            
        } // End try-catch block
        
        return date;
        
    } // End parseDateString()
    
    
    /* Accessor and mutator methods */
    public String getFirstName(){
        
        return firstName;
    }
    
    
    public void setFirstName( String first ){
        
        firstName = first;
    }
    
    
    public String getLastName(){
        
        return lastName;
    }
    
    
    public void setLastName( String last ){
        
        lastName = last;
    }
    
    
    public int getNUID( ){
        
        return nuid;
    }
    
    
    public void setNUID( int id ){
        
        nuid = id;
    }
    
    public int getAgeInYears() {
        Calendar now = Calendar.getInstance();
        return (int) ((now.getTimeInMillis() - this.calendar.getTimeInMillis()) / (1000 * 60 *60 * 24 * 365.25));
    }
    
    @Override
    public String toString(){
        /* Prepare to properly format Date output for display */
        SimpleDateFormat display = new SimpleDateFormat( "EEE, MMM d yyyy" );
        
        return String.format( "%s %s %d %s (%d years old)", firstName, lastName, nuid, 
                                                    display.format(birthDate), this.getAgeInYears() );
                
    } 

    
}
