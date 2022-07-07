package pipeline

public class Member {
    private String firstName;
    private String lastName;
    private Integer age;
    private String job;
    
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
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
}

/*
class MemberObject extends Serializable {

    String firstName;
    String lastName;
    long age;
    String job;
    
    MemberObject(){
        this.firstName = ""
        this.lastName = ""
        this.age
        this.job = ""
    }
}
*/
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