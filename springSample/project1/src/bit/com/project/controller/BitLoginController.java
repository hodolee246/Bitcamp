package bit.com.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import bit.com.project.service.BitLoginService;



@Controller
public class BitLoginController {

	private static final Logger logger = LoggerFactory.getLogger(BitLoginController.class);
	
	@Autowired
	private BitLoginService bitLoginService;
	
}
