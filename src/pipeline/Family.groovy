package pipeline

public class Family implements Serializable{

    private List<Member> members;

    Family() {
        this.members = []
    }
    /*
    public List<Member> getMembers() {
        return members;
    }
    public void setMembers(List<Member> members) {
        this.members = members;
    }*/
}

/*
class FamilyObject extends Serializable {


    FamilyObject(){
        
    }

}
*/
/*
public class Family {
    private String name;
    private Member[] members;

    public String getName() { 
        return name
    }
    public void setName(String value) { 
        this.name = value
    }

    public Member[] getMembers() { 
        return members
    }
    public void setMembers(Member[] value) { 
        this.members = value
    }
}
*/