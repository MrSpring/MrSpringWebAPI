package dk.mrspring.api.type;

import dk.mrspring.api.Function;
import dk.mrspring.api.Parameter;
import dk.mrspring.api.call.Call;
import dk.mrspring.api.call.SimpleCaller;
import dk.mrspring.api.json.CheckUpdateWrapper;
import dk.mrspring.api.json.GetVersionWrapper;

/**
 * Created on 24-09-2015 for MrSpringWebAPI.
 */
public class LatestVersion implements Populate<LatestVersion, CheckUpdateWrapper>
{
    private String modId;
    private String currentVersionName;
    private boolean isLatest;
    private Version latest;
    private Version current;

    public String getModId()
    {
        return modId;
    }

    public String getCurrentVersionName()
    {
        return currentVersionName;
    }

    public boolean isLatestVersion()
    {
        return isLatest;
    }

    public Version getLatestVersion()
    {
        return latest;
    }

    public boolean isCurrentVersionDownloaded()
    {
        return current != null;
    }

    public Version getCurrentVersion()
    {
        return current;
    }

    public void downloadCurrentVersion()
    {
        SimpleCaller caller = new SimpleCaller(Function.GET_MOD_VERSION);
        Call<GetVersionWrapper, Version> call =
                caller.makeCall(new Parameter("m", getModId()), new Parameter("v", getCurrentVersionName()));
        this.current = call.getDecodedResult();
    }

    public LatestVersion populate(CheckUpdateWrapper type)
    {
        this.modId = type.mod_id;
        this.currentVersionName = type.current_version;
        this.isLatest = type.is_latest;
        this.latest = type.latest_version.decode(this.modId);
        return this;
    }
}
