package jp.xx.restapi.job.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.xx.restapi.job.dao.CompanyDao;
import jp.xx.restapi.job.entity.Company;

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
	* */
	@Override
	public List<Company> searchFullFillCompanyList() {
		return companyDao.selectAll();
	}
}
