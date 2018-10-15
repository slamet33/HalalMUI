package id.slametriyadi.halalmui.Main.view;

import java.util.List;

import id.slametriyadi.halalmui.Base.BaseView;
import id.slametriyadi.halalmui.Main.model.DataItem;
import id.slametriyadi.halalmui.Main.model.ResponseProduct;

public interface MainView extends BaseView {
    void onError(String msg);
    void onSuccess(List<DataItem> data);
}
