package id.slametriyadi.halalmui.Main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.slametriyadi.halalmui.Main.model.DataItem;
import id.slametriyadi.halalmui.Main.presenter.MainPresenter;
import id.slametriyadi.halalmui.R;

public class MainAdapter extends RecyclerView.Adapter {

    List<DataItem> data;
    Context context;
    // The minimum amount of items to have below your current scroll position
    // before loading more.

    public MainAdapter(Context context, List<DataItem> data, RecyclerView rcView, LinearLayoutManager linearLayoutManager, final MainPresenter presenter) {
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder;

            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_item, viewGroup, false);
            viewHolder = new DataViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof DataViewHolder) {
            ((DataViewHolder) viewHolder).namaproduk.setText(data.get(i).getNamaProduk());
            ((DataViewHolder) viewHolder).namaperusahaan.setText(data.get(i).getNamaProdusen());
            ((DataViewHolder) viewHolder).nomorsertifikat.setText(data.get(i).getNomorSertifikat());
            ((DataViewHolder) viewHolder).masaberlaku.setText(data.get(i).getBerlakuHingga());
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {

        TextView namaproduk, namaperusahaan, nomorsertifikat, masaberlaku;

        public DataViewHolder(View itemView) {
            super(itemView);
            namaproduk = itemView.findViewById(R.id.namaproducet);
            namaperusahaan = itemView.findViewById(R.id.namaperusahaan);
            nomorsertifikat = itemView.findViewById(R.id.nomorsertifikat);
            masaberlaku = itemView.findViewById(R.id.masaberlaku);
        }
    }
}
