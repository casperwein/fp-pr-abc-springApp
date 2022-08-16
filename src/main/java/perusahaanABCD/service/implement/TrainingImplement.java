package perusahaanABCD.service.implement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import perusahaanABCD.model.Training;
import perusahaanABCD.service.TrainingService;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class TrainingImplement implements TrainingService {
    private JdbcTemplate jdbcTemplate;

    public TrainingImplement(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Training> postTraining(Training obj) {
        String sql = "INSERT INTO training (id, tema, nama_pengajar) VALUES (?, ?, ?) returning true";
        int id = obj.getId();
        String tema = obj.getTema();
        String nama_pengajar = obj.getNama_pengajar();

        return  jdbcTemplate.query(sql, new RowMapper<Training>(){
            @Override
            public Training mapRow(ResultSet rs, int rowNum) throws SQLException {
                return obj ;
            }
        }, id, tema, nama_pengajar);
    }

    @Override
    public List<Training> updateTraining(Training obj) {
        String sql = "UPDATE training SET id = ?, tema = ?, nama_pengajar = ? WHERE id = ? returning true";
        int id = obj.getId();
        String tema = obj.getTema();
        String nama_pengajar = obj.getNama_pengajar();

        return  jdbcTemplate.query(sql, new RowMapper<Training>(){
            @Override
            public Training mapRow(ResultSet rs, int rowNum) throws SQLException {
                return obj ;
            }
        }, id, tema, nama_pengajar, id);
    }

    @Override
    public List<Training> findByIdTraining(long obj) {
        String sql = "SELECT * FROM training WHERE id = ?";
        List<Training> list = jdbcTemplate.query(sql, new RowMapper<Training>() {
            @Override
            public Training mapRow(ResultSet rs, int rowNum) throws SQLException {
                Training training = new Training();
                training.setId(rs.getInt("Id"));
                training.setTema(rs.getString("tema"));
                training.setNama_pengajar(rs.getString("nama_pengajar"));
                training.setCreatedAt(rs.getDate("created_date"));
                training.setUpdatedAt(rs.getDate("updated_date"));
                return training;
            }
        }, obj);
        return list;
    }

    @Override
    public List<Training> findTrainingByName(String name) {
        String sql = "SELECT * FROM training WHERE tema LIKE ?";
        String like = "%" + name + "%";
        List<Training> list = jdbcTemplate.query(sql, new RowMapper<Training>() {
            @Override
            public Training mapRow(ResultSet rs, int rowNum) throws SQLException {
                Training training = new Training();
                training.setId(rs.getInt("Id"));
                training.setTema(rs.getString("tema"));
                training.setNama_pengajar(rs.getString("nama_pengajar"));
                training.setCreatedAt(rs.getDate("created_date"));
                training.setUpdatedAt(rs.getDate("updated_date"));
                return training;
            }
        }, like);
        return list;
    }

    @Override
    public List<Training> findAllTraining(int row, int page) {
        String sql = "SELECT * FROM training";

        List<Training> list = jdbcTemplate.query(sql, new RowMapper<Training>() {
            @Override
            public Training mapRow(ResultSet rs, int rowNum) throws SQLException {
                Training training = new Training();
                training.setId(rs.getInt("Id"));
                training.setNama_pengajar(rs.getString("nama_pengajar"));
                training.setTema(rs.getString("tema"));
                training.setCreatedAt(rs.getDate("created_date"));
                training.setUpdatedAt(rs.getDate("updated_date"));
                return training;
            }
        });
        return list;
    }
}
