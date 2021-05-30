package model;

public class Genre {
    private String genre_ID;
    private String name;
    private String age_restriction;

    public Genre() {
    }

    public Genre(String name, String age_restriction) {
        this.name = name;
        this.age_restriction = age_restriction;
    }

    public String getGenre_ID() {
        return genre_ID;
    }

    public void setGenre_ID(String genre_ID) {
        this.genre_ID = genre_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge_restriction() {
        return age_restriction;
    }

    public void setAge_restriction(String age_restriction) {
        this.age_restriction = age_restriction;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genre_ID='" + genre_ID + '\'' +
                ", name='" + name + '\'' +
                ", age_restriction='" + age_restriction + '\'' +
                '}';
    }
}
