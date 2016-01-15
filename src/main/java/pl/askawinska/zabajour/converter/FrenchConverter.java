package pl.askawinska.zabajour.converter;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class FrenchConverter implements Converter {

    protected static final Map<String, String> SINGLES = new com.google.common.collect.ImmutableMap.Builder<String, String>()
            //@formatter:off
            .put("a", "a")
            .put("b", "b")
            .put("c", "ts")
            .put("d", "d")
            .put("e", "ai")
            .put("f", "f")
            .put("g", "g")
            .put("h", "h")
            .put("i", "i")
            .put("j", "ill")
            .put("k", "k")
            .put("m", "m")
            .put("n", "n")
            .put("o", "o")
            .put("p", "pp")
            .put("r", "r")
            .put("s", "s")
            .put("t", "t")
            .put("u", "ou")
            .put("w", "v")
            .put("y", "é")
            .put("z", "z")
            .put("ą", "ont")
            .put("ę", "ain")
            .put("ć", "tchi")
            .put("ł", "u")
            .put("ń", "gn")
            .put("ó", "où")
            .put("ś", "ch")
            .put("ź", "gi")
            .put("ż", "j")
            .build();
            //@formatter:on

    protected static final Map<String, String> DIGRAMS = new com.google.common.collect.ImmutableMap.Builder<String, String>()
            //@formatter:off
            .put("ch", "h")
            .put("cz", "tch")
            .put("dź", "jea")
            .put("dż", "dj")
            .put("rz", "j")
            .put("sz", "ch")
            .put("ci", "tchi")
            .put("dzi", "jea")
            .put("ni", "gn")
            .put("si", "ch")
            .put("zi", "gi")
            .put("ła", "oi")
            .build();
            //@formatter:on

    @Override
    public String convert(final String convertMe) {

        StringBuffer meltdown = new StringBuffer(convertMe);
        StringBuffer translation = new StringBuffer(convertMe);

        for (String pattern : DIGRAMS.keySet()) {
            int found = meltdown.indexOf(pattern);
            while (found >= 0) {
                meltdown.replace(found, found + pattern.length(), howManyStars(DIGRAMS.get(pattern).length()));
                translation.replace(found, found + pattern.length(), DIGRAMS.get(pattern));

                found = meltdown.indexOf(pattern);
            }
        }

        for (String pattern : SINGLES.keySet()) {
            int found = meltdown.indexOf(pattern);
            while (found >= 0) {
                meltdown.replace(found, found + pattern.length(), howManyStars(SINGLES.get(pattern).length()));
                translation.replace(found, found + pattern.length(), SINGLES.get(pattern));

                found = meltdown.indexOf(pattern);
            }
        }

        return translation.toString();
    }

    private String howManyStars(final int length) {
        switch (length) {
        case 1:
            return "*";
        case 2:
            return "**";
        case 3:
            return "***";
        case 4:
            return "****";
        default:
            throw new RuntimeException();
        }
    }

}
