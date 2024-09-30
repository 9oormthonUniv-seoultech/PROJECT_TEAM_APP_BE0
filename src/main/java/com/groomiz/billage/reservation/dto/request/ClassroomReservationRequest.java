package com.groomiz.billage.reservation.dto.request;

import java.time.LocalDate;
import java.util.List;

import com.groomiz.billage.reservation.entity.ReservationPurpose;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "강의실 예약 요청 DTO")
public class ClassroomReservationRequest {

	@Schema(description = "강의실 ID", example = "1")
	private Long classroomId;
	@Schema(description = "예약자 전화번호 리스트", example = "[\"010-1234-5678\",\"010-1234-5679\"]")
	private List<String> phoneNumbers;
	@Schema(description = "예약 날짜", example = "2024-08-01")
	private LocalDate applyDate;
	@Schema(description = "예약 시작 시간", example = "9")
	private Integer startTime;
	@Schema(description = "예약 종료 시간", example = "10")
	private Integer endTime;
	@Schema(description = "예약 인원", example = "30")
	private Integer headcount;
	@Schema(description = "예약 사유", example = "단과대 행사")
	private ReservationPurpose purpose;
	@Schema(description = "비고", example = "공대인의 밤 행사입니다.")
	private String contents;
}