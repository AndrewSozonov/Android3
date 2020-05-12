package ru.andreysozonov.popularlibrarytask5;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface UserDao {

    @Query("SELECT * FROM table_users")
    Single<List<User>> getAll();

    @Insert
    Single<Long> insert(User user);

    @Insert
    Single<List<Long>> insertList(List<User> users);

    @Query("DELETE FROM table_users WHERE surname = :surname")
    Single<Integer> delete(String surname);

    @Update
    Single<Integer> update(User user);
}
