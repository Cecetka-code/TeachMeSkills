package entity;

public class Employees {
    private String firstName;
    private String lastName;
    private int positionId;
    private String post;
    private int experience;

    public Employees() {
    }

    public Employees(String firstName, String lastName, int positionId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.positionId = positionId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

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

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    @Override
    public String toString() {
        return  "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", post='" + post + '\'' +
                ", experience=" + experience;
    }
}
