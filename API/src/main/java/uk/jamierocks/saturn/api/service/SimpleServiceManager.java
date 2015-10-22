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

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Optional;

/**
 * The simple implementation of {@link ServiceManager}.
 *
 * @author Jamie Mansfield
 * @since 1.0
 */
public class SimpleServiceManager implements ServiceManager {

    private final Map<Class<?>, Object> providers = Maps.newConcurrentMap();

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> void setProvider(Class<T> service, T provider) throws ProviderExistsException {
        Preconditions.checkNotNull(service);
        Preconditions.checkNotNull(provider);

        if (!this.providers.containsKey(service) && !this.providers.containsKey(provider.getClass())) {
            this.providers.put(service, provider);
            this.providers.put(provider.getClass(), provider);
        } else {
            throw new ProviderExistsException();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> Optional<T> provide(Class<T> service) {
        Preconditions.checkNotNull(service);
        T provider = (T) this.providers.get(service);
        return provider != null ? Optional.of(provider) : Optional.empty();
    }
}