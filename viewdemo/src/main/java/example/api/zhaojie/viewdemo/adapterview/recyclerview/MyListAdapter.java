package example.api.zhaojie.viewdemo.adapterview.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import example.api.zhaojie.viewdemo.R;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.MyListViewHolder>{
    private String[] mDataset;

    public class MyListViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public MyListViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.listadapter_item_textview);
        }
    }

    public MyListAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    @NonNull
    @Override
    public MyListAdapter.MyListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyclerview_item_textview, viewGroup, false);
        MyListViewHolder mListViewHolder = new MyListViewHolder(v);
        return mListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.MyListViewHolder myListViewHolder, int position) {
        myListViewHolder.mTextView.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }


}
