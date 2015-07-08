package dk.mrspring.api.type;

import dk.mrspring.api.MCVersion;
import dk.mrspring.api.Versions;
import dk.mrspring.api.json.GetVersionWrapper;
import dk.mrspring.api.json.GetVersionsWrapper;
import dk.mrspring.api.json.Populator;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by MrSpring on 06-07-2015 for MC Music Player.
 */
public class Version implements Populator<GetVersionWrapper>
{
    String name;
    String mod;
    MCVersion mcVersion;
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

    public MCVersion getMcVersion()
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

    public Version populate(GetVersionsWrapper wrapper, GetVersionWrapper.VersionWrapper wrap)
    {
        this.name = wrap.name;
        this.mod = wrapper.mod;
        this.populate(wrap);
        return this;
    }

    private void populate(GetVersionWrapper.VersionWrapper wrap)
    {
        this.mcVersion = new MCVersion(wrap.mc_version);
        try
        {
            if (wrap.direct_download_url != null)
                this.directDownload = new URL(wrap.direct_download_url);
            if (wrap.adfly_download_url != null) this.adflyUrl = new URL(wrap.adfly_download_url);
            if (wrap.source_url != null) this.sourceUrl = new URL(wrap.source_url);
            if (wrap.changelog_url != null) this.changeLogUrl = new URL(wrap.changelog_url);
            if (wrap.release_date != null) this.releaseDate = wrap.release_date;
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Version populate(GetVersionWrapper wrap)
    {
        this.name = wrap.version.name;
        this.mod = wrap.mod;
        this.populate(wrap.version);
        return this;
    }
}
