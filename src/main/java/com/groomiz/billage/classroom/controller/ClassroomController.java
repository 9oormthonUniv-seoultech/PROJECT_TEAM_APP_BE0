package com.groomiz.billage.classroom.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.groomiz.billage.classroom.dto.request.ClassroomListRequest;
import com.groomiz.billage.classroom.dto.response.ClassroomDetailResponse;
import com.groomiz.billage.classroom.dto.response.ClassroomListResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/univ/classroom")
@Tag(name = "Classroom Controller", description = "[학생] 강의실 관련 API")
public class ClassroomController {

	@PostMapping
	@Operation(summary = "강의실 목록 조회")
	public ResponseEntity<List<ClassroomListResponse>> findAll(@RequestBody ClassroomListRequest request) {

		List<ClassroomListResponse> response = null;
		return ResponseEntity.ok(response);
	}

	@GetMapping("/info")
	@Operation(summary = "강의실 상세 조회")
	public ResponseEntity<ClassroomDetailResponse> findByClassroomId(
		@Parameter(description = "강의실 ID", example = "1")
		@RequestParam("id") Long id) {

		ClassroomDetailResponse response = new ClassroomDetailResponse();
		return ResponseEntity.ok(response);
	}
}
