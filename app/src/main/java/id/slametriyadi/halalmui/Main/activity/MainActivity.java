package id.slametriyadi.halalmui.Main.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.slametriyadi.halalmui.Main.adapter.MainAdapter;
import id.slametriyadi.halalmui.Main.model.DataItem;
import id.slametriyadi.halalmui.Main.model.ResponseProduct;
import id.slametriyadi.halalmui.Main.presenter.MainOnScrollPresenter;
import id.slametriyadi.halalmui.Main.presenter.MainPresenter;
import id.slametriyadi.halalmui.Main.view.MainView;
import id.slametriyadi.halalmui.R;
import id.slametriyadi.halalmui.Utils.PaginationScrollListener;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.rcView)
    RecyclerView rcView;
    private MainPresenter presenter;
    MainAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainPresenter();
        onAttach();
    }

    @Override
    public void onError(String msg) {

    }

    MainOnScrollPresenter onScrollListener;

    @Override
    public void onSuccess(List<DataItem> data) {
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcView.setLayoutManager(new LinearLayoutManager(this));
        rcView.setItemAnimator(new DefaultItemAnimator());
        rcView.setAdapter(new MainAdapter(this, data, rcView, linearLayoutManager, presenter));
    }

    @Override
    public void onAttach() {
        presenter.onAttach(this);
        presenter.getData(); // Load First Page
    }

    @Override
    public void onDettach() {

    }
}
