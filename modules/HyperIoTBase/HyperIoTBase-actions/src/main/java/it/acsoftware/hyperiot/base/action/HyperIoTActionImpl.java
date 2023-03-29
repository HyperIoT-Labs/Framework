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

package it.acsoftware.hyperiot.base.action;

import it.acsoftware.hyperiot.base.api.HyperIoTAction;

/**
 * @author Aristide Cittadino Class that implements HyperIoTAction interface. It
 * is used to implement the concept of action within the HyperIoT
 * platform.
 */
public class HyperIoTActionImpl implements HyperIoTAction {

    /**
     * String resource name of action
     */
    protected String resourceName;
    /**
     * String action name
     */
    protected String actionName;
    /**
     * String action category
     */
    protected String category;
    /**
     * int action id
     */
    protected int actionId;

    /**
     * Boolean referring to the action osgi registration
     */
    protected boolean registered;

    /**
     * Constructor of HyperIoTActionImpl
     *
     * @param category     parameter that indicates the action category
     * @param resourceName parameter that indicates the resource name of action
     * @param actionName   parameter that indicates the action name
     */
    public HyperIoTActionImpl(String category, String resourceName, String actionName) {
        this.category = category;
        this.actionName = actionName;
        this.resourceName = resourceName;
    }


    /**
     * Gets the resource name of action
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * Gets the action name
     */
    public String getActionName() {
        return actionName;
    }

    /**
     * Gets the action id
     */
    public int getActionId() {
        return actionId;
    }

    /**
     * Gets category of action
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the action id
     *
     * @param actionId parameter that set up the action id
     */
    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    @Override
    public boolean isRegistered() {
        return this.registered;
    }

    @Override
    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("Resource Name:").append(resourceName).append(" ActionName: ").append(actionName)
                .append(" Category: ").append(category).append(" ActionId: ").append(actionId).toString();
    }

}
