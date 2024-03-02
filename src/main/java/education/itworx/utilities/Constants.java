package education.itworx.utilities;

import java.util.ResourceBundle;

public class Constants
{

	private static final ResourceBundle ENVIRONMENT_RN = ResourceBundle.getBundle("environment");
	public static final String APPLICATION_HOST = ENVIRONMENT_RN.getString("app.host");

	/***********Data Provider Excel***********/
	public static final String COURSE_WORKBOOK = "CourseData.xlsx";
	public static final String COURSE_SHEET = "CourseData";

}
