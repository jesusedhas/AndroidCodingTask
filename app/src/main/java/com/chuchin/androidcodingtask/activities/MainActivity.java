package com.chuchin.androidcodingtask.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.chuchin.androidcodingtask.R;
import com.chuchin.androidcodingtask.adapters.PostsAdapter;
import com.chuchin.androidcodingtask.helper.Util;
import com.chuchin.androidcodingtask.interfaces.DataPresenterInterface;
import com.chuchin.androidcodingtask.model.CommentModel;
import com.chuchin.androidcodingtask.model.PostModel;
import com.chuchin.androidcodingtask.presenter.DataPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DataPresenterInterface {


    //region View
    RecyclerView recyclerPosts;
    PostsAdapter postsAdapter;

    //endregion


    //region AppCompatActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init necessary data
        recyclerPosts = findViewById(R.id.recycler_posts);
        recyclerPosts.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        postsAdapter = new PostsAdapter(new ArrayList<PostModel>(), this);
        recyclerPosts.setAdapter(postsAdapter);

        DataPresenter dataPresenter = new DataPresenter(this);

        //download posts
        Util.showProgressDialog(getString(R.string.wait), "", this);
        dataPresenter.getPosts();
    }

    //endregion


    //region DataPresenterInterface

    @Override
    public void didDownloadPosts(boolean success, String message, List<PostModel> listPosts) {
        Util.dismissProgressDialog();
        if (success) {
            postsAdapter.setListPosts(listPosts);
        } else {
            //an error ocurred
            Util.showDefaultDialog(getString(R.string.error), message, this);
        }
    }

    @Override
    public void didDownloadComments(boolean success, String message, List<CommentModel> listComments) {
        return;
    }

    //endregion

}
