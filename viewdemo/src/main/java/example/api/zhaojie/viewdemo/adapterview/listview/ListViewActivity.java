package example.api.zhaojie.viewdemo.adapterview.listview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import example.api.zhaojie.viewdemo.R;

public class ListViewActivity extends Activity implements ListView.OnItemClickListener{
    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);

        initLayout();
    }

    private void initLayout() {
        mListView = findViewById(R.id.list_view_main);
        String[] strarr = {"1","2","3","4","5"};
        ArrayAdapter<String> madapter = new ArrayAdapter<String>(
                this, R.layout.support_simple_spinner_dropdown_item, strarr);
        mListView.setAdapter(madapter);

        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
