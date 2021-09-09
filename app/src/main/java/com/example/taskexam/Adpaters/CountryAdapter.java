package com.example.taskexam.Adpaters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.taskexam.Model.Country;
import com.example.taskexam.R;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import retrofit2.http.Url;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

   private List<Country> countriesList;
   private OnItemClickListiner mListener;
   private Context context;
   private String url;
   private List<Country> copyList;

    public CountryAdapter(List<Country> countries){


        this.countriesList = countries;
        copyList = new ArrayList<>(countries);

    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();
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

//    @Override
//    public Filter getFilter() {
//        return filter;
//    }
//    private Filter filter = new Filter() {
//        @Override
//        protected FilterResults performFiltering(CharSequence charSequence) {
//            List<Country> filterdList =new ArrayList<>();
//
//            if(charSequence == null || charSequence.length() == 0){
//                filterdList.addAll(countriesList);
//            }else {
//                String filterPattern = charSequence.toString().toLowerCase().trim();
//
//                for (Country country : copyList){
//                    if(country.getName().toLowerCase().contains(filterPattern)){
//                        filterdList.add(country);
//                    }
//                }
//
//            }
//            FilterResults results = new FilterResults();
//            results.values = filterdList;
//
//            return results;
//        }
//
//        @Override
//        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
//            countriesList.clear();
//            countriesList.addAll((List)filterResults.values);
//            notifyDataSetChanged();
//
//
//
//
//
//        }
//    };

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
            url = "http://www.geognos.com/api/en/countries/flag/"+country.getId()+".png";
            country.setImageFlag(url);


            Glide.with(context).load(url)
                    .placeholder(R.drawable.ic_launcher_background)
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
