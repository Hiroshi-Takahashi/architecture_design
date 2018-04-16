package jp.xx.restapi.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.xx.restapi.company.entity.Company;
import jp.xx.restapi.company.service.CompanyService;

/**
 * 企業に対して操作を行うコントローラクラス
 */
@RestController
public class CompanyController {

	/** 企業操作用サービス */
	@Autowired CompanyService jobService;
	
	/**
	 * 検索用API
	 * return 検索結果
	 */
	@RequestMapping("/search")
	public String search() {
		
		/**
		 * 条件を満たす企業を探す
		 */
		List<Company> fullFillConditionJobList = jobService.searchFullFillCompanyList();
		
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
