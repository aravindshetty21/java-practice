import java.util.Arrays;

public class StringsImpl {
    public static void main(String[] args) {

        char[] charArr = { 'a', 'e', 'i', 'o', 'u' };
        print(charArr.length);
        print(Arrays.toString(charArr));
        String str = new String(charArr);
        print(str);

        String palindrome = "Dot saw I was Tod";
        print(palindrome.length());

        char[] newStr = new char[palindrome.length()];
        palindrome.getChars(0, palindrome.length(), newStr, 0);
        print(new String(newStr));

        print("\n example2: =================================================\n");
        print(str.concat(new String(newStr)));
        print("hello".concat("\sworld!"));
        print("hello" + "\sworld!");

        print("\n example3: =================================================\n");
        // breaking lines with + operators

        String longStr = "very very very very" +
                "long String";

        print(longStr);

        // added in JAVA SE15;
        String longStr2 = """
                very very
                long string
                """;

        print(longStr2);

        print("\n example3: =================================================\n");

        String fs;
        fs = String.format("My name is %s", "Aravind");
        print(fs);

        print("\n example4: =================================================\n");

        int j = 1;
        String s = "" + j;
        print(s);

        String s2 = String.valueOf(j);
        print(s2);

        print("\n example5: =================================================\n");

        s = "23121.56";
        print(s.indexOf('.'));
        print(s.indexOf('1'));
        print(s.indexOf('1', s.indexOf('1') + 1));
        print(s.lastIndexOf('1'));
        print(s.substring(2));
        print(s.substring(2, 4));

        String str2 = "Aravind is a good boy!";
        print(str2.indexOf("is"));
        print(str2.contains("is"));

        print(str2.replace("is", "is not"));

        print("\n example6: =================================================\n");

        final String FPATH = "/home/user/index.html";
        Filename myHomePage = new Filename(FPATH, '/', '.'); // see below for the implementation of file name;
        System.out.println("Extension = " + myHomePage.extension());
        System.out.println("Filename = " + myHomePage.filename());
        System.out.println("Path = " + myHomePage.path());

        /**
         * Other methods
         * .endsWith()
         * .startsWith()
         * .compareTo()
         * .compareToIgnoreCase()
         * .equals()
         * .equalsIgnoreCase()
         * .regionMatches()
         * .matches() -> regex.
         */

        print("\n example7: =================================================\n");

        String searchMe = "Green Eggs and Ham";
        String findMe = "Eggs";
        print(searchMe.indexOf(findMe));
        int searchMeLength = searchMe.length();
        int findMeLength = findMe.length();
        boolean foundIt = false;
        for (int i = 0; i <= (searchMeLength - findMeLength); i++) {
            if (searchMe.regionMatches(i, findMe, 0, findMeLength)) {
                foundIt = true;
                System.out.println(searchMe.substring(i, i + findMeLength));
                break;
            }
        }
        if (!foundIt)
            System.out.println("No match found.");

        print("\n example7: =================================================\n");

        StringBuilder sb = new StringBuilder();
        sb.append("Greetings");
        print(sb);
        sb.setLength(5);
        print(sb);
        sb.insert(3, "hello");
        print(sb);
        sb.deleteCharAt(3);
        print(sb);
        sb.delete(3, 7);
        print(sb);
        sb.setCharAt(3, 'h');
        print(sb);
        sb.replace(3, 5, "eh");
        print(sb);
        print(sb.reverse());
    }

    public static void print(Object x) {
        System.out.println(x);
    }
}

class Filename {
    private String fullPath;
    private char pathSeparator,
            extensionSeparator;

    public Filename(String str, char sep, char ext) {
        fullPath = str;
        pathSeparator = sep;
        extensionSeparator = ext;
    }

    public String extension() {
        int dot = fullPath.lastIndexOf(extensionSeparator);
        return fullPath.substring(dot + 1);
    }

    // gets filename without extension
    public String filename() {
        int dot = fullPath.lastIndexOf(extensionSeparator);
        int sep = fullPath.lastIndexOf(pathSeparator);
        return fullPath.substring(sep + 1, dot);
    }

    public String path() {
        int sep = fullPath.lastIndexOf(pathSeparator);
        return fullPath.substring(0, sep);
    }
}