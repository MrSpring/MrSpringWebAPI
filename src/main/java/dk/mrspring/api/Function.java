package dk.mrspring.api;

import dk.mrspring.api.call.Call;

/**
 * Created on 07-09-2015 for LiteLoader.
 */
public class Function
{
    public static final Function GET_MOD_INFO = new Function("mod.get_info", Call.ModInfoCall.class);
    public static final Function GET_MOD_VERSIONS = new Function("mod.get_versions", Call.GetVersionsCall.class);
    public static final Function GET_MOD_VERSION = new Function("mod.get_version", Call.GetVersionCall.class);
    public static final Function CHECK_UPDATE = new Function("mod.check_update", Call.CheckUpdateCall.class);

    public String function;
    public Class<? extends Call> callClass;

    public Function(String function, Class<? extends Call> callClass)
    {
        this.function = function;
        this.callClass = callClass;
    }
}
