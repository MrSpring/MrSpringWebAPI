package dk.mrspring.api;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by MrSpring on 06-07-2015 for MC Music Player.
 */
public class Caller
{
    public static final String GET_MOD_INFO = "mod.get_info";
    public static final String GET_VERSION = "mod.get_version";
    public static final String IS_LATEST_VERSION = "mod.check_update";
    public static final String GET_CHANGE_LOG = "mod.get_changelog";
    public static final String GET_LANGUAGES = "mod.get_languages";
    public static final String GET_VERSIONS = "mod.get_versions";

    public static AbstractApiCall call(String function, String... parameters) throws IOException, WebAPIExpception
    {
        return makeCall(function, AbstractApiCall.class, parameters);
    }

    public static <T extends AbstractApiCall> T makeCall(String function, Class<T> type, String... parameters)
            throws IOException, WebAPIExpception
    {
        try
        {
            URL calling = makeUrl(function, parameters);
            InputStream input = calling.openStream();
            String jsonResult = IOUtils.toString(input);
            Gson gson = new Gson();
            T callResult = gson.fromJson(jsonResult, type);
            if (callResult.didError())
                throw new WebAPIExpception(callResult.getError(), callResult.getErrorDescription());
            callResult.onCallFinished();
            return callResult;
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private static URL makeUrl(String function, String... parameters) throws MalformedURLException
    {
        return new URL("http", "mrspring.dk", "api/" + function + query(parameters));
    }

    private static String query(String... parameters)
    {
        StringBuilder query = new StringBuilder("?");
        for (int i = 0; i < parameters.length; i++)
        {
            String str = parameters[i];
            if (str == null || str.isEmpty())
                continue;
            query.append(str);
            if (i + 1 < parameters.length)
                query.append("&");
        }
        return query.toString();
    }
}
