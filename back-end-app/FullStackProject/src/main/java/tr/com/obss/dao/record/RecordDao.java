package tr.com.obss.dao.record;

import tr.com.obss.model.Record;

public interface RecordDao {
	public Record post(Record record);

	public Record get(int userID);

	public Record put(int userID, Record record);

	public void delete(int userID);
}
