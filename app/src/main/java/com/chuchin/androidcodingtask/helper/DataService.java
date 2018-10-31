package com.chuchin.androidcodingtask.helper;

import com.chuchin.androidcodingtask.model.CommentModel;
import com.chuchin.androidcodingtask.model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataService {

        @GET("posts")
        Call<List<PostModel>> getPosts();

        @GET("comments")
        Call<List<CommentModel>> getComments(@Query("postId") int postId);

}