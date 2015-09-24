package dk.mrspring.api.call;

import dk.mrspring.api.json.*;
import dk.mrspring.api.type.LatestVersion;
import dk.mrspring.api.type.Mod;
import dk.mrspring.api.type.Version;
import dk.mrspring.api.type.Versions;

/**
 * Created on 06-09-2015 for WebAPI.
 */
public class Call<T extends IJsonWrapper<K>, K>
{
    int error = 0;
    T result = null;
    String error_desc = "No error.";
    String[] missing_parameters = new String[0];

    private K decodedResult = null;

    public Call()
    {
        error = 0;
        error_desc = "No error.";
        result = null;
        decodedResult = null;
    }

    public String getErrorDescription()
    {
        return error_desc;
    }

    public int getError()
    {
        return error;
    }

    public boolean didError()
    {
        return error != 0;
    }

    public void onCallFinished()
    {
        decodedResult = result.decode();
    }

    public K getDecodedResult()
    {
        return decodedResult;
    }

    public String[] getMissingParameters()
    {
        return missing_parameters;
    }

    public T getRawResult()
    {
        return result;
    }

    public static class ModInfoCall extends Call<ModInfoWrapper, Mod>
    {
    }

    public static class GetVersionsCall extends Call<GetVersionsWrapper, Versions>
    {
    }

    public static class GetVersionCall extends Call<GetVersionWrapper, Version>
    {
    }

    public static class CheckUpdateCall extends Call<CheckUpdateWrapper, LatestVersion>
    {
    }
}
