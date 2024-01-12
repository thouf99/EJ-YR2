import java.util.Arrays;

public class BookMain {
    public static void main(String[] args) {
        BookCollection bCollection = new BookCollection("BookList.csv");
//        System.out.println(bCollection.getAuthors());
//        System.out.println(bCollection.getBookByTitle("Pride and Prejudice"));
//        System.out.println(bCollection.getLongBooks());
        System.out.println(Arrays.toString(bCollection.mostPopular()));
    }
}
