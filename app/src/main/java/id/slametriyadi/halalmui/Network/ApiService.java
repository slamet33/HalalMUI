package id.slametriyadi.halalmui.Network;

import id.slametriyadi.halalmui.Main.model.ResponseProduct;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("halal/")
    Call<ResponseProduct> getProduct(
            @Query("menu") String menu,
            @Query("query") String query,
            @Query("page") int page

    );

}
