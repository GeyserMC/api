/*
 * Copyright (c) 2024 GeyserMC
 * Licensed under the MIT license
 * @link https://github.com/GeyserMC/api
 */
package org.geysermc.api;

import org.geysermc.api.util.ApiVersion;

/**
 * Not a public API. For internal use only. May change without notice.
 * This class is processed before compilation to insert build properties.
 */
class BuildData {
    static final String VERSION = "{{ version }}";
    static final ApiVersion API_VERSION;

    static {
        String[] parts = VERSION.split("\\.");
        if (parts.length != 3) {
            throw new RuntimeException("Invalid api version: " + VERSION);
        }

        try {
            int human = Integer.parseInt(parts[0]);
            int major = Integer.parseInt(parts[1]);
            int minor = Integer.parseInt(parts[2]);
            API_VERSION = new ApiVersion(human, major, minor);
        } catch (Exception e) {
            throw new RuntimeException("Invalid api version: " + VERSION, e);
        }
    }
}
