package dk.mrspring.api.old.type;

import dk.mrspring.api.old.NameSet;
import dk.mrspring.api.old.json.GetLanguagesWrapper;
import dk.mrspring.api.old.json.Populator;

/**
 * Created by MrSpring on 07-07-2015 for MC Music Player.
 */
public class Language implements Populator<GetLanguagesWrapper.LanguageWrapper>
{
    NameSet name;
    String implementedVersion;
    String updatedVersion;
    String[] credit;
    boolean hideLink;

    @Override
    public Language populate(GetLanguagesWrapper.LanguageWrapper wrap)
    {
        this.name = new NameSet(wrap.short_name, wrap.full_name);
        this.implementedVersion = wrap.implemented_version;
        this.updatedVersion = wrap.updated_version;
        this.credit = wrap.translated_by;
        this.hideLink = wrap.hide_link;
        return this;
    }

    public String getFullName()
    {
        return name.getFullName();
    }
}
