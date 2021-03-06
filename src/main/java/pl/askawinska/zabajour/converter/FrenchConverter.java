package pl.askawinska.zabajour.converter;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.common.base.Optional;
import com.google.common.base.Strings;

@Component
public class FrenchConverter implements Converter {

    protected static final String ALREADY_MAPPED_MARKER = "*";

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

    protected static final Map<String, String> WHOLE_WORDS = new com.google.common.collect.ImmutableMap.Builder<String, String>()
            //@formatter:off
            .put("o", "eau")
            .build();
            //@formatter:on

    protected String convertee;
    protected StringBuffer alreadyMappedExcluded;
    protected StringBuffer translation;

    @Override
    public String convert(final String convertee) {
        reset(convertee);

        map(DIGRAMS);
        map(SINGLES);
        mapWholeWord(WHOLE_WORDS);

        return translation.toString();
    }

    protected void reset(final String convertee) {
        this.convertee = convertee;
        Optional<String> nullSafeConvertee = Optional.fromNullable(convertee);
        alreadyMappedExcluded = new StringBuffer(nullSafeConvertee.or(""));
        translation = new StringBuffer(nullSafeConvertee.or(""));
    }

    protected void map(final Map<String, String> mapping) {
        for (Map.Entry<String, String> entry : mapping.entrySet()) {
            int found = alreadyMappedExcluded.indexOf(entry.getKey());
            while (found >= 0) {
                alreadyMappedExcluded.replace(found, found + entry.getKey().length(),
                        Strings.repeat(ALREADY_MAPPED_MARKER, entry.getValue().length()));
                translation.replace(found, found + entry.getKey().length(), entry.getValue());

                found = alreadyMappedExcluded.indexOf(entry.getKey());
            }
        }
    }

    protected void mapWholeWord(final Map<String, String> mapping) {
        String replaceMe = translation.toString();
        for (Map.Entry<String, String> entry : mapping.entrySet()) {
            replaceMe = replaceMe.replaceAll("\\b(" + entry.getKey() + ")\\b", entry.getValue());
        }
        translation = new StringBuffer(replaceMe);
    }

}
