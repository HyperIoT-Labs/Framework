/*
 * Copyright 2019-2023 HyperIoT
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

package it.acsoftware.hyperiot.websocket.channel.session.encryption;

import it.acsoftware.hyperiot.websocket.api.channel.HyperIoTWebSocketChannelManager;
import it.acsoftware.hyperiot.websocket.channel.session.HyperIoTWebSocketChannelBasicSession;
import it.acsoftware.hyperiot.websocket.compression.HyperIoTWebSocketCompression;
import it.acsoftware.hyperiot.websocket.encryption.HyperIoTWebSocketEncryption;
import it.acsoftware.hyperiot.websocket.model.message.HyperIoTWebSocketMessage;
import it.acsoftware.hyperiot.websocket.model.message.HyperIoTWebSocketMessageType;
import org.eclipse.jetty.websocket.api.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public abstract class HyperIoTWebSocketChannelEncryptedSession extends HyperIoTWebSocketChannelBasicSession {
    private static Logger log = LoggerFactory.getLogger(HyperIoTWebSocketChannelEncryptedSession.class);

    public HyperIoTWebSocketChannelEncryptedSession(Session session, boolean authenticationRequired, HyperIoTWebSocketChannelManager channelManager) {
        super(session, authenticationRequired, channelManager);
    }

    public HyperIoTWebSocketChannelEncryptedSession(Session session, boolean authenticated, HyperIoTWebSocketEncryption encryptionPolicy, HyperIoTWebSocketChannelManager channelManager) {
        super(session, authenticated, encryptionPolicy, channelManager);
    }

    public HyperIoTWebSocketChannelEncryptedSession(Session session, boolean authenticated, HyperIoTWebSocketCompression compressionPolicy, HyperIoTWebSocketChannelManager channelManager) {
        super(session, authenticated, compressionPolicy, channelManager);
    }

    public HyperIoTWebSocketChannelEncryptedSession(Session session, boolean authenticated, HyperIoTWebSocketEncryption encryptionPolicy, HyperIoTWebSocketCompression compressionPolicy, HyperIoTWebSocketChannelManager channelManager) {
        super(session, authenticated, encryptionPolicy, compressionPolicy, channelManager);
    }

    @Override
    protected void onConnect() {
        super.onConnect();
        try {
            String encryptionKeyMessageString = defineEncryptionMessage();
            HyperIoTWebSocketMessage m = HyperIoTWebSocketMessage.createMessage(null, encryptionKeyMessageString.getBytes("UTF8"), HyperIoTWebSocketMessageType.SET_ENCRYPTION_KEY);
            sendRemote(m);
            Map<String, Object> params = defineEncryptionPolicyParams();
            this.updateEncryptionPolicyParams(params);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    protected abstract String defineEncryptionMessage();

    protected abstract Map<String, Object> defineEncryptionPolicyParams();
}
