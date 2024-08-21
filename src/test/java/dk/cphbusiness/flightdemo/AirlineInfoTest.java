package dk.cphbusiness.flightdemo;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AirlineInfoTest
{
    
    private static FlightReader reader = new FlightReader();
    
    private static List< DTOs.FlightDTO > flightList;
    private static List< DTOs.FlightInfo > flightInfoList;
    
    private static AirlineFacts airlineFacts;
    
    @BeforeAll
    static void beforeAll()
    {
        try {
            flightList = reader.getFlightsFromFile( "flights.json" );
            
        } catch ( IOException e ) {
            throw new RuntimeException( e );
        }
        
        flightInfoList = reader.getFlightInfoDetails( flightList );
        
        airlineFacts = new AirlineFacts( flightInfoList );
    }
    
    @BeforeEach
    void setUp()
    {
    }
    
    @AfterEach
    void tearDown()
    {
    }
    
    @Test
    @DisplayName( "Airline Set" )
    void airlineSet()
    {
        System.out.println();
        System.out.println( "-----AIRLINE SET-----" );
        
        Set< String > airlines = airlineFacts.getAirlinesSet();
        
        System.out.println( airlines );
    }
    
    @Test
    @DisplayName( "Airline Set" )
    void pickOutRelevantAirlines()
    {
        List< DTOs.FlightInfo > relevantAirlines;
        
        String testString1;
        String testString2;
        
        System.out.println();
        System.out.println( "-----AIRLINE SET-----" );
        
        Set< String > airlines = airlineFacts.getAirlinesSet();
        
        testString1 = "China Airlines";
        relevantAirlines = airlineFacts.filterOutRelevantAirlines( testString1 );
        
        assertEquals( testString1, relevantAirlines.get( 0 ).getAirline() );
        assertEquals( 50, relevantAirlines.size() );
        
        testString2 = "ANA";
        relevantAirlines = airlineFacts.filterOutRelevantAirlines( testString1, testString2 );
        
        assertEquals( testString2, relevantAirlines.get( 0 ).getAirline() );
        assertEquals( testString1, relevantAirlines.get( 300 ).getAirline() );
        assertEquals( 313, relevantAirlines.size() );
        
        System.out.println( airlines );
    }
    
    @Test
    @DisplayName( "Average Airline Flight Time" )
    void averageFlightTime()
    {
        System.out.println();
        System.out.println( "-----AVERAGE FLIGHT TIME-----" );
        
        Set< String > airlines = airlineFacts.getAirlinesSet();
        
        Map< String, Duration > averageFlightTime = airlineFacts.calcAverageFlightDuration( airlines.toArray( new String[ 0 ] ) );
        
        averageFlightTime.forEach( ( k, v ) -> {
            System.out.println( k + " " + v.toSeconds() + " s" );
        } );
        
    }
    
    @Test
    @DisplayName( "Total Airline Flight Time" )
    void totalFlightTime()
    {
    }
    
    
    
    
    
    
    
}
