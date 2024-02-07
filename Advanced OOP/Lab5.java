import java.util.*;
// UML WITH SUBMISSION

abstract class Item {

    protected String title;

    public Item() {
        title = "";
    }
    
    public Item(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return title;
    }

    public abstract String getListing();

}

class Book extends Item {

    private String author;
    private int isbn_number;

    public Book() {
        super();
    }

    public Book(String title, String author, int isbn_number) {
        super();
        this.author = author;
        this.isbn_number = isbn_number;
    }
    
    public int getISBN() {
        return isbn_number;
    }

    public void setISBN(int isbn_number) {
        this.isbn_number = isbn_number;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getListing() {
        return "Book Name - "+getTitle()
            +"\nAuthor - "+author
            +"\nIssue # - "+isbn_number;
    }

}

class Periodicals extends Item {

    private int issue_num;

    public Periodicals() {
        super();
    }

    public Periodicals(String title, int issue_num) {
        super();
        this.issue_num = issue_num;
    }

    public void setIssue(int issue_num) {
        this.issue_num = issue_num;
    }

    public int getIssue() {
        return issue_num;
    }

    public String getListing() {
        return "Periodical Title - "+getTitle()
            +"\nIssue # - "+issue_num;
    }

}

class myCollection {

    private ArrayList<Item> collection = new ArrayList<Item>();

    public void addItem(Item new_item) {
        collection.add(new_item);
    }

    public void present() {
        for (Item x : collection) {
            System.out.println(x.getListing()+'\n');
        }
    }
}

public class Lab5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        myCollection collection = new myCollection(); // myCollection?
        String title, author;
        int number;
        
        for (int i = 0; i < 1; i++) {
            System.out.println("Please enter B for Book or P for Periodical");
            
            switch (input.nextLine().charAt(0)) {
                case 'b':
                case 'B':
                    System.out.println("Please enter the name of the Book");
                    title = input.nextLine();
                    System.out.println("Please enter the author of the Book");
                    author = input.nextLine();
                    System.out.println("Please enter the ISBN of the Book");
                    number = input.nextInt();
                    input.nextLine();

                    Item new_book = new Book(title, author, number);
                    collection.addItem(new_book);
                    break;

                case 'p':
                case 'P':
                    System.out.println("Please enter the name of the Periodical");
                    title = input.nextLine();
                    System.out.println("Please enter the issue number");
                    number = input.nextInt();
                    input.nextLine();

                    Item new_period = new Periodicals(title, number);
                    collection.addItem(new_period);
                    break; 
            }
        }

        System.out.println("Your Items:");
        collection.present();
        input.close();

    }
}
