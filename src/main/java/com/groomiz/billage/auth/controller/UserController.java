package com.groomiz.billage.auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.groomiz.billage.auth.dto.LoginRequest;
import com.groomiz.billage.auth.dto.RegisterRequest;
import com.groomiz.billage.auth.service.AuthService;
import com.groomiz.billage.member.service.MemberService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "User Controller", description = "회원 인증/인가 관련 API")
public class UserController {

	private final AuthService authService;
	private final MemberService memberService;

	@PostMapping("/login")
	@Operation(summary = "회원 로그인")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
		try {
			authService.login(loginRequest, response);
			return ResponseEntity.ok("Login successful");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + e.getMessage());
		}
	}

	@PostMapping("/logout")
	@Operation(summary = "회원 로그아웃")
	public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
		try {
			authService.logout(request, response);
			return ResponseEntity.ok("Logout successful");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Logout failed: " + e.getMessage());
		}
	}

	@PostMapping("/register")
	@Operation(summary = "회원 가입")
	public String join(@RequestBody RegisterRequest registerRequest) {

		memberService.register(registerRequest);

		return "success";
	}

	@GetMapping("/check-student-number")
	@Operation(summary = "학번 중복 확인")
	public String checkStudentNumber(
		@Parameter(description = "학번", example = "20100000") @RequestParam Long studentNumber) {

		return "success";
	}

	@PostMapping("/certificate")
	@Operation(summary = "이메일 인증 요청")
	public String certificate(
		@Parameter(description = "이메일", example = "asdf1234@gmail.com") @RequestParam String email) {
		return "success";
	}

	@PostMapping("/verify")
	@Operation(summary = "이메일 인증 코드 검증")
	public String verify(
		@Parameter(description = "이메일", example = "asdf1234@gmail.com") @RequestParam String email,
		@Parameter(description = "인증 코드", example = "123456") @RequestParam String code) {
		return "success";
	}

}