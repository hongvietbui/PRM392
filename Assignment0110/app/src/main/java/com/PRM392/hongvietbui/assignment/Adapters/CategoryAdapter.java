package com.PRM392.hongvietbui.assignment.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.PRM392.hongvietbui.assignment.Models.Category;
import com.PRM392.hongvietbui.assignment.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private List<Category> categories;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Category category);
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        public ImageView icon;
        public TextView text;

        public CategoryViewHolder(android.view.View itemView, final OnItemClickListener listener, final List<Category> categories) {
            super(itemView);
            icon = itemView.findViewById(R.id.item_icon);
            text = itemView.findViewById(R.id.item_text);
            itemView.setOnClickListener(view -> {
                if(listener != null) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(categories.get(position));
                    }
                }
            });
        }
    }

    public CategoryAdapter(List<Category> categories, OnItemClickListener listener) {
        this.categories = categories;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view, listener, categories);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.icon.setImageResource(category.getIconResId());
        holder.text.setText(category.getName());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}

