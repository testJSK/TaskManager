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
	
	
}
