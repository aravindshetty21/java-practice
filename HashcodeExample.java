import java.util.HashMap;

public class HashcodeExample {
    public static void main(String[] args) {
        HashMap<Book, Integer> bookMap = new HashMap<>();

        // Creating some Book objects
        Book book1 = new Book("Java Programming", "John Smith");
        Book book2 = new Book("Python Basics", "Jane Doe");
        Book book3 = new Book("Java Programming", "John Smith");

        // Adding books to the HashMap
        bookMap.put(book1, 100);
        bookMap.put(book2, 150);
        bookMap.put(book3, 200);

        // Retrieving values using Book objects as keys
        System.out.println("Price of " + book1.getTitle() + " by " + book1.getAuthor() + ": " + bookMap.get(book1)); // Output:
                                                                                                                     // Price
                                                                                                                     // of
                                                                                                                     // Java
                                                                                                                     // Programming
                                                                                                                     // by
                                                                                                                     // John
                                                                                                                     // Smith:
                                                                                                                     // 100
        System.out.println("Price of " + book2.getTitle() + " by " + book2.getAuthor() + ": " + bookMap.get(book2)); // Output:
                                                                                                                     // Price
                                                                                                                     // of
                                                                                                                     // Python
                                                                                                                     // Basics
                                                                                                                     // by
                                                                                                                     // Jane
                                                                                                                     // Doe:
                                                                                                                     // 150
        System.out.println("Price of " + book3.getTitle() + " by " + book3.getAuthor() + ": " + bookMap.get(book3)); // Output:
                                                                                                                     // Price
                                                                                                                     // of
                                                                                                                     // Java
                                                                                                                     // Programming
                                                                                                                     // by
                                                                                                                     // John
                                                                                                                     // Smith:
                                                                                                                     // 200
                                                                                                                     // (Note:
                                                                                                                     // Same
                                                                                                                     // as
                                                                                                                     // book1)
    }
}

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        return (title == null ? other.title == null : title.equals(other.title))
                && (author == null ? other.author == null : author.equals(other.author));
    }
}