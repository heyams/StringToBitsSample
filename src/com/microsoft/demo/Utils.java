package com.microsoft.demo;

import java.util.Base64;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Utils {

    static Set<String> decode(String base64EncodedString, Map<Integer, String> decoderMap) {
        long num = decodeBase64EncodedStringAsLong(base64EncodedString);
        Set<String> result = new HashSet<>();
        for(Map.Entry<Integer, String> entry: decoderMap.entrySet()) {
            double value = entry.getKey();
            long powerVal = (long) Math.pow(2, value);
            if ((powerVal & num) == powerVal) {
                result.add(entry.getValue());
            }
        }

        return result;
    }

    static String encode(Set<String> features, Map<String, Integer> encoderMap) {
        BitSet bitSet = new BitSet(64);
        for (String feature : features) {
            int index = encoderMap.get(feature);
            bitSet.set(index);
        }

        long[] longArray = bitSet.toLongArray();
        System.out.println("long: " + longArray[0] + "\n");

        return Base64.getEncoder().withoutPadding().encodeToString(bitSet.toByteArray());
    }

    static long decodeBase64EncodedStringAsLong(String base64EncodedString) {
        byte[] bytes = Base64.getDecoder().decode(base64EncodedString.getBytes());
        long result = 0;
        for (int i = 0; i < bytes.length; i++) {
            result += ((long) bytes[i] & 0xffL) << (8 * i); // use Big Endian Byte Order.
        }
        return result;
    }
}
