/*
 * Copyright (c) 2021-2024 GeyserMC
 * Licensed under the MIT license
 * @link https://github.com/GeyserMC/api
 */
package org.geysermc.api;

import java.util.List;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.common.value.qual.IntRange;
import org.geysermc.api.connection.Connection;
import org.geysermc.api.util.ApiVersion;
import org.geysermc.cumulus.form.Form;
import org.geysermc.cumulus.form.util.FormBuilder;

/**
 * The base API class.
 */
public interface GeyserApiBase {
    /**
     * Gets the connection from the given UUID, if applicable. The player must be logged in to the Java server
     * for this to return a non-null value.
     *
     * @param uuid the UUID of the connection
     * @return the connection from the given UUID, if applicable
     */
    @Nullable Connection connectionByUuid(@NonNull UUID uuid);

    /**
     * Gets the connection from the given XUID, if applicable. This method only works for online connections.
     *
     * @param xuid the XUID of the session
     * @return the connection from the given UUID, if applicable
     */
    @Nullable Connection connectionByXuid(@NonNull String xuid);

    /**
     * Method to determine if the given <b>online</b> player is a Bedrock player.
     *
     * @param uuid the uuid of the online player
     * @return true if the given online player is a Bedrock player
     */
    boolean isBedrockPlayer(@NonNull UUID uuid);

    /**
     * Sends a form to the given connection and opens it.
     *
     * @param uuid the uuid of the connection to open it on
     * @param form the form to send
     * @return whether the form was successfully sent
     */
    boolean sendForm(@NonNull UUID uuid, @NonNull Form form);

    /**
     * Sends a form to the given connection and opens it.
     *
     * @param uuid        the uuid of the connection to open it on
     * @param formBuilder the formBuilder to send
     * @return whether the form was successfully sent
     */
    boolean sendForm(@NonNull UUID uuid, @NonNull FormBuilder<?, ?, ?> formBuilder);

    /**
     * Transfer the given connection to a server. A Bedrock player can successfully transfer to the same server they are
     * currently playing on.
     *
     * @param uuid    the uuid of the connection
     * @param address the address of the server
     * @param port    the port of the server
     * @return true if the transfer was a success
     */
    boolean transfer(@NonNull UUID uuid, @NonNull String address, @IntRange(from = 0, to = 65535) int port);

    /**
     * Returns all the online connections.
     */
    @NonNull List<? extends Connection> onlineConnections();

    /**
     * Returns the amount of online connections.
     */
    int onlineConnectionsCount();

    /**
     * Returns the prefix used by Floodgate. Will be null when the auth-type isn't Floodgate.
     */
    @MonotonicNonNull String usernamePrefix();

    /**
     * @deprecated in favor of {@link #baseApiVersion()}.
     */
    @Deprecated
    default int majorApiVersion() {
        return baseApiVersion().human();
    }

    /**
     * @deprecated in favor of {@link #baseApiVersion()}.
     */
    @Deprecated
    default int minorApiVersion() {
        return baseApiVersion().major();
    }

    /**
     * Returns the Base API version.
     */
    default ApiVersion baseApiVersion() {
        return BuildData.API_VERSION;
    }
}
