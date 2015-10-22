/*
 * This file is part of Saturn, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2015, Jamie Mansfield <https://github.com/jamierocks>
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
 */
package uk.jamierocks.saturn.api;

import uk.jamierocks.saturn.api.service.ServiceManager;

/**
 * Represents the game. Where the game is Minecraft.
 * Information such as the version and the internal server will be here.
 *
 * @since 1.0
 * @author Jamie Mansfield
 */
public interface Game {

    /**
     * Gets the game's version, NOT the API version!
     * This is the version of Minecraft.
     *
     * @return the game's version.
     * @since 1.0
     */
    String getVersion();

    /**
     * Gets the game's service manager.
     * See {@link ServiceManager} for more information on what a service manager does.
     *
     * @return the game's service manager.
     * @since 1.0
     */
    ServiceManager getServiceManager();
}
