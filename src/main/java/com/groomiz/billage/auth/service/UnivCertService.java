package com.groomiz.billage.auth.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.groomiz.billage.member.exception.MemberErrorCode;
import com.groomiz.billage.member.exception.MemberException;
import com.univcert.api.UnivCert;

@Service
public class UnivCertService {

	@Value("${univcert.api-key}")
	private String UNIV_API_KEY;

	public Map<?, ?> certificate(String email){
		String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

		if (!email.matches(EMAIL_REGEX)) {
			throw new MemberException(MemberErrorCode.INVALID_EMAIL);
		}

		try {
			Map<String, Object> certifyMap = UnivCert.certify(UNIV_API_KEY, email, "서울과학기술대학교", true);

			return certifyMap;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<?, ?> verify(String email, int codeNumber){
		try {
			Map<String, Object> verifyMap = UnivCert.certifyCode(UNIV_API_KEY, email, "서울과학기술대학교", codeNumber);

			return verifyMap;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Map<?, ?> clearEmailList(){
		try {
			Map<String, Object> clearMap = UnivCert.clear(UNIV_API_KEY);

			return clearMap;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
