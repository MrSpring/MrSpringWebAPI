package dk.mrspring.api.type;

import java.util.Arrays;

/**
 * Created on 07-09-2015 for LiteLoader.
 */
public enum Dependency
{
    FORGE("Forge", "fml", "f", "forge"),
    LITE_LOADER("LiteLoader", "ll", "litemod", "lite");

    private String[] alts = new String[0];
    private String name = "";

    Dependency(String name)
    {
        this.name = name;
    }

    Dependency(String name, String... alts)
    {
        this(name);
        this.alts = alts;
    }

    public String getName()
    {
        return name;
    }

    public static Dependency fromName(String dependency)
    {
        try
        {
            return valueOf(dependency);
        } catch (IllegalArgumentException e)
        {
            for (Dependency d : values()) if (Arrays.asList(d.alts).contains(dependency)) return d;
            return FORGE;
        }
    }
}
