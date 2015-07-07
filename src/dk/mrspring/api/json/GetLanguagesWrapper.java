package dk.mrspring.api.json;

import dk.mrspring.api.type.Language;
import dk.mrspring.api.type.LanguageSet;

/**
 * Created by MrSpring on 07-07-2015 for MC Music Player.
 */
public class GetLanguagesWrapper implements IJsonWrapper<LanguageSet>
{
    public String mod;
    public String language_link_prefix;
    public String language_link_suffix;
    public LanguageWrapper[] languages;

    @Override
    public LanguageSet decode()
    {
        return new LanguageSet().populate(this);
    }

    public class LanguageWrapper implements IJsonWrapper<Language>
    {
        public String short_name;
        public String full_name;
        public String implemented_version;
        public String updated_version;
        public String[] translated_by;
        public boolean hide_link;

        @Override
        public Language decode()
        {
            return new Language().populate(this);
        }
    }
}
