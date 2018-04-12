package jp.xx.restapi.jobService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.xx.restapi.jobService.service.JobService;

@RestController
public class JobSearchController {

	@Autowired JobService jobService;
	
	@RequestMapping("/search")
	public String search() {
		
		List<String> fullFillConditionJobList = jobService.searchFullFillJobList();
		
		return "{"
				+ "["
					+ "{"
						+ "company:'A社', income:'300万〜'"
					+ "}"
					+ ",{"
						+ "company:'B社', income:'400万〜'"
					+ "}"
				+ "]"
			+ "}";
	}
}
