package com.chuchin.androidcodingtask.presenter;

import android.util.Log;

import com.chuchin.androidcodingtask.helper.RetrofitClient;
import com.chuchin.androidcodingtask.helper.DataService;
import com.chuchin.androidcodingtask.interfaces.DataPresenterInterface;
import com.chuchin.androidcodingtask.model.CommentModel;
import com.chuchin.androidcodingtask.model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataPresenter {


    //region Propiedades
    private DataPresenterInterface dataPresenterInterface;

    //endregion

    //region Constructor

    public DataPresenter(DataPresenterInterface dataPresenterInterface) {
        this.dataPresenterInterface = dataPresenterInterface;
    }

    //endregion

    //region Methods

    public void getPosts() {

        //Create handle for retrofit instance interface
        DataService dataService = RetrofitClient.getRetrofitInstance().create(DataService.class);

        //Call the method in the interface to get the data (posts)
        Call<List<PostModel>> call = dataService.getPosts();
        call.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {

                if (response.isSuccessful()) {
                    dataPresenterInterface.didDownloadPosts(true, response.message(), response.body());
                } else {
                    //an error ocurred
                    dataPresenterInterface.didDownloadPosts(false, response.message(), null);
                }
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                //an error ocurred
                dataPresenterInterface.didDownloadPosts(false, t.getMessage(), null);
            }
        });
    }


    public void getComments(int postId) {

        final DataService dataService = RetrofitClient.getRetrofitInstance().create(DataService.class);
        Call<List<CommentModel>> call = dataService.getComments(postId);
        call.enqueue(new Callback<List<CommentModel>>() {
            @Override
            public void onResponse(Call<List<CommentModel>> call, Response<List<CommentModel>> response) {
                if (response.isSuccessful()) {
                    dataPresenterInterface.didDownloadComments(true, response.message(), response.body());
                } else {
                    //an error ocurred
                    dataPresenterInterface.didDownloadComments(false, response.message(), null);
                }
            }

            @Override
            public void onFailure(Call<List<CommentModel>> call, Throwable t) {
                dataPresenterInterface.didDownloadComments(false, t.getMessage(), null);
            }
        });

    }

    //endregion

}
