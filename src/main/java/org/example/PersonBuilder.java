package org.example;

import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private OptionalInt age;
    private String city;
    private String surname;

    public PersonBuilder setName(String name) {
        this.name = name;
        return PersonBuilder.this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return PersonBuilder.this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Указан неверный возраст. ");
        } else {
            this.age = OptionalInt.of(age);
            return this;
        }
    }

    public PersonBuilder setAddress(String city) {
        this.city = city;
        return PersonBuilder.this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("Не указаны необходимые данные. Поля Имя и Фамилия являются обязательными.");
        }
        return new Person(name, surname, age, city);
    }
}
