/**
 * Copyright © 2016-2020 The Thingsboard Authors
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
package org.thingsboard.server.common.data.id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.thingsboard.server.common.data.EntityType;

public final class CustomerId extends UUIDBased implements EntityId,Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("ids")
    private List<UUID> ids = new ArrayList<>();

    //@JsonCreator
    public CustomerId(@JsonProperty("id") UUID id) {
        super(id);
    }

    @JsonCreator
    public CustomerId(@JsonProperty("id") UUID id,@JsonProperty("ids") List<UUID> ids) {
        super(id);
        this.ids=ids;
    }

    @JsonIgnore
    @Override
    public EntityType getEntityType() {
        return EntityType.CUSTOMER;
    }

    public List<UUID> getIds() {
        return ids;
    }

    public void setIds(List<UUID> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        if (ids != null && !ids.isEmpty()) {
            final StringBuilder sb = new StringBuilder();
            ids.stream()
               .forEach(uuid -> {
                   sb.append(uuid)
                     .append(",");
               });
            return sb.toString()
                     .substring(0, sb.length() - 1);
        }

        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CustomerId other = (CustomerId) obj;

        if (ids != null && !ids.isEmpty() && ids.contains(other.getId()) ||
                (other.getIds() != null && !other.getIds()
                                                 .isEmpty() && other.getIds()
                                                                    .contains(getId()))) {
            return true;
        }
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!getId().equals(other.getId()))
            return false;
        return true;

    }
}
