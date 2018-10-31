package com.chuchin.androidcodingtask.interfaces;

import com.chuchin.androidcodingtask.model.CommentModel;
import com.chuchin.androidcodingtask.model.PostModel;

import java.util.List;

public interface DataPresenterInterface {

    void didDownloadPosts(boolean success, String message, List<PostModel> listPosts);

    void didDownloadComments(boolean success, String message, List<CommentModel> listComments);

}
