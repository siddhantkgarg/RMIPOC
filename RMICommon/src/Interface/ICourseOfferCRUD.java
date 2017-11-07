package Interface;

import java.rmi.Remote;
import java.util.List;

import Model.CourseOffer;

public interface ICourseOfferCRUD extends Remote{
	List<CourseOffer> getCourse(int id);
	Boolean offerCourse(CourseOffer offer);
	
	int getOfferedCount(int courseId);
	
}
