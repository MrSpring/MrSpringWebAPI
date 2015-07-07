package dk.mrspring.api;

import dk.mrspring.api.call.ModInfoCall;
import dk.mrspring.api.type.Mod;

import java.io.IOException;

/**
 * Created by MrSpring on 05-07-2015 for MC Music Player.
 */
public class Mods
{
    public static Mod getMod(String modId)
    {
        try
        {
            ModInfoCall call = Caller.makeCall(Caller.GET_MOD_INFO, ModInfoCall.class, "mod=" + modId);
            return call.getResult();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (WebAPIExpception webAPIExpception)
        {
            webAPIExpception.printStackTrace();
        }
        return null;
    }
}
