package com.superkei.kafka.connect.cassandra.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

public class Version {
    private static final Logger log = LoggerFactory.getLogger(Version.class);
    private static final String PATH = "/kafka-connect-cassandra-version.properties";
    private static String version = "unknown";

    static {
        try (InputStream stream = Version.class.getResourceAsStream(PATH)) {
            Properties props = new Properties();
            props.load(stream);
            version = props.getProperty("version", version).trim();
        } catch (Exception e) {
            log.warn("Error while loading version:", e);
        }
    }

    public static String getVersion() {
        return version;
    }
}