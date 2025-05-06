package org.geysermc.api.util;

/**
 * Represents a version of an api.
 * @since 1.0.1
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
     * @since 1.0.1
     */
    public int human() {
        return this.human;
    }

    /**
     * Returns the major version of the api.
     * @since 1.0.1
     */
    public int major() {
        return this.major;
    }

    /**
     * Returns the minor version of the api.
     * @since 1.0.1
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
     * @since 1.0.1
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
     * Returns a human-readable string of the version.
     * Example: "1.0.0"
     * @since 1.0.2
     */
    public String toString() {
        return human + "." + major + "." + minor;
    }

    /**
     * Describes compatibility between the current version of an API and a requested version
     * @since 1.0.1
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
