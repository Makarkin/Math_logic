import java.util.ArrayList;

public class Auto_Seek_value
{
    Operators_Dictionary osd;
    {
        osd = new Operators_Dictionary();
    }

    ArrayList<String> seek(StringBuilder sb)
    {
        ArrayList<String> res_arr = new ArrayList<>();
        String s;
        for (int i=0; i<sb.length(); i++)
        {
            s = String.valueOf(sb.charAt(i));
            if (osd.o_d.contains(s)==false && res_arr.contains(s)==false) res_arr.add(String.valueOf(s));
        }

        return res_arr;
    }
}
