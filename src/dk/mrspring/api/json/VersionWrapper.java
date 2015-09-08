package dk.mrspring.api.json;

import dk.mrspring.api.IJsonWrapper;
import dk.mrspring.api.type.Version;

/**
 * Created on 07-09-2015 for LiteLoader.
 */
public class VersionWrapper implements IJsonWrapper<Version>
{
    public String name = "";
    public String mc_version = "";
    public String direct_download_url = null;
    public String adfly_download_url = null;
    public String changelog_url = null;
    public String source_url = null;
    public String release_date = "";
    public String download_page = "";
    public String[] changelog = new String[0];
    public String full_version_api_page = null;

    public boolean isSimple()
    {
        return full_version_api_page != null;
    }

    public Version decode(String modId)
    {
        return new Version().populate(this, modId);
    }

    @Override
    public Version decode()
    {
        return decode(null);
    }
}
