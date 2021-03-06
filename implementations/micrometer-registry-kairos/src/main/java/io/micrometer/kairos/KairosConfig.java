/**
 * Copyright 2018 Pivotal Software, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micrometer.kairos;

import io.micrometer.core.instrument.step.StepRegistryConfig;
import io.micrometer.core.lang.Nullable;

/**
 * @author Anton Ilinchik
 */
public interface KairosConfig extends StepRegistryConfig {

    /**
     * Accept configuration defaults
     */
    KairosConfig DEFAULT = k -> null;

    /**
     * Property prefix to prepend to configuration names.
     *
     * @return property prefix
     */
    default String prefix() {
        return "kairos";
    }

    /**
     * The URI to send the metrics to.
     *
     * @return uri
     */
    default String uri() {
        String v = get(prefix() + ".uri");
        return v == null ? "http://localhost:8080/api/v1/datapoints" : v;
    }

    /**
     * @return Authenticate requests with this user. By default is {@code null}, and the registry will not
     * attempt to present credentials to KairosDB.
     */
    @Nullable
    default String userName() {
        return get(prefix() + ".userName");
    }

    /**
     * @return Authenticate requests with this password. By default is {@code null}, and the registry will not
     * attempt to present credentials to KairosDB.
     */
    @Nullable
    default String password() {
        return get(prefix() + ".password");
    }
}
