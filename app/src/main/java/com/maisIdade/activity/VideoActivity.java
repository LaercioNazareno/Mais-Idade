package com.maisIdade.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubeBaseActivity;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.maisIdade.DAO.VideoDAO;
import com.maisIdade.R;
import com.maisIdade.model.Video;

public class VideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static final String DEVELOPER_KEY = "AIzaSyBtHusfz9V1D2yxTELnJSLzan9D_WAC4fc";
    private String idVideo= "MM4ShEnKw3A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Intent it = getIntent();
        int id = it.getIntExtra("videoId",0);


        VideoDAO videoDAO = new VideoDAO(getBaseContext());

        Video video = videoDAO.getVideoById(id+1);
        idVideo = video.getUrl();

        YouTubePlayerView playerYouTube = findViewById(R.id.playerYouTube);
        playerYouTube.initialize(DEVELOPER_KEY, this);


    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean isload) {
        if(isload){
            youTubePlayer.cueVideo(idVideo);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(getBaseContext(),"error",Toast.LENGTH_LONG);
    }


}
