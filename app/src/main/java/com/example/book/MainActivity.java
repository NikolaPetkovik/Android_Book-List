package com.example.book;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.book.adapter.BookAdapter;
import com.example.book.model.BookModel;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

        List<BookModel> bookList;
        BookAdapter     mAdapter;

        RecyclerView    recyclerView;

        EditText    addTitle,   addAuthor;
        Button      save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        setComponents();
    }

    private void initComponents() {
        bookList     = new ArrayList<>();
        mAdapter     = new BookAdapter(bookList);

        recyclerView = findViewById(R.id.recyclerview_book_ID);

        addTitle     = findViewById(R.id.edit_title);
        addAuthor    = findViewById(R.id.edit_author);
        save         = findViewById(R.id.button_save);
    }

    private void setComponents() {

        // RecyclerView
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        // Add Item (Books)
        bookList.add(new BookModel("Hello Android", "Ed Burnette"));
        bookList.add(new BookModel("Beginning Android 3", "Mark Murphy"));
        bookList.add(new BookModel("Unlocking Android", "W. Frank Ableson"));
        bookList.add(new BookModel("Android Tablet Development", "Wei Meng Lee"));
        bookList.add(new BookModel("Android Apps Security", "Sheran Gunasekera"));

        mAdapter.notifyDataSetChanged();

        // Add Item with Button
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            String title  = addTitle.getText().toString();
            String author = addAuthor.getText().toString();

                if (title.length() == 0) {
                    Toast.makeText(MainActivity.this, "Enter Title", Toast.LENGTH_SHORT).show();

                } else if (author.length() == 0) {
                    Toast.makeText(MainActivity.this, "Enter Author", Toast.LENGTH_SHORT).show();

                } else {
                    bookList.add(new BookModel(title, author));
                    addTitle.setText("");
                    addAuthor.setText("");
                    mAdapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "SAVE", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}


