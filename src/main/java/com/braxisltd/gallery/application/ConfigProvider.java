package com.braxisltd.gallery.application;

import com.google.common.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ConfigProvider {

    private static Logger logger = LoggerFactory.getLogger(ConfigProvider.class);

    private static ResourceBundle properties;
    private static ResourceBundle specifiedProperties;

    public static <T> T provide(Class<T> config) {
        return (T) Proxy.newProxyInstance(ConfigProvider.class.getClassLoader(), new Class[]{config}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String propertyName = method.getName().replaceAll("get", "");
                if (!getProperties().containsKey(propertyName)) {
                    throw new ConfigurationException(String.format("Property %s does not exist in config.properties", propertyName));
                }
                String propertyString = getProperties().getString(propertyName);
                if (method.getReturnType().equals(int.class)) {
                    return Integer.parseInt(propertyString);
                }
                return propertyString;
            }
        });
    }

    public static <T> T provide(final String path, Class<T> config) {
        return (T) Proxy.newProxyInstance(ConfigProvider.class.getClassLoader(), new Class[]{config}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String propertyName = method.getName().replaceAll("get", "");
                if (!getProperties(path).containsKey(propertyName)) {
                    throw new ConfigurationException(String.format("Property %s does not exist in config.properties", propertyName));
                }
                String propertyString = getProperties(path).getString(propertyName);
                if (method.getReturnType().equals(int.class)) {
                    return Integer.parseInt(propertyString);
                }
                return propertyString;
            }
        });
    }

    private static ResourceBundle getProperties() {
        if (properties == null) {
            try {
                logger.debug("Loading configuration config.properties");
                properties = new PropertyResourceBundle(Resources.getResource("config.properties").openStream());
            } catch (IOException e) {
                throw new ConfigurationException("Unable to open config.properties");
            }
        }
        return properties;
    }

    private static ResourceBundle getProperties(String path) {
        if (specifiedProperties == null) {
            try {
                logger.debug(String.format("Loading configuration %s", path));
                specifiedProperties = new PropertyResourceBundle(new FileInputStream(path));
            } catch (IOException e) {
                throw new ConfigurationException("Unable to open config.properties");
            }
        }
        return specifiedProperties;
    }
}
