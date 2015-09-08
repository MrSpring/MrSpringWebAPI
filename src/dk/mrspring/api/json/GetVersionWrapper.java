package dk.mrspring.api.json;

import dk.mrspring.api.IJsonWrapper;
import dk.mrspring.api.type.Version;

/**
 * Created on 08-09-2015 for LiteLoader.
 */
public class GetVersionWrapper implements IJsonWrapper<Version>
{
    public String mod_id = "";
    public VersionWrapper version = null;

    @Override
    public Version decode()
    {
        return new Version().populate(version, mod_id);
    }
}
