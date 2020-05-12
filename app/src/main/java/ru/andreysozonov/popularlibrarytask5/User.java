package ru.andreysozonov.popularlibrarytask5;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_users")
public class User {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;

    public String surname;

    public int age;

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return " " + id + " " + name + " " + surname + " " + age;
    }
}
