package com.microsoft.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Feature {

    private static final Map<String, Integer> FEATURE_MAP_ENCODING;
    private static final Map<Integer, String> FEATURE_MAP_DECODING;

    static {
        FEATURE_MAP_ENCODING = new HashMap<>();
        FEATURE_MAP_ENCODING.put("Oracle Corporation", 0); // https://www.oracle.com/technetwork/java/javase/downloads/index.html
        FEATURE_MAP_ENCODING.put("Azul Systems, Inc.", 1); // https://www.azul.com/downloads/zulu/
        FEATURE_MAP_ENCODING.put("Microsoft", 2); // https://www.azul.com/downloads/zulu/
        FEATURE_MAP_ENCODING.put("AdoptOpenJDK", 3); // https://adoptopenjdk.net/
        FEATURE_MAP_ENCODING.put("Red Hat, Inc.", 4); // https://developers.redhat.com/products/openjdk/download/

        FEATURE_MAP_DECODING = new HashMap<>();
        FEATURE_MAP_DECODING.put(0, "Oracle Corporation");
        FEATURE_MAP_DECODING.put(1, "Azul Systems, Inc.");
        FEATURE_MAP_DECODING.put(2, "Microsoft");
        FEATURE_MAP_DECODING.put(3, "AdoptOpenJDK");
        FEATURE_MAP_DECODING.put(4, "Red Hat, Inc.");
        FEATURE_MAP_DECODING.put(5, "Other");
    }

    public static void main(String[] args) {
        Set<String> features = new HashSet<>() {{
            add("Azul Systems, Inc.");
        }};

        System.out.println("Expected features: ");
        System.out.println(features + "\n");
        String base64EncodedString = Utils.encode(features, FEATURE_MAP_ENCODING);
        System.out.println("convert long to base64 encoded string: " + base64EncodedString + "\n");
        System.out.println("Actual instrumentations: ");
        Set<String> decodedFeatures = Utils.decode(base64EncodedString, FEATURE_MAP_DECODING);
        assert (features.equals(decodedFeatures));
        System.out.println(decodedFeatures);
    }
}
