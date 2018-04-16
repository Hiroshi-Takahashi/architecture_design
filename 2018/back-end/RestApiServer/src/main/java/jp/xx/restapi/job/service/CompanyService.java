package jp.xx.restapi.job.service;

import java.util.List;

import jp.xx.restapi.job.entity.Company;

/**
 * 企業用サービスクラス
 */
public interface CompanyService {
	
	/**
	 * 条件を満たす企業を検索する
	 * @return 条件を満たした企業リスト
	 */
	public List<Company> searchFullFillCompanyList();
}
