package com.chuchin.androidcodingtask.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chuchin.androidcodingtask.R;
import com.chuchin.androidcodingtask.adapters.CommentsAdapter;
import com.chuchin.androidcodingtask.helper.Util;
import com.chuchin.androidcodingtask.interfaces.DataPresenterInterface;
import com.chuchin.androidcodingtask.model.CommentModel;
import com.chuchin.androidcodingtask.model.PostModel;
import com.chuchin.androidcodingtask.presenter.DataPresenter;

import java.util.ArrayList;
import java.util.List;

public class CommentsActivity extends AppCompatActivity implements DataPresenterInterface {

    //region View
    RecyclerView recyclerComments;
    CommentsAdapter commentsAdapter;

    //endregion

    //region Propiedades


    //endregion



    //region AppCompatActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        //get necessary data
        int postId = getIntent().getExtras().getInt("postId");

        //init necessary data
        recyclerComments = findViewById(R.id.recycler_comments);
        recyclerComments.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        commentsAdapter = new CommentsAdapter(new ArrayList<CommentModel>());
        recyclerComments.setAdapter(commentsAdapter);

        DataPresenter dataPresenter = new DataPresenter(this);

        //get comments
        Util.showProgressDialog(getString(R.string.getting_comments), "", this);
        dataPresenter.getComments(postId);

    }

    //endregion

    //region DataPresenterInterface

    @Override
    public void didDownloadPosts(boolean success, String message, List<PostModel> listPosts) {
        return;
    }

    @Override
    public void didDownloadComments(boolean success, String message, List<CommentModel> listComments) {
        Util.dismissProgressDialog();
        if (success) {

            commentsAdapter.setListComments(listComments);

        } else {
            //an error ocurred
            Util.showDefaultDialog(getString(R.string.error), "", this);
        }
    }

    //endregion

}


























