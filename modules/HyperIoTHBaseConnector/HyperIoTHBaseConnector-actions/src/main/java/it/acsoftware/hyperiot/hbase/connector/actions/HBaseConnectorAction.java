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

package it.acsoftware.hyperiot.hbase.connector.actions;

import it.acsoftware.hyperiot.base.action.HyperIoTActionName;

/**
 *
 * @author Aristide Cittadino Model class that enumerate HBaseConnector Actions
 *
 */
public enum HBaseConnectorAction implements HyperIoTActionName {

	//TO DO: add enumerations here
	CHECK_CONNECTION(Names.CHECK_CONNECTION),
	CREATE_TABLE(Names.CREATE_TABLE),
	DELETE_DATA(Names.DELETE_DATA),
	DISABLE_TABLE(Names.DISABLE_TABLE),
	DROP_TABLE(Names.DROP_TABLE),
	ENABLE_TABLE(Names.ENABLE_TABLE),
	INSERT_DATA(Names.INSERT_DATA),
	READ_DATA(Names.READ_DATA);

	private final String name;

     /**
	 * Role Action with the specified name.
	 *
	 * @param name parameter that represent the HBaseConnector  action
	 */
	HBaseConnectorAction(String name) {
		this.name = name;
	}

	/**
	 * Gets the name of HBaseConnector action
	 */
	public String getName() {
		return name;
	}

	public class Names{
	    public static final String CHECK_CONNECTION = "check_connection";
        public static final String CREATE_TABLE = "create_table";
        public static final String DELETE_DATA = "delete_data";
        public static final String DISABLE_TABLE = "disable_data";
        public static final String DROP_TABLE = "drop_table";
        public static final String ENABLE_TABLE = "enable_table";
        public static final String INSERT_DATA = "insert_data";
        public static final String READ_DATA = "read_data";
    }

}
