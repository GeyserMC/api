/*
 * Copyright (c) 2019-2022 GeyserMC. http://geysermc.org
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 * @author GeyserMC
 * @link https://github.com/GeyserMC/Geyser
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
    @Deprecated HOLOLENS("Hololens"),
    UWP("Windows"),
    WIN32("Windows x86"),
    DEDICATED("Dedicated"),
    @Deprecated TVOS("Apple TV"),
    /**
     * This is for all PlayStation platforms not just PS4
     */
    PS4("PlayStation"),
    NX("Switch"),
    XBOX("Xbox"),
    @Deprecated WINDOWS_PHONE("Windows Phone"),
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
    @NonNull
    public static BedrockPlatform fromId(int id) {
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
