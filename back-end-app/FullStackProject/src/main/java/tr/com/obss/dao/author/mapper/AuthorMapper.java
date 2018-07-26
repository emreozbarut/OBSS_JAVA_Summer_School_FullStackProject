package tr.com.obss.dao.author.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import tr.com.obss.model.Author;

@SuppressWarnings("rawtypes")
public class AuthorMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Author author = new Author();
		author.setAuthorID(rs.getInt("authorID"));
		author.setName(rs.getString("name"));
		author.setSurname(rs.getString("surname"));
		return author;
	}

}
