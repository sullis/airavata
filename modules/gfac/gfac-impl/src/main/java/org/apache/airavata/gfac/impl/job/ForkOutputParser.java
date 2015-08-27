/*
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
 *
*/

package org.apache.airavata.gfac.impl.job;

import org.apache.airavata.common.utils.AiravataUtils;
import org.apache.airavata.gfac.core.JobDescriptor;
import org.apache.airavata.gfac.core.SSHApiException;
import org.apache.airavata.gfac.core.cluster.OutputParser;
import org.apache.airavata.model.status.JobStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ForkOutputParser implements OutputParser {
    private static final Logger log = LoggerFactory.getLogger(ForkOutputParser.class);
    @Override
    public void parseSingleJob(JobDescriptor descriptor, String rawOutput) throws SSHApiException {
        log.info(rawOutput);
    }

    @Override
    public String parseJobSubmission(String rawOutput) throws SSHApiException {
        return null;
    }

    @Override
    public JobStatus parseJobStatus(String jobID, String rawOutput) throws SSHApiException {
        return null;
    }

    @Override
    public void parseJobStatuses(String userName, Map<String, JobStatus> statusMap, String rawOutput) throws SSHApiException {

    }

    @Override
    public String parseJobId(String jobName, String rawOutput) throws SSHApiException {
        // For fork jobs there is no job ID, hence airavata generates a job ID
        return AiravataUtils.getId(jobName);
    }
}
