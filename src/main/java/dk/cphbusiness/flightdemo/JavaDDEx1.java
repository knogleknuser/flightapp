package dk.cphbusiness.flightdemo;

import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaDDEx1
{
    
    public static void main( String[] args )
    {
        List< Book > books = Arrays.asList(
                new Book( "title1", "author1", 1999, 10, 1 ),
                new Book( "title2", "author1", 1992, 10023, 1 ),
                new Book( "title3", "author9", 1999, 99, 5 ),
                new Book( "title4", "author8", 1992, 1010, 4 ),
                new Book( "title5", "author3", 1999, 10434, 2 ),
                new Book( "title6", "author6", 1994, 100, 1 ),
                new Book( "title7", "author2", 1996, 105, 2 ),
                new Book( "title1", "author3", 1997, 102, 3 ),
                new Book( "title8", "author2", 1998, 1, 5 ),
                new Book( "title9", "author1", 2199, 150, 4 )
                                          );
        
        //Find the average rating of all books.
        System.out.println();
        System.out.println( "Average Rating" );
        System.out.println( books.stream()
                                    .mapToInt( book -> book.rating )
                                    .average()
                          );

//        Filter and display books published after a specific year.
        System.out.println();
        System.out.println( "After year" );
        System.out.println( books.stream()
                                    .filter( book -> book.publicationYear > 1999 )
                                    .toList()
                          );

//        Sort books by rating in descending order.
        System.out.println();
        System.out.println( "Rating Descending order" );
        System.out.println( books.stream()
                                    .sorted( ( book1, book2 ) -> book2.rating - book1.rating() )
                                    .toList()
                          );

//        Find and display the title of the book with the highest rating.
        System.out.println();
        System.out.println( "Max Rated Book Title" );
        
        System.out.println( books.stream()
                                    .max( ( book1, book2 ) -> book2.rating - book1.rating() )
                                    .get()
                                    .title );


//        Group books by author and calculate the average rating for each author’s books.
        System.out.println();
        System.out.println( "Average ratings pr author" );
        
        books.stream()
                .collect( Collectors.groupingBy( book -> book.author ) )
                .forEach( ( author, books1 ) -> {
                    System.out.print( author + " " );
                    System.out.println( books1.stream().mapToInt( book -> book.rating ).average() );
                } );



//        Calculate the total number of pages for all books (assuming each book has a fixed number of pages).
        System.out.println();
        System.out.println( "Total number of pages" );
        
        System.out.println( books.stream()
                                    .mapToInt( book -> book.pages )
                                    .sum()
                          );
        
        
    }
    
    record Book( String title, String author, int publicationYear, int pages, int rating )
    {
        
        @Override
        public String toString()
        {
            return "Book{" +
                   "title='" + this.title + '\'' +
                   ", author='" + this.author + '\'' +
                   ", publicationYear=" + this.publicationYear +
                   ", pages=" + this.pages +
                   ", rating=" + this.rating +
                   '}';
        }
        
    }
    
    
}
