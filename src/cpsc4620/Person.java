package cpsc4620;

public class Person {
    private int personId;
    private String fullname;
    private String phone;
    private UserType userType;
    private String userLoc;

    public Person() {
    }

    public Person(int personId, String fullname, String phone, UserType userType, String userLoc) {
        this.personId = personId;
        this.fullname = fullname;
        this.phone = phone;
        this.userType = userType;
        this.userLoc = userLoc;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getUserLoc() {
        return userLoc;
    }

    public void setUserLoc(String userLoc) {
        this.userLoc = userLoc;
    }

    // Override the toString method to print object details
    @Override
    public String toString() {
        return "Person [personId=" + personId + ", fullname=" + fullname + ", phone=" + phone + ", userType=" + userType
                + ", userLoc=" + userLoc + "]";
    }

}

enum UserType {
    Rider, Driver, Both;
}
