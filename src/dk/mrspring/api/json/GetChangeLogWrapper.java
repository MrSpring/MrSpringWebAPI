package dk.mrspring.api.json;

import dk.mrspring.api.type.ChangeLog;

/**
 * Created by MrSpring on 06-07-2015 for MC Music Player.
 */
public class GetChangeLogWrapper implements IJsonWrapper<ChangeLog>
{
    public String mod;
    public String version;
    public String[] changelog;

    @Override
    public ChangeLog decode()
    {
        return new ChangeLog().populate(this);
    }
}
