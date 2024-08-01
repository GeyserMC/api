/*
 * Copyright (c) 2024 GeyserMC
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
 * @link https://github.com/GeyserMC/api
 */
package org.geysermc.api.util;

/**
 * Represents a version of an api.
 */
public class ApiVersion {
    private final int human;
    private final int major;
    private final int minor;

    public ApiVersion(int human, int major, int minor) {
        this.human = human;
        this.major = major;
        this.minor = minor;
    }

    /**
     * Returns the human version of the api.
     */
    public int human() {
        return this.human;
    }

    /**
     * Returns the major version of the api.
     */
    public int major() {
        return this.major;
    }

    /**
     * Returns the minor version of the api.
     */
    public int minor() {
        return this.minor;
    }

    /**
     * Checks whether an API described by this version has a good likelihood of supporting an API consumer.
     * <p>
     * The compatibility is described as follows:
     * The human version must match.
     * The requested major version must be equal or smaller than this major version.
     * If the major versions are equal, the requested minor version must be equal or smaller than this minor version.
     *
     * @param human the requested human version
     * @param major the requested major version
     * @param minor the requested minor version
     * @return a {@link Compatibility} indicating whether this version may support the requested version
     */
    public Compatibility supportsRequestedVersion(int human, int major, int minor) {
        if (human != this.human) {
            return Compatibility.HUMAN_DIFFER;
        }

        if (major > this.major) {
            return Compatibility.MAJOR_TOO_NEW;
        }

        if (minor > this.minor && major >= this.major) {
            return Compatibility.MINOR_TOO_NEW;
        }

        return Compatibility.COMPATIBLE;
    }

    /**
     * Describes compatibility between the current version of an API and a requested version
     */
    public enum Compatibility {
        COMPATIBLE("The api versions are compatible!"),
        HUMAN_DIFFER("The requested human api version does not match!"),
        MAJOR_TOO_NEW("The requested major api version is too high!"),
        MINOR_TOO_NEW("The requested minor api version is too high!");

        private final String reason;

        Compatibility(String reason) {
            this.reason = reason;
        }

        public String cause() {
            return this.reason;
        }
    }
}
