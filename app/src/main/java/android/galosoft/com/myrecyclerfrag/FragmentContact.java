package android.galosoft.com.myrecyclerfrag;

import android.galosoft.com.myrecyclerfrag.Adapters.RecyclerViewAdapter;
import android.galosoft.com.myrecyclerfrag.Models.Contact;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentContact extends Fragment {

    View v;
    private RecyclerView recyclerView;
    private List<Contact> contactList;

    public FragmentContact() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.contact_fragment, container, false);
        recyclerView = v.findViewById(R.id.contact_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), contactList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        contactList = new ArrayList<>();
        contactList.add(new Contact("Jose Garcia", "58-27-54-56", R.drawable.uno));
        contactList.add(new Contact("Bruno Garcia", "78-27-54-56", R.drawable.dos));
        contactList.add(new Contact("Angel Garcia", "58-89-54-56", R.drawable.tres));
        contactList.add(new Contact("Alexander Garcia", "58-27-88-56", R.drawable.cuatro));
    }
}
