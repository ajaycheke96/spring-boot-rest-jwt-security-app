package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.AcademicSession;
import com.ajay.security.api.tenant.repository.AcademicSessionRepository;

@Service
@Transactional
public class AcademicSessionService {

	@Autowired
	private AcademicSessionRepository academicSessionRepository;

	public List<AcademicSession> getAllAcademicSessions() {
//		return academicSessionRepository.findAll().stream().map(mapAcademicSession).collect(Collectors.toList());
		return academicSessionRepository.findAll();
	}

	public AcademicSession getOneAcademicSession(Integer id) {
		return academicSessionRepository.findById(id).get();
	}

	public String saveAcademicSession(AcademicSession academicSession) {
		return academicSessionRepository.save(academicSession) != null ? "Academic Session successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateAcademicSession(AcademicSession academicSession) {
		return academicSessionRepository.save(academicSession) != null ? "Academic Session successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneAcademicSession(Integer id) {
		academicSessionRepository.deleteById(id);
		return "Academic Session successfully deleted!";
	}

//	private Function<AcademicSession, AcademicSession> mapAcademicSession = (academicSession) -> {
//		AcademicSession updatedAcademicSession = new AcademicSession();
//
//		// copy AcademicSession value
//		BeanUtils.copyProperties(academicSession, updatedAcademicSession);
//
//		// copy List of ClassTiming values and set to AcademicSession
//		List<ClassTiming> updatedClassTimings = academicSession.getClassTimings().stream().map((classTiming) -> {
//			ClassTiming updatedClassTiming = new ClassTiming();
//			BeanUtils.copyProperties(classTiming, updatedClassTiming);
//			return updatedClassTiming;
//		}).collect(Collectors.toList());
//		updatedAcademicSession.setClassTimings(updatedClassTimings);
//
//		// copy List of CourseGroup values and set to AcademicSession
//		List<CourseGroup> updatedCourseGroups = academicSession.getCourseGroups().stream().map((courseGroup) -> {
//			CourseGroup updatedCourseGroup = new CourseGroup();
//			BeanUtils.copyProperties(courseGroup, updatedCourseGroup);
//			return updatedCourseGroup;
//		}).collect(Collectors.toList());
//		updatedAcademicSession.setCourseGroups(updatedCourseGroups);
//
//		// copy List of Course values and set to AcademicSession
//		List<Course> updatedCourses = academicSession.getCourses().stream().map((course) -> {
//			Course updatedCourse = new Course();
//			BeanUtils.copyProperties(course, updatedCourse);
//			return updatedCourse;
//		}).collect(Collectors.toList());
//		academicSession.setCourses(updatedCourses);
//
//		/**
//		 * TODO: copy more values in AcademicSession entity if required
//		 */
//
//		return updatedAcademicSession;
//	};
}
