package dk.mrspring.api.type;

import dk.mrspring.api.json.IsLatestVersionJsonWrapper;
import dk.mrspring.api.json.Populator;

/**
 * Created by MrSpring on 06-07-2015 for MC Music Player.
 */
public class LatestVersion implements Populator<IsLatestVersionJsonWrapper>
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
    public LatestVersion populate(IsLatestVersionJsonWrapper jsonWrapper)
    {
        this.latest = new Version().populate(jsonWrapper.getLatest());
        this.isLatest = jsonWrapper.is_latest;
        this.current = jsonWrapper.current;
        return this;
    }
}
