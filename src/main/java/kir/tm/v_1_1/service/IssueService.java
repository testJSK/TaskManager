package kir.tm.v_1_1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kir.tm.v_1_1.entity.Issue;
import kir.tm.v_1_1.repo.IssueRepo;

@Service
public class IssueService {
	
	@Autowired
	private IssueRepo issueRepo;

	public IssueService(IssueRepo issueRepo) {
		this.issueRepo = issueRepo;
	}

	public List<Issue> getAll() {
		List<Issue> issues = (List<Issue>) issueRepo.findAll();
		return issues;
	}

	public Optional<Issue> getOne(Long id) throws Exception {
		Optional<Issue> issue = issueRepo.findById(id);
		if(issue != null) {
			return issue;			
		}
		throw new Exception("31 IssueService");

	}
}
