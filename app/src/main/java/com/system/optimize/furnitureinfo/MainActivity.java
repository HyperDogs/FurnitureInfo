package com.system.optimize.furnitureinfo;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.security.Permission;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import resource.CreateFile;

public class MainActivity extends Activity {
    //@BindView(R.id.changeLang_btn) Button changeLang_btn;
    //@BindView(R.id.canvasView) FrameLayout canvas;
    @BindView(R.id.basic_info_block) LinearLayout basicInfoBlock;

    ImageView mainPic = (ImageView)findViewById(R.id.product_photo_imv);
    String uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
         /*Configuration config = new Configuration();
        config.locale = new Locale("th");
        getResources().updateConfiguration(config, null);
        onCreate(null);*/
        //ขออนุญาติ
        Dexter.initialize(MainActivity.this);
        Dexter.checkPermission(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse response) {
                Toast.makeText(MainActivity.this,"OK",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse response) {
                finish();
            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                // request permission when call method again
                token.continuePermissionRequest();

                // ask permission once time
                token.cancelPermissionRequest();
            }
        }, Manifest.permission.CAMERA);
        //ver Btn
        mainPic.setOnClickListener(onClickTakePic);


    }

    @OnClick(R.id.basic_info_block)
    public void changeLanguage_onClick() {
        Intent basicInfo = new Intent(MainActivity.this, BasicInfoActivity.class);
        startActivity(basicInfo);
    }


    private View.OnClickListener onClickTakePic = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            CreateFile createFile = new CreateFile();
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            File file = createFile.createUnique();
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
            startActivityForResult(intent, 1);

        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            ContentResolver cr = getContentResolver();
            try {
               // Bitmap bitmap = MediaStore.Images.Media.getBitmap(cr, uri);
               // mainPic.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
