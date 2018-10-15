package id.slametriyadi.halalmui.Base;

public interface BasePresenter <T extends BaseView> {
    void onAttach(T v);
    void onDettach();
}
