package ru.andreysozonov.popularlibrarytask4.retrofit;

import android.os.Bundle;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import butterknife.BindView;
import butterknife.ButterKnife;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import ru.andreysozonov.popularlibrarytask4.R;
import ru.andreysozonov.popularlibrarytask4.retrofit.presenter.RetrofitPresenter;

public class RetrofitActivity extends MvpAppCompatActivity implements RetrofitView {

    @InjectPresenter
    RetrofitPresenter retrofitPresenter;

    @BindView(R.id.avatar_image_view)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);

        retrofitPresenter.getUrl();
    }

    public void setImage(String url) {
        Glide
                .with(this)
                .load(url)
                .into(imageView);
    }
}
