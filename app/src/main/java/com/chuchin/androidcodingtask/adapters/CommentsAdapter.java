package com.chuchin.androidcodingtask.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chuchin.androidcodingtask.R;
import com.chuchin.androidcodingtask.model.CommentModel;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {

    //region Propiedades
    List<CommentModel> listComments;

    //endregion


    //region Constructor

    public CommentsAdapter(List<CommentModel> listComments) {
        this.listComments = listComments;
    }

    //endregion


    //region RecyclerView.Adapter

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycle_comment, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final CommentModel comment = listComments.get(position);

        holder.tvName.setText(comment.getName());
        holder.tvEmail.setText(comment.getEmail());
        holder.tvBody.setText(comment.getBody());
    }

    @Override
    public int getItemCount() {
        return listComments.size();
    }

    //endregion


    //region Custom methods

    public void setListComments(List<CommentModel> listComments){
        this.listComments = listComments;
        notifyDataSetChanged();
    }

    //endregion


    //region ViewHolder

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvEmail, tvBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvEmail = itemView.findViewById(R.id.tv_email);
            tvBody = itemView.findViewById(R.id.tv_body);
        }
    }

    //endregion

}
