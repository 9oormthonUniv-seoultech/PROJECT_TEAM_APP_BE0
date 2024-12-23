package com.groomiz.billage.reservation.document;

import com.groomiz.billage.building.exception.BuildingErrorCode;
import com.groomiz.billage.building.exception.BuildingException;
import com.groomiz.billage.classroom.exception.ClassroomErrorCode;
import com.groomiz.billage.classroom.exception.ClassroomException;
import com.groomiz.billage.global.anotation.ExceptionDoc;
import com.groomiz.billage.global.anotation.ExplainError;
import com.groomiz.billage.global.exception.GlobalCodeException;
import com.groomiz.billage.global.interfaces.SwaggerExampleExceptions;
import com.groomiz.billage.reservation.exception.AdminReservationErrorCode;
import com.groomiz.billage.reservation.exception.AdminReservationException;
import com.groomiz.billage.reservation.exception.ReservationErrorCode;
import com.groomiz.billage.reservation.exception.ReservationException;

@ExceptionDoc
public class AdminReservationExceptionDocs implements SwaggerExampleExceptions {

	@ExplainError("예약 타입이 올바르지 않은 경우 발생하는 오류입니다.")
	public GlobalCodeException 잘못된_예약_타입 = new AdminReservationException(
		AdminReservationErrorCode.INVALID_RESERVATION_TYPE);

	@ExplainError("존재하지 않는 건물일 경우 발생하는 오류입니다.")
	public GlobalCodeException 존재하지_않는_건물 = new BuildingException(BuildingErrorCode.BUILDING_NOT_FOUND);

	@ExplainError("존재하지 않는 강의실일 경우 발생하는 오류입니다.")
	public GlobalCodeException 존재하지_않는_강의실 = new ClassroomException(ClassroomErrorCode.CLASSROOM_NOT_FOUND);

	@ExplainError("강의실 아이디가 건물 아이디에 매칭되지 않는 경우 발생하는 오류입니다.")
	public GlobalCodeException 건물에_없는_강의실 = new ClassroomException(ClassroomErrorCode.CLASSROOM_BUILDING_MISMATCH);

	@ExplainError("예약 날짜가 과거인 경우 발생하는 오류입니다.")
	public GlobalCodeException 과거_날짜_예약 = new ReservationException(ReservationErrorCode.PAST_DATE_RESERVATION);

	@ExplainError("예약 날짜가 한 달 이후인 경우 발생하는 오류입니다.")
	public GlobalCodeException 한달_이후_예약 = new ReservationException(ReservationErrorCode.FUTURE_DATE_LIMIT_EXCEEDED);

	@ExplainError("시작 시간이 종료 시간보다 뒤일 경우 발생하는 오류입니다.")
	public GlobalCodeException 잘못된_시간_범위 = new ReservationException(ReservationErrorCode.START_TIME_AFTER_END_TIME);

	@ExplainError("예약 시간이 24시 형식이 아닌 경우 발생하는 오류입니다.")
	public GlobalCodeException 잘못된_시간_형식 = new ReservationException(ReservationErrorCode.INVALID_RESERVATION_TIME);

	@ExplainError("이미 예약 중인 강의실에 대해 중복 예약을 시도한 경우 발생하는 오류입니다.")
	public GlobalCodeException 중복_예약 = new ReservationException(ReservationErrorCode.DUPLICATE_RESERVATION);
}
