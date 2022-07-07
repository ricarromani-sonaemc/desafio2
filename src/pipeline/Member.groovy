package pipeline

public class Member implements Serializable{
    String firstName
    String lastName
    String job
    Integer age

    Member() {
        this.firstName = ""
        this.lastName = ""
        this.job = ""
        this.age = 0
    }
/*
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }*/
    
    public String ToString() {
        return "firstName = " + this.firstName + "\nlastName = " + this.lastName + "\njob = " + this.job; 
    } 
}

/*
public class Member {
    private String firstName
    private String lastName
    private long age
    private String job

    public String getFirstName() {
        return firstName
    }
    public void setFirstName(String value) { 
        this.firstName = value; 
    }

    public String getLastName() { 
        return lastName    
    }
    public void setLastName(String value) { 
        this.lastName = value
    }

    public long getAge() { 
        return age
    }
    public void setAge(long value) { 
        this.age = value
    }

    public String getJob() { 
        return job
    }
    public void setJob(String value) { 
        this.job = value
    }
}
*/