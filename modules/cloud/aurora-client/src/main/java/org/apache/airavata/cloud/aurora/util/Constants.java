/**
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.airavata.cloud.aurora.util;

/**
 * The Class Constants.
 */
public class Constants {

	/** The Constant AURORA_SCHEDULER_PROP_FILE. */
	public static final String AURORA_SCHEDULER_PROP_FILE = "aurora-scheduler.properties";
	
	/** The Constant AURORA_SCHEDULER_HOST. */
	public static final String AURORA_SCHEDULER_HOSTS = "aurora.scheduler.hosts";
	
	/** The Constant AURORA_SCHEDULER_PORT. */
	public static final String AURORA_SCHEDULER_PORT = "aurora.scheduler.port";
	
	/** The Constant AURORA_EXECUTOR_NAME. */
	public static final String AURORA_EXECUTOR_NAME = "aurora.executor.name";
	
	/** The Constant MESOS_CLUSTER_NAME. */
	public static final String MESOS_CLUSTER_NAME = "mesos.cluster.name";
	
	/** The Constant AURORA_SCHEDULER_CONNECTION_URL. */
	public static final String AURORA_SCHEDULER_CONNECTION_URL = "http://%s:%s/api";
	
	/** The Constant AURORA_SCHEDULER_CONNECT_TIMEOUT_MS. */
	public static final String AURORA_SCHEDULER_CONNECT_TIMEOUT_MS = "aurora.scheduler.timeoutms";
}
