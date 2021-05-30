package model;

public class Genre {
    private int genre_id;
    private String name;
    private String age_restriction;

    public Genre() {
    }

    public Genre(String name, String age_restriction) {
        this.name = name;
        this.age_restriction = age_restriction;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
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
                "genre_id=" + genre_id +
                ", name='" + name + '\'' +
                ", age_restriction='" + age_restriction + '\'' +
                '}';
    }
}
