public class Book {
    private String title;
    private String author;
    private int CopiesOnLoan;
    private long isbn;
    private int pages;
    private int copiesInCollection;


//1, complete this class with a constructor that has arguments for all the properties
    //and, getters and setters for each of them
    public Book(String title, String author, int copiesOnLoan, long isbn, int pages, int copiesInCollection) {
        this.title = title;
        this.author = author;
        CopiesOnLoan = copiesOnLoan;
        this.isbn = isbn;
        this.pages = pages;
        this.copiesInCollection = copiesInCollection;
    }

    @Override
    public String toString() {
        return title +
                "' author='" + author + '\'' +
                ", CopiesOnLoan=" + CopiesOnLoan +
                ", isbn=" + isbn +
                ", pages=" + pages +
                ", copiesInCollection=" + copiesInCollection +
                "}\"\n\"";
    }

    //getters and setters for each variable of book
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getCopiesInCollection() {
        return copiesInCollection;
    }

    public void setCopiesInCollection(int copiesInCollection) {
        this.copiesInCollection = copiesInCollection;
    }

    public int getCopiesOnLoan() {
        return CopiesOnLoan;
    }

    public void setCopiesOnLoan(int copiesOnLoan) {
        CopiesOnLoan = copiesOnLoan;
    }


}
