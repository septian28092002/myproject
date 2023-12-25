package com.example.uts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BajuAdapter extends ArrayAdapter {
	private ArrayList<Baju> listBaju;
	Activity context;

	public BajuAdapter(@NonNull Context context, ArrayList<Baju> bajuList) {
		super(context, 0, bajuList);

		this.listBaju = bajuList;
		this.context = (Activity) context;
	}

	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		convertView = inflater.inflate(R.layout.item_list_baju, null);

		listBaju.get(position).quantity = 0;
		listBaju.get(position).total = 0;

		ImageView gambar;
		TextView nama_baju, qty, harga_baju, total_harga,alamat;
		Button btn_add, btn_min,btn_detail;


		gambar = convertView.findViewById(R.id.gambar_baju);
		nama_baju = convertView.findViewById(R.id.nama_baju);
		harga_baju = convertView.findViewById(R.id.harga_baju);
		total_harga = convertView.findViewById(R.id.total_harga);
		btn_add = convertView.findViewById(R.id.btn_add);
		btn_min = convertView.findViewById(R.id.btn_min);
		btn_detail = convertView.findViewById(R.id.btn_detail);
		qty = convertView.findViewById(R.id.qty);
		alamat = convertView.findViewById(R.id.alamat);


		qty.setText(String.valueOf(listBaju.get(position).quantity));

		gambar.setImageResource(listBaju.get(position).gambar);
		nama_baju.setText(listBaju.get(position).nama);
		harga_baju.setText("Rp."+listBaju.get(position).harga);
		total_harga.setText("Rp."+ String.valueOf(listBaju.get(position).total));
		alamat.setText(listBaju.get(position).alamat);

		btn_add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				listBaju.get(position).quantity++;
				qty.setText(String.valueOf(listBaju.get(position).quantity));
				listBaju.get(position).total = Integer.parseInt(listBaju.get(position).harga) * listBaju.get(position).quantity;
				total_harga.setText("Rp."+String.valueOf(listBaju.get(position).total));
			}
		});

		btn_min.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (listBaju.get(position).quantity > 1)
				{
					listBaju.get(position).quantity--;
				}
				else{
					listBaju.get(position).quantity = 0;
				}
				qty.setText(String.valueOf(listBaju.get(position).quantity));
				listBaju.get(position).total = Integer.parseInt(listBaju.get(position).harga) * listBaju.get(position).quantity;
				total_harga.setText("Rp."+String.valueOf(listBaju.get(position).total));

			}
		});

		btn_detail.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(context, DetailBajuActivity.class);
				intent.putExtra("nama",listBaju.get(position).nama);
				intent.putExtra("gambar",listBaju.get(position).gambar);
				intent.putExtra("keterangan",listBaju.get(position).keterangan);
				intent.putExtra("harga",listBaju.get(position).harga);
				context.startActivity(intent);
			}
		});

		return convertView;
	}
}
