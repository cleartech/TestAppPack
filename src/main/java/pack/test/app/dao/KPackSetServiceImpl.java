package pack.test.app.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import pack.test.app.model.KPack;
import pack.test.app.model.KPackSet;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class KPackSetServiceImpl implements KPackSetService {

    private final Logger logger = Logger.getLogger(KPackSetServiceImpl.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private KPackService kPackService;

    public KPackSetServiceImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(final KPackSet kPackSet) {

        final String setSaveQuery = "insert into kpacksets (title) values (?)";

        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

                PreparedStatement statement = con.prepareStatement(setSaveQuery, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, kPackSet.getTitle());

                return statement;
            }
        }, holder);

        int primaryKey = Objects.requireNonNull(holder.getKey()).intValue();

        logger.debug("Created K-Pac Set PK: " + primaryKey);
        logger.debug("K-Packs list size: " + kPackSet.getkPacks().size());

        if (kPackSet.getkPacks().size() != 0) {
            saveKPacksForSet(kPackSet, primaryKey);
        }
    }

    private void saveKPacksForSet(KPackSet set, int primaryKey) {
        final String crossRefQuery = "insert into pack_set_cross (pack_id, set_id) values (?, ?)";
        for (KPack kPack : set.getkPacks()) {
            logger.debug("Save K-Pack with id: " + kPack.getId() + " to K-Pack Set id: " + primaryKey);
            jdbcTemplate.update(crossRefQuery, kPack.getId(), primaryKey);
        }
    }

    @Override
    public void delete(int id) {

        final String deleteSetQuery = "delete from kpacksets where id = " + id;
        final String deletePacksQuery = "delete from pack_set_cross where set_id = " + id;

        jdbcTemplate.update(deletePacksQuery);

        jdbcTemplate.update(deleteSetQuery);
    }

    @Override
    public KPackSet get(final int id) {

        String getSetQuery = "select * from kpacksets where id = " + id;

        return jdbcTemplate.query(getSetQuery, new ResultSetExtractor<KPackSet>() {

            @Override
            public KPackSet extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    KPackSet kPackSet = new KPackSet();
                    kPackSet.setId(rs.getInt("id"));
                    kPackSet.setTitle(rs.getString("title"));

                    kPackSet.setkPacks(getKPacksForSet(id));

                    return kPackSet;
                }
                return null;
            }
        });
    }

    private List<KPack> getKPacksForSet(int id) {

        String getPacksListQuery = "select pack_id from pack_set_cross where set_id = " + id;
        List<Integer> idList = jdbcTemplate.queryForList(getPacksListQuery, Integer.class);

        List<KPack> kPacks = new ArrayList<>();

        for (int tempId : idList) {
            kPacks.add(kPackService.get(tempId));
        }

        return kPacks;
    }

    @Override
    public List<KPackSet> getAll() {

        String getAllQuery = "SELECT * FROM kpacksets";

        return jdbcTemplate.query(getAllQuery, new RowMapper<KPackSet>() {

            @Override
            public KPackSet mapRow(ResultSet rs, int rowNum) throws SQLException {
                KPackSet kPackSet = new KPackSet();

                kPackSet.setId(rs.getInt("id"));
                kPackSet.setTitle(rs.getString("title"));

                return kPackSet;
            }
        });
    }
}
