package kir.tm.v_1_1.repo;

import org.springframework.data.repository.CrudRepository;

import kir.tm.v_1_1.entity.Issue;

public interface IssueRepo extends CrudRepository<Issue, Long> {
	
}
