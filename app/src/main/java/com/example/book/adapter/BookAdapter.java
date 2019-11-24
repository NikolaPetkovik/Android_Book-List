package com.example.book.adapter;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.book.model.BookModel;
import com.example.book.R;
import java.util.List;


public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>{

    private List<BookModel> bookList;
        // Constructor
        public BookAdapter(List<BookModel> bookList){
            this.bookList = bookList;
        }


    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // Layout Inflater
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_book, viewGroup, false);
        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final BookViewHolder bookViewHolder, final int position) {

        bookViewHolder.title.setText(bookList.get(position).getTitle());
        bookViewHolder.author.setText(bookList.get(position).getAuthor());

        // OnLongClickListener (Remove Item (Books))
        bookViewHolder.rootLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Toast.makeText(v.getContext(), "DELETE", Toast.LENGTH_SHORT).show();

            bookList.remove(position);
            notifyDataSetChanged();
            return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }


    // ViewHolder -- RecyclerView
    public class BookViewHolder extends RecyclerView.ViewHolder {
            TextView         title, author;
            ConstraintLayout rootLayout;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            title       =   itemView.findViewById(R.id.textView_title_ID);
            author      =   itemView.findViewById(R.id.textView_author_ID);

            rootLayout  =   itemView.findViewById(R.id.root_layout);
        }
    }

}
