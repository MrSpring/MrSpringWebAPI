package dk.mrspring.api.json;

import dk.mrspring.api.type.Version;

/**
 * Created by MrSpring on 06-07-2015 for MC Music Player.
 */
public class GetVersionWrapper implements IJsonWrapper<Version>
{
    public String mod;
    public String version_name;
    public VersionWrapper version;

    @Override
    public Version decode()
    {
        return new Version().populate(this);
    }

    public class VersionWrapper
    {
        public String name;
        public String mc_version;
        public String direct_download_url;
        public String adfly_download_url;
        public String changelog_url;
        public String source_url;
        public String release_date;
        public String download_page;
    }
}
