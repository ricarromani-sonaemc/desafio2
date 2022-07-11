package pipeline

public class Member implements Serializable{
    String firstName
    String lastName
    String job
    Integer age
    String parent

    Member() {
        this.firstName = ""
        this.lastName = ""
        this.job = ""
        this.age = 0
        this.parent = ""
    }

    public String ToString() {
        return "firstName = " + this.firstName + "\nlastName = " + this.lastName + "\njob = " + this.job; 
    } 
}
