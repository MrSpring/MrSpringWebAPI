package dk.mrspring.api.type;

import dk.mrspring.api.json.ChangeLogJsonWrapper;
import dk.mrspring.api.json.Populator;

/**
 * Created by MrSpring on 06-07-2015 for MC Music Player.
 */
public class ChangeLog implements Populator<ChangeLogJsonWrapper>
{
    String mod;
    String version;
    String[] changeLog;

    @Override
    public ChangeLog populate(ChangeLogJsonWrapper jsonWrapper)
    {
        this.mod = jsonWrapper.mod;
        this.version = jsonWrapper.version;
        this.changeLog = jsonWrapper.changelog;

        return this;
    }

    public String[] getChangeLog()
    {
        return changeLog;
    }
}
