package com.example.apcsas1final;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SettingsActivity extends AppCompatActivity
{
    ImageButton backBtn;

    Button changesBtn;

    EditText editMusicVol;

    EditText editMusicTrack;

    MediaPlayer mediaPlayer;

    float musicVolume = 0.5F;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);

        backBtn = findViewById(R.id.backBtn);
        changesBtn = findViewById(R.id.changesBtn);
        editMusicTrack = (EditText) findViewById(R.id.editMusicTrack);
        editMusicVol = (EditText) findViewById(R.id.editMusicVol);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_settings), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Back button to take you to main screen
        backBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //Button to apply setting changes
        changesBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {


                editMusicTrack.setText("Music Track (1 - 10)");
                editMusicVol.setText("Music Volume% (0.1 - 1.0)");
            }
        });
    }
}