package demo.ykq.com.design;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolBar;
    private RecyclerView recycleView;
    private RecycleViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolBar= (Toolbar) findViewById(R.id.toolBar);
        recycleView= (RecyclerView) findViewById(R.id.recycleView);
        toolBar.setTitle("标题");
        setSupportActionBar(toolBar);

        adapter=new RecycleViewAdapter();
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.setItemAnimator(new DefaultItemAnimator());
        recycleView.setAdapter(adapter);
        recycleView.getAdapter().notifyItemChanged(2);

        View btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.add();
                adapter.notifyItemChanged(2);
            }
        });
    }

    class RecycleViewAdapter extends RecyclerView.Adapter<MyViewHolder>{
        private int dataCount=10;
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_recycle_item,parent,false));
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
//            holder.tv.setHint("位置:"+position);
            holder.textView.setText(""+position);
        }

        @Override
        public int getItemCount() {
            return dataCount;
        }

        public void add()
        {
            dataCount++;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private AppCompatAutoCompleteTextView tv;
        private TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
//            tv= (AppCompatAutoCompleteTextView) itemView.findViewById(R.id.tv);
            textView= (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
