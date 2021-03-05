package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Student;
import com.ajay.security.api.tenant.repository.StudentRepository;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student getOneStudent(Integer id) {
		return studentRepository.findById(id).get();
	}

	public Student saveStudent(Student student) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (student.getCreatedAt() == null)
			student.setCreatedAt(currentTimestamp);
		student.setUpdatedAt(currentTimestamp);

//		// For studentAccounts list
//		if (!student.getStudentAccounts().isEmpty())
//			student.getStudentAccounts().forEach(studentAccount -> {
//				if (studentAccount.getCreatedAt() == null)
//					studentAccount.setCreatedAt(currentTimestamp);
//				studentAccount.setUpdatedAt(currentTimestamp);
//			});
//
//		// for studentDocuments list
//		if (!student.getStudentDocuments().isEmpty())
//			student.getStudentDocuments().forEach(studentDocument -> {
//				if (studentDocument.getCreatedAt() == null)
//					studentDocument.setCreatedAt(currentTimestamp);
//				studentDocument.setUpdatedAt(currentTimestamp);
//			});
//
//		// For studentQualifications list
//		if (!student.getStudentQualifications().isEmpty())
//			student.getStudentQualifications().forEach(studentQualification -> {
//				if (studentQualification.getCreatedAt() == null)
//					studentQualification.setCreatedAt(currentTimestamp);
//				studentQualification.setUpdatedAt(currentTimestamp);
//			});
//
//		// For studentRecords list
//		if (!student.getStudentRecords().isEmpty())
//			student.getStudentRecords().forEach(studentRecord -> {
//				if (studentRecord.getCreatedAt() == null)
//					studentRecord.setCreatedAt(currentTimestamp);
//				studentRecord.setUpdatedAt(currentTimestamp);
//
//				// For certificates list
//				if (!studentRecord.getCertificates().isEmpty())
//					studentRecord.getCertificates().forEach(certificate -> {
//						if (certificate.getCreatedAt() == null)
//							certificate.setCreatedAt(currentTimestamp);
//						certificate.setUpdatedAt(currentTimestamp);
//					});
//
//				// For incomes list
//				if (!studentRecord.getIncomes().isEmpty())
//					studentRecord.getIncomes().forEach(income -> {
//						if (income.getCreatedAt() == null)
//							income.setCreatedAt(currentTimestamp);
//						income.setUpdatedAt(currentTimestamp);
//
//						// For Transactions list
//						if (!income.getTransactions().isEmpty())
//							income.getTransactions().forEach(transaction -> {
//								if (transaction.getCreatedAt() == null)
//									transaction.setCreatedAt(currentTimestamp);
//								transaction.setUpdatedAt(currentTimestamp);
//							});
//					});
//
//				// For onlineExamRecords list
//				if (!studentRecord.getOnlineExamRecords().isEmpty())
//					studentRecord.getOnlineExamRecords().forEach(onlineExamRecord -> {
//						if (onlineExamRecord.getCreatedAt() == null)
//							onlineExamRecord.setCreatedAt(currentTimestamp);
//						onlineExamRecord.setUpdatedAt(currentTimestamp);
//					});
//
//				// For studentFeeRecords list
//				if (!studentRecord.getStudentFeeRecords().isEmpty())
//					studentRecord.getStudentFeeRecords().forEach(studentFeeRecord -> {
//						if (studentFeeRecord.getCreatedAt() == null)
//							studentFeeRecord.setCreatedAt(currentTimestamp);
//						studentFeeRecord.setUpdatedAt(currentTimestamp);
//
//						//transactions
//						if (!studentFeeRecord.getTransactions().isEmpty())
//							studentFeeRecord.getTransactions().forEach(transaction -> {
//								if (transaction.getCreatedAt() == null)
//									transaction.setCreatedAt(currentTimestamp);
//								transaction.setUpdatedAt(currentTimestamp);
//							});
//						
//						//studentOptionalFeeRecords
//						
//						
//						//studentFeeRecordDetails
//						
//						
//					});
//
//				// For transferCertificates list
//				if (!studentRecord.getTransferCertificates().isEmpty())
//					studentRecord.getTransferCertificates().forEach(transferCertificate -> {
//						if (transferCertificate.getCreatedAt() == null)
//							transferCertificate.setCreatedAt(currentTimestamp);
//						transferCertificate.setUpdatedAt(currentTimestamp);
//					});
//
//				// For transportRouteStudents list
//				if (!studentRecord.getTransportRouteStudents().isEmpty())
//					studentRecord.getTransportRouteStudents().forEach(transportRouteStudent -> {
//						if (transportRouteStudent.getCreatedAt() == null)
//							transportRouteStudent.setCreatedAt(currentTimestamp);
//						transportRouteStudent.setUpdatedAt(currentTimestamp);
//					});
//			});
//
//		// For studentSiblings2 list
		return studentRepository.save(student);
	}

	public String deleteOneStudent(Student student) {
		String result = null;
		if (studentRepository.existsById(student.getId())) {
			studentRepository.delete(student);
			result = " Student deleted!";
		} else {
			result = "Student Not Found! or Already deleted!";
		}
		return result;
	}
}
