package com.microsoft.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    /**
     * source https://github.com/microsoft/ApplicationInsights-Java/blob/master/agent/instrumentation/build.gradle
     */
    private static Map<String, Integer> mapForEncode = new HashMap<String, Integer>() {{
        put("opentelemetry-javaagent-apache-httpasyncclient-4.1", 0);
        put("opentelemetry-javaagent-apache-httpclient-2.0", 1);
        put("opentelemetry-javaagent-kotlinx-coroutines", 2);
        put("opentelemetry-javaagent-apache-httpclient-4.0", 3);
        put("opentelemetry-javaagent-apache-httpclient-5.0", 4);
        put("opentelemetry-javaagent-applicationinsights-web-2.3", 5);
        put("opentelemetry-javaagent-azure-functions", 6);
        put("opentelemetry-javaagent-cassandra-3.0", 7);
        put("opentelemetry-javaagent-cassandra-4.0", 8);
        put("opentelemetry-javaagent-classloaders", 9);
        put("opentelemetry-javaagent-executors", 10);
        put("opentelemetry-javaagent-grpc-1.5", 11);
        put("opentelemetry-javaagent-http-url-connection", 12);
        put("opentelemetry-javaagent-java-util-logging-spans", 13);
        put("opentelemetry-javaagent-jaxrs-1.0", 14);
        put("opentelemetry-javaagent-jaxrs-2.0-common", 15);
        put("opentelemetry-javaagent-jaxrs-2.0-jersey-2.0", 16);
        put("opentelemetry-javaagent-jaxrs-2.0-resteasy-3.0", 17);
        put("opentelemetry-javaagent-jaxrs-2.0-resteasy-3.1", 18);
        put("opentelemetry-javaagent-jdbc", 19);
        put("opentelemetry-javaagent-jedis-1.4", 20);
        put("opentelemetry-javaagent-jedis-3.0", 21);
        put("opentelemetry-javaagent-jetty-8.0", 22);
        put("opentelemetry-javaagent-jms-1.1", 23);
        put("opentelemetry-javaagent-kafka-clients-0.11", 24);
        put("opentelemetry-javaagent-kafka-streams-0.11", 25);
        put("opentelemetry-javaagent-lettuce-common", 26);
        put("opentelemetry-javaagent-lettuce-4.0", 27);
        put("opentelemetry-javaagent-lettuce-5.0", 28);
        put("opentelemetry-javaagent-lettuce-5.1", 29);
        put("opentelemetry-javaagent-log4j-spans-1.2", 30);
        put("opentelemetry-javaagent-log4j-spans-2.0", 31);
        put("opentelemetry-javaagent-logback-spans-1.0", 32);
        put("opentelemetry-javaagent-micrometer-1.0", 33);
        put("opentelemetry-javaagent-mongo-3.1", 34);
        put("opentelemetry-javaagent-mongo-3.7", 35);
        put("opentelemetry-javaagent-mongo-async-3.3", 36);
        put("opentelemetry-javaagent-netty-4.0", 37);
        put("opentelemetry-javaagent-netty-4.1", 38);
        put("opentelemetry-javaagent-okhttp-3.0", 39);
        put("opentelemetry-javaagent-opentelemetry-api-1.0", 40);
        put("opentelemetry-javaagent-reactor-3.1", 41);
        put("opentelemetry-javaagent-servlet-common", 42);
        put("opentelemetry-javaagent-servlet-2.2", 43);
        put("opentelemetry-javaagent-servlet-3.0", 44);
        put("opentelemetry-javaagent-spring-scheduling-3.1", 45);
        put("opentelemetry-javaagent-spring-webmvc-3.1", 46);
        put("opentelemetry-javaagent-spring-webflux-5.0", 47);
        put("opentelemetry-javaagent-mongo-common", 48);
        put("opentelemetry-javaagent-opentelemetry-annotations-1.0", 49);
        put("opentelemetry-javaagent-reactor-netty-0.9", 50);
        put("opentelemetry-javaagent-reactor-netty-1.0", 51);
        put("opentelemetry-javaagent-tomcat-7.0", 52);
    }};

    /**
     * source https://github.com/microsoft/ApplicationInsights-Java/blob/master/agent/instrumentation/build.gradle
     */
    private static Map<Integer, String> mapForDecoding = new HashMap<Integer, String>() {{
        put(0, "opentelemetry-javaagent-apache-httpasyncclient-4.1");
        put(1, "opentelemetry-javaagent-apache-httpclient-2.0");
        put(2, "opentelemetry-javaagent-kotlinx-coroutines");
        put(3, "opentelemetry-javaagent-apache-httpclient-4.0");
        put(4, "opentelemetry-javaagent-apache-httpclient-5.0");
        put(5, "opentelemetry-javaagent-applicationinsights-web-2.3");
        put(6, "opentelemetry-javaagent-azure-functions");
        put(7, "opentelemetry-javaagent-cassandra-3.0");
        put(8, "opentelemetry-javaagent-cassandra-4.0");
        put(9, "opentelemetry-javaagent-classloaders");
        put(10, "opentelemetry-javaagent-executors");
        put(11, "opentelemetry-javaagent-grpc-1.5");
        put(12, "opentelemetry-javaagent-http-url-connection");
        put(13, "opentelemetry-javaagent-java-util-logging-spans");
        put(14, "opentelemetry-javaagent-jaxrs-1.0");
        put(15, "opentelemetry-javaagent-jaxrs-2.0-common");
        put(16, "opentelemetry-javaagent-jaxrs-2.0-jersey-2.0");
        put(17, "opentelemetry-javaagent-jaxrs-2.0-resteasy-3.0");
        put(18, "opentelemetry-javaagent-jaxrs-2.0-resteasy-3.1");
        put(19, "opentelemetry-javaagent-jdbc");
        put(20, "opentelemetry-javaagent-jedis-1.4");
        put(21, "opentelemetry-javaagent-jedis-3.0");
        put(22, "opentelemetry-javaagent-jetty-8.0");
        put(23, "opentelemetry-javaagent-jms-1.1");
        put(24, "opentelemetry-javaagent-kafka-clients-0.11");
        put(25, "opentelemetry-javaagent-kafka-streams-0.11");
        put(26, "opentelemetry-javaagent-lettuce-common");
        put(27, "opentelemetry-javaagent-lettuce-4.0");
        put(28, "opentelemetry-javaagent-lettuce-5.0");
        put(29, "opentelemetry-javaagent-lettuce-5.1");
        put(30, "opentelemetry-javaagent-log4j-spans-1.2");
        put(31, "opentelemetry-javaagent-log4j-spans-2.0");
        put(32, "opentelemetry-javaagent-logback-spans-1.0");
        put(33, "opentelemetry-javaagent-micrometer-1.0");
        put(34, "opentelemetry-javaagent-mongo-3.1");
        put(35, "opentelemetry-javaagent-mongo-3.7");
        put(36, "opentelemetry-javaagent-mongo-async-3.3");
        put(37, "opentelemetry-javaagent-netty-4.0");
        put(38, "opentelemetry-javaagent-netty-4.1");
        put(39, "opentelemetry-javaagent-okhttp-3.0");
        put(40, "opentelemetry-javaagent-opentelemetry-api-1.0");
        put(41, "opentelemetry-javaagent-reactor-3.1");
        put(42, "opentelemetry-javaagent-servlet-common");
        put(43, "opentelemetry-javaagent-servlet-2.2");
        put(44, "opentelemetry-javaagent-servlet-3.0");
        put(45, "opentelemetry-javaagent-spring-scheduling-3.1");
        put(46, "opentelemetry-javaagent-spring-webmvc-3.1");
        put(47, "opentelemetry-javaagent-spring-webflux-5.0");
        put(48, "opentelemetry-javaagent-mongo-common");
        put(49, "opentelemetry-javaagent-opentelemetry-annotations-1.0");
        put(50, "opentelemetry-javaagent-reactor-netty-0.9");
        put(51, "opentelemetry-javaagent-reactor-netty-1.0");
        put(52, "opentelemetry-javaagent-tomcat-7.0");
    }};

    private static long encode(Set<String> instrumentations) {
        Long number = 0L;
        for (String instrumentation : instrumentations) {
            int index = mapForEncode.get(instrumentation);
            number |= getPowerOf2(index);
        }

        return number;
    }

    private static String decode(long num) {
        StringBuffer sb = new StringBuffer();
        Set<Integer> keySet = mapForDecoding.keySet();
        for(int key : keySet) {
            Long powerVal = getPowerOf2(key);
            if ((powerVal & num) == powerVal) {
                sb.append(mapForDecoding.get(key));
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    private static Long getPowerOf2(int exponent) {
        long result = 1L;
        while (exponent != 0) {
            result *= 2;
            exponent--;
        }
        return result;
    }

    public static void main(String[] args) {
        Set<String> instrumentations = new HashSet<String>() {{
            add("opentelemetry-javaagent-kafka-clients-0.11");
            add("opentelemetry-javaagent-tomcat-7.0");
        }};

        System.out.println("\n############## encoding ##############");
        System.out.println("strings to be encoded as long:");
        for (String val : instrumentations) {
            System.out.println(val);
        }

        long num = encode(instrumentations);
        System.out.println("\nencoded number: " + num + "\nbinary: " + Long.toBinaryString(num));

        System.out.println("\n############## decoding ##############");
        System.out.print("decoded strings: \n" + decode(num));

        System.out.println("\n############## worst case scenario ##############");
        double totalStringBytes = mapForEncode.toString().getBytes().length;
        System.out.println("total string bytes: " + totalStringBytes);
        System.out.println("bytes sent: 8 bytes");
        System.out.println("Saving: " + (totalStringBytes - 8)/totalStringBytes * 100 + "%");
    }
}
