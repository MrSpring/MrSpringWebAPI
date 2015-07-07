package dk.mrspring.api.json;

import dk.mrspring.api.type.LatestVersion;

/**
 * Created by MrSpring on 06-07-2015 for MC Music Player.
 */
public class CheckUpdateWrapper implements IJsonWrapper<LatestVersion>
{
    public String mod;
    public String current;
    public boolean is_latest;
    public GetVersionWrapper.VersionWrapper latest_version;

    public GetVersionWrapper getLatest()
    {
        GetVersionWrapper wrapper = new GetVersionWrapper();
        wrapper.mod = this.mod;
        wrapper.version_name = latest_version.name;
        wrapper.version = this.latest_version;
        return wrapper;
    }

    @Override
    public LatestVersion decode()
    {
        return new LatestVersion().populate(this);
    }
}
