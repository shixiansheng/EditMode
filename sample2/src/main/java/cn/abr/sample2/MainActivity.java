package cn.abr.sample2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strings.add(i+"");
        }
        final Button button = findViewById(R.id.button);

        RecyclerView rlv = (RecyclerView) findViewById(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(strings);
        rlv.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button.getText().equals("编辑"))
                {
                    button.setText("取消");
                    adapter.setEdit(true);
                }
                else if (button.getText().equals("取消")){
                    button.setText("编辑");
                    adapter.setEdit(false);
                }
            }
        });
    }


}
