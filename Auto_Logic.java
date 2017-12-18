import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class Auto_Logic
{
    private Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder(sc.nextLine());
    private Auto_Seek_value s_v = new Auto_Seek_value();
    private ArrayList<String> values = s_v.seek(sb);
    private Auto_Exp_Dictionaty dict = new Auto_Exp_Dictionaty(values);
    private Set<String> keys = dict.e_d.keySet();

    public void replaceString()
    {
        int m,n,v;
        v = 0;
        while (v!=-1)
        {
            n = this.sb.lastIndexOf("(");
            m = this.sb.indexOf(")");
            if(m!=-1&&n!=-1)
            {
                innerReplace(n, m);
                sb.deleteCharAt(n);
                sb.deleteCharAt(sb.indexOf(")"));
            }
            else
            {
                innerReplace(0, sb.length());
                v = -1;
            }
        }
    }

    private void innerReplace(int n, int m)
    {
        int j,i;
        for (String k:keys)
        {
            j = 0;
            while(j==0)
            {
                i = sb.indexOf(k, n);
                if (i!=-1&&i<m)
                {
                    sb.replace(i, i+k.length(), dict.e_d.get(k));
                }
                else
                {
                    j = 1;
                }
            }
        }
    }

    public void splice_m()
    {
        ArrayList<String> final_values = s_v.seek(sb);
        int i, j, k, m;
        StringBuilder sb1;
        boolean b;

        for (String s : final_values)
        {
            do
                {
                    i = sb.lastIndexOf("*" + s);
                    j = sb.indexOf(s + "*");
                    m = sb.lastIndexOf("*" + "!" + s);
                    k = sb.indexOf("!" + s + "*");
                    if (j!=-1)
                    {
                        sb.delete(i, i+2);
                        sb.insert(j+2, s+"*");
                    }
                }
            while (i!=j+1 || i!=k+1);
        }
    }

    public void splice() {
        ArrayList<String> final_values = s_v.seek(sb);
        int i, j, k, m;
        StringBuilder sb1;
        boolean b = true;
        while (b == true)
        {
            sb1 = sb;
            for (String s : final_values)
            {
                i = sb.indexOf(s + "+");
                j = sb.indexOf("+" + s);
                if (i != -1)
                {
                    if (j != -1 && j > i)
                    {
                        sb.delete(j, j + 2);
                    }
                    else if (sb.indexOf("+!" + s) != -1 && sb.indexOf("+!" + s) > i)
                    {
                        k = sb.indexOf("+!" + s);
                        sb.delete(k, k + 3);
                        sb.insert(i + 2, "!" + s + "+");
                    }
                }
                else if (sb.indexOf("!" + s + "+") != -1)
                {
                    m = sb.indexOf("!" + s + "+");
                    if (j != -1 && j > m)
                    {
                        sb.delete(j, j + 2);
                        sb.insert(m + 3, s + "+");
                    }
                    else if (sb.indexOf("+!" + s) != -1 && sb.indexOf("+!" + s) > m)
                    {
                        k = sb.indexOf("+!" + s);
                        sb.delete(k, k + 3);
                        sb.insert(m + 3, "!" + s + "+");
                    }
                }

            }

            if (sb1.equals(sb)) b = false;
        }
    }
}
