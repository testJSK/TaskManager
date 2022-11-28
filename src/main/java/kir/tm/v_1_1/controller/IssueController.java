package kir.tm.v_1_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/v1.1/issue")
public class IssueController {
	
	// @Autowired
	// private IssueService IssueService;

	public ResponseEntity getAll(@RequestParam(required=false) String parentId) {
		return null;
		
	}

}
