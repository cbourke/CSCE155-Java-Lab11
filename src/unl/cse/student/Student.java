package unl.cse.student;

/**
 * A class that represents a student, with appropriate fields and methods.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Student {
    
    private static final String PATTERN = "MM/dd/yyyy";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat( PATTERN );
    
    /* Member variables */
    private String firstName;
    private String lastName;
    private Integer nuid;
    private Date birthDate;

    /**
     * Constructor that requires users to provide all fields.
     * @param firstName
     * @param lastName
     * @param id
     * @param dob
     */
    public Student(String firstName, String lastName, Integer id, String dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nuid = id;        
        this.birthDate = parseDateString( dob );
    }
    
    /**
     * Parses String input representing a specific date into an instance of 
     * class Date.
     * @param dateOfBirth String the student's date of birth.
     * @return Date object date, the student's date of birth.
     */
    private Date parseDateString( String dateOfBirth ){
        
        Date date = null;
        try {
            date = dateFormat.parse(dateOfBirth);
        } catch(ParseException e) {
        	throw new RuntimeException(e);            
        }
        return date;
        
    }

    public String getFirstName(){        
        return firstName;
    }
        
    public String getLastName() {        
        return lastName;
    }
    
    public int getNUID() {  
        return nuid;
    }
    
    public int getAgeInYears() {
        Calendar now = Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.birthDate);
        return (int) ((now.getTimeInMillis() - calendar.getTimeInMillis()) / (1000 * 60 *60 * 24 * 365.25));
    }
    
    @Override
    public String toString(){
        /* Prepare to properly format Date output for display */
        SimpleDateFormat display = new SimpleDateFormat( "EEE, MMM d yyyy" );
        
        return String.format( "%s %s %d %s (%d years old)", firstName, lastName, nuid, 
                                                    display.format(birthDate), this.getAgeInYears() );
                
    } 

    
}
