import java.text.DecimalFormat;

public class NumbersImpl {
    public static void main(String... args) {
        Number num = 10235;
        print(num);
        print(num.byteValue());
        print(num.shortValue());
        print(num.intValue());
        print(num.longValue());
        print(num.floatValue());
        print(num.doubleValue());

        print("\n example2: =================================================\n");

        String strNum = "12345";
        Integer integer = Integer.decode(strNum);
        print(integer / 10);
        print(integer.toString() + '1');
        String x1 = '+' + Integer.toString(3457) + "2";
        print(x1);
        print(Integer.valueOf(x1) / 2);

        print("\n example3: =================================================\n");

        format("My name is %s. I am a %s. I have %05d years of work experience. I can work with %d different technologies",
                "Aravind", "Software Engineer", 3, 10);

        print("\n example4: =================================================\n");

        DecimalFormatDemo.example();

        print("\n example5: =================================================\n");

        float x = 1.2f;
        float y = -1.8f;
        int z = 5;

        print(Math.abs(y));
        print(Math.ceil((x)));
        print(Math.floor(x));
        print(Math.rint(y));
        print(Math.round(x));
        print(Math.min(x, y));
        print(Math.max(z, x));

        print(Math.random() * 1000);

        /**
         * double exp(double d): Returns the base of the natural logarithms, e, to the
         * power of the argument.
         * double log(double d): Returns the natural logarithm of the argument.
         * double pow(double base, double exponent): Returns the value of the first
         * argument raised to the power of the second argument.
         * double sqrt(double d): Returns the square root of the argument.
         * 
         * double sin(double d): Returns the sine of the specified double value.
         * double cos(double d): Returns the cosine of the specified double value.
         * double tan(double d): Returns the tangent of the specified double value.
         * double asin(double d): Returns the arcsine of the specified double value.
         * double acos(double d): Returns the arccosine of the specified double value.
         * double atan(double d): Returns the arctangent of the specified double value.
         * double atan2(double y, double x): Converts rectangular coordinates (x, y) to
         * polar coordinate (r, theta) and returns theta.
         * double toDegrees(double d) and double toRadians(double d): Converts the
         * argument to degrees or radians.
         */
    }

    public static void print(Object x) {
        System.out.println(x);
    }

    public static void format(String s, Object... x) {
        System.out.format(s, x);
    }
}

class DecimalFormatDemo {

    static public void customFormat(String pattern, double value) {
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
        System.out.println(value + "  " + pattern + "  " + output);
    }

    public static void example() {

        customFormat("###,###.###", 123456.789);
        customFormat("###.##", 123456.789);
        customFormat("000000.000", 123.78);
        customFormat("$###,###.###", 12345.67);
    }
}