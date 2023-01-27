/*
 * Copyright 2019-2023 ACSoftware
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
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
 *
 */

package it.acsoftware.hyperiot.websocket.channel.session;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.acsoftware.hyperiot.websocket.api.channel.HyperIoTWebSocketChannel;
import it.acsoftware.hyperiot.websocket.api.channel.HyperIoTWebSocketChannelRole;
import it.acsoftware.hyperiot.websocket.api.channel.HyperIoTWebSocketChannelSessionInfo;
import it.acsoftware.hyperiot.websocket.model.HyperIoTWebSocketUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Set;

public class HyperIoTWebSocketChannelSessionlBasicInfo implements HyperIoTWebSocketChannelSessionInfo {
    @JsonIgnore
    private static Logger log = LoggerFactory.getLogger(HyperIoTWebSocketChannelSessionlBasicInfo.class);

    @JsonIgnore
    private static ObjectMapper mapper = new ObjectMapper();

    private HyperIoTWebSocketUserInfo userInfo;
    private HyperIoTWebSocketChannel channel;
    private Set<HyperIoTWebSocketChannelRole> roles;

    public HyperIoTWebSocketChannelSessionlBasicInfo(HyperIoTWebSocketUserInfo userInfo, HyperIoTWebSocketChannel channel, Set<HyperIoTWebSocketChannelRole> roles) {
        this.userInfo = userInfo;
        this.channel = channel;
        this.roles = roles;
    }

    public HyperIoTWebSocketUserInfo getUserInfo() {
        return userInfo;
    }

    public HyperIoTWebSocketChannel getChannel() {
        return channel;
    }

    public Set<HyperIoTWebSocketChannelRole> getRoles() {
        return roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HyperIoTWebSocketChannelSessionlBasicInfo that = (HyperIoTWebSocketChannelSessionlBasicInfo) o;
        return userInfo.equals(that.userInfo) && channel.equals(that.channel) && roles.equals(that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userInfo, channel, roles);
    }

    public static HyperIoTWebSocketChannelSessionlBasicInfo fromString(String message) {
        try {
            return mapper.readValue(message, HyperIoTWebSocketChannelSessionlBasicInfo.class);
        } catch (Throwable t) {
            log.debug("Error while parsing websocket channel user info: {}", new Object[]{t.getMessage()});
        }
        return null;
    }

    public String toJson() {
        try {
            return mapper.writeValueAsString(this);
        } catch (Throwable t) {
            log.error(t.getMessage(), t);
        }
        return "{}";
    }
}
