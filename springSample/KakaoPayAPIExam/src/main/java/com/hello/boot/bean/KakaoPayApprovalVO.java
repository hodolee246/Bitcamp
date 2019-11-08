package com.hello.boot.bean;

import java.util.Date;

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
public class KakaoPayApprovalVO {

	//response
	private String aid, tid, cid, sid;
	private String parner_order_id, partner_user_id, payment_method_type;
	private AmountVO amount;
	private CardVO card_info;
	private String item_name, itme_code, payload;
	private Integer quantity, tax_free_amount, vat_amount;
	private Date created_at, approved_at;
		
}
