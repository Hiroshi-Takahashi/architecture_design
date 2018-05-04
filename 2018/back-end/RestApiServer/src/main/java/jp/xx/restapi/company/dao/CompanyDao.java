package jp.xx.restapi.company.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import jp.xx.restapi.company.entity.Company;

/**
 * 企業用DAOクラス
 */
@ConfigAutowireable
@Dao
public interface CompanyDao {
	
	/**
	 * 全件検索する
	 * @return 全件取得結果
	 */
	@Select
	List<Company> selectAll();
	
	/**
	 * 条件を満たした企業を取得する
	 * @return 条件を満たした企業リスト
	 */
	@Select
	List<Company> selectFullFillCompanyList(Company condition);
	
	/**
	 * 登録する
	 * @return 登録した件数
	 */
	@Insert
	int insert(Company company);

}
