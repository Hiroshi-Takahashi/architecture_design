package jp.xx.restapi.company.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.xx.restapi.company.dao.CompanyDao;
import jp.xx.restapi.company.dto.CompanySearchConditionDto;
import jp.xx.restapi.company.dto.CompanySearchResultRowDto;
import jp.xx.restapi.company.entity.Company;

/**
 * 企業用サービスクラス
 */
@Service
public class CompanyServiceImpl implements CompanyService {

	/** 会社情報DAO */
	@Autowired
	CompanyDao companyDao;
	
	/**
	* {@inheritDoc}
	*/
	@Override
	public List<CompanySearchResultRowDto> searchFullFillCompanyList(CompanySearchConditionDto conditionDto) {

		/**
		 * 検索条件を元にDBに問い合わせて企業情報を取得する
		 */
		Company condition = new Company();
		condition.jobCategoryLevel1 = conditionDto.getJobCategoryLevel1();
		condition.jobCategoryLevel2 = conditionDto.getJobCategoryLevel2();
		
		// EntityからDtoへ変換する
		return companyDao.selectFullFillCompanyList(condition).stream().map(new Function<Company,CompanySearchResultRowDto>() {
			@Override
			public CompanySearchResultRowDto apply(final Company company) {
				CompanySearchResultRowDto dto = new CompanySearchResultRowDto();
				dto.setCompanyId(company.companyId);
				dto.setCompanyName(company.companyName);
				dto.setJobCategoryLevel1(company.jobCategoryLevel1);
				dto.setJobCategoryLevel2(company.jobCategoryLevel2);
				return dto;
			}
		}).collect(Collectors.toList());
	}
}
