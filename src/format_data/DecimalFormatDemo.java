package format_data;

import java.text.DecimalFormat;

public class DecimalFormatDemo {
    static public void customFormat(String pattern, double value ) {
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
        System.out.println(value + "  " + pattern + "  " + output);
    }

    static public void main(String[] args) {

        customFormat("###,###.###", 123456.789); //работает только в английской локали, в русской разделитель - пробел
        customFormat("###.##", 123456.789);
        customFormat("000000.000", 123.78);
        customFormat("$###,###.###", 12345.67);
    }
}
