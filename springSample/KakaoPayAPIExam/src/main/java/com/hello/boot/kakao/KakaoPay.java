package com.hello.boot.kakao;

import java.net.URI;
import java.net.URISyntaxException;
 

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.hello.boot.bean.KakaoPayApprovalVO;
import com.hello.boot.bean.KakaoPayReadyVO;

import lombok.extern.java.Log;
 
@Service
@Log
public class KakaoPay {
 
    private static final String HOST = "https://kapi.kakao.com";
    
    private KakaoPayReadyVO kakaoPayReadyVO;
    private KakaoPayApprovalVO kakaoPayApprovalVO;
      
    public String kakaoPayReady() {
 
        RestTemplate restTemplate = new RestTemplate();
 
        // 서버로 요청할 헤더
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "e0d714b896777ed7638e9d01bc142d94");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
		
        // 서버로 요청할 바디
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");			// 가맹점코드 10자
        params.add("partner_order_id", "1001");		// 주문번호
        params.add("partner_user_id", "inwoo1");	// 유저 id
        params.add("item_name", "200포인트 충전");	// 상품 이름
        params.add("quantity", "1");				// 수량
        params.add("total_amount", "2000");			// 가격
        params.add("tax_free_amount", "100");		// 상품 비과세 금액
        // 결제 여부 관련 url
        params.add("approval_url", "http://localhost:8080/kakaoPaySuccess");
        params.add("cancel_url", "http://localhost:8080/kakaoPayCancel");
        params.add("fail_url", "http://localhost:8080/kakaoPaySuccessFail");
        
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String,String>>(params, headers);
        
        try {
            kakaoPayReadyVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyVO.class);
            
            log.info("" + kakaoPayReadyVO);
            
            return kakaoPayReadyVO.getNext_redirect_pc_url();
        	
        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        return "/pay";
     
    }
    
    public KakaoPayApprovalVO kakaoPayInfo(String pg_token) {
    	
    	log.info("KakaoPayInfoVO");
    	log.info("---------");

    	RestTemplate restTemplate = new RestTemplate();
    	
    	// 서버로 요청할 헤더
    	HttpHeaders headers = new HttpHeaders();
    	headers.add("Authorization", "KakaoAK " + "e0d714b896777ed7638e9d01bc142d94");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        // 서버로 요청할 바디
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");				// 가맹점코드 10자
        params.add("tid", kakaoPayReadyVO.getTid());
        params.add("partner_order_id", "1001");			// 주문번호
        params.add("partner_user_id", "inwoo1");		// 유저 id
        params.add("pg_token", pg_token);
        params.add("total_amount", "2000");				// 가격
    
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String,String>>(params, headers);
        
        try {
			kakaoPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, KakaoPayApprovalVO.class);
			log.info("kakaoPayApprovalVo : " + kakaoPayApprovalVO);
			
			return kakaoPayApprovalVO;
		} catch (RestClientException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return null;

    }
    
}