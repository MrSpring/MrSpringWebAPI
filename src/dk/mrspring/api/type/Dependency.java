package dk.mrspring.api.type;

/**
 * Created by MrSpring on 06-07-2015 for MC Music Player.
 */
public enum Dependency
{
    UNKNOWN(""),
    LITE_LOADER("LiteLoader"),
    FORGE("Forge");

    final String id;

    Dependency(String str)
    {
        this.id = str;
    }

    public static Dependency fromId(String id)
    {
        for (Dependency dep : values())
            if (dep.id.equals(id))
                return dep;
        return UNKNOWN;
    }
}
