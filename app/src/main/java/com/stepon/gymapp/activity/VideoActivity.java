package com.stepon.gymapp.activity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import com.stepon.gymapp.R;
import com.stepon.gymapp.utils.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoActivity extends AppCompatActivity {

    @BindView(R.id.videoView)
    protected VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        String strUrl = getIntent().getStringExtra(Constant.STR_URL);
        Uri uri = Uri.parse(strUrl);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.seekTo(1000);
        videoView.start();
    }
}
