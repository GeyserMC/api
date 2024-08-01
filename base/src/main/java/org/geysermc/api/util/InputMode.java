/*
 * Copyright (c) 2021-2024 GeyserMC
 * Licensed under the MIT license
 * @link https://github.com/GeyserMC/api
 */
package org.geysermc.api.util;

import org.checkerframework.checker.nullness.qual.NonNull;

public enum InputMode {
    UNKNOWN,
    KEYBOARD_MOUSE,
    TOUCH,
    CONTROLLER,
    VR;

    private static final InputMode[] VALUES = values();

    /**
     * Get the InputMode from the identifier.
     *
     * @param id the InputMode identifier
     * @return The InputMode or {@link #UNKNOWN} if the mode wasn't found
     */
    public static @NonNull InputMode fromId(int id) {
        return VALUES.length > id ? VALUES[id] : VALUES[0];
    }
}
