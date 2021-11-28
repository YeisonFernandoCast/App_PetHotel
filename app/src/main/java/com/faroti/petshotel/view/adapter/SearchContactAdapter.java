package com.faroti.petshotel.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faroti.petshotel.R;
import com.faroti.petshotel.mvp.SearchContactMVP;

import java.util.ArrayList;
import java.util.List;

public class SearchContactAdapter extends RecyclerView.Adapter<SearchContactAdapter.ViewHolder> {
    private List<SearchContactMVP.SearchContactInfo> data;

    public SearchContactAdapter() {
        this.data = new ArrayList<>();
    }

    public void setData(List<SearchContactMVP.SearchContactInfo> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact_search, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SearchContactMVP.SearchContactInfo item = data.get(position);

        //TODO Agregar un evento a la vista
        holder.itemView.setOnClickListener(v ->{
            Toast.makeText(v.getContext(),item.getName(), Toast.LENGTH_SHORT).show();
        });

        //TODO holder.getIvClient().setImageIcon();
        holder.getTvClient().setText(item.getName());
        holder.getTvAddress().setText(item.getAddress());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivClient;
        private TextView tvClient;
        private  TextView tvAddress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivClient = itemView.findViewById(R.id.iv_client);
            tvClient = itemView.findViewById(R.id.tv_client);
            tvAddress = itemView.findViewById(R.id.tv_address);

        }

        public ImageView getIvClient() {
            return ivClient;
        }

        public TextView getTvClient() {
            return tvClient;
        }

        public TextView getTvAddress() {
            return tvAddress;
        }
    }
}
