package dk.mrspring.api.json;

import dk.mrspring.api.IJsonWrapper;
import dk.mrspring.api.type.Mod;

/**
 * Created on 07-09-2015 for LiteLoader.
 */
public class ModInfoWrapper implements IJsonWrapper<Mod>
{
    public String mod_id = "";
    public String mod_name = "";
    public String dependency = "";
    public String logo_url = "";
    public boolean has_versions;
    public String versions_url = "";
    public String versions_api_url = "";
    public boolean has_languages = true;
    public String languages_url = "";
    public String languages_api_url = "";
    public boolean has_source = true;
    public String source_url = "";

    @Override
    public Mod decode()
    {
        return new Mod().populate(this);
    }
}
