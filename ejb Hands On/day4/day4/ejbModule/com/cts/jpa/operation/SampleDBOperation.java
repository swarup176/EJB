package com.cts.jpa.operation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.cts.jpa.entity.Child;
import com.cts.jpa.entity.Employee;
import com.cts.jpa.entity.Event;
import com.cts.jpa.entity.EventParticipant;
import com.cts.jpa.entity.EventParticipantPK;
import com.cts.jpa.entity.Parent;
import com.cts.jpa.entity.Part;
import com.cts.jpa.entity.Participant;
import com.cts.jpa.entity.Passport;
import com.cts.jpa.entity.Student;
import com.cts.jpa.entity.Supplier;
import com.cts.jpa.entity.TravelGuide;
import com.cts.jpa.entity.Version;



public class SampleDBOperation extends BaseEntity {

	public static void addStudent() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Student student = new Student();
		student.setStudentId("100");
		student.setStuName("Swarup das");
		entityManager.persist(student);
		transaction.commit();

	}

	public static void deleteStudent() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Student student = entityManager.find(Student.class, "100");
		System.out.println(student.getStuName());
		entityManager.remove(student);
		transaction.commit();
	}

	public static void updateStudent() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Student student = new Student();
		student.setStudentId("200");
		student.setStuName("swarup das");
		entityManager.merge(student);
		transaction.commit();

	}

	public static void oneToone() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Employee employee = entityManager.find(Employee.class, 3100);
		if (employee == null) {
			employee = new Employee();
			employee.setEmpName("reshmik");
			entityManager.persist(employee);
			entityManager.flush();
		}

		Passport passport = new Passport();
		passport.setEmpID(employee.getEmpID());
		passport.setCountry("INDIA");
		employee.setPassport(passport);
		entityManager.merge(employee);
		transaction.commit();
	}

	/**
	 * Example of named query
	 */
	public static void getEmpDetails() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createNamedQuery("getEmpDetails");
		transaction.commit();
		List<Employee> arrayList = (List<Employee>) query.getResultList();
		System.out.println("******One to one******");
		for(Employee employee:  arrayList)
		{
		System.out.println(employee.getEmpID());
		System.out.println(employee.getEmpName());
		System.out.println(employee.getPassport().getCountry());
		System.out.println("************");
		}
	}

	/**
	 * Example of one to many relation
	 */
	public static void addChildList() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		List<Child> childList = new ArrayList<Child>();
		Parent parent = new Parent();
		parent.setPname("Bob");

		Child child01 = new Child();
		child01.setParent(parent);
		child01.setCname("Bobun01");

		Child child02 = new Child();
		child02.setParent(parent);
		child02.setCname("Bobun02");
		childList.add(child01);
		childList.add(child02);
		parent.setChildren(childList);
		entityManager.persist(parent);
		transaction.commit();
	}

	/**
	 * Example of many to many relation
	 */
	public static void addProductSupplierDetails() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Supplier supplier = new Supplier();
		supplier.setSname("sandip");
		Supplier supplier1 = new Supplier();
		supplier1.setSname("Rashmik");
		Set<Supplier> supSet = new HashSet<Supplier>();
		supSet.add(supplier);
		supSet.add(supplier1);

		Part part = new Part();

		part.setName("let us c");
		Part product1 = new Part();
		product1.setName("Java");

		part.setSupplier(supSet);
		product1.setSupplier(supSet);

		// entityManager.persist(product);
		entityManager.persist(product1);
		transaction.commit();
	}

	/**
	 * Example of native query
	 */
	public static void nativequery() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager
				.createNativeQuery("select  sup.sname from supplier sup "
						+ " where sup.sid in(select sp.sid from supplierpart sp where sp.pid"
						+ " in ( select pro.pid from part pro  where pro.pname like ?1) )");
		query.setParameter(1, "let us c");
		List results = query.getResultList();
		if (results.size() != 0) {
			Iterator stIterator = results.iterator();
			while (stIterator.hasNext()) {
				System.out.println(" sname : " + stIterator.next());

			}
		} else {
			System.out.println("Record not found.");
		}
		

		transaction.commit();

	}

	public static void inheritence() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();	
	TravelGuide guide = new TravelGuide();
	guide.setName("Travel Guide");
	guide.setPrice(100.20);
	guide.setAuthor("Anonymous");
	guide.setTitle("Guide to Argentina");
	guide.setDescription("It is a guide for the new comers to Argentina");
	guide.setCountry("Argentina");
	entityManager.persist(guide);
	transaction.commit();
	}

	public static void checkOptimisticLockingWithVersion() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Version version = new Version();
		version.setId(20);
		version.setName("AAA");
		version.setPhone("9836193576");
		entityManager.merge(version);
		transaction.commit();
		
	}

	public static void createEvent() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Event event = new Event();
		event.setName("Design Pattern");
		event.setEventDate(new Date());
		entityManager.merge(event);
		transaction.commit();
		
	}

	public static void createParticipant() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Participant participant = new Participant();
		participant.setName("swarup");
		participant.setContactNumber("+919051672898");
		entityManager.merge(participant);
		transaction.commit();
		
	}

	public static void createEventParticipant() {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Event event1 = new Event();
		event1.setName("EJB 3.0");
		event1.setEventDate(new Date());

		Participant participant1 = new Participant();
		participant1.setName("Somenath");
		participant1.setContactNumber("+919836193000");
		entityManager.persist(event1);
		entityManager.persist(participant1);
		entityManager.flush();
		
		EventParticipant eventParticipant = new EventParticipant();
		eventParticipant.setEventId(event1.getEventId());
		eventParticipant.setParticipantId(participant1.getParticipantId());
		eventParticipant.setRegistrationDate(new Date());
		eventParticipant.setEvent(event1);
		eventParticipant.setParticipant(participant1);
		entityManager.persist(eventParticipant);
		transaction.commit();
		
	}
}
