package dk.mrspring.api;

import dk.mrspring.api.json.Populator;
import dk.mrspring.api.json.VersionJsonWrapper;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by MrSpring on 06-07-2015 for MC Music Player.
 */
public class Version implements Populator<VersionJsonWrapper>
{
    String name;
    String mod;
    String mcVersion;
    String releaseDate;
    URL directDownload;
    URL adflyUrl;
    URL sourceUrl;
    URL changeLogUrl;
    String[] changeLog;

    public String getName()
    {
        return name;
    }

    public String getMod()
    {
        return mod;
    }

    public String getMcVersion()
    {
        return mcVersion;
    }

    public URL getDirectDownload()
    {
        return directDownload;
    }

    public URL getAdflyUrl()
    {
        return adflyUrl;
    }

    public URL getSourceUrl()
    {
        return sourceUrl;
    }

    public String[] getChangeLog()
    {
        if (changeLog == null) loadChangeLog();
        if (changeLog == null) changeLog = new String[0];
        return changeLog;
    }

    public void loadChangeLog()
    {
        ChangeLog log = Versions.getChangeLog(mod, name);
        this.changeLog = log.getChangeLog();
    }

    @Override
    public Version populate(VersionJsonWrapper wrap)
    {
        this.name = wrap.version.name;
        this.mod = wrap.mod;
        this.mcVersion = wrap.version.mc_version;
        try
        {
            if (wrap.version.direct_download_url != null)
                this.directDownload = new URL(wrap.version.direct_download_url);
            if (wrap.version.adfly_download_url != null) this.adflyUrl = new URL(wrap.version.adfly_download_url);
            if (wrap.version.source_url != null) this.sourceUrl = new URL(wrap.version.source_url);
            if (wrap.version.changelog_url != null) this.changeLogUrl = new URL(wrap.version.changelog_url);
            if (wrap.version.release_date != null) this.releaseDate = wrap.version.release_date;
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        return this;
    }
}
