package dk.mrspring.api.old;

import dk.mrspring.api.old.call.GetLanguagesCall;
import dk.mrspring.api.old.type.LanguageSet;

import java.io.IOException;

/**
 * Created by MrSpring on 07-07-2015 for MC Music Player.
 */
public class Languages
{

    public static LanguageSet getLanguages(String mod)
    {
        try
        {
            GetLanguagesCall call = Caller.makeCall(Caller.GET_LANGUAGES, GetLanguagesCall.class, "mod=" + mod);
            return call.getResult();
        } catch (WebAPIExpception webAPIExpception)
        {
            webAPIExpception.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
