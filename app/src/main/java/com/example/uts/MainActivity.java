package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
	ListView lvBaju;

	TypedArray dataNama;
	TypedArray dataGambar;
	TypedArray dataHarga;
	TypedArray dataKeterangan;
	TypedArray dataalamat;

	ArrayList<Baju> listBaju = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		lvBaju = findViewById(R.id.lv_buah);

		setResource();
		addItem();

		BajuAdapter adapter = new BajuAdapter(this, listBaju);
		lvBaju.setAdapter(adapter);

	}

	private void setResource() {
		dataNama = getResources().obtainTypedArray(R.array.nama_baju);
		dataGambar = getResources().obtainTypedArray(R.array.gambar_baju);
		dataHarga = getResources().obtainTypedArray(R.array.harga_baju);
		dataKeterangan = getResources().obtainTypedArray(R.array.keterangan);
		dataalamat = getResources().obtainTypedArray(R.array.alamat);

	}

	private void addItem() {
		listBaju = new ArrayList<>();
		for (int i = 0; i < dataNama.length(); i++) {
			Baju baju = new Baju(
					dataNama.getString(i),
					dataGambar.getResourceId(i, -1),
					dataHarga.getString(i),
					dataKeterangan.getString(i),
					dataalamat.getString(i)
			);
			listBaju.add(baju);
		}
	}
}