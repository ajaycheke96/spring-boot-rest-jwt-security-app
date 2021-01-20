package com.ajay.security.api.tenant.service;

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

	public String saveRoom(Room room) {
		return roomRepository.save(room) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateRoom(Room room) {
		return roomRepository.save(room) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneRoom(Integer id) {
		roomRepository.deleteById(id);
		return " successfully deleted!";
	}
}
