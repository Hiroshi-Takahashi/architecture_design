package jp.xx.restapi.job.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.xx.restapi.job.service.JobService;

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
