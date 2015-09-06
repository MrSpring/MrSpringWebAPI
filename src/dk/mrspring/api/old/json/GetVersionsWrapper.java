package dk.mrspring.api.old.json;

import dk.mrspring.api.old.type.Version;

/**
 * Created by MrSpring on 08-07-2015 for MC Music Player.
 */
public class GetVersionsWrapper implements IJsonWrapper<Version[]>
{
    public String mod;
    public GetVersionWrapper.VersionWrapper[] versions;

    @Override
    public Version[] decode()
    {
        Version[] versions = new Version[this.versions.length];
        for (int i = 0; i < versions.length; i++)
            versions[i] = new Version().populate(this, this.versions[i]);
        return versions;
    }
}
