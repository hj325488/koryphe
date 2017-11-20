/*
 * Copyright 2017 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.gov.gchq.koryphe.impl.function;

import com.google.common.collect.Iterables;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import uk.gov.gchq.koryphe.function.KorypheFunction;

/**
 * A {@code Size} is a {@link KorypheFunction} which returns the size of a provided
 * {@link Iterable}.
 */
public class Size extends KorypheFunction<Iterable, Integer> {
    @Override
    @SuppressFBWarnings(value = "DE_MIGHT_IGNORE", justification = "Any exceptions are to be ignored")
    public Integer apply(final Iterable input) {
        if (null == input) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        try {
            return Iterables.size(input);
        } finally {
            if (input instanceof AutoCloseable) {
                try {
                    ((AutoCloseable) input).close();
                } catch (final Exception e) {
                    // ignore exception
                }
            }
        }
    }
}
