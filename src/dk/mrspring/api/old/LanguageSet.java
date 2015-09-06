package dk.mrspring.api.old.type;

import dk.mrspring.api.old.json.GetLanguagesWrapper;
import dk.mrspring.api.old.json.Populator;

/**
 * Created by MrSpring on 07-07-2015 for MC Music Player.
 */
public class LanguageSet implements Populator<GetLanguagesWrapper>
{
    String mod;
    String unFormattedURL;
    Language[] languages;

    @Override
    public LanguageSet populate(GetLanguagesWrapper wrap)
    {
        this.mod = wrap.mod;
        this.unFormattedURL = wrap.language_link_prefix + "%1$s" + wrap.language_link_suffix;
        this.languages = new Language[wrap.languages.length];
        for (int i = 0; i < languages.length; i++)
            languages[i] = wrap.languages[i].decode();
        return this;
    }

    public Language[] getLanguages()
    {
        return languages;
    }
}
