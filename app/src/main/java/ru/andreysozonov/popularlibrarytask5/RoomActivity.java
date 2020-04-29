package ru.andreysozonov.popularlibrarytask5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RoomActivity extends AppCompatActivity {

    private RoomPresenter roomPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        ButterKnife.bind(this);

        roomPresenter = new RoomPresenter();
    }

    @OnClick(R.id.buttonAddUser)
    public void addUser() {
        roomPresenter.putUser();
    }

    @OnClick(R.id.buttonAddUsers)
    public void addUsers() {
        roomPresenter.putUsers();
    }

    @OnClick(R.id.buttonDeleteUser)
    public void deleteUser() {
        roomPresenter.removeUser();
    }

    @OnClick(R.id.buttonUpdateUser)
    public void updateUser() {
        roomPresenter.update();
    }

    @OnClick(R.id.buttonGetUsers)
    public void getUsers() {
        roomPresenter.getAllUsers();
    }
}
