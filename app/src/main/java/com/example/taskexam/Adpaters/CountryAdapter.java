package com.example.taskexam.Adpaters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.taskexam.Model.Country;
import com.example.taskexam.R;

import java.net.URI;
import java.util.List;

import retrofit2.http.Url;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

   private List<Country> countriesList;
   OnItemClickListiner mListener;
   private Context context;

    public CountryAdapter(List<Country> countries){

        this.countriesList = countries;

    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.country_row,parent,false);
        return new CountryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {

        Country country = countriesList.get(position);


        holder.bind(country);



    }

    @Override
    public int getItemCount() {
        return countriesList.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder{

        TextView tv_country_name;
        TextView tv_region_name;
        ImageView iv_flagImageView;


        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_country_name = itemView.findViewById(R.id.tv_country_name);
            tv_region_name = itemView.findViewById(R.id.tv_region_name);
            iv_flagImageView = itemView.findViewById(R.id.iv_flagImageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListener != null ){

                        mListener.onItemClick(countriesList.get(getAdapterPosition()));
                    }


                }
            });
        }

        public void bind(Country country){
            tv_country_name.setText(country.getName());
            tv_region_name.setText(country.getRegion());
//            URI url = new URI("http://www.geognos.com/api/en/countries/flag/"+ country.getId() +".png");
            Glide.with(context).load(url)
                    .apply(RequestOptions.centerCropTransform())
                    .into(iv_flagImageView);


        }


    }
    public OnItemClickListiner onItemClickListiner( OnItemClickListiner clickListiner){

        mListener = clickListiner;
        return mListener;



    }

    public interface OnItemClickListiner{

        void onItemClick(Country country);

    }


}
