package jp.xx.restapi.job.entity;

import java.sql.Date;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;

@Entity
public class Company {
	/** ジョブ */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer companyId;
	/** 会社名 */
	public String companyName;
	/** ジョブカテゴリ１（大分類） */
	public String jobCategoryLevel1;
	/** ジョブカテゴリ２（小分類） */
	public String jobCategoryLevel2;
	/** 登録日 */
	public Date registDate;
	/** 登録者 */
	public String registUser;
	/** 更新日 */
	public Date updatedDate;
	/** 更新者 */
	public String updatedUser;
}
