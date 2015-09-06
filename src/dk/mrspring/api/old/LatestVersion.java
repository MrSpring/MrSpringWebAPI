package dk.mrspring.api.old.type;

import dk.mrspring.api.old.Version;
import dk.mrspring.api.old.json.CheckUpdateWrapper;
import dk.mrspring.api.old.json.Populator;

/**
 * Created by MrSpring on 06-07-2015 for MC Music Player.
 */
public class LatestVersion implements Populator<CheckUpdateWrapper>
{
    Version latest;
    boolean isLatest;
    String current;

    public LatestVersion()
    {

    }

    public LatestVersion(Version latest, boolean isLatest)
    {
        this.latest = latest;
        this.isLatest = isLatest;
    }

    public Version getLatest()
    {
        return latest;
    }

    public String getCurrent()
    {
        return current;
    }

    public boolean isLatest()
    {
        return isLatest;
    }

    @Override
    public LatestVersion populate(CheckUpdateWrapper jsonWrapper)
    {
        this.latest = new Version().populate(jsonWrapper.getLatest());
        this.isLatest = jsonWrapper.is_latest;
        this.current = jsonWrapper.current;
        return this;
    }
}
