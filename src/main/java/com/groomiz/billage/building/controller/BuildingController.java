package com.groomiz.billage.building.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.groomiz.billage.building.document.BuildingListExcpetionDocs;
import com.groomiz.billage.building.dto.response.BuildingListResponse;
import com.groomiz.billage.global.anotation.ApiErrorExceptionsExample;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/univ/building")
@Tag(name = "Building Controller", description = "[학생] 건물 관련 API")
public class BuildingController {

	@GetMapping
	@Operation(summary = "건물 목록 조회")
	@ApiErrorExceptionsExample(BuildingListExcpetionDocs.class)
	public ResponseEntity<List<BuildingListResponse>> findAll(
		@Parameter(description = "예약 날짜", example = "2024-07-01")
		@RequestParam("date") LocalDate date,
		@Parameter(description = "예약 인원", example = "30")
		@RequestParam("headcount") Integer count) {

		List<BuildingListResponse> response = null;
		return ResponseEntity.ok(response);
	}
}
