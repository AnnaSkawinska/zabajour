package pl.xsolve.zabajour;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(final String... args) {
        FrenchConverter frenchConverter = new FrenchConverter();

        printConversion(frenchConverter, "litwo, ojczyzno moja, ty jesteś jak zdrowie. szopen.");
    }

    private static void printConversion(final FrenchConverter frenchConverter, final String s) {
        System.out.println(s + " -> " + frenchConverter.convert(s));
    }
}
