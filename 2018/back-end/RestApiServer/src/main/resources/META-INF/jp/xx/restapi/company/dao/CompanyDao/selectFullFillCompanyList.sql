SELECT 
	companyId,
	companyName,
	jobCategoryLevel1,
	jobCategoryLevel2
FROM company
WHERE 
	jobCategoryLevel1 = /* condition.jobCategoryLevel1 */'01'
	AND jobCategoryLevel2 = /* condition.jobCategoryLevel2 */'02'