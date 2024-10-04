public class CharactersImpl {
    public static void main(String[] args) {
        char ch = 'a';
        // Unicode for uppercase Greek omega character
        char uniChar = '\u03A9';
        // an array of chars
        char[] charArray = { 'a', 'b', 'c', 'd', 'e' };

        print(Character.isLetter('a'));
        print(Character.isLetter('1'));
        print(Character.isDigit('2'));
        print(Character.isWhitespace(' '));
        print(Character.isUpperCase('a'));
        print(Character.isLowerCase('a'));
        print(Character.isLowerCase('1'));
        print(Character.isUpperCase('1'));
        print(Character.toString('2'));

    }

    public static void print(Object x) {
        System.out.println(x);
    }
}
