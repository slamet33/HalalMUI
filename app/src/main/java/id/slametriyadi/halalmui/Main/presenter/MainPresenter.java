package id.slametriyadi.halalmui.Main.presenter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import id.slametriyadi.halalmui.Base.BasePresenter;
import id.slametriyadi.halalmui.Base.BaseView;
import id.slametriyadi.halalmui.Main.model.DataItem;
import id.slametriyadi.halalmui.Main.model.ResponseProduct;
import id.slametriyadi.halalmui.Main.view.MainView;
import id.slametriyadi.halalmui.Network.ApiService;
import id.slametriyadi.halalmui.Network.ConfigRetrofit;
import id.slametriyadi.halalmui.Utils.PaginationScrollListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements BasePresenter<MainView> {

    MainView v;

    public void getData() {
        ApiService api = ConfigRetrofit.getInstance();
        Call<ResponseProduct> call = api.getProduct("nama_produk", "tempe", 10);
        call.enqueue(new Callback<ResponseProduct>() {
            @Override
            public void onResponse(Call<ResponseProduct> call, Response<ResponseProduct> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("success")) {
                        List<DataItem> data = response.body().getData();
                            v.onSuccess(data);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseProduct> call, Throwable t) {
                Log.d("MyError", t.getMessage());
            }
        });
    }


    @Override
    public void onAttach(MainView v) {
        this.v = v;
    }

    @Override
    public void onDettach() {

    }
}
