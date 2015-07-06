package dk.mrspring.api.json;

/**
 * Created by MrSpring on 06-07-2015 for MC Music Player.
 */
public interface Populator<T extends IJsonWrapper>
{
    public Populator populate(T jsonWrapper);
}
