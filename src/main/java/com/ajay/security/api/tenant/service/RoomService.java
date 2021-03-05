package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Room;
import com.ajay.security.api.tenant.repository.RoomRepository;

@Service
@Transactional
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;

	public List<Room> getAllRooms() {
		return roomRepository.findAll();
	}

	public Room getOneRoom(Integer id) {
		return roomRepository.findById(id).get();
	}

	public Room saveRoom(Room room) {
		Timestamp cuurentTimestamp = new Timestamp(System.currentTimeMillis());
		if (room.getCreatedAt() == null)
			room.setCreatedAt(cuurentTimestamp);
		room.setUpdatedAt(cuurentTimestamp);
		return roomRepository.save(room);
	}

	public String deleteOneRoom(Room room) {
		String result = null;
		if (roomRepository.existsById(room.getId())) {
			roomRepository.delete(room);
			result = "Room deleted!";
		} else {
			result = "Room not found! Or Already deleted!";
		}
		return result;
	}
}
