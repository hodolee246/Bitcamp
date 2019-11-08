package com.hello.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CardVO {
	
	private String purchase_corp, purchase_corp_code;
	private String issuer_corp, issuer_corp_code;
	private String bin, card_type, install_month, approved_id, card_mid;
	private String interset_free_install, card_item_code;
}