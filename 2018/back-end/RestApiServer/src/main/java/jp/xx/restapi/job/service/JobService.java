package jp.xx.restapi.job.service;

import java.util.List;

public interface JobService {
	
	/**
	 * 仕事を検索する
	 * @return
	 */
	public List<String> searchFullFillJobList();
}
