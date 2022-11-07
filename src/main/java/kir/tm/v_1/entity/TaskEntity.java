package kir.tm.v_1.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author june
 */
@Entity
@Table(name = "tasks")
public class TaskEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "parent_task_id")
    private Long parentId;
    
    @Column(name = "initiator_id")
    private Long initiatorId;
    
    @Column(name = "manager_id")
    private Long managerId;
    
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

    @Column(name = "price")
    private Long price;

    public TaskEntity() {
    }

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TaskEntity{" + "id=" + id + ", title=" + title + ", description=" + description + ", parentId=" + parentId + ", initiatorId=" + initiatorId + ", managerId=" + managerId + ", dateStart=" + dateStart + ", dateEnd=" + dateEnd + ", taskTypeId=" + taskTypeId + ", workAppId=" + workAppId + '}';
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.title);
        hash = 89 * hash + Objects.hashCode(this.description);
        hash = 89 * hash + Objects.hashCode(this.parentId);
        hash = 89 * hash + Objects.hashCode(this.initiatorId);
        hash = 89 * hash + Objects.hashCode(this.managerId);
        hash = 89 * hash + Objects.hashCode(this.dateStart);
        hash = 89 * hash + Objects.hashCode(this.dateEnd);
        hash = 89 * hash + Objects.hashCode(this.taskTypeId);
        hash = 89 * hash + Objects.hashCode(this.workAppId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TaskEntity other = (TaskEntity) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.parentId, other.parentId)) {
            return false;
        }
        if (!Objects.equals(this.initiatorId, other.initiatorId)) {
            return false;
        }
        if (!Objects.equals(this.managerId, other.managerId)) {
            return false;
        }
        if (!Objects.equals(this.dateStart, other.dateStart)) {
            return false;
        }
        if (!Objects.equals(this.dateEnd, other.dateEnd)) {
            return false;
        }
        if (!Objects.equals(this.taskTypeId, other.taskTypeId)) {
            return false;
        }
        return Objects.equals(this.workAppId, other.workAppId);
    }
    
    
}
