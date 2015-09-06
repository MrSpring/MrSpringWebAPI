package dk.mrspring.api.old;

import dk.mrspring.api.old.json.IJsonWrapper;

import java.lang.*;

/**
 * Created by MrSpring on 05-07-2015 for MC Music Player.
 */
public abstract class AbstractApiCall<T extends IJsonWrapper<K>, K>
{
    int error = 0;
    String error_desc = "empty";
    T result = null;
    K decodedResult = null;

    public AbstractApiCall()
    {
        this.error = 0;
        this.error_desc = "empty";
        this.result = null;
    }

    public void onCallFinished()
    {
        this.decodedResult = getRawResult().decode();
    }

    public boolean didError()
    {
        return error != 0;
    }

    public Error getError()
    {
        return Error.fromId(error);
    }

    public K getResult()
    {
        return decodedResult;
    }

    public T getRawResult()
    {
        return result;
    }

    public String getErrorDescription()
    {
        return error_desc;
    }
}
