package kir.tm.v_1_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kir.tm.v_1_1.entity.Issue;
import kir.tm.v_1_1.service.IssueService;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/v1.1/issues")
public class IssueController {
	
	private IssueService issueService;
	
	@Autowired
	public IssueController(IssueService issueService) {
		this.issueService = issueService;
	}

	@GetMapping
	public ResponseEntity getAll(@RequestParam(required=false) String parentId) {

		if(false) {
			public Issue issues = issueService.getAll();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok("[{result: true},{result: true}]".toString());
		//"[{'result': true},{'result': true}]".toString();
		
	}

}
