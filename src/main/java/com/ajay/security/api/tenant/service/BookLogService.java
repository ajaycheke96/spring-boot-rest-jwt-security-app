package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.BookLog;
import com.ajay.security.api.tenant.repository.BookLogRepository;

@Service
@Transactional
public class BookLogService {

	@Autowired
	private BookLogRepository bookLogRepository;

	public List<BookLog> getAllBookLogs() {
		return bookLogRepository.findAll();
	}

	public BookLog getOneBookLog(Integer id) {
		return bookLogRepository.findById(id).get();
	}

	public BookLog saveBookLog(BookLog bookLog) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (bookLog.getCreatedAt() == null)
			bookLog.setCreatedAt(currentTimestamp);
		bookLog.setUpdatedAt(currentTimestamp);

		// For BookLogDetails List
		if (!bookLog.getBookLogDetails().isEmpty())
			bookLog.getBookLogDetails().forEach(bookLogDetail -> {
				if (bookLogDetail.getCreatedAt() == null)
					bookLogDetail.setCreatedAt(currentTimestamp);
				bookLogDetail.setUpdatedAt(currentTimestamp);

				// For Transactions List
				if (!bookLogDetail.getTransactions().isEmpty())
					bookLogDetail.getTransactions().forEach(transaction -> {
						if (transaction.getCreatedAt() == null)
							transaction.setCreatedAt(currentTimestamp);
						transaction.setUpdatedAt(currentTimestamp);
					});
			});

		return bookLogRepository.save(bookLog);
	}

	public String deleteOneBookLog(BookLog bookLog) {
		String result = null;
		if (bookLogRepository.existsById(bookLog.getId())) {
			bookLogRepository.delete(bookLog);
			result = "BookLog deleted!";
		} else {
			result = "BookLog not found! Or Already deleted!";
		}
		return result;
	}
}
