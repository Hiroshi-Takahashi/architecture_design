package jp.xx.restapi.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.xx.restapi.company.dto.CompanySearchConditionDto;
import jp.xx.restapi.company.entity.Company;
import jp.xx.restapi.company.form.CompanySearchConditionForm;
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
	@CrossOrigin
	@RequestMapping("/search")
	public List<Company> search(@RequestBody CompanySearchConditionForm conditionForm) {
		
		/**
		 * 条件を満たす企業を探す
		 */
		CompanySearchConditionDto conditionDto = new CompanySearchConditionDto();
		conditionDto.setJobCategoryLevel1(conditionForm.getJobCategoryLevel1());
		conditionDto.setJobCategoryLevel2(conditionForm.getJobCategoryLevel2());
		return jobService.searchFullFillCompanyList(conditionDto);
	}
}
