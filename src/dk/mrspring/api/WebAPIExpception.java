package dk.mrspring.api;

/**
 * Created by MrSpring on 05-07-2015 for MC Music Player.
 */
public class WebAPIExpception extends Exception
{
    public WebAPIExpception(Error error, String errorDesc)
    {
        super(errorDesc);
    }

    public WebAPIExpception(int errorId, String errorDesc)
    {
        this(Error.fromId(errorId), errorDesc);
    }
}
