package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class WelcomeActivity extends AppCompatActivity {
    ViewFlipper viewFlipper;
    TextView textView_content,below_content;
    ConnectionDetector connection_detector;
    private static String contentText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        connection_detector=new ConnectionDetector(this);
        if (connection_detector.isConnected())
        {
        }else
        {
            Intent intent = new Intent(this,ConnectionError.class);
            startActivity(intent);
            //Toast.makeText(this,"Not Connected",Toast.LENGTH_LONG).show();
        }
        viewFlipper = findViewById(R.id.v_flifer);
        int images[] = {R.mipmap.slider1,R.mipmap.slider2,R.mipmap.slider3};
        for (int i=0; i<images.length; i++){
            flipImages(images[i]);
        }
        textView_content = findViewById(R.id.id_content);
        textView_content.setText(contentText);
        below_content = findViewById(R.id.id_below_content);
        below_content.setText(contentText);
    }
    public void flipImages(int images){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(images);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(WelcomeActivity.this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(WelcomeActivity.this, android.R.anim.slide_out_right);
    }

    public void openMainActivity(View view) {
        Intent intent = new Intent(this,BasicCategoryActivity.class);
        startActivity(intent);
    }

    public void openSignInActivity(View view) {
        Intent intent = new Intent(this,SignInActivity.class);
        startActivity(intent);
    }
}
