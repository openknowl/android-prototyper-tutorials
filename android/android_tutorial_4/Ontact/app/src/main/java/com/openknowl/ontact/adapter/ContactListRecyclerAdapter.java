package com.openknowl.ontact.adapter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.openknowl.ontact.R;
import com.openknowl.ontact.model.Contact;

import java.util.List;

/**
 * Created by gracefulife on 16. 8. 11.
 */
public class ContactListRecyclerAdapter extends RecyclerView.Adapter<ContactListRecyclerAdapter.ViewHolder> {
    private List<Contact> contactList;

    public ContactListRecyclerAdapter(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_contact, parent, false);
        return new ViewHolder(itemLayout);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        holder.init(contact);
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView avatarImageView;
        TextView nameTextView;
        ImageView outgoingCallImageView;
        Contact contact;

        public ViewHolder(View itemView) {
            super(itemView);
            avatarImageView = (ImageView) itemView.findViewById(R.id.avatarImageView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            outgoingCallImageView = (ImageView) itemView.findViewById(R.id.outgoingCallImageView);
            outgoingCallImageView.setOnClickListener(this);
        }

        public void init(Contact contact) {
            this.contact = contact;
            nameTextView.setText(contact.getName());
        }

        @Override
        public void onClick(View view) {
            Uri uri = Uri.parse("tel:" + contact.getNumber());
            Intent intent = new Intent(Intent.ACTION_DIAL, uri);
            view.getContext().startActivity(intent);
        }
    }
}
