package com.example.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import android.widget.SeekBar;
import android.widget.Toast;

import java.io.FileReader;


public class MainActivity extends AppCompatActivity {

    private Button speek;
    private TextToSpeech TTS;
    private EditText editText;


    private ArabicTTS tts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater my = getLayoutInflater();
        View MyView = my.inflate(R.layout.welcome,(ViewGroup)findViewById(R.id.b1));
        Toast t = new Toast(getApplicationContext());
        t.setGravity(Gravity.FILL,0,0);
        t.setDuration(Toast.LENGTH_LONG);
        t.setView(MyView);
        t.show();


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


final MediaPlayer voice=MediaPlayer.create(this,R.raw.qq);

        final MediaPlayer voice1=MediaPlayer.create(this,R.raw.qw);


        speek  =(Button) findViewById(R.id.S2);
        editText = (EditText) findViewById(R.id.S1);


        speek.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                speak();
            }
        });


        Button hello=findViewById(R.id.M1);
        hello.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                editText.setText("مرحبا , كيف حالك ؟");
              //  speak();
                voice1.start();
            }
        });
        Button you = findViewById(R.id.M2);
        you.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                editText.setText("ساعدني ...");
               // speak();
voice.start();

            }
        });

        tts = new ArabicTTS();
        // Preparing the language
        tts.prepare(this);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_email) {
            email();
            return true;
        }else if (id == R.id.action_ShareText){
            ShareText();
            return true;
        }else if (id == R.id.action_image){
            image();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void image() {
        Intent intent = new Intent(this , image.class);
        startActivity(intent);
    }

    private void ShareText() {
        Intent senttext = new Intent(Intent.ACTION_SEND);
        senttext.putExtra(Intent.EXTRA_TEXT," download MyMic in play Store ");
        senttext.setType("text/plain");
        startActivity(Intent.createChooser(senttext,"send text"));

    }

    private void email() {
        try{
            Intent send =new Intent(Intent.ACTION_SEND);
            send.setData(Uri.parse("mailto:"));
            send.setType("message/rfc822");
            send.putExtra(Intent.EXTRA_EMAIL,"saja_gassan@yahoo.com");
            send.putExtra(Intent.EXTRA_SUBJECT,"welcome to the application ,you can contact with us ... Thank you");
            send.putExtra(Intent.EXTRA_TEXT," saja_gassan@yahoo.com ");
            startActivity(send);
        }catch (Exception e){

            Toast.makeText(this , " not application ",Toast.LENGTH_LONG).show();
        }
    }

    public void vedio(View view) {
        Intent intent = new Intent(this , Vedio.class);
        startActivity(intent);

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void speak() {


        String ip = editText.getText().toString();
        if (ip != null && !ip.equals("")) {

            tts.talk(ip);

            Toast.makeText(this, "Your device is speaking .....", Toast.LENGTH_SHORT).show();
        }


      


    }






}
