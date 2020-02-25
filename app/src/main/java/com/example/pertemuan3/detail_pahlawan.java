package com.example.pertemuan3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class detail_pahlawan extends AppCompatActivity {

    public static String EXTRA_DATA = "extra data";
    private TextView tv_nama, tv_detail;
    private ImageView iv_gambar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pahlawan);

        tv_nama = findViewById(R.id.tv_nama);
        tv_detail = findViewById(R.id.tv_deskripsifull);
        iv_gambar = findViewById(R.id.iv_gambar);

        modelPahlawan pahlawan = getIntent().getParcelableExtra(EXTRA_DATA);
        if (pahlawan != null){
            int image = pahlawan.getHeroImages();
            String nama = pahlawan.getHeroNames();
            String detail = pahlawan.getHeroDetails();

            tv_nama.setText(nama);
            tv_detail.setText(detail);
            Glide.with(this).load(image).into(iv_gambar);
        }
    }
}
