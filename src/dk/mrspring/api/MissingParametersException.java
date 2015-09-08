package dk.mrspring.api;

/**
 * Created on 07-09-2015 for LiteLoader.
 */
public class MissingParametersException extends Throwable
{
    public MissingParametersException(String... missingParameters)
    {
        super("Missing parameters: " + compileParams(missingParameters));
    }

    private static String compileParams(String[] parameters)
    {
        if (parameters.length == 0) return "";
        else if (parameters.length == 1) return parameters[1];
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < parameters.length; i++)
        {
            builder.append(parameters[i]);
            if (i + 1 < parameters.length) builder.append(", ");
        }
        return builder.toString();
    }
}
