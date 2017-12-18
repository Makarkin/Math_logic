public class Auto_Main
{
    public static void main(String[] args)
    {
        System.out.println("Введите логическое выражение,\n используя две переменные, " +
                "операции * и +,\n а также круглые скобки. \n Оператор NOT обозначайте как !");

        Auto_Logic l = new Auto_Logic();
        l.replaceString();
        System.out.println(l.sb);
    }
}
