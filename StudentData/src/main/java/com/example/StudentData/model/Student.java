package com.example.StudentData.model;

/**
 * Represents a student entity within the Student Data application.
 * <p>
 * This class is a simple POJO (Plain Old Java Object) used to model student
 * data. It includes fields for ID, name, age, and course along with
 * corresponding constructors, getters, and setters.
 * </p>
 *
 * Example:
 * <pre>
 * Student student = new Student(1L, "Aniket", 22, "Computer Science");
 * </pre>
 *
 * @author An…
 * @version 1.0
 */
public class Student {

    /** Unique identifier for the student. */
    private Long id;

    /** The full name of the student. */
    private String name;

    /** The age of the student. */
    private int age;

    /** The course in which the student is enrolled. */
    private String course;

    /**
     * Default constructor for creating an empty {@code Student} object.
     */
    public Student() {}

    /**
     * Constructs a {@code Student} with the specified details.
     *
     * @param id     the unique ID of the student
     * @param name   the full name of the student
     * @param age    the age of the student
     * @param course the course the student is enrolled in
     */
    public Student(Long id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    /**
     * Gets the student's unique ID.
     *
     * @return the student's ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the student's unique ID.
     *
     * @param id the new ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the student's name.
     *
     * @return the student's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the student's name.
     *
     * @param name the new name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the student's age.
     *
     * @return the student's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the student's age.
     *
     * @param age the new age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the student's course.
     *
     * @return the course the student is enrolled in
     */
    public String getCourse() {
        return course;
    }

    /**
     * Sets the student's course.
     *
     * @param course the new course to set
     */
    public void setCourse(String course) {
        this.course = course;
    }
}
