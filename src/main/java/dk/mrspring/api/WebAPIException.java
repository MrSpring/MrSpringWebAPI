package dk.mrspring.api;

/**
 * Created on 06-09-2015 for LiteLoader.
 */
public class WebAPIException extends Throwable
{
    public WebAPIException(int error, String errorDescription)
    {
        super(errorDescription);
    }
}
