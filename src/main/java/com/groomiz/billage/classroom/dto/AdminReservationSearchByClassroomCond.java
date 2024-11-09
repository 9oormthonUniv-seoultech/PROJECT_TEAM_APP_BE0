package com.groomiz.billage.classroom.dto;

import com.groomiz.billage.classroom.entity.Classroom;
import com.groomiz.billage.global.dto.PageRequestDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AdminReservationSearchByClassroomCond extends PageRequestDto {

	private Classroom classroom;
	private LocalDate applyDate;

	@Builder
	public AdminReservationSearchByClassroomCond(Classroom classroom, LocalDate applyDate) {
		this.classroom = classroom;
		this.applyDate = applyDate;
	}
}
