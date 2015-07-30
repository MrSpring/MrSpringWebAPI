package dk.mrspring.api.type;

import dk.mrspring.api.json.GetChangeLogWrapper;
import dk.mrspring.api.json.Populator;

/**
 * Created by MrSpring on 06-07-2015 for MC Music Player.
 */
public class ChangeLog implements Populator<GetChangeLogWrapper>
{
    String mod;
    String version;
    String[] changeLog;

    @Override
    public ChangeLog populate(GetChangeLogWrapper jsonWrapper)
    {
        this.mod = jsonWrapper.mod;
        this.version = jsonWrapper.version;
        this.changeLog = jsonWrapper.changelog;

        return this;
    }

    public String getVersion()
    {
        return version;
    }

    public String getMod()
    {
        return mod;
    }

    public String[] getChangeLog()
    {
        return changeLog;
    }
}
