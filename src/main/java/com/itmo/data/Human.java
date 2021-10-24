package com.itmo.data;

import com.itmo.utils.FieldsValidator;

import java.io.Serializable;
import java.time.LocalDate;

import java.util.Objects;

public class Human implements Serializable {

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public void setBirth(String birthday) {
        this.birthday = FieldsValidator.getDate(birthday);
    }

    private String name; //Поле не может быть null, Строка не может быть пустой
    private long age; //Значение поля должно быть больше 0
    private long height; //Значение поля должно быть больше 0
    private java.time.LocalDate birthday;

    public Human(String name, long height, String birthday) {
        this.name = name;
        this.height = height;
        setBirth(birthday);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return height == human.height && name.equals(human.name) && birthday.equals(human.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, height, birthday);
    }

    public Human(){}

    public String getName() {
        return name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public long getHeight() {
        return height;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", birthday=" + birthday +
                '}';
    }
}

