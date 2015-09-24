package dk.mrspring.api.call;

import dk.mrspring.api.Function;
import dk.mrspring.api.MissingParametersException;
import dk.mrspring.api.Parameter;
import dk.mrspring.api.WebAPIException;

import java.io.IOException;

/**
 * Created on 07-09-2015 for LiteLoader.
 */
public class SimpleCaller extends AbstractCaller
{
    Function function;

    public SimpleCaller(Function function)
    {
        this.function = function;
    }

    public void setFunction(Function function)
    {
        this.function = function;
    }

    public <R extends Call> R makeCall(Parameter... parameters)
    {
        try
        {
            return (R) super.makeCall(function.function, parameters);
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (WebAPIException e)
        {
            e.printStackTrace();
        } catch (MissingParametersException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Class<? extends Call> getTypeClass()
    {
        return function.callClass;
    }
}
