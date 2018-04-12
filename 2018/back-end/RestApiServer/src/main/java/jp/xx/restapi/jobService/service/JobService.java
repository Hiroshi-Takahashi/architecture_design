package jp.xx.restapi.jobService.service;

import java.util.List;

public interface JobService {
	
	/**
	 * 仕事を検索する
	 * @return
	 */
	public List<String> searchFullFillJobList();
}
