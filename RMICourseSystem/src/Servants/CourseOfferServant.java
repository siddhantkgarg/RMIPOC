package Servants;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Interface.ICourseOfferCRUD;
import Model.CourseOffer;
import Util.Constants;
import Util.FileHandler;

public class CourseOfferServant extends AbstractCRUD<CourseOffer> implements ICourseOfferCRUD{

	public CourseOfferServant() throws RemoteException {
		List<CourseOffer> offerList = new ArrayList<CourseOffer>();
		List<List<String>> allOffers;
		try {
			allOffers = FileHandler.readLineFromCSV(Constants.OFFER_FILE);
			for (List<String> list : allOffers) {
				CourseOffer offer = new CourseOffer();
				offer.buildFromCSV(list);
				offerList.add(offer);
			}
			this.t = offerList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<CourseOffer> Upsert(CourseOffer cOffer){
		List<CourseOffer> coList = Retrieve(super.t, CourseOffer::getCourseId,cOffer.getCourseId());
		//check if already exists
		List<CourseOffer> exists = Retrieve(coList,CourseOffer::getStudent_id,cOffer.getStudent_id());
		if(exists == null || exists.size()==0) {
			if(coList.size()<5) {
				if(t.size()==4) {
					cOffer.setStatus(0);
				}
				super.t.add(cOffer);
			}else {
				System.out.println("Course if full. Not able to assign");
				return Collections.EMPTY_LIST;
			}
		}
		FileHandler.writeToFile(super.t,Constants.OFFER_FILE, false);
		return super.t;
		
	}
	

	@Override
	public List<CourseOffer> getCourse(int id) {
		return Retrieve(t, CourseOffer::getCourseId, id);
	}

	@Override
	public Boolean offerCourse(CourseOffer offer) {
		return Upsert(offer).size() >0;
	}

	@Override
	public int getOfferedCount(int courseId) {
		return 0;
	}
	
	

}
