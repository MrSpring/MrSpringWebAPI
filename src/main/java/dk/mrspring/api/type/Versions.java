package dk.mrspring.api.type;

import com.google.gson.internal.LinkedTreeMap;
import dk.mrspring.api.json.GetVersionsWrapper;
import dk.mrspring.api.json.VersionWrapper;

import java.util.Collection;
import java.util.Map;

/**
 * Created on 07-09-2015 for LiteLoader.
 */
public class Versions implements Populate<Versions, GetVersionsWrapper>
{
    private String modId;
    private Map<String, Version> versions;

    public String getModId()
    {
        return modId;
    }

    public Collection<Version> getAllVersions()
    {
        return getVersionMap().values();
    }

    public Map<String, Version> getVersionMap()
    {
        return versions;
    }

    public boolean doesVersionExist(String version)
    {
        return getVersionMap().containsKey(version);
    }

    public Version getVersion(String version)
    {
        if (doesVersionExist(version)) return versions.get(version);
        else return null;
    }

    public Versions populate(GetVersionsWrapper type)
    {
        this.modId = type.mod_id;
        this.versions = new LinkedTreeMap<String, Version>();
        for (VersionWrapper v : type.version_list) this.versions.put(v.name, v.decode(type.mod_id));

        return this;
    }
}
