package org.apache.airavata.helix.impl.task.env;

import org.apache.airavata.agents.api.AgentAdaptor;
import org.apache.airavata.helix.impl.task.AiravataTask;
import org.apache.airavata.helix.impl.task.TaskContext;
import org.apache.airavata.helix.task.api.TaskHelper;
import org.apache.airavata.helix.task.api.annotation.TaskDef;
import org.apache.airavata.model.status.ProcessState;
import org.apache.helix.task.TaskResult;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@TaskDef(name = "Environment Setup Task")
public class EnvSetupTask extends AiravataTask {

    private static final Logger logger = LogManager.getLogger(EnvSetupTask.class);

    @Override
    public TaskResult onRun(TaskHelper taskHelper, TaskContext taskContext) {
        try {
            saveAndPublishProcessStatus(ProcessState.CONFIGURING_WORKSPACE);
            AgentAdaptor adaptor = taskHelper.getAdaptorSupport().fetchAdaptor(
                    getTaskContext().getGatewayId(),
                    getTaskContext().getComputeResourceId(),
                    getTaskContext().getJobSubmissionProtocol().name(),
                    getTaskContext().getComputeResourceCredentialToken(),
                    getTaskContext().getComputeResourceLoginUserName());

            logger.info("Creating directory " + getTaskContext().getWorkingDir() + " on compute resource " + getTaskContext().getComputeResourceId());
            adaptor.createDirectory(getTaskContext().getWorkingDir());
            return onSuccess("Envi setup task successfully completed " + getTaskId());

        } catch (Exception e) {
            return onFail("Failed to setup environment of task " + getTaskId(), true, e);
        }
    }

    @Override
    public void onCancel(TaskContext taskContext) {

    }

}
