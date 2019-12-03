package android.galosoft.com.myrecyclerfrag.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.galosoft.com.myrecyclerfrag.Models.Contact;
import android.galosoft.com.myrecyclerfrag.R;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context context;
    List<Contact> contacts;
    Dialog myDialog;

    public RecyclerViewAdapter(Context context, List<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.item_contact, viewGroup, false);
        final MyViewHolder viewHolder = new MyViewHolder(v);

        //dialog init
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.dialog_contact);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        viewHolder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dialog_name = myDialog.findViewById(R.id.dialog_name_id);
                TextView dialog_phone = myDialog.findViewById(R.id.dailog_phone_id);
                ImageView dialog_contact_img = myDialog.findViewById(R.id.dialog_img);

                dialog_name.setText(contacts.get(viewHolder.getAdapterPosition()).getName());
                dialog_phone.setText(contacts.get(viewHolder.getAdapterPosition()).getPhone());
                dialog_contact_img.setImageResource(contacts.get(viewHolder.getAdapterPosition()).getPhoto());

                Toast.makeText(context, "Test click " + String.valueOf(viewHolder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
                myDialog.show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.tv_name.setText(contacts.get(i).getName());
        myViewHolder.tv_phone.setText(contacts.get(i).getPhone());
        myViewHolder.img.setImageResource(contacts.get(i).getPhoto());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout item_contact;
        private TextView tv_name;
        private TextView tv_phone;
        private ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_contact = itemView.findViewById(R.id.contact_item_id);
            tv_name = itemView.findViewById(R.id.name_contact);
            tv_phone = itemView.findViewById(R.id.phone_contact);
            img = itemView.findViewById(R.id.img_contact);
        }
    }
}
