public class SUBS
{
    public static void findLocations(String s, String t)
    {
        int tLen = t.length();

        for (int i = 0; i <= s.length() - tLen; i++)
        {
            if (s.substring(i, i + tLen).equals(t))
            {
                System.out.print((i + 1) + " "); 
            }
        }
    }
}
