package dk.cphbusiness.utils;

public class TimeUnitConverter
{
    
    public static String toPrettyString( long timeSeconds )
    {
        StringBuilder stringBuilder = new StringBuilder();
        
        long hours = timeSeconds / 3600;
        long hoursRest = timeSeconds % 3600;
        long minutes = hoursRest / 60;
        long seconds = hoursRest % 60;
        
        stringBuilder.append( hours ).append( "h " ).append( minutes ).append( "m " ).append( seconds ).append( "s" );
        
        return stringBuilder.toString();
    }
    
}
