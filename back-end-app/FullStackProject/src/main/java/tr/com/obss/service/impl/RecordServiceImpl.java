package tr.com.obss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.obss.dao.record.RecordDao;
import tr.com.obss.model.Record;
import tr.com.obss.service.RecordService;
@Service
public class RecordServiceImpl implements RecordService{
	@Autowired
	private RecordDao recordDao;
	
	@Override
	public Record post(Record record) {
		return recordDao.post(record);
	}

	@Override
	public Record get(int userID) {
		return recordDao.get(userID);
	}

	@Override
	public Record put(int userID, Record record) {
		return recordDao.put(userID, record);
	}

	@Override
	public void delete(int userID) {
		recordDao.delete(userID);
	}

}
