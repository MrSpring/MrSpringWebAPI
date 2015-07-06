package dk.mrspring.api;

/**
 * Created by MrSpring on 05-07-2015 for MC Music Player.
 */
public enum Error
{
    UNKNOWN_ERROR(-1, "An unknown error occurred."),
    NO_ERROR(0, "Everything went as planned."),
    MOD_NOT_DEFINED(1, "No mod requested."),
    UNKNOWN_MOD(2, "Unknown mod: %1$s."),
    MOD_HAS_NO_VERSIONS(3, "Mod: %1$s does not have versions declared."),
    NO_VERSION_DEFINED(4, "No current version declared."),
    UNKNOWN_VERSION(5, "Version: %2$s could not be found."),
    MOD_HAS_NO_LANGUAGES(6, "Mod: %1$s does not have languages declared."),
    NO_CHANGELOG_AVAILABLE(7, "Version: %1$s does not have languages declared.");

    public static Error fromId(int id)
    {
        for (Error error : values())
            if (error.id == id)
                return error;
        return UNKNOWN_ERROR;
    }

    final int id;
    final String description;

    Error(int id)
    {
        this.id = id;
        this.description = "No description!";
    }

    Error(int id, String desc)
    {
        this.id = id;
        this.description = desc;
    }
}
