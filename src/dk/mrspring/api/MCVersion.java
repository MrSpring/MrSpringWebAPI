package dk.mrspring.api;

/**
 * Created by MrSpring on 08-07-2015 for MC Music Player.
 */
public class MCVersion
{
    int[] version = new int[3];

    public MCVersion(int release, int major, int minor)
    {
        this.version[0] = release;
        this.version[1] = major;
        this.version[2] = minor;
    }

    public MCVersion(int release, int major)
    {
        this(release, major, -1);
    }

    public MCVersion(String versionString)
    {
        int[] parsed = parse(versionString);
        for (int i = 0; i < version.length; i++)
        {
            if (i < parsed.length)
                version[i] = parsed[i];
            else version[i] = -1;
        }
    }

    public int[] parse(String version)
    {
        String trimmed = version.startsWith("Minecraft") ? version.substring(9) : version;
        trimmed = trimmed.trim();
        String[] split = trimmed.split(".");
        int[] parsed = new int[split.length];
        for (int i = 0; i < split.length; i++)
        {
            String str = split[i];
            if ("*".equals(str))
                parsed[i] = -1;
            else if (str != null)
                parsed[i] = Integer.valueOf(str);
        }
        return parsed;
    }

    @Override
    public String toString()
    {
        return "Minecraft " + getPlaced(0) + "." + getPlaced(1) + "." + getPlaced(2);
    }

    private String getPlaced(int i)
    {
        return version[i] == -1 ? "*" : String.valueOf(version[i]);
    }

    public int getRelease()
    {
        return version[0];
    }

    public int getMajor()
    {
        return version[1];
    }

    public int getMinor()
    {
        return version[2];
    }

    public boolean areVersionsEqual(MCVersion version)
    {
        return areReleaseEqual(version) && areMajorEqual(version) && areMinorEqual(version);
    }

    private boolean areReleaseEqual(MCVersion that)
    {
        return areVEqual(this.getRelease(), that.getRelease());
    }

    private boolean areMajorEqual(MCVersion version)
    {
        return areVEqual(this.getMajor(), version.getMajor());
    }

    private boolean areMinorEqual(MCVersion version)
    {
        return areVEqual(this.getMajor(), version.getMajor());
    }

    private boolean areVEqual(int thisI, int thatI)
    {
        return thisI == -1 || thatI == -1 || thisI == thatI;
    }

    public boolean areVersionsEqual(String version)
    {
        return this.areVersionsEqual(new MCVersion(version));
    }
}
