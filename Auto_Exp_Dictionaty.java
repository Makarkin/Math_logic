import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Auto_Exp_Dictionaty
{
    Map<String, String> e_d;

    Auto_Exp_Dictionaty(ArrayList<String> values_list)
    {
        e_d = new HashMap<>();
        for (String s:values_list)
        {
            e_d.put(s + "*" + s, s);
            e_d.put(s + "*!" + s, "0");
            e_d.put("!" + s + "*" + s, "0");
            e_d.put("!" + s + "*!" + s, "!" + s);
            e_d.put("0*" + s, "0");
            e_d.put("0*!" + s, "0");
            e_d.put(s + "*0", "0");
            e_d.put("!" + s + "*0", "0");
        }

        for (String s:values_list)
        {
            e_d.put(s + "+" + s, s);
            e_d.put(s + "+!" + s, "1");
            e_d.put("!" + s + "+" + s, "1");
            e_d.put("!" + s + "+!" + s, "!" + s);
        }

        e_d.put("0+", "");
        e_d.put("+0", "");
    }
}
