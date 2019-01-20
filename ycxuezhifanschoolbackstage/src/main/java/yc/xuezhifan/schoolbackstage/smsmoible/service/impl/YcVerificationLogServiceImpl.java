package yc.xuezhifan.schoolbackstage.smsmoible.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yc.xuezhifan.schoolbackstage.smsmoible.bean.YcVerificationLog;
import yc.xuezhifan.schoolbackstage.smsmoible.mapper.YcVerificationLogMapper;
import yc.xuezhifan.schoolbackstage.smsmoible.service.YcVerificationLogService;
import yc.xuezhifan.schoolbackstage.utils.UUIDFactory;



@Service
public class YcVerificationLogServiceImpl implements YcVerificationLogService {
	
	@Autowired
	private YcVerificationLogMapper ycVerificationLogMapper;

	@Override
	public YcVerificationLog getYcVerificationLog(YcVerificationLog ycVerificationLog) {
		return ycVerificationLogMapper.getYcVerificationLog(ycVerificationLog);
	}

	@Override
	public int saveYcVerificationLog(YcVerificationLog ycVerificationLog) {
		// TODO Auto-generated method stub
		ycVerificationLog.setId(UUIDFactory.random());
		return ycVerificationLogMapper.saveYcVerificationLog(ycVerificationLog);
	}

	@Override
	public int modifyYcVerificationLog(YcVerificationLog ycVerificationLog) {
		// TODO Auto-generated method stub
		return ycVerificationLogMapper.modifyYcVerificationLog(ycVerificationLog);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		ycVerificationLogMapper.delete(id);
	}

}
