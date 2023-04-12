package main.shoppinglist;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ShoppingViewHolder extends RecyclerView.ViewHolder {
    ImageView deleteItem, editItem;
    TextView itemName, itemInfo, editText,editInfo;

    public ShoppingViewHolder(@NonNull View itemView) {
        super(itemView);
        itemName = itemView.findViewById(R.id.tvItemName);
        editText = itemView.findViewById(R.id.tvEditText);
        editInfo = itemView.findViewById(R.id.tvEditInfo);
        itemInfo = itemView.findViewById(R.id.tvItemInfo);
        deleteItem = itemView.findViewById(R.id.ivDeleteItem);
        editItem = itemView.findViewById(R.id.ivEdit);
        
    }
}
