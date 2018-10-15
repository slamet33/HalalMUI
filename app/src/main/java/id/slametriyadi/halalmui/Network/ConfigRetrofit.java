package id.slametriyadi.halalmui.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigRetrofit {


    public static Retrofit setInit() {
        return new Retrofit.Builder()
                .baseUrl("http://api.agusadiyanto.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getInstance() {
        return setInit().create(ApiService.class);
    }

}
