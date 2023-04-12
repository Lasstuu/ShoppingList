package main.shoppinglist;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;

public class AddItemActivity extends AppCompatActivity {
    private Context context;
    private int id = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
    }

    public void addItem(View view) {

        TextView tvItemName = findViewById(R.id.etItemName);
        TextView tvItemInfo = findViewById(R.id.etItemInfo);
        ItemList.getInstance().addItem(new Item(tvItemName.getText().toString(),tvItemInfo.getText().toString(),id));
        id++;

    }
}