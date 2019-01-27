package example.api.zhaojie.viewdemo.adapterview.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import example.api.zhaojie.viewdemo.R;
/**
 * 参考：
 * https://developer.android.google.cn/guide/topics/ui/layout/recyclerview#java
 * */
public class RecyclerViewActivity extends Activity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] myDataset = {"a", "b", "c", "d", "e"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.e("viewdemo", "onCreate() recyclerview");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_main);
        mRecyclerView = findViewById(R.id.recycler_view);

        //设置layoutmanager, 使用LinearLayoutManager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //设置Adapter
        mAdapter = new MyListAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }
}
