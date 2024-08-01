/*
 * Copyright (c) 2021-2024 GeyserMC
 * Licensed under the MIT license
 * @link https://github.com/GeyserMC/api
 */
package org.geysermc.api.util;

import org.checkerframework.checker.nullness.qual.NonNull;

public enum BedrockPlatform {
    UNKNOWN("Unknown"),
    GOOGLE("Android"),
    IOS("iOS"),
    OSX("macOS"),
    AMAZON("Amazon"),
    GEARVR("Gear VR"),
    @Deprecated
    HOLOLENS("Hololens"),
    UWP("Windows"),
    WIN32("Windows x86"),
    DEDICATED("Dedicated"),
    @Deprecated
    TVOS("Apple TV"),
    /**
     * This is for all PlayStation platforms not just PS4
     */
    PS4("PlayStation"),
    NX("Switch"),
    XBOX("Xbox"),
    @Deprecated
    WINDOWS_PHONE("Windows Phone"),
    LINUX("Linux");

    private static final BedrockPlatform[] VALUES = values();

    private final String displayName;

    BedrockPlatform(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Get the BedrockPlatform from the identifier.
     *
     * @param id the BedrockPlatform identifier
     * @return The BedrockPlatform or {@link #UNKNOWN} if the platform wasn't found
     */
    public static @NonNull BedrockPlatform fromId(int id) {
        return id < VALUES.length ? VALUES[id] : VALUES[0];
    }

    /**
     * @return friendly display name of platform.
     */
    @Override
    public String toString() {
        return displayName;
    }
}
