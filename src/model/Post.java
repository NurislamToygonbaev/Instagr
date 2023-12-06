package model;

public class Post {
    private long id;
    private String imageUrl;
    private String description;

    public Post() {
    }

    public Post(long id, String imageUrl, String description) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Post: " +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                "\n\n";
    }
}
