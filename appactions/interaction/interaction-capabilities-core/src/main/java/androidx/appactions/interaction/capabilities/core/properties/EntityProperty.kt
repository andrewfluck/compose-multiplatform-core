/*
 * Copyright 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.appactions.interaction.capabilities.core.properties

/** The property which describes a entity parameter for {@code ActionCapability}. */
class EntityProperty internal constructor(
    override val possibleValues: List<Entity>,
    override val isRequired: Boolean,
    override val isValueMatchRequired: Boolean,
    override val isProhibited: Boolean,
) : ParamProperty<Entity> {
    /** Builder for {@link EntityProperty}. */
    public class Builder {

        private val possibleEntities = mutableListOf<Entity>()
        private var isRequired = false
        private var isValueMatchRequired = false
        private var isProhibited = false

        /**
         * Adds one or more possible entities for this entity parameter.
         *
         * @param entities the possible entities.
         */
        fun addPossibleEntities(vararg entities: Entity) = apply {
            this.possibleEntities.addAll(entities)
        }

        /** Sets whether or not this property requires a value for fulfillment. */
        fun setRequired(isRequired: Boolean) = apply {
            this.isRequired = isRequired
        }

        /**
         * Sets whether or not this property requires that the value for this property must match
         * one of
         * the Entity in the defined possible entities.
         */
        fun setValueMatchRequired(isValueMatchRequired: Boolean) = apply {
            this.isValueMatchRequired = isValueMatchRequired
        }

        /**
         * Sets whether this property is prohibited in the response.
         *
         * @param isProhibited Whether this property is prohibited in the response.
         */
        fun setProhibited(isProhibited: Boolean) = apply {
            this.isProhibited = isProhibited
        }

        /** Builds the property for this entity parameter. */
        fun build() = EntityProperty(
            this.possibleEntities.toList(),
            this.isRequired,
            this.isValueMatchRequired,
            this.isProhibited,
        )
    }
}
