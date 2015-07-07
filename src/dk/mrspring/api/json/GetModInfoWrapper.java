package dk.mrspring.api.json;

import dk.mrspring.api.type.Mod;

/**
 * Created by MrSpring on 05-07-2015 for MC Music Player.
 */
public class GetModInfoWrapper implements IJsonWrapper<Mod>
{
    public String full_name = "";
    public String short_name = "";
    public String dependency = "";
    public String logo_url = "";
    public boolean has_versions = false;
    public String versions_url = "";
    public boolean has_languages = false;
    public String languages_url = "";
    public boolean has_source = false;
    public String source_url = "";

    @Override
    public Mod decode()
    {
        return new Mod().populate(this);
    }
}
