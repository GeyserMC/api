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
     * The parameters show the desired API version, that is checked against the API version present.
     * Major version must match, desired minor must be equal or smaller, same for patch.
     * Patch version is ignored if the desired minor version is smaller than this minor version.
     *
     * @param major the major version to check against
     * @param minor the minor version to check against
     * @param patch the patch version to check against
     * @return whether the desired API version is compatible with the present API version
     */
    public boolean isCompatible(int major, int minor, int patch) {
        return major == this.major
                && minor <= this.minor
                && (patch <= this.patch || minor < this.minor);
    }
}
