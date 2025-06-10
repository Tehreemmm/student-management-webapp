package model;

public class Student {
    private int id;
    private String name;
    private String email;
    private String course;
    private String country;

    // Constructors
    public Student() {}

    public Student(int id, String name, String email, String course, String country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
        this.country = country;
    }

    public Student(String name, String email, String course, String country) {
        this.name = name;
        this.email = email;
        this.course = course;
        this.country = country;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}
