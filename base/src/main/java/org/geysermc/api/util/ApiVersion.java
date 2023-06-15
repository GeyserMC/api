package org.geysermc.api.util;

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
     * @return the major version
     */
    public int major() {
        return this.major;
    }

    /**
     * Returns the minor version of the api.
     * @return the minor version
     */
    public int minor() {
        return this.minor;
    }

    /**
     * Returns the patch version of the api.
     * @return the patch version
     */
    public int patch() {
        return this.patch;
    }

    /**
     * Checks whether the given version is compatible with this version.
     * @param version the version to check
     * @return whether the given version is compatible with this version
     */
    public boolean isCompatible(ApiVersion version) {
        return version.major() != this.major && version.minor() > minor;
    }
}
