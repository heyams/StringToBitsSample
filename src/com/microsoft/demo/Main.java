package com.microsoft.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    /**
     * source https://github.com/microsoft/ApplicationInsights-Java/blob/master/agent/instrumentation/build.gradle
     */
    private static Map<String, Long> mapForEncode = new HashMap<String, Long>() {{
        put("opentelemetry-javaagent-apache-httpasyncclient-4.1", 1L);
        put("opentelemetry-javaagent-apache-httpclient-2.0", 2L);
        put("opentelemetry-javaagent-kotlinx-coroutines", 4L);
        put("opentelemetry-javaagent-apache-httpclient-4.0", 8L);
        put("opentelemetry-javaagent-apache-httpclient-5.0", 16L);
        put("opentelemetry-javaagent-applicationinsights-web-2.3", 32L);
        put("opentelemetry-javaagent-azure-functions", 64L);
        put("opentelemetry-javaagent-cassandra-3.0", 128L);
        put("opentelemetry-javaagent-cassandra-4.0", 256L);
        put("'opentelemetry-javaagent-classloaders", 512L);
        put("opentelemetry-javaagent-executors", 1024L);
        put("opentelemetry-javaagent-grpc-1.5", 2048L);
        put("opentelemetry-javaagent-http-url-connection", 4096L);
        put("opentelemetry-javaagent-java-util-logging-spans", 8192L);
        put("opentelemetry-javaagent-jaxrs-1.0", 16384L);
        put("opentelemetry-javaagent-jaxrs-2.0-common", 32768L);
        put("opentelemetry-javaagent-jaxrs-2.0-jersey-2.0", 65536L);
        put("opentelemetry-javaagent-jaxrs-2.0-resteasy-3.0", 131072L);
        put("opentelemetry-javaagent-jaxrs-2.0-resteasy-3.1", 262144L);
        put("opentelemetry-javaagent-jdbc", 524288L);
        put("opentelemetry-javaagent-jedis-1.4", 1048576L);
        put("opentelemetry-javaagent-jedis-3.0", 2097152L);
        put("opentelemetry-javaagent-jetty-8.0", 4194304L);
        put("opentelemetry-javaagent-jms-1.1", 8388608L);
        put("opentelemetry-javaagent-kafka-clients-0.11", 16777216L);
        put("opentelemetry-javaagent-kafka-streams-0.11", 33554432L);
        put("opentelemetry-javaagent-lettuce-common", 67108864L);
        put("opentelemetry-javaagent-lettuce-4.0", 134217728L);
        put("opentelemetry-javaagent-lettuce-5.0", 268435456L);
        put("opentelemetry-javaagent-lettuce-5.1", 536870912L);
        put("opentelemetry-javaagent-log4j-spans-1.2", 1073741824L);
        put("opentelemetry-javaagent-log4j-spans-2.0", 2147483648L);
        put("opentelemetry-javaagent-logback-spans-1.0", 4294967296L);
        put("opentelemetry-javaagent-micrometer-1.0", 8589934592L);
        put("opentelemetry-javaagent-mongo-3.1", 17179869184L);
        put("opentelemetry-javaagent-mongo-3.7", 34359738368L);
        put("opentelemetry-javaagent-mongo-async-3.3", 68719476736L);
        put("opentelemetry-javaagent-netty-4.0", 137438953472L);
        put("opentelemetry-javaagent-netty-4.1", 274877906944L);
        put("opentelemetry-javaagent-okhttp-3.0", 549755813888L);
        put("opentelemetry-javaagent-opentelemetry-api-1.0", 1099511627776L);
        put("opentelemetry-javaagent-reactor-3.1", 2199023255552L);
        put("opentelemetry-javaagent-servlet-common", 4398046511104L);
        put("opentelemetry-javaagent-servlet-2.2", 8796093022208L);
        put("opentelemetry-javaagent-servlet-3.0", 17592186044416L);
        put("opentelemetry-javaagent-spring-scheduling-3.1", 35184372088832L);
        put("opentelemetry-javaagent-spring-webmvc-3.1", 70368744177664L);
        put("opentelemetry-javaagent-spring-webflux-5.0", 140737488355328L);
        put("opentelemetry-javaagent-mongo-common", 281474976710656L);
        put("opentelemetry-javaagent-opentelemetry-annotations-1.0", 562949953421312L);
        put("opentelemetry-javaagent-reactor-netty-0.9", 1125899906842624L);
        put("opentelemetry-javaagent-reactor-netty-1.0", 2251799813685248L);
        put("opentelemetry-javaagent-tomcat-7.0", 4503599627370496L);
    }};

    /**
     * source https://github.com/microsoft/ApplicationInsights-Java/blob/master/agent/instrumentation/build.gradle
     */
    private static Map<Long, String> mapForDecoding = new HashMap<Long, String>() {{
        put(1L, "opentelemetry-javaagent-apache-httpasyncclient-4.1");
        put(2L, "opentelemetry-javaagent-apache-httpclient-2.0");
        put(4L, "opentelemetry-javaagent-kotlinx-coroutines");
        put(8L, "opentelemetry-javaagent-apache-httpclient-4.0");
        put(16L, "opentelemetry-javaagent-apache-httpclient-5.0");
        put(32L, "opentelemetry-javaagent-applicationinsights-web-2.3");
        put(64L, "opentelemetry-javaagent-azure-functions");
        put(128L, "opentelemetry-javaagent-cassandra-3.0");
        put(256L, "opentelemetry-javaagent-cassandra-4.0");
        put(512L, "'opentelemetry-javaagent-classloaders");
        put(1024L, "opentelemetry-javaagent-executors");
        put(2048L, "opentelemetry-javaagent-grpc-1.5");
        put(4096L, "opentelemetry-javaagent-http-url-connection");
        put(8192L, "opentelemetry-javaagent-java-util-logging-spans");
        put(16384L, "opentelemetry-javaagent-jaxrs-1.0");
        put(32768L, "opentelemetry-javaagent-jaxrs-2.0-common");
        put(65536L, "opentelemetry-javaagent-jaxrs-2.0-jersey-2.0");
        put(131072L, "opentelemetry-javaagent-jaxrs-2.0-resteasy-3.0");
        put(262144L, "opentelemetry-javaagent-jaxrs-2.0-resteasy-3.1");
        put(524288L, "opentelemetry-javaagent-jdbc");
        put(1048576L, "opentelemetry-javaagent-jedis-1.4");
        put(2097152L, "opentelemetry-javaagent-jedis-3.0");
        put(4194304L, "opentelemetry-javaagent-jetty-8.0");
        put(8388608L, "opentelemetry-javaagent-jms-1.1");
        put(16777216L, "opentelemetry-javaagent-kafka-clients-0.11");
        put(33554432L, "opentelemetry-javaagent-kafka-streams-0.11");
        put(67108864L, "opentelemetry-javaagent-lettuce-common");
        put(134217728L, "opentelemetry-javaagent-lettuce-4.0");
        put(268435456L, "opentelemetry-javaagent-lettuce-5.0");
        put(536870912L, "opentelemetry-javaagent-lettuce-5.1");
        put(1073741824L, "opentelemetry-javaagent-log4j-spans-1.2");
        put(2147483648L, "opentelemetry-javaagent-log4j-spans-2.0");
        put(4294967296L, "opentelemetry-javaagent-logback-spans-1.0");
        put(8589934592L, "opentelemetry-javaagent-micrometer-1.0");
        put(17179869184L, "opentelemetry-javaagent-mongo-3.1");
        put(34359738368L, "opentelemetry-javaagent-mongo-3.7");
        put(68719476736L, "opentelemetry-javaagent-mongo-async-3.3");
        put(137438953472L, "opentelemetry-javaagent-netty-4.0");
        put(274877906944L, "opentelemetry-javaagent-netty-4.1");
        put(549755813888L, "opentelemetry-javaagent-okhttp-3.0");
        put(1099511627776L, "opentelemetry-javaagent-opentelemetry-api-1.0");
        put(2199023255552L, "opentelemetry-javaagent-reactor-3.1");
        put(4398046511104L, "opentelemetry-javaagent-servlet-common");
        put(8796093022208L, "opentelemetry-javaagent-servlet-2.2");
        put(17592186044416L, "opentelemetry-javaagent-servlet-3.0");
        put(35184372088832L, "opentelemetry-javaagent-spring-scheduling-3.1");
        put(70368744177664L, "opentelemetry-javaagent-spring-webmvc-3.1");
        put(140737488355328L, "opentelemetry-javaagent-spring-webflux-5.0");
        put(281474976710656L, "opentelemetry-javaagent-mongo-common");
        put(562949953421312L, "opentelemetry-javaagent-opentelemetry-annotations-1.0");
        put(1125899906842624L, "opentelemetry-javaagent-reactor-netty-0.9");
        put(2251799813685248L, "opentelemetry-javaagent-reactor-netty-1.0");
        put(4503599627370496L, "opentelemetry-javaagent-tomcat-7.0");
    }};

    private static long encode(Set<String> instrumentations) {
        Long number = 0L;
        for (String instrumentation : instrumentations) {
            Long index = mapForEncode.get(instrumentation);
            number = number | index;
        }

        return number;
    }

    private static String decode(long num) {
        StringBuffer sb = new StringBuffer();
        Set<Long> keySet = mapForDecoding.keySet();
        for(long key : keySet) {
            if ((key & num) == key) {
                sb.append(mapForDecoding.get(key));
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    private static void printTwoToPowerOf(int power) {
        long result = 1L;
        while (power > 0) {
            result = result << 1;
            power--;
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
//        printTwoToPowerOf(64);

        Set<String> instrumentations = new HashSet<String>() {{
            add("opentelemetry-javaagent-reactor-netty-1.0");
            add("opentelemetry-javaagent-kotlinx-coroutines");
            add("opentelemetry-javaagent-mongo-async-3.3");
            add("opentelemetry-javaagent-mongo-common");
        }};

        System.out.println("\n############## encoding ##############");
        System.out.println("strings to be encoded as long:");
        for (String val : instrumentations) {
            System.out.println(val);
        }

        long num = encode(instrumentations);
        System.out.println("encoded number: " + num + "\nbinary: " + Long.toBinaryString(num));

        System.out.println("\n############## decoding ##############");
        System.out.print("decoded strings: \n" + decode(num));

        System.out.println("\n############## worst case scenario ##############");
        double totalStringBytes = mapForEncode.toString().getBytes().length;
        System.out.println("total string bytes: " + totalStringBytes);
        System.out.println("bytes sent: 8 bytes");
        System.out.println("Saving: " + (totalStringBytes - 8)/totalStringBytes * 100 + "%");
    }
}
