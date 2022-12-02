package com.example.finalpro;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> implements Filterable {

    private List<ItemModel> mDataList;
    private List<ItemModel> mDataListAll;

    //constructor
    public ItemAdapter(List<ItemModel> items) {
        mDataList = items;
        mDataListAll = new ArrayList<>(items);
    }

    //interface - 클릭인터페이스
    private onItemListener mListener;
    public void setOnClickListener(onItemListener listener){
        mListener = listener;
    }

    //data set changed
    public void dataSetChanged(List<ItemModel> exampleList) {
        mDataList = exampleList;
        notifyDataSetChanged();
    }

    //1.onCreateViewHolder -------------------------------------------------------
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,
                parent, false);
        return new ItemViewHolder(v);
    }

    //2.onBindViewHolder  -------------------------------------------------------
    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ItemModel currentItem = mDataList.get(position);
        // TODO : 데이터를 뷰홀더에 표시하시오

        holder.textView1.setText(currentItem.getText1());


        // TODO : 리스너를 정의하시오.
        if (mListener != null){
            final int pos = position;
            //final ItemModel item = mItems.get(viewHolder.getAdapterPosition());
            holder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    mListener.onItemClicked(position);
//                    mListener.onItemClicked(item);
                }
            });
            //버튼등에도 동일하게 지정할 수 있음 holder.버튼이름.setOnClickListener..형식으로
        }
    }

    //3.getItemCount  -------------------------------------------------------
    @Override
    public int getItemCount() {
        return mDataList.size();
    }


    // 데이터 필터 검색 Filterable implement ---------------------------------
    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        //Automatic on background thread
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ItemModel> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mDataListAll);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (ItemModel item : mDataListAll) {
                    //TODO filter 대상 setting
                    if (item.getText1().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        //Automatic on UI thread
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mDataList.clear();
            mDataList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    // 뷰홀더 클래스  ---------------------------------
    class ItemViewHolder extends RecyclerView.ViewHolder {
        // TODO : 뷰홀더 완성하시오

        TextView textView1;


        ItemViewHolder(View itemView) {
            super(itemView);
            // TODO : 뷰홀더 완성하시오

            textView1 = itemView.findViewById(R.id.text_view1);

        }
    }

    //onclick listener interface
    //1. interface onItemListener 선언
    //2. 내부에서 mListener 선언하고
    // 외부에서 접근가능하도록 setOnClickListener작성
    //3.onBindViewHolder에서 처리
    public interface onItemListener {
        void onItemClicked(int position);
        //void onItemClicked(ItemModel model); 모델값을 넘길수 있음
        //다른버튼도 정의할 수 있음 onShareButtonClicked(int position);
    }
}