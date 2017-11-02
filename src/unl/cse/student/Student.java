package unl.cse.student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * A class that represents a student, with appropriate fields and methods.
 */
public class Student {

    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    
    /* Member variables */
    private String firstName;
    private String lastName;
    private Integer nuid;
    private LocalDate dateOfBirth;

    /**
     * Constructor that requires users to provide all fields.
     * @param firstName
     * @param lastName
     * @param id
     * @param dob
     */
    public Student(String firstName, String lastName, Integer id, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nuid = id;        
        this.dateOfBirth = LocalDate.parse(dateOfBirth, dateFormat);
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
    
    public long getAgeInYears() {
    	return ChronoUnit.YEARS.between(this.dateOfBirth, LocalDate.now());
    }
    
    @Override
    public String toString(){
        return String.format( "%s %s %d %s (%d years old)", firstName, lastName, nuid, 
                                                    this.dateOfBirth, this.getAgeInYears() );                
    } 

    
}
