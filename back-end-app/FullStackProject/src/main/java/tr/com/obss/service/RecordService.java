package tr.com.obss.service;

import tr.com.obss.model.Record;

public interface RecordService {
	public Record post(Record record);

	public Record get(int userID);

	public Record put(int userID, Record record);

	public void delete(int userID);
}
