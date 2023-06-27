package org.geysermc.api.util;

/**
 * Represents a version of the api.
 */
public class ApiVersion {
    private final int major;
    private final int minor;
    private final int patch;

    public ApiVersion(int major, int minor, int patch) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
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
     * Returns the patch version of the api.
     *
     * @return the patch version
     */
    public int patch() {
        return this.patch;
    }

    /**
     * Checks whether the given version is compatible with this version.
     * The parameters show the desired API version, which is checked against this present API version.
     * The major versions must match, and the desired minor version must be equal or smaller than this minor version.
     * If the minor versions match, then the desired patch version must be equal or smaller than this patch version.
     *
     * @param major the desired major version
     * @param minor the desired minor version
     * @param patch the desired patch version
     * @return true if the desired API version is compatible with the present API version
     */
    public boolean isCompatible(int major, int minor, int patch) {
        return major == this.major
                && minor <= this.minor
                && (patch <= this.patch || minor < this.minor);
    }
}
