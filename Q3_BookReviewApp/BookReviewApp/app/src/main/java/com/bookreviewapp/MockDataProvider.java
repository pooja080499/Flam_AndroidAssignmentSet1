package com.bookreviewapp;

import java.util.ArrayList;
import java.util.List;

public class MockDataProvider {

    public static List<Book> getMockBooks() {
        List<Book> books = new ArrayList<>();

        books.add(new Book(
                1,
                "The Great Gatsby",
                "F. Scott Fitzgerald",
                "A classic American novel set in the Jazz Age, exploring themes of wealth, love, and the American Dream. Follow Jay Gatsby's pursuit of the elusive Daisy Buchanan in this timeless tale of obsession and tragedy.",
                "placeholder",
                4.2,
                false
        ));

        books.add(new Book(
                2,
                "To Kill a Mockingbird",
                "Harper Lee",
                "A gripping tale of racial injustice and childhood innocence in the American South. Through the eyes of Scout Finch, witness her father Atticus defend a black man falsely accused of rape.",
                "placeholder",
                4.5,
                false
        ));

        books.add(new Book(
                3,
                "1984",
                "George Orwell",
                "A dystopian novel about totalitarianism and surveillance in a future society. Winston Smith struggles against Big Brother's oppressive regime in this chilling vision of a world without freedom.",
                "placeholder",
                4.3,
                false
        ));

        books.add(new Book(
                4,
                "Pride and Prejudice",
                "Jane Austen",
                "A romantic novel about love, marriage, and social class in 19th century England. Follow Elizabeth Bennet and Mr. Darcy's complicated relationship in this beloved classic.",
                "placeholder",
                4.1,
                false
        ));

        books.add(new Book(
                5,
                "The Catcher in the Rye",
                "J.D. Salinger",
                "A coming-of-age story following Holden Caulfield through New York City. This controversial novel explores themes of alienation, rebellion, and the loss of innocence.",
                "placeholder",
                3.9,
                false
        ));

        books.add(new Book(
                6,
                "Lord of the Rings",
                "J.R.R. Tolkien",
                "An epic fantasy adventure following Frodo Baggins on his quest to destroy the One Ring. Join hobbits, elves, and men in the ultimate battle between good and evil in Middle-earth.",
                "placeholder",
                4.6,
                false
        ));

        return books;
    }
}
