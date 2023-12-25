package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailBajuActivity extends AppCompatActivity {
	ArrayList<Baju> listBaju;
	int quantity = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_baju);
		TextView nama_masuk,ket_masuk,harga_masuk,total_harga,qty;
		ImageView gambar_masuk;
		Button btn_add,btn_min;



		gambar_masuk = findViewById(R.id.gambar_masuk);
		nama_masuk = findViewById(R.id.nama_masuk);
		ket_masuk = findViewById(R.id.ket_masuk);
		harga_masuk = findViewById(R.id.harga_masuk);
		total_harga = findViewById(R.id.total_Harga);
		qty = findViewById(R.id.qty);
		btn_add = findViewById(R.id.btn_add);
		btn_min = findViewById(R.id.btn_min);



		String nama,keterangan,harga;
		int gambar;


		nama = getIntent().getStringExtra("nama");
		keterangan = getIntent().getStringExtra("keterangan");
		gambar = getIntent().getIntExtra("gambar",0);// default value kalau ada yg kosong;
		harga = getIntent().getStringExtra("harga");



		nama_masuk.setText(nama);
		ket_masuk.setText(keterangan);
		gambar_masuk.setImageResource(gambar);
		harga_masuk.setText(harga);

		btn_add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				qty.setText(""+ (quantity++));
				total_harga.setText("Rp."+quantity* Integer.parseInt(harga));
			}
		});

		btn_min.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if(quantity != 0){
					qty.setText(""+(--quantity));
					total_harga.setText("Rp."+ quantity * Integer.parseInt(harga));
				} else {
					qty.setText(""+(0));
					total_harga.setText("Rp."+ 0);
				}


			}
		});


	}
}