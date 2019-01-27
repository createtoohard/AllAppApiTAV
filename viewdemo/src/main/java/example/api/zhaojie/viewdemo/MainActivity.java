package example.api.zhaojie.viewdemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button mListViewButton;
    private Button mRecyclerViewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.list_view_button:
                Intent ListViewIntent = new Intent();
                ListViewIntent.setAction("show_listview");
                startActivity(ListViewIntent);
                break;
            case R.id.recyler_view_button:
                Log.e("viewdemo", "startRecyclerView");
                Intent RecyclerViewIntent = new Intent();
                RecyclerViewIntent.setAction("show_recyclerview");
                startActivity(RecyclerViewIntent);
                break;
        }

    }

    private void initLayout() {
        mListViewButton = findViewById(R.id.list_view_button);
        mListViewButton.setOnClickListener(this);

        mRecyclerViewButton = findViewById(R.id.recyler_view_button);
        mRecyclerViewButton.setOnClickListener(this);
    }
}
