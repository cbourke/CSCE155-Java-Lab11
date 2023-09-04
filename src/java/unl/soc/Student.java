package unl.soc;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * A class that represents a student, with appropriate fields and methods.
 */
public class Student {

    // Member variables
    private final String firstName;
    private final String lastName;
    private final Integer nuid;
    private final LocalDate dateOfBirth;

    /**
     * Constructor that requires users to provide all fields.
     * @param firstName
     * @param lastName
     * @param id
     * @param dob
     */
    public Student(String firstName, String lastName, Integer nuid, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nuid = nuid;        
        this.dateOfBirth = dateOfBirth;
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
