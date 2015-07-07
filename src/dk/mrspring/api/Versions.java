package dk.mrspring.api;

import dk.mrspring.api.call.GetChangeLogCall;
import dk.mrspring.api.call.GetVersionCall;
import dk.mrspring.api.call.IsLatestVersionCall;
import dk.mrspring.api.type.ChangeLog;
import dk.mrspring.api.type.LatestVersion;
import dk.mrspring.api.type.Mod;
import dk.mrspring.api.type.Version;

import java.io.IOException;

/**
 * Created by MrSpring on 06-07-2015 for MC Music Player.
 */
public class Versions
{
    public static ChangeLog getChangeLog(String mod, String version)
    {
        try
        {
            GetChangeLogCall call = Caller.makeCall(Caller.GET_CHANGE_LOG, GetChangeLogCall.class, "mod=" + mod, "version=" + version);
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

    public static ChangeLog getChangeLog(Mod mod, String version)
    {
        return getChangeLog(mod.getShortName(), version);
    }

    public static LatestVersion getLatestVersion(String mod, String version)
    {
        try
        {
            IsLatestVersionCall call = Caller.makeCall(Caller.IS_LATEST_VERSION, IsLatestVersionCall.class, "mod=" + mod, "version=" + version);
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

    public static LatestVersion getLatestVersion(Mod mod, String version)
    {
        return getLatestVersion(mod.getShortName(), version);
    }

    public static Version[] getVersions(String mod)
    {
        return null;
    }

    public static Version[] getVersions(Mod mod)
    {
        return getVersions(mod.getShortName());
    }

    public static Version getVersion(String mod, String version)
    {
        try
        {
            GetVersionCall call = Caller.makeCall(Caller.GET_VERSION, GetVersionCall.class, "mod=" + mod, "version=" + version);
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

    public static Version getVersion(Mod mod, String version)
    {
        return getVersion(mod.getShortName(), version);
    }
}
