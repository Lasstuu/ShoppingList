package main.shoppinglist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingViewHolder> {

    private Context context;
    private ArrayList<Item> items = new ArrayList<Item>();

    public ShoppingListAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ShoppingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShoppingViewHolder(LayoutInflater.from(context).inflate(R.layout.list_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingViewHolder holder, int position) {
        holder.itemName.setText(items.get(position).getName());
        holder.itemInfo.setText(items.get(position).getInfo());
        holder.editText.setText(items.get(position).getName());
        holder.editInfo.setText(items.get(position).getInfo());
        holder.deleteItem.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            ItemList.getInstance().removeItem(items.get(pos).getId());
            notifyItemRemoved(pos);
        });
        holder.editItem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                if(holder.editText.getVisibility() == View.VISIBLE){
                    Item item = ItemList.getInstance().getItemById(pos);
                    item.setName(holder.editText.getText().toString());
                    item.setInfo(holder.editInfo.getText().toString());
                    holder.editInfo.setVisibility(View.GONE);
                    holder.editText.setVisibility(View.GONE);
                    notifyDataSetChanged();
                }
                else {
                    holder.editInfo.setVisibility(View.VISIBLE);
                    holder.editText.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
