package dk.cphbusiness.flightdemo;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class AirlineFacts
{
    
    private List< DTOs.FlightInfo > flightInfoList;
    
    private final Set< String > airlinesSet = new TreeSet<>();
    
    public AirlineFacts( List< DTOs.FlightInfo > flightInfoList )
    {
        this.flightInfoList = flightInfoList;
        
        this.calcAirlines( flightInfoList );
    }
    
    private void calcAirlines( List< DTOs.FlightInfo > flightInfoList )
    {
        if ( flightInfoList == null ) {
            System.err.println( "Flight info was null" );
            return;
        }
        
        this.airlinesSet.clear();
        
        this.airlinesSet.addAll(
                flightInfoList.stream()
                        .map( flightInfo ->
                              {
                                  if ( flightInfo.getAirline() == null ) {
                                      return "null";
                                  }
                                  
                                  return flightInfo.getAirline();
                              } )
                        .toList()
                               );
        
    }
    
    public Set< String > getAirlinesSet()
    {
        return this.airlinesSet;
    }
    
    protected List< DTOs.FlightInfo > filterOutRelevantAirlines( String... airline )
    {
        Set< String > inputAirlineSet = Arrays.stream( airline ).collect( Collectors.toSet() );
        
        List< DTOs.FlightInfo > relevantAirlines = this.flightInfoList.stream()
                .filter( flightInfo -> inputAirlineSet.contains( flightInfo.getAirline() ) )
                .collect( Collectors.toList() );
        
        return relevantAirlines;
    }

//    public Map< String, List< Duration > > getFlightDurationsByAirline( String... airline )
//    {
//        List< DTOs.FlightInfo > relevantAirlines = this.filterOutRelevantAirlines( airline );
//
//        Map< String, List< Duration > > flightDurationsByAirline = relevantAirlines.stream()
//                .collect( Collectors.groupingBy( flightInfo -> flightInfo.getAirline(),
//                                                 aver
//                                               )
//                        )
////                .map( flightInfos -> flightInfos.stream().map( flightInfo -> flightInfo.getDuration() ).toList() )
//                .
//                ;
//
//        return flightDurationsByAirline;
//    }
    
    public Map< String, Duration > calcAverageFlightDuration( String... airline )
    {
//        Set< String > inputAirlineSet = Arrays.stream( airline ).collect( Collectors.toSet() );
//
//        Map< String, List< Duration > > flightMapDurationList = new HashMap<>();
//
//        Map< String, Duration > averageFlightDuration = new TreeMap<>();
//
//        Map< String, Duration > averageFlightDurationRes = this.flightInfoByAirlineList.entrySet()
//                .stream()
//                .filter( stringListEntry -> inputAirlineSet.contains( stringListEntry.getKey() ) )
//                .map( stringListEntry -> {
//
//                          flightMapDurationList.put(
//                                  stringListEntry.getKey(),
//                                  stringListEntry.getValue().stream().map( flightInfo -> flightInfo.getDuration() ).toList()
//                                                   );
//
//
//                          return flightMapDurationList;
//                      }
//                    )
//                .map( flightMapDurationListInput -> {
//
//                    flightMapDurationListInput.entrySet()
//                            .stream()
//                            .map(
//                                    flightEntryDurationListInput -> {
//                                        averageFlightDuration.put(
//                                                flightEntryDurationListInput.getKey(),
//                                                Duration.of(
//                                                        ( long ) flightEntryDurationListInput.getValue()
//                                                                .stream()
//                                                                .mapToLong( flightDuration -> flightDuration.toSeconds() )
//                                                                .average()
//                                                                .getAsDouble(),
//                                                        ChronoUnit.SECONDS )
//                                                                 );
//
//                                        return averageFlightDuration;
//                                    }
//                                );
//
//                    return averageFlightDuration;
//
//                } )
//                .collect( Collectors.toMap() );
//
//        return averageFlightDurationRes;
        return null;
    }
    
//    public Map< String, Duration > calcTotalFlightDuration( String... airline )
//    {
//        List< DTOs.FlightInfo > relevantAirlines = this.filterOutRelevantAirlines( airline );
//
//        Map< String, Duration > totalFlightDurationsByAirline = relevantAirlines.stream()
//                .collect(
//                        Collectors.groupingBy(
//                                flightInfo -> flightInfo.getAirline(),
//                                Collectors
//                                             )
//                        );
//
//        return totalFlightDurationsByAirline;
//    }
    
}
