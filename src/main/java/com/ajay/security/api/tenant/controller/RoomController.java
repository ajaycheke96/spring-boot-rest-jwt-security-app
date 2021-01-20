package com.ajay.security.api.tenant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.security.api.tenant.entity.Room;
import com.ajay.security.api.tenant.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {

	@Autowired
	private RoomService roomService;

	@GetMapping("/all")
	public List<Room> getAllRoom() {
		return roomService.getAllRooms();
	}

	@GetMapping("/one/{id}")
	public Room getOneRoom(@PathVariable Integer id) {
		return roomService.getOneRoom(id);
	}

	@PostMapping("/save")
	public String saveRoom(@RequestBody Room room) {
		return roomService.saveRoom(room);
	}

	@PutMapping("/update")
	public String updateRoom(@RequestBody Room room) {
		return roomService.updateRoom(room);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneRoom(@PathVariable Integer id) {
		return roomService.deleteOneRoom(id);
	}
}
