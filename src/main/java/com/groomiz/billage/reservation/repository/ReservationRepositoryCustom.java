package com.groomiz.billage.reservation.repository;

import com.groomiz.billage.classroom.dto.response.AdminClassroomDetailResponse.ReservationDetail;
import com.groomiz.billage.classroom.dto.AdminReservationSearchByClassroomCond;
import org.springframework.data.domain.Page;

import com.groomiz.billage.reservation.dto.AdminReservationSearchCond;
import com.groomiz.billage.reservation.dto.ReservationSearchCond;
import com.groomiz.billage.reservation.dto.response.AdminReservationStatusListResponse.ReservationInfo;
import com.groomiz.billage.reservation.dto.response.ReservationStatusListResponse;

import java.util.List;

public interface ReservationRepositoryCustom {

	Page<ReservationInfo> searchPendingReservationPageByBuilding(AdminReservationSearchCond adminReservationSearchCond);
	Page<ReservationInfo> searchApprovedReservationPageByAdmin(AdminReservationSearchCond adminReservationSearchCond);
	Page<ReservationInfo> searchRejectedAndCanceledReservationPageByAdmin(
		AdminReservationSearchCond adminReservationSearchCond);
	Page<ReservationStatusListResponse.ReservationInfo> searchUpcomingReservationPageByRequester(ReservationSearchCond reservationSearchCond);
	Page<ReservationStatusListResponse.ReservationInfo> searchPastReservationPageByRequester(ReservationSearchCond reservationSearchCond);

	List<ReservationDetail> searchPendingAndApprovedReservationByClassroom(AdminReservationSearchByClassroomCond reservationSearchCond);
}
