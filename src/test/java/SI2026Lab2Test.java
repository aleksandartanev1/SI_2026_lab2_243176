import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SI2026Lab2Test {

    @Test
    public void searchBookEveryStatementTest() {
        Library library = new Library();

        library.addBook(new Book("Java", "Marko", "Programming"));
        library.addBook(new Book("Python", "Ana", "Programming"));

        // книга постои
        List<Book> result1 = library.searchBookByTitle("Java");
        assertNotNull(result1);
        assertEquals(1, result1.size());

        // книга не постои
        List<Book> result2 = library.searchBookByTitle("C++");
        assertNull(result2);

        // празен title
        assertThrows(IllegalArgumentException.class, () -> {
            library.searchBookByTitle("");
        });
    }

    @Test
    public void borrowBookEveryBranchTest() {
        Library library = new Library();

        library.addBook(new Book("Java", "Marko", "Programming"));

        // success branch
        library.borrowBook("Java", "Marko");

        // already borrowed branch
        assertThrows(RuntimeException.class, () -> {
            library.borrowBook("Java", "Marko");
        });

        // not found branch
        assertThrows(RuntimeException.class, () -> {
            library.borrowBook("Python", "Ana");
        });

        // invalid input branch
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "Marko");
        });
    }

    @Test
    public void searchBookMultipleConditionTest() {
        Library library = new Library();

        Book b1 = new Book("Java", "Marko", "Programming"); // T,T
        Book b2 = new Book("Java", "Ana", "Programming");   // T,F
        b2.setBorrowed(true);

        Book b3 = new Book("Python", "Ana", "Programming"); // F,T

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        List<Book> result = library.searchBookByTitle("Java");

        assertNotNull(result);
        assertEquals(1, result.size());

        Book b4 = new Book("C++", "Ivan", "Programming"); // F, F
        b4.setBorrowed(true);
        library.addBook(b4);
    }

    @Test
    public void borrowBookMultipleConditionTest() {
        Library library = new Library();

        // T,T
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "");
        });

        // T,F
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "Marko");
        });

        // F,T
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("Java", "");
        });

        // F,F
        library.addBook(new Book("Java", "Aleksandar", "Programming"));
        assertDoesNotThrow(() -> {
            library.borrowBook("Java", "Aleksandar");
        });
    }
}