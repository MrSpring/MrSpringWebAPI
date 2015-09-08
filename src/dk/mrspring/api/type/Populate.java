package dk.mrspring.api.type;

/**
 * Created on 07-09-2015 for LiteLoader.
 */
public interface Populate<T, K>
{
    T populate(K type);
}
