package dk.mrspring.api.type;

/**
 * Created by MrSpring on 05-07-2015 for MC Music Player.
 */
public class NameSet
{
    final String SHORT_NAME, FULL_NAME;

    public NameSet(String shortName, String fullName)
    {
        this.SHORT_NAME = shortName;
        this.FULL_NAME = fullName;
    }

    public String getShortName()
    {
        return SHORT_NAME;
    }

    public String getFullName()
    {
        return FULL_NAME;
    }

    @Override
    public String toString()
    {
        return getShortName() + ":" + getFullName();
    }
}
