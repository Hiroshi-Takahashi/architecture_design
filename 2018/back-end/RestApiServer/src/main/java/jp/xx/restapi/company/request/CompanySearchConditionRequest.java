package jp.xx.restapi.company.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 企業検索用条件リクエスト
 */
public class CompanySearchConditionRequest {
	/** ジョブカテゴリ１（大分類） */
    @NotBlank(message="ジョブカテゴリ１は必須です")
    @Size(min=2, max=2)
	private String jobCategoryLevel1;
	/** ジョブカテゴリ２（小分類） */
    @NotBlank(message="ジョブカテゴリ２は必須です")
    @Size(min=2, max=2)
	private String jobCategoryLevel2;
	
	public String getJobCategoryLevel1() {
		return jobCategoryLevel1;
	}
	public void setJobCategoryLevel1(String jobCategoryLevel1) {
		this.jobCategoryLevel1 = jobCategoryLevel1;
	}
	public String getJobCategoryLevel2() {
		return jobCategoryLevel2;
	}
	public void setJobCategoryLevel2(String jobCategoryLevel2) {
		this.jobCategoryLevel2 = jobCategoryLevel2;
	}
}
