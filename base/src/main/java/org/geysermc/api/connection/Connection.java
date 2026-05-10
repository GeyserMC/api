/*
 * Copyright (c) 2021-2026 GeyserMC
 * Licensed under the MIT license
 * @link https://github.com/GeyserMC/api
 */
package org.geysermc.api.connection;

import java.util.UUID;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.common.value.qual.IntRange;
import org.geysermc.api.util.BedrockPlatform;
import org.geysermc.api.util.InputMode;
import org.geysermc.api.util.UiProfile;
import org.geysermc.cumulus.form.Form;
import org.geysermc.cumulus.form.util.FormBuilder;

/**
 * Represents a player connection.
 */
public interface Connection {
    /**
     * Returns the bedrock name of the connection.
     */
    String bedrockUsername();

    /**
     * Returns the java name of the connection.
     */
    @MonotonicNonNull String javaUsername();

    /**
     * Returns the UUID of the connection.
     */
    @MonotonicNonNull UUID javaUuid();

    /**
     * Returns the XUID of the connection.
     */
    String xuid();

    /**
     * Returns the version of the Bedrock client.
     */
    String version();

    /**
     * Returns the platform that the connection is playing on.
     */
    BedrockPlatform platform();

    /**
     * Returns the language code of the connection.
     */
    String languageCode();

    /**
     * Returns the User Interface Profile of the connection.
     */
    UiProfile uiProfile();

    /**
     * Returns the Input Mode of the Bedrock client.
     */
    InputMode inputMode();

    /**
     * Returns whether the connection is linked.
     * This will always return false when the auth-type isn't Floodgate.
     */
    boolean isLinked();

    /**
     * Sends a form to the connection and opens it.
     *
     * @param form the form to send
     * @return whether the form was successfully sent
     */
    boolean sendForm(Form form);

    /**
     * Sends a form to the connection and opens it.
     *
     * @param formBuilder the formBuilder to send
     * @return whether the form was successfully sent
     */
    boolean sendForm(FormBuilder<?, ?, ?> formBuilder);

    /**
     * Transfer the connection to a server. A Bedrock player can successfully transfer to the same server they are
     * currently playing on.
     *
     * @param address the address of the server
     * @param port    the port of the server
     * @return true if the transfer was a success
     */
    boolean transfer(String address, @IntRange(from = 0, to = 65535) int port);
}
