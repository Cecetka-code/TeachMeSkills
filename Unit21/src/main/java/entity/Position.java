package entity;

public class Position {
    private int positionId;
    private String post;
    private int experience;

    public Position(int positionId, String post, int experience) {
        this.positionId = positionId;
        this.post = post;
        this.experience = experience;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
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

    @Override
    public String toString() {
        return "Position{" +
                "positionId=" + positionId +
                ", post='" + post + '\'' +
                ", experience='" + experience + '\'' +
                '}';
    }
}
