package jp.xx.restapi.company.response;

import java.util.List;

import jp.xx.restapi.company.dto.CompanySearchResultRowDto;

/**
 * 企業検索用条件リクエスト
 */
public class CompanySearchConditionResponse {
	/** 条件を満たす企業リスト */
	private List<CompanySearchResultRowDto> fullFillCompanyList;

	public List<CompanySearchResultRowDto> getFullFillCompanyList() {
		return fullFillCompanyList;
	}

	public void setFullFillCompanyList(List<CompanySearchResultRowDto> fullFillCompanyList) {
		this.fullFillCompanyList = fullFillCompanyList;
	}
}
