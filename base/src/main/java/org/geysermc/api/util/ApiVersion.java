package org.geysermc.api.util;

/**
 * Represents a version of the api.
 */
public class ApiVersion {
    private final int human;
    private final int major;
    private final int minor;

    public ApiVersion(int human, int minor, int patch) {
        this.human = human;
        this.major = minor;
        this.minor = patch;
    }

    /**
     * Returns the human version of the api.
     *
     * @return the human version
     */
    public int human() {
        return this.human;
    }

    /**
     * Returns the major version of the api.
     *
     * @return the major version
     */
    public int major() {
        return this.major;
    }

    /**
     * Returns the minor version of the api.
     *
     * @return the minor version
     */
    public int minor() {
        return this.minor;
    }

    /**
     * Checks whether the requested version is compatible with this version.
     * The parameters represent the desired api version, which is checked against this version.
     * The human version must match, and the desired major version must be equal or smaller than this major version.
     * If the major versions match, then the desired minor version must be equal or smaller than this minor version.
     *
     * @param human the desired human version
     * @param major the desired major version
     * @param minor the desired minor version
     * @return a {@link Compatibility} indicating whether the versions are compatible
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
     * Used in {@link #supportsRequestedVersion(int, int, int)} to inform users about compatibility levels
     * between a requested api version and this version.
     */
    public enum Compatibility {
        COMPATIBLE("The api versions are compatible!"),
        HUMAN_DIFFER("The human api version does not match!"),
        MAJOR_TOO_NEW("The major api version is too high!"),
        MINOR_TOO_NEW("The minor api version is too high!");

        private final String reason;

        Compatibility(String reason) {
            this.reason = reason;
        }

        public String cause() {
            return this.reason;
        }
    }
}
