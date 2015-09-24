package dk.mrspring.api.json;

import dk.mrspring.api.type.Versions;

/**
 * Created on 07-09-2015 for LiteLoader.
 */
public class GetVersionsWrapper implements IJsonWrapper<Versions>
{
    public String mod_id = "";
    public VersionWrapper[] version_list = new VersionWrapper[0];

    public Versions decode()
    {
        return new Versions().populate(this);
    }
}
