package dk.mrspring.api.type;

import dk.mrspring.api.json.ModInfoWrapper;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created on 07-09-2015 for LiteLoader.
 */
public class Mod implements Populate<Mod, ModInfoWrapper>
{
    private String modId;
    private String modName;
    private Dependency dependency;
    private URL logoUrl;
    private URL versionsPublicUrl;
    private URL versionsApiUrl;
    private URL languagesPublicUrl;
    private URL languagesApiUrl;
    private URL sourceUrl;

    public String getModId()
    {
        return modId;
    }

    public String getModName()
    {
        return modName;
    }

    public Dependency getDependency()
    {
        return dependency;
    }

    public String getDependencyString()
    {
        return getDependency().getName();
    }

    public URL getLogoUrl()
    {
        return logoUrl;
    }

    public URL getVersionsPublicUrl()
    {
        return versionsPublicUrl;
    }

    public URL getVersionsApiUrl()
    {
        return versionsApiUrl;
    }

    public URL getLanguagesPublicUrl()
    {
        return languagesPublicUrl;
    }

    public URL getLanguagesApiUrl()
    {
        return languagesApiUrl;
    }

    public URL getSourceUrl()
    {
        return sourceUrl;
    }

    public boolean hasVersions()
    {
        return versionsApiUrl != null && versionsPublicUrl != null;
    }

    public boolean hasLanguages()
    {
        return languagesApiUrl != null && languagesPublicUrl != null;
    }

    public boolean hasSource()
    {
        return sourceUrl != null;
    }

    @Override
    public Mod populate(ModInfoWrapper type)
    {
        this.modId = type.mod_id;
        this.modName = type.mod_name;
        this.dependency = Dependency.fromName(type.dependency);
        this.logoUrl = makeUrl(true, type.logo_url);
        this.versionsPublicUrl = makeUrl(type.has_versions, type.versions_url);
        this.versionsApiUrl = makeUrl(type.has_versions, type.versions_api_url);
        this.languagesPublicUrl = makeUrl(type.has_languages, type.languages_url);
        this.languagesApiUrl = makeUrl(type.has_languages, type.languages_api_url);
        this.sourceUrl = makeUrl(type.has_source, type.source_url);
        return this;
    }

    private URL makeUrl(boolean has, String urlString)
    {
        if (!has) return null;
        try
        {
            return new URL(urlString);
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
