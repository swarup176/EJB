package com.cts.jpa.main;



import com.cts.jpa.operation.SampleDBOperation;

public class SampleJPAMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			final InputParam input = InputParam.AddTravelGuide;
		switch (input) {
		case AddStudent:
			SampleDBOperation.addStudent();
			break;
		case DeleteStudent:
			SampleDBOperation.deleteStudent();
			break;
		case UpdateStudent:
			SampleDBOperation.updateStudent();
			break;
		case AddPassPort:
			// example of one to one mapping
			SampleDBOperation.oneToone();
			break;
		case GetEmpDetails:
			// nameed query
			SampleDBOperation.getEmpDetails();
			break;
		case AddChildList:
           //one to many or many to one 
			SampleDBOperation.addChildList();
			break;
		case AddProductSupplierDetails:
			SampleDBOperation.addProductSupplierDetails();
			break;
		case ShowProductSupplierDetails:
		   SampleDBOperation.nativequery();
			break;
		case AddTravelGuide:
			   SampleDBOperation.inheritence();
				break;
		case CheckOptimisticLockingByVersion:
			SampleDBOperation.checkOptimisticLockingWithVersion();
			break;
		case CreateEvent:
			SampleDBOperation.createEvent();
			break;
		case CreateParticipant:
			SampleDBOperation.createParticipant();
			break;
		case CreateParticipantEvent:
			SampleDBOperation.createEventParticipant();
			break;	
		}
	}

	

}
