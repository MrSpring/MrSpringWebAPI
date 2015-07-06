package dk.mrspring.api;

/**
 * Created by MrSpring on 05-07-2015 for MC Music Player.
 */
public class WebAPIExpception extends Exception
{
    public WebAPIExpception(Error error, String... parameters)
    {
        super(String.format(error.description, parameters));
    }

    public WebAPIExpception(int errorId, String... parameters)
    {
        this(Error.fromId(errorId), parameters);
    }
}
