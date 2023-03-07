package pack.test.app.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import pack.test.app.model.KPack;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class KPackServiceImpl implements KPackService {

    private final JdbcTemplate jdbcTemplate;

    public KPackServiceImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int save(KPack kPack) {

        String savePackQuery = "INSERT INTO kpacks (title, descr, cr_date) VALUES (?, ?, ?)";

        return jdbcTemplate.update(savePackQuery, kPack.getTitle(), kPack.getDescription(), kPack.getCreationDate());
    }

    @Override
    public int delete(int id) {
        final String deletePackQuery = "delete from kpacks where id = " + id;
        final String deletePacksQuery = "delete from pack_set_cross where pack_id = " + id;

        jdbcTemplate.update(deletePacksQuery);

        return jdbcTemplate.update(deletePackQuery);
    }

    @Override
    public KPack get(int id) {

        String getPackQuery = "select * from kpacks where id = " + id;

        return jdbcTemplate.query(getPackQuery, new ResultSetExtractor<KPack>() {

            @Override
            public KPack extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    KPack kPack = new KPack();
                    kPack.setId(rs.getInt("id"));
                    kPack.setTitle(rs.getString("title"));
                    kPack.setDescription(rs.getString("descr"));
                    kPack.setCreationDate(rs.getDate("cr_date"));
                    return kPack;
                }
                return null;
            }
        });
    }

    @Override
    public List<KPack> getAll() {

        String getAllQuery = "SELECT * FROM kpacks";

        return jdbcTemplate.query(getAllQuery, new RowMapper<KPack>() {

            @Override
            public KPack mapRow(ResultSet rs, int rowNum) throws SQLException {
                KPack kPack = new KPack();

                kPack.setId(rs.getInt("id"));
                kPack.setTitle(rs.getString("title"));
                kPack.setDescription(rs.getString("descr"));
                kPack.setCreationDate(rs.getDate("cr_date"));

                return kPack;
            }

        });
    }
}