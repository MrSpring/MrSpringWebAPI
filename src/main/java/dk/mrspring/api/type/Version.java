package dk.mrspring.api.type;

import dk.mrspring.api.Function;
import dk.mrspring.api.Parameter;
import dk.mrspring.api.call.Call;
import dk.mrspring.api.call.SimpleCaller;
import dk.mrspring.api.json.GetVersionWrapper;
import dk.mrspring.api.json.VersionWrapper;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created on 07-09-2015 for LiteLoader.
 */
public class Version implements Populate<Version, VersionWrapper>
{
    private String modVersion, mcVersion;
    private String modId = null;
    private URL directDownloadUrl, adflyDownloadUrl;
    private URL sourceUrl;
    private URL publicDownloadUrl;
    private String release;
    private String[] changeLog;
    private boolean isSimple;

    public Version populate(VersionWrapper type)
    {
        return this.populate(type, null);
    }

    public Version populate(VersionWrapper type, String modId)
    {
        this.modVersion = type.name;
        this.mcVersion = type.mc_version;
        this.modId = modId;
        this.isSimple = type.isSimple();
        if (!isSimple)
        {
            this.directDownloadUrl = makeUrl(type.direct_download_url);
            this.adflyDownloadUrl = makeUrl(type.adfly_download_url);
            this.sourceUrl = makeUrl(type.source_url);
            this.publicDownloadUrl = makeUrl(type.changelog_url);
            this.release = type.release_date;
            this.changeLog = type.changelog;
        }

        return this;
    }

    public boolean isSimple()
    {
        return this.isSimple;
    }

    public boolean hasMod()
    {
        return modId != null;
    }

    public String getMod()
    {
        return modId;
    }

    public void downloadFullVersion()
    {
        if (!isSimple()) System.err.println("Version already has all the necessary information downloaded!");
        else if (!hasMod()) System.err.println("Version has unknown mod. Cannot download additional information!");
        else
        {
            SimpleCaller caller = new SimpleCaller(Function.GET_MOD_VERSION);
            Call<GetVersionWrapper, Version> call = caller.makeCall(new Parameter("m", getMod()), new Parameter("v", getVersionString()));
            GetVersionWrapper wrapper = call.getRawResult();
            this.populate(wrapper.version, wrapper.mod_id);
        }
    }

    private URL makeUrl(String urlString)
    {
        if (urlString == null) return null;
        try
        {
            return new URL(urlString);
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public String getVersionString()
    {
        return modVersion;
    }

    public URL getDirectDownload()
    {
        return directDownloadUrl;
    }

    public String[] getChangeLog()
    {
        return changeLog;
    }
}
