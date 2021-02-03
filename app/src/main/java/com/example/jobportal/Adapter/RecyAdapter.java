//package com.example.jobportal.Adapter;
//
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.example.jobportal.Aactivities.Recy;
//import com.example.jobportal.R;
//
//import java.util.ArrayList;
//
//public class RecyAdapter  extends RecyclerView.Adapter<RecyAdapter.ExampleViewHolder> {
//    private ArrayList<Recy> mExampleList;
//    private OnItemClickListener mListener;
//    public interface OnItemClickListener {
//        void onItemClick(int position);
//    }
//    public void setOnItemClickListener(OnItemClickListener listener) {
//        mListener = listener;
//    }
//    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
//
//        public TextView mTextView1;
//        public TextView mTextView2;
//        public TextView mTextView3;
//        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
//            super(itemView);
//
//            mTextView1 = itemView.findViewById(R.id.editEmail);
//            mTextView2 = itemView.findViewById(R.id.editEm);
//            mTextView3 = itemView.findViewById(R.id.editEma);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (listener != null) {
//                        int position = getAdapterPosition();
//                        if (position != RecyclerView.NO_POSITION) {
//                            listener.onItemClick(position);
//                        }
//                    }
//                }
//            });
//        }
//    }
//    public RecyAdapter(ArrayList<Recy> exampleList) {
//        mExampleList = exampleList;
//    }
//    @Override
//    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.comman_item,parent, false);
//        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
//        return evh;
//    }
//    @Override
//    public void onBindViewHolder(ExampleViewHolder holder, int position) {
//        Recy currentItem = mExampleList.get(position);
//
//        holder.mTextView1.setText(currentItem.getText1());
//        holder.mTextView2.setText(currentItem.getText2());
//        holder.mTextView2.setText(currentItem.getText3());
//    }
//    @Override
//    public int getItemCount() {
//        return mExampleList.size();
//    }
//}
