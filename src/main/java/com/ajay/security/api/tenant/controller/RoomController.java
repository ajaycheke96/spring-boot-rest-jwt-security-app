package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.Room;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.RoomService;

@RestController
@RequestMapping("/room")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RoomController {

	@Autowired
	private RoomService roomService;

	@GetMapping("/listAllRoom")
	public ApiResponse getAllRoom() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Room", roomService.getAllRooms());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Room Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneRoom(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Room", roomService.getOneRoom(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Room Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveRoom")
	public ApiResponse saveRoom(@RequestBody Room room) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Room saved!", roomService.saveRoom(room));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Room Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateRoom")
	public ApiResponse updateRoom(@RequestBody Room room) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Room updated!", roomService.saveRoom(room));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Room Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteRoom")
	public ApiResponse deleteOneRoom(@RequestBody Room room) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, roomService.deleteOneRoom(room), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Room Service exception : " + e.getLocalizedMessage());
		}
	}
}
