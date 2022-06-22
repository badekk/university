//Badysiak Paweł s21166 gr.41c
public class ConsoleUtil {

    public static String badArgument(String v) {
        return String.format("Bad %s argument", v);
    }

    public static void emptyArguments() {
        System.out.println("No arguments found.");
        System.out.println("1 argument - mode: encode / decode");
        System.out.println("2 argument - input file");
        System.out.println("3 argument - output file");
    }
}
