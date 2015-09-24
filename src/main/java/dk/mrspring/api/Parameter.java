package dk.mrspring.api;

/**
 * Created on 07-09-2015 for LiteLoader.
 */
public class Parameter
{
    public String name, value;

    public Parameter(String n, String v)
    {
        this.name = n;
        this.value = v;
    }

    @Override
    public String toString()
    {
        if (isEmpty(value))
            return name;
        else return name + "=" + value;
    }

    private boolean isEmpty(String s)
    {
        return s == null || s.equals("");
    }
}
