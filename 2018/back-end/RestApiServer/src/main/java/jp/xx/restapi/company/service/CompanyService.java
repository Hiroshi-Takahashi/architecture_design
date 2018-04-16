package jp.xx.restapi.company.service;

import java.util.List;

import jp.xx.restapi.company.dto.CompanySearchConditionDto;
import jp.xx.restapi.company.entity.Company;

/**
 * 企業用サービスクラス
 */
public interface CompanyService {
	
	/**
	 * 条件を満たす企業を検索する
	 * @param conditionDto 検索条件
	 * @return 条件を満たした企業リスト
	 */
	public List<Company> searchFullFillCompanyList(CompanySearchConditionDto conditionDto);
}
