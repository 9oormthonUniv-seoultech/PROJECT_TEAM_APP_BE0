package com.groomiz.billage.building.entity;

import com.groomiz.billage.common.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Building extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String number;

	@Column(name = "image_url")
	private String imageUrl;

	@Builder
	public Building(String name, String number, String imageUrl) {
		this.name = name;
		this.number = number;
		this.imageUrl = imageUrl;
	}
}