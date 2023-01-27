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

package it.acsoftware.hyperiot.base.api;

/**
 * @author Aristide Cittadino
 * <p>
 * Class that implements the concept of action within the platform.
 * Every interaction the users has with HyperIoT it will be related to
 * actions. Each Action is managed by Permissions
 */
public interface HyperIoTAction {

    /**
     * Gets the resource name of action
     *
     * @return resource name
     */
    public String getResourceName();

    /**
     * Gets the action name
     *
     * @return action name
     */
    public String getActionName();

    /**
     * Gets the action id
     *
     * @return action id
     */
    public int getActionId();

    /**
     * @param actionId the action id to be set
     */
    public void setActionId(int actionId);

    /**
     * Gets category of action
     *
     * @return action category
     */
    public String getCategory();

    boolean isRegistered();

    void setRegistered(boolean registered);
}
