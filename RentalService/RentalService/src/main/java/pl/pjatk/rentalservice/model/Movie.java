package pl.pjatk.rentalservice.model;

public class Movie {

    private Long id;
    private String title;
    private Boolean isAvailable;

    public Movie() {
    }

    public Movie(Long id, String title, Boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.isAvailable = isAvailable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean available) {
        isAvailable = available;
    }
}