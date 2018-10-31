package com.chuchin.androidcodingtask.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chuchin.androidcodingtask.R;
import com.chuchin.androidcodingtask.activities.CommentsActivity;
import com.chuchin.androidcodingtask.model.PostModel;

import java.util.List;

public class PostsAdapter  extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    //region Propiedades
    List<PostModel> listPosts;
    Context context;


    //endregion

    //region Constructor

    public PostsAdapter(List<PostModel> listPosts, Context context) {
        this.listPosts = listPosts;
        this.context = context;
    }

    //endregion



    //region Recycler.Adapter

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycle_post, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final PostModel post = listPosts.get(position);

        holder.tvTitle.setText(post.getTitle());
        holder.tvBody.setText(post.getBody());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CommentsActivity.class);
                intent.putExtra("postId", post.getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listPosts.size();
    }


    //endregion

    //region Custom methods

    public void setListPosts(List<PostModel> listPosts){
        this.listPosts = listPosts;
        notifyDataSetChanged();
    }

    //endregion


    //region ViewHolder

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvBody = itemView.findViewById(R.id.tv_body);
        }
    }

    //endregion

}
