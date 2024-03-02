package education.itworx.dataproviderobjects;


import education.itworx.utilities.CustomAnnotations;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseData
{

	@CustomAnnotations.ExcelColumn(1)
	String testCaseName;

	@CustomAnnotations.ExcelColumn(2)
	String courseName;

	@CustomAnnotations.ExcelColumn(3)
	String subject;

	@CustomAnnotations.ExcelColumn(4)
	String grade;

}

