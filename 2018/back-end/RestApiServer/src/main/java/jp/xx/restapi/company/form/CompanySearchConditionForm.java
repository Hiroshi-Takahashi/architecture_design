package jp.xx.restapi.company.form;

public class CompanySearchConditionForm {
	/** ジョブカテゴリ１（大分類） */
	private String jobCategoryLevel1;
	/** ジョブカテゴリ２（小分類） */
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
