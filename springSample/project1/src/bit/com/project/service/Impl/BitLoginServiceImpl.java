package bit.com.project.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.project.dao.BitLoginDao;
import bit.com.project.service.BitLoginService;

@Service
public class BitLoginServiceImpl implements BitLoginService {

	@Autowired
	private BitLoginDao bitLoginDao;
}
