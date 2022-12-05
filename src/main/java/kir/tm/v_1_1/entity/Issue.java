package kir.tm.v_1_1.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "issues", schema = "public")
public class Issue implements Serializable {

	@Id 	@Column(name = "issue_id") 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long issue_id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "parent_id")
	private Long parentId;
	
	@Column(name = "initiator_id")
	private Long initiatorId;
	
	@Column(name = "manager_id")
	private Long managerId;

	@Column(name = "type_id")
	private Long typeId;
	
	@Column(name = "date_start")
	private Date dateStart;
	
	@Column(name = "date_end")
	private Date dateEnd;
	
	@Column(name = "task_type_id")
	private Long taskTypeId;
	
	@Column(name = "work_app_id")
	private Long workAppId;

	@Column(name = "status_id")
	private Long statusId;

	@Column(name = "operation_info")	
	private String operationInfo;

	public Issue() {
	}

	public Long getIssue_id() {
		return issue_id;
	}

	public void setIssue_id(Long issue_id) {
		this.issue_id = issue_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getInitiatorId() {
		return initiatorId;
	}

	public void setInitiatorId(Long initiatorId) {
		this.initiatorId = initiatorId;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Long getTaskTypeId() {
		return taskTypeId;
	}

	public void setTaskTypeId(Long taskTypeId) {
		this.taskTypeId = taskTypeId;
	}

	public Long getWorkAppId() {
		return workAppId;
	}

	public void setWorkAppId(Long workAppId) {
		this.workAppId = workAppId;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getOperationInfo() {
		return operationInfo;
	}

	public void setOperationInfo(String operationInfo) {
		this.operationInfo = operationInfo;
	}
	
	
}
