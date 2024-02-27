package co.edu.escuelaing.sparkdockerdemolive;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

public class SparkWebServer {
    public static void main(String... args) {
        port(getPort());
        staticFiles.location("/public");
        get("hello", (req, res) -> "Hello Docker!");
        get("sin/:num", (req, res) -> "The sine of " + req.params(":num") + " is "
                + Math.sin(Math.toRadians(Double.valueOf(req.params(":num")))));
        get("cos/:num", (req, res) -> "The cosine of " + req.params(":num") + " is "
                + Math.cos(Math.toRadians(Double.valueOf(req.params(":num")))));
        get("palindrome/:word",
                (req, res) -> {
                    String result = "The word " + req.params(":word");
                    String isPalindrome = checkPalindrome(req.params(":word")) ? " is palindrome"
                            : " is not palindrome";
                    return result + isPalindrome;
                });
        get("module/:coords", (req, res) -> "The module of the given vector is " + vectorModule(req.params(":coords")));
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static boolean checkPalindrome(String word) {
        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }

        return word.equals(reversed);
    }

    private static String vectorModule(String coords) {
        String[] coords_divided = coords.split(",");
        double a = Double.parseDouble(coords_divided[0]);
        double b = Double.parseDouble(coords_divided[1]);
        return String.valueOf(Math.sqrt(a * a + b * b));
    }

}