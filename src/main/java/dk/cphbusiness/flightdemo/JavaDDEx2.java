package dk.cphbusiness.flightdemo;

import java.util.*;
import java.util.stream.Collectors;

public class JavaDDEx2
{
    
    public static void main( String[] args )
    {
        List< Transaction > transactions = Arrays.asList(
                new Transaction( 0, 10000, "OERE" ),
                new Transaction( 1, 15000, "OERE" ),
                new Transaction( 2, 10500, "OERE" ),
                new Transaction( 3, 10050, "OERE" ),
                new Transaction( 4, 10005, "OERE" ),
                new Transaction( 5, 50000, "EUR" ),
                new Transaction( 6, 55000, "USD" ),
                new Transaction( 7, 50500, "DKK" ),
                new Transaction( 8, 50050, "YEN" ),
                new Transaction( 9, 50005, "OERE" )
                                                        );


//        Calculate the total sum of all transaction amounts.
        int sumTransactions = transactions.stream()
                .mapToInt( transaction -> transaction.amount )
                .sum();
        
        System.out.println();
        System.out.println( "Sum Transactions" );
        System.out.println( sumTransactions );

//        Group transactions by currency and calculate the sum of amounts for each currency.
        Map< String, Integer > sumByCurrency = transactions.stream()
                .collect( Collectors.groupingBy( transaction -> transaction.currency, Collectors.summingInt( transaction -> transaction.amount ) ) );
        
        System.out.println();
        System.out.println( "Sum By Currency" );
        System.out.println( sumByCurrency );


//        Find the highest transaction amount.
        OptionalInt highestTransactionAmount= transactions.stream()
                .mapToInt( transaction -> transaction.amount )
                .max();
        
        System.out.println();
        System.out.println( "Highest Transaction Amount" );
        System.out.println( highestTransactionAmount );

//        Find the average transaction amount.
        OptionalDouble averageTransactionAmount = transactions.stream()
                .mapToInt( transaction -> transaction.amount )
                .average();
        
        System.out.println();
        System.out.println( "Average Transaction Amount" );
        System.out.println( averageTransactionAmount );


//        2.4 Collecting Results:
//        Use the collect method with different Collectors to aggregate and collect the results of your operations.
    
        
    }
    
    record Transaction( int id, int amount, String currency )
    {
        
        @Override
        public String toString()
        {
            return "Transaction{" +
                   "id=" + this.id +
                   ", amount=" + this.amount +
                   ", oere=" + this.currency +
                   '}';
        }
        
    }
    
    
}
