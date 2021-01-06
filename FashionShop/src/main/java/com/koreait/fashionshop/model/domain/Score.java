package com.koreait.fashionshop.model.domain;

import lombok.Data;

@Data
public class Score {
	private int score_id;
	private int product_id;
	private int star; //별점 (1~5)
}