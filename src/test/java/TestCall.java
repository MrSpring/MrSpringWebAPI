import dk.mrspring.api.Function;
import dk.mrspring.api.Parameter;
import dk.mrspring.api.call.Call;
import dk.mrspring.api.call.SimpleCaller;
import dk.mrspring.api.json.GetVersionsWrapper;
import dk.mrspring.api.type.Versions;

/**
 * Created by MrSpring on 07-07-2015 for MC Music Player.
 */
public class TestCall
{
    public static void main(String[] args)
    {
        SimpleCaller caller = new SimpleCaller(Function.GET_MOD_VERSIONS);
        System.out.println("call: " + System.currentTimeMillis());
        Call<GetVersionsWrapper, Versions> call = caller.makeCall(new Parameter("m", "tkm"), new Parameter("s", null));
        System.out.println("call: " + System.currentTimeMillis());
        Versions vs = call.getDecodedResult();
        System.out.println("call: " + System.currentTimeMillis());
        vs.getVersion("1.3.15").downloadFullVersion();
        System.out.println("call: " + System.currentTimeMillis());
        if (call.didError())
            System.out.printf("Failed with error code: \"%s\", description: \"%s\".", call.getError(), call.getErrorDescription());
        else
        {
            System.out.println(call.getDecodedResult().getModId() + ", " + call.getDecodedResult().getVersion("1.3.15").getDirectDownload().toString());
            String[] log = call.getDecodedResult().getVersion("1.3.15").getChangeLog();
            for (String s : log) System.out.println(s);
        }
    }
}
