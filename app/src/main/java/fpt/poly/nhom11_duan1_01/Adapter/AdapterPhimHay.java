package fpt.poly.nhom11_duan1_01.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


import java.util.ArrayList;

import fpt.poly.nhom11_duan1_01.DTO.DTO_Phim;
import fpt.poly.nhom11_duan1_01.R;

public class AdapterPhimHay extends RecyclerView.Adapter<AdapterPhimHay.ViewHolder> {

    private Context context;
    private ArrayList<DTO_Phim> list;

    public AdapterPhimHay(Context context, ArrayList<DTO_Phim> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_phimhay, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.sosao.setText("" + String.valueOf(list.get(position).getTrungBinhCong()));

        String base64String = list.get(position).getAnh();

        // Giải mã chuỗi Base64 thành mảng byte
        byte[] decodedByteArray = Base64.decode(base64String, Base64.DEFAULT);

        // Chuyển đổi mảng byte thành Bitmap
        Bitmap bitmap = BitmapFactory.decodeByteArray(decodedByteArray, 0, decodedByteArray.length);

        // Hiển thị Bitmap bằng Glide
        Glide.with(context)
                .load(bitmap)
                .into(holder.anh);

        float sao = list.get(position).getTrungBinhCong();
        if (sao == 1) {
            Glide.with(context)
                    .load(R.drawable.img_sao1) // Thay thế R.drawable.anh_sao_1 bằng ID của ảnh tương ứng
                    .into(holder.img_sao);
        } else if (sao == 2) {
            Glide.with(context)
                    .load(R.drawable.img_2sao) // Thay thế R.drawable.anh_sao_2 bằng ID của ảnh tương ứng
                    .into(holder.img_sao);
        }else if (sao == 3) {
            Glide.with(context)
                    .load(R.drawable.img_3sao) // Thay thế R.drawable.anh_sao_2 bằng ID của ảnh tương ứng
                    .into(holder.img_sao);
        }else if (sao == 4) {
            Glide.with(context)
                    .load(R.drawable.img_4sao) // Thay thế R.drawable.anh_sao_2 bằng ID của ảnh tương ứng
                    .into(holder.img_sao);
        }else if (sao == 5) {
            Glide.with(context)
                    .load(R.drawable.img_5sao) // Thay thế R.drawable.anh_sao_2 bằng ID của ảnh tương ứng
                    .into(holder.img_sao);
        } else {
            holder.img_sao.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView anh, img_sao;
        TextView sosao;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            anh = itemView.findViewById(R.id.img_AnhTop5);
            sosao = itemView.findViewById(R.id.txtSaoTop5);
            img_sao = itemView.findViewById(R.id.img_Sao);

        }
    }
}
