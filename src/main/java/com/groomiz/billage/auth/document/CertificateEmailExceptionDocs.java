package com.groomiz.billage.auth.document;

import com.groomiz.billage.global.anotation.ExceptionDoc;
import com.groomiz.billage.global.anotation.ExplainError;
import com.groomiz.billage.global.exception.GlobalCodeException;
import com.groomiz.billage.global.interfaces.SwaggerExampleExceptions;
import com.groomiz.billage.member.exception.MemberErrorCode;
import com.groomiz.billage.member.exception.MemberException;

@ExceptionDoc
public class CertificateEmailExceptionDocs implements SwaggerExampleExceptions {
	@ExplainError
	public GlobalCodeException 이메일_형식_오류 = new MemberException(MemberErrorCode.INVALID_EMAIL);
}
