package dk.mrspring.api.call;

import com.google.gson.Gson;
import dk.mrspring.api.MissingParametersException;
import dk.mrspring.api.Parameter;
import dk.mrspring.api.WebAPIException;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created on 06-09-2015 for WebAPI.
 */
public abstract class AbstractCaller<T extends Call>
{
    public abstract Class<T> getTypeClass();

    protected T makeCall(String function, Parameter... parameters) throws IOException, WebAPIException, MissingParametersException
    {
        try
        {
            URL calling = makeUrl(function, parameters);
            InputStream input = calling.openStream();
            String jsonResult = IOUtils.toString(input);
            Gson gson = new Gson();
            T callResult = gson.fromJson(jsonResult, getTypeClass());
            if (callResult.didError())
            {
                if (callResult.getError() == 1) throw new MissingParametersException(callResult.getMissingParameters());
                else throw new WebAPIException(callResult.getError(), callResult.getErrorDescription());
            } else this.onCallFinished(callResult);
            return callResult;
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    protected void onCallFinished(T callResult)
    {
        callResult.onCallFinished();
    }

    public URL makeUrl(String function, Parameter... parameters) throws MalformedURLException
    {
        return new URL("http", "mrspring.dk", "api/" + function + query(parameters));
    }

    public String query(Parameter... parameters)
    {
        StringBuilder query = new StringBuilder("?");
        for (int i = 0; i < parameters.length; i++)
        {
            String str = parameters[i].toString();
            if (str == null || str.isEmpty())
                continue;
            query.append(str);
            if (i + 1 < parameters.length)
                query.append("&");
        }
        return query.toString();
    }
}
