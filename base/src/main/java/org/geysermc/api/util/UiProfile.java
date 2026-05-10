/*
 * Copyright (c) 2021-2026 GeyserMC
 * Licensed under the MIT license
 * @link https://github.com/GeyserMC/api
 */
package org.geysermc.api.util;

public enum UiProfile {
    CLASSIC,
    POCKET;

    private static final UiProfile[] VALUES = values();

    /**
     * Get the UiProfile from the identifier.
     *
     * @param id the UiProfile identifier
     * @return The UiProfile or {@link #CLASSIC} if the profile wasn't found
     */
    public static UiProfile fromId(int id) {
        return VALUES.length > id ? VALUES[id] : VALUES[0];
    }
}
