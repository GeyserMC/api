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

package org.geysermc.geyser.api.command;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Map;

/**
 * Manages Bedrock commands within Geyser.
 */
public abstract class CommandManager {

    /**
     * Provides a {@link Command.Builder}.
     *
     * @param sourceType the command source type
     * @param <T> the type
     * @return a command builder
     */
    protected abstract <T extends CommandSource> Command.Builder<T> provideBuilder(Class<T> sourceType);

    /**
     * Registers the given {@link Command}.
     *
     * @param command the command to register
     */
    public abstract void register(@NonNull Command command);

    /**
     * Unregisters the given {@link Command}.
     *
     * @param command the command to unregister
     */
    public abstract void unregister(@NonNull Command command);

    /**
     * Gets all the registered {@link Command}s.
     *
     * @return all the registered commands
     */
    @NonNull
    public abstract Map<String, Command> commands();
}
