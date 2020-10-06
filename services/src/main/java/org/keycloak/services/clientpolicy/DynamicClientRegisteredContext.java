/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.keycloak.services.clientpolicy;

import org.keycloak.models.ClientModel;
import org.keycloak.models.RealmModel;
import org.keycloak.representations.JsonWebToken;
import org.keycloak.services.clientregistration.ClientRegistrationContext;

public class DynamicClientRegisteredContext extends DynamicClientRegisterContext {

    private final ClientModel registeredClient;

    public DynamicClientRegisteredContext(ClientRegistrationContext context, JsonWebToken token, RealmModel realm, ClientModel client) {
        super(context, token, realm);
        registeredClient = client;
    }

    @Override
    public ClientModel getRegisteredClient() {
        return registeredClient;
    }

    @Override
    public ClientPolicyEvent getEvent() {
        return ClientPolicyEvent.REGISTERED;
    }

}
