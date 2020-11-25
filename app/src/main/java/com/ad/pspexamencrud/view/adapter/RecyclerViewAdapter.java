package com.ad.pspexamencrud.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.ad.pspexamencrud.model.entity.AgendaPOJO;
import com.ad.pspexamencrud.model.entity.EditAgendaActivity;

import java.util.List;
import java.util.stream.Collectors;

public class RecyclerViewAdapter extends ListAdapter<AgendaPOJO, RecyclerViewHolder> {

    private Context context;

    public RecyclerViewAdapter(Context context, @NonNull DiffUtil.ItemCallback<AgendaPOJO> diffCallback) {
        super(diffCallback);
        this.context = context;
    }

    public RecyclerViewAdapter(@NonNull AsyncDifferConfig<AgendaPOJO> config) {
        super(config);
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return RecyclerViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        AgendaPOJO posItem = getItem(position);
        holder.onBindViewHolder(posItem.getId() ,posItem.getNombre(), posItem.getApellidos(), posItem.getTelefono(), posItem.getFecha_nacimiento(), posItem.getLocalidad(), posItem.getCalle(), posItem.getNumero());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditAgendaActivity.class);
                intent.putExtra("contacto", posItem);
                context.startActivity(intent);
            }
        });
    }

    public static class AgendaDiff extends DiffUtil.ItemCallback<AgendaPOJO> {

        @Override
        public boolean areItemsTheSame(@NonNull AgendaPOJO oldItem, @NonNull AgendaPOJO newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull AgendaPOJO oldItem, @NonNull AgendaPOJO newItem) {
            return oldItem.getNombre().equals(newItem.getNombre());
        }
    }
}
