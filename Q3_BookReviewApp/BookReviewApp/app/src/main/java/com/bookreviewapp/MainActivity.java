package com.bookreviewapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Test our mock data
        List<Book> books = MockDataProvider.getMockBooks();

        // Find the TextView in our layout
        TextView textView = findViewById(R.id.textView);

        // Display first book title to test
        if (!books.isEmpty()) {
            Book firstBook = books.get(0);
            textView.setText("First book: " + firstBook.getTitle() + " by " + firstBook.getAuthor());
        }
    }
}