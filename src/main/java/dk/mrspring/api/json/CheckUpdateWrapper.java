package dk.mrspring.api.json;

import dk.mrspring.api.type.LatestVersion;

/**
 * Created on 24-09-2015 for MrSpringWebAPI.
 */
public class CheckUpdateWrapper implements IJsonWrapper<LatestVersion>
{
    public String mod_id = "";
    public String current_version = "";
    public boolean is_latest = false;
    public VersionWrapper latest_version = null;

    public LatestVersion decode()
    {
        return new LatestVersion().populate(this);
    }
}
