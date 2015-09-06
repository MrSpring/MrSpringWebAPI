package dk.mrspring.api.old.type;

import dk.mrspring.api.old.NameSet;
import dk.mrspring.api.old.json.GetModInfoWrapper;
import dk.mrspring.api.old.json.Populator;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by MrSpring on 05-07-2015 for MC Music Player.
 */
public class Mod implements Populator<GetModInfoWrapper>
{
    NameSet name;
    dk.mrspring.api.old.type.Dependency dependency;
    URL logoUrl;
    URL versionsUrl;
    URL languagesUrl;
    URL sourceUrl;

    public String getFullName()
    {
        return name.getFullName();
    }

    public String getShortName()
    {
        return name.getShortName();
    }

    public boolean hasSource()
    {
        return sourceUrl != null;
    }

    public boolean hasVersions()
    {
        return versionsUrl != null;
    }

    public boolean hasLanguages()
    {
        return languagesUrl != null;
    }

    public URL getSourceUrl()
    {
        return sourceUrl;
    }

    public URL getVersionsUrl()
    {
        return versionsUrl;
    }

    public URL getLanguagesUrl()
    {
        return languagesUrl;
    }

    public URL getLogoUrl()
    {
        return logoUrl;
    }

    @Override
    public Mod populate(GetModInfoWrapper jsonWrapper)
    {
        this.name = new NameSet(jsonWrapper.short_name, jsonWrapper.full_name);
        try
        {
            this.logoUrl = new URL(jsonWrapper.logo_url);
            if (jsonWrapper.has_versions) this.versionsUrl = new URL(jsonWrapper.versions_url);
            if (jsonWrapper.has_languages) this.languagesUrl = new URL(jsonWrapper.languages_url);
            if (jsonWrapper.has_source) this.sourceUrl = new URL(jsonWrapper.source_url);
            this.dependency = dk.mrspring.api.old.type.Dependency.fromId(jsonWrapper.dependency);
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        }

        return this;
    }
}
