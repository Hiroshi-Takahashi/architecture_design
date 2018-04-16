package jp.xx.restapi.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.xx.restapi.company.dao.CompanyDao;
import jp.xx.restapi.company.dto.CompanySearchConditionDto;
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
	public List<Company> searchFullFillCompanyList(CompanySearchConditionDto conditionDto) {
		Company condition = new Company();
		condition.jobCategoryLevel1 = conditionDto.getJobCategoryLevel1();
		condition.jobCategoryLevel2 = conditionDto.getJobCategoryLevel2();
		return companyDao.selectFullFillCompanyList(condition);
	}
}
