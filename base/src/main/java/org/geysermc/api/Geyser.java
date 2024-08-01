/*
 * Copyright (c) 2021-2024 GeyserMC
 * Licensed under the MIT license
 * @link https://github.com/GeyserMC/api
 */
package org.geysermc.api;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * General API class for Geyser.
 */
public class Geyser {
    private static GeyserApiBase api;

    /**
     * Returns the base api.
     *
     * @return the base api
     */
    public static @NonNull GeyserApiBase api() {
        if (api == null) {
            throw new RuntimeException("Api has not been registered yet!");
        }

        return api;
    }

    /**
     * Returns the api of the given type.
     *
     * @param apiClass the api class
     * @param <T> the type
     * @return the api of the given type
     */
    @SuppressWarnings("unchecked")
    public static <T extends GeyserApiBase> T api(@NonNull Class<T> apiClass) {
        if (apiClass.isInstance(api)) {
            return (T) api;
        }

        if (api == null) {
            throw new RuntimeException("Api has not been registered yet!");
        } else {
            throw new RuntimeException("Api was not an instance of " + apiClass + "! Was "
                    + api.getClass().getCanonicalName());
        }
    }

    /**
     * Registers the given api type. The api cannot be
     * registered if {@link #isRegistered()} is true as
     * an api has already been specified.
     *
     * @param api the api
     */
    public static void set(@NonNull GeyserApiBase api) {
        if (Geyser.api != null) {
            throw new RuntimeException("Cannot redefine already registered api!");
        }

        Geyser.api = api;
    }

    /**
     * Gets if the api has been registered and
     * is ready for usage.
     *
     * @return if the api has been registered
     */
    public static boolean isRegistered() {
        return api != null;
    }
}
