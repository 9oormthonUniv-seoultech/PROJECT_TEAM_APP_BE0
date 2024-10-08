package com.groomiz.billage.classroom.document;

import com.groomiz.billage.auth.exception.AuthErrorCode;
import com.groomiz.billage.auth.exception.AuthException;
import com.groomiz.billage.building.exception.BuildingErrorCode;
import com.groomiz.billage.building.exception.BuildingException;
import com.groomiz.billage.classroom.exception.ClassroomErrorCode;
import com.groomiz.billage.classroom.exception.ClassroomException;
import com.groomiz.billage.global.anotation.ExceptionDoc;
import com.groomiz.billage.global.anotation.ExplainError;
import com.groomiz.billage.global.exception.GlobalCodeException;
import com.groomiz.billage.global.interfaces.SwaggerExampleExceptions;
import com.groomiz.billage.reservation.exception.ReservationErrorCode;
import com.groomiz.billage.reservation.exception.ReservationException;

@ExceptionDoc
public class AdminClassroomFilterExceptionDocs implements SwaggerExampleExceptions {

	@ExplainError
	public GlobalCodeException 토큰_만료 = new AuthException(AuthErrorCode.TOKEN_EXPIRED);

	@ExplainError
	public GlobalCodeException 토큰_없음 = new AuthException(AuthErrorCode.TOKEN_NOT_FOUND);

	@ExplainError
	public GlobalCodeException 토큰_유효하지_않음 = new AuthException(AuthErrorCode.INVALID_TOKEN);

	@ExplainError("존재하지 않는 건물일 경우 발생하는 오류입니다.")
	public GlobalCodeException 존재하지_않는_건물 = new BuildingException(BuildingErrorCode.BUILDING_NOT_FOUND);

	@ExplainError("존재하지 않는 층일 경우 발생하는 오류입니다.")
	public GlobalCodeException 존재하지_않는_층 = new BuildingException(BuildingErrorCode.FLOOR_NOT_FOUND);

	@ExplainError("예약 날짜가 과거인 경우 발생하는 오류입니다.")
	public GlobalCodeException 과거_날짜_예약 = new ReservationException(ReservationErrorCode.PAST_DATE_RESERVATION);

	@ExplainError("예약 날짜가 한 달 이후인 경우 발생하는 오류입니다.")
	public GlobalCodeException 한달_이후_예약 = new ReservationException(ReservationErrorCode.FUTURE_DATE_LIMIT_EXCEEDED);

}
