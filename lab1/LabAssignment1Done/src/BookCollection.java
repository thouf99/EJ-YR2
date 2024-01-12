import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class BookCollection {
    private final ArrayList<Book> books = new ArrayList<>();

    @Override
    public String toString() {
        return "BookCollection{" +
                "Books=" + books +
                '}';
    }

    //2, complete constructor that takes a string path (the BookList file name) load the books from BookList into the books arrayList
    //When complete books should have 100 items. Make sure you don't include the header row!
    BookCollection(String path) {
        //loads the file
        File file = new File("BookList.csv");
        //scanner to read in the file and manipulate information
        Scanner in;
        try {
            //reads in the file
            in = new Scanner(file);
            //gets rid of the header from the csv file
            String[] headers = in.nextLine().split(",");
            while (in.hasNextLine()) {
                //when the scanner reads the next line to split each part with a comma
                String[] row = in.nextLine().split(",");
                //book constructor that initializes a new book and holds information from the index of the row array
                //then parse some information as some are in their natural type of either string or integer and we need to convert them
                //to type string or long.
                //E.g. parsing long values for isbn and integer values for copies of books.
                /*This is the constructor for book and each index of row populates this information and
                 * when the while loop enters the next line that new line gets put into the row array and adds that information*/
                Book b = new Book(row[0], row[1], Integer.parseInt(row[5]),
                        Long.parseLong(row[2]), Integer.parseInt(row[3]), Integer.parseInt(row[4]));

                //adds type book to the array list and then looks at the next line. And will eventually stop once there
                //is no nextLine to read.
                books.add(b);
            }
            //closes the file after being loaded in.
            in.close();
        }
        //Catches the file not found if the csv filename changes
        catch (FileNotFoundException e) {
                e.printStackTrace();
        }
    }


    //3, Return a HashSet of all the authors in the book list
    public HashSet<String> getAuthors() {

        //hashset of Authors
        HashSet<String> n = new HashSet<String>();
        File file = new File("BookList.csv");
        Scanner in;
        try {
            //scanner reads in the file
            in = new Scanner(file);
            //gets rid of the firs line of the file
            String[] headers = in.nextLine().split(",");
            while (in.hasNextLine()) {
                //looks at each row and adds that to the hashset but only of the authors in each row
                String[] row = in.nextLine().split(",");
                //adds authors from index 1 from each row
                n.add(row[1]);
            }
            //closes the file
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //returns the hashset of authors.
        return n;
    }

    //4, return an arrayList of books with more than 750 pages
    public ArrayList<Book> getLongBooks() {
        //arralist of type Book
        ArrayList<Book> b = new ArrayList<Book>();
        File file = new File("BookList.csv");
        Scanner in;
        try {
            //loads in the file
            in = new Scanner(file);
            //gets rid of the firstline of the file
            String[] headers = in.nextLine().split(",");
            while (in.hasNextLine()) {
                //looking at each row of the file
                String[] row = in.nextLine().split(",");
                //new book constructor on what information it will hold
                Book t = new Book(row[0], row[1], Integer.parseInt(row[5]),
                        Long.parseLong(row[2]), Integer.parseInt(row[3]), Integer.parseInt(row[4]));
                //looking at each book and checking row 3 for any book that has above 750 pages
                //and adding those to the arraylist only.
                if (t.getPages() >= 750) {
                    b.add(t);
                }
            }
            //closes the file after being opened
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //returns ArrayList of Book
        return b;
    }

    //5, return the book if the given title is in the list.
    public Book getBookByTitle(String title) {

        ArrayList<Book> t = new ArrayList<Book>();
        File file = new File("BookList.csv");
        Scanner in;
        try {
            in = new Scanner(file);
            String[] headers = in.nextLine().split(",");
            while (in.hasNextLine()) {
                String[] row = in.nextLine().split(",");
                Book m = new Book(row[0], row[1], Integer.parseInt(row[5]),
                        Long.parseLong(row[2]), Integer.parseInt(row[3]), Integer.parseInt(row[4]));
                // if the title that is entered is equal to any in the books array list then
                //return that book otherwise return null as it is not in the list
                if (title.equals(m.getTitle())) {
                    return m;
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //return null if there are no books with the same title.
        return null;
    }

    //6, return an array of the 10 most popular books (That is those that currently have most copies on loan)
    public Book[] mostPopular() {
        //Array of Book b will hold all information from the list of Book which is an arraylist
        Book[] b = {};
        //Array of Book c will hold only the first 10 popular books
        Book[] c = new Book[10];
        //List to hold all the book from the highest number of books on loan to the least.
        List<Book> a = new ArrayList();
        File file = new File("BookList.csv");
        Scanner in;
        try {
            in = new Scanner(file);
            String[] headers = in.nextLine().split(",");
            while (in.hasNextLine()) {
                String[] row = in.nextLine().split(",");
                Book t = new Book(row[0], row[1], Integer.parseInt(row[5]),
                        Long.parseLong(row[2]), Integer.parseInt(row[3]), Integer.parseInt(row[4]));
                a.add(t);
                //Takes the list and sorts them in descending order where the most copiesonloan is at the start and the
                //lowest is as the bottom.
                //This is by using the comparator class at the bottom comparing each book based on copies on loan
                //and which ever is higher is at the start and lowest at the bottom
                for (int i = 0; i < a.size(); i++) {
                    a.sort(new SortbyCopiesOnLoan());

                }
                //converting the list to an array to then return that Book array
                b = a.toArray(b);
            }
            //goes through the first 10 elements and make each iteration of
            //Book array c at index j be equal to the index of the list and
            for (int j = 0; j<10;j++){
                c[j] = (a.get(j));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //return the Book array c of only 10 elements
        return c;
    }

    class SortbyCopiesOnLoan implements Comparator<Book> {

        // Method
        // Sorting in descending order of CopiesOnLoan number
        public int compare(Book a, Book b) {
            return b.getCopiesOnLoan() - a.getCopiesOnLoan();
        }
    }

}
