package activiti;

import java.util.List;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class ActivitiTest {

	@Test
	public void test() {
		ProcessEngine eng = ProcessEngines.getDefaultProcessEngine();
		/**
		 * 管理和操作 流程定义、流程部署
		 * 1.查找流程
		 * 2.启动、停止流程
		 * 3.申请和执行某任务
		 */
		RepositoryService repositoryService = eng.getRepositoryService();
		
		RuntimeService runtimeService = eng.getRuntimeService();
		
		/**
		 * task需要人为操作/执行
		 * 1.查找分配给某人或某小组的任务
		 * 2.创建相互独立的任务（不关联任何流程实例）
		 * 3.分配任务给某人或某小组
		 */
		TaskService taskService = eng.getTaskService();
		
		/**
		 * 管理用户和小组
		 */
		IdentityService identityService = eng.getIdentityService();
		
		/**
		 * 历史服务
		 */
		HistoryService historyService = eng.getHistoryService();
		
		/**
		 * 自定义表单（可选服务）
		 * start form，流程实例开始的表单界面
		 * task form，用户执行任务的表单界面
		 */
		FormService formService = eng.getFormService();
		
		/**
		 * 管理服务（非必要）
		 * 1.管理数据库、表的元数据
		 * 2.管理jobs
		 */
		ManagementService managementService = eng.getManagementService();
		
		Deployment deployment = repositoryService.createDeployment()
				.addClasspathResource("FinancialReportProcess.bpmn20.xml")
				.deploy();
		
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("financialReport");
		
		List<Task> tasks = taskService.createTaskQuery().taskCandidateUser("kermit").list();

		
	}

}
