package com.system.optimize.furnitureinfo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.icu.text.UnicodeSetSpanner;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {
    //@BindView(R.id.changeLang_btn) Button changeLang_btn;
    //@BindView(R.id.canvasView) FrameLayout canvas;
    @BindView(R.id.basic_info_block) LinearLayout basicInfoBlock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        /*Configuration config = new Configuration();
        config.locale = new Locale("th");
        getResources().updateConfiguration(config, null);

        onCreate(null);*/
    }

    @OnClick(R.id.basic_info_block)
    public void changeLanguage_onClick() {
        Intent basicInfo = new Intent(MainActivity.this, BasicInfoActivity.class);
        startActivity(basicInfo);
    }
}
