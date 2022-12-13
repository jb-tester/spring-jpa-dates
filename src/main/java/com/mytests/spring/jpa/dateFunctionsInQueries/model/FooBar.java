package com.mytests.spring.jpa.dateFunctionsInQueries.model;


import jakarta.persistence.*;

/**
 * *
 * <p>Created by irina on 6/3/2022.</p>
 * <p>Project: spring-jpa-dates</p>
 <p> dot in entity.name: <a href="https://youtrack.jetbrains.com/issue/IDEA-295357">IDEA-295357</a></p>
 * *
 */
@Entity(name = "foo.bar")
public class FooBar {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "family_name")
    private String familyName;
    @Basic
    @Column(name = "nationality")
    private String nationality;
    @Basic
    @Column(name = "age")
    private Integer age;

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

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FooBar fooBar = (FooBar) o;

        if (id != fooBar.id) return false;
        if (name != null ? !name.equals(fooBar.name) : fooBar.name != null) return false;
        if (familyName != null ? !familyName.equals(fooBar.familyName) : fooBar.familyName != null) return false;
        if (nationality != null ? !nationality.equals(fooBar.nationality) : fooBar.nationality != null) return false;
        if (age != null ? !age.equals(fooBar.age) : fooBar.age != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (familyName != null ? familyName.hashCode() : 0);
        result = 31 * result + (nationality != null ? nationality.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FooBar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", age=" + age +
                '}';
    }
}
