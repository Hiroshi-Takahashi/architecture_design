package jp.xx.restapi.company.dto;

public class CompanySearchResultRowDto {
	/** 企業ID */
	private int companyId;
	/** 企業名 */
	private String companyName;
	/** ジョブカテゴリ１（大分類） */
	private String jobCategoryLevel1;
	/** ジョブカテゴリ２（大分類） */
	private String jobCategoryLevel2;
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
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
