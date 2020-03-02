package format_data;

import java.io.PrintStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        GregorianCalendar calendar = new GregorianCalendar();
        Date date = new Date();

        System.out.format("Дата и время — полное название месяца в зависимости от языка. %tB", date.getTime());
        //февраля
        System.out.format("%n");
        //переход на новую строку
        System.out.format("Дата и время — 2 цифры дня месяца. td — с ведущими нулями, te — без. %td, %te", date.getTime(), date.getTime());
        //06, 6
        System.out.format("%n");
        System.out.format("Дата и время — ty = год из 2х цифр, tY = год из 4х цифр. %ty %tY", date.getTime(), date.getTime());
        //20 2020
        System.out.format("%n");
        System.out.format ("часы в 12 формате %tl минуты из 2х цифр %tM  am/pm %tp " +
                "месяц — 2 цифры %tm дата в формате %tm/%td/%ty %tD",date.getTime(), date.getTime(), date.getTime(), date.getTime(), date.getTime(), date.getTime(), date.getTime(), date.getTime() );
        long n = 461012;
        System.out.format("%d%n", n);      //  -->  "461012"
        System.out.format("%08d%n", n);    //  -->  "00461012"
        System.out.format("%+8d%n", n);    //  -->  " +461012"
        System.out.format("%,8d%n", n);    // -->  " 461,012"
        System.out.format(Locale.CANADA,"%+,8d%n%n", n); //  -->  "+461,012"

        double pi = Math.PI;

        System.out.format("%f%n", pi);       // -->  "3.141593"
        System.out.format("%.3f%n", pi);     // -->  "3.142"
        System.out.format("%10.3f%n", pi);   // -->  "     3.142"
        System.out.format("%-10.3f%n", pi);  // -->  "3.142"
        System.out.format(Locale.CANADA,
                "%-10.4f%n%n", pi); // -->  "3,1416"

        Calendar c = Calendar.getInstance();
        System.out.format("%tB %te, %tY%n", c, c, c); // -->  "May 29, 2006"

        System.out.format("%tl:%tM %tp%n", c, c, c);  // -->  "2:34 am"

        System.out.format("%tD%n", c);    // -->  "05/29/06"


        StringBuilder sb = new StringBuilder();
        // Send all output to the Appendable object sb
        Formatter formatter = new Formatter(sb, Locale.US);

        // Explicit argument indices may be used to re-order output.
        formatter.format("%4$2s %3$2s %2$2s %1$2s", "a", "b", "c", "d");
        // -> " d  c  b  a"

        // Optional locale as the first argument can be used to get
        // locale-specific formatting of numbers.  The precision and width can be
        // given to round and align the value.
        formatter.format(Locale.FRANCE, "e = %+10.4f", Math.E);
        // -> "e =    +2,7183"


        // The '(' numeric flag may be used to format negative numbers with
        // parentheses rather than a minus sign.  Group separators are
        // automatically inserted.
//        formatter.format("Amount gained or lost since last statement: $ %(,.2f",
//                balanceDelta);
        // -> "Amount gained or lost since last statement: $ (6,217.58)"
        System.out.format("%-8.2f%n", pi);       // -->  "3.141593"

        StringBuilder sb1 = new StringBuilder();
        Formatter formatter1 = new Formatter(sb1);
        int a = 19846;
        String s = "Шорты пляжные синиеШорты пляжные синие";
        double b= 159.00;
        int d = 12;
        formatter1.format("%-8d%-30.30s%-8.2f%-4d", a, s, b, d);

        formatter1.format("%b", true);
        formatter1.format("%e", b);
        formatter1.format("%c", 'r');
        formatter1.format("% (d", -100);

        System.out.println(formatter1);
    }
}
