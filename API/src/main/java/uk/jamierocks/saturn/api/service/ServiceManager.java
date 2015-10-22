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
package uk.jamierocks.saturn.api.service;

import java.util.Optional;

/**
 * Represents the service manager.
 * The service manager stores services, and is able to map them to a provider upon request.
 *
 * @since 1.0
 * @author Jamie Mansfield
 */
public interface ServiceManager {

    /**
     * Sets the given service to be provided with the given provider.
     * The type of the given provider is also registered for convenience.
     *
     * @param service the service you wish to map to the given provider.
     * @param provider the provider you wish to be mapped to the given service.
     * @param <T> the type of the provider.
     * @throws ProviderExistsException if the given service has already been mapped to a provider.
     * @since 1.0
     */
    <T> void setProvider(Class<T> service, T provider) throws ProviderExistsException;

    /**
     * Gets the provider for the given service.
     *
     * @param service the service you wish to receive a provider for.
     * @param <T> the type of the provider.
     * @return {@link Optional#empty()} if no provider exists for the requested service,
     *         else {@link Optional#of(Object)} of the provider.
     * @since 1.0
     */
    <T> Optional<T> provide(Class<T> service);
}
