package pipeline
/*
class FamilyObject extends Serializable {


    FamilyObject(){
        
    }

}
*/

public class FamilyFamily {
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