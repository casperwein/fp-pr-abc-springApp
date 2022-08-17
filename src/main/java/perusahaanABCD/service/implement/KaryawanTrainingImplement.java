package perusahaanABCD.service.implement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import perusahaanABCD.model.KaryawanTraining;
import perusahaanABCD.service.KaryawanTrainingService;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Service
public class KaryawanTrainingImplement  implements KaryawanTrainingService {

    private JdbcTemplate jdbcTemplate;

    public KaryawanTrainingImplement(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<KaryawanTraining> findAllTrainingKaryawan(int row, int page) {
        String sql = "SELECT * FROM karyawan_training";

        List<KaryawanTraining> list = jdbcTemplate.query(sql, new RowMapper<KaryawanTraining>() {
            @Override
            public KaryawanTraining mapRow(ResultSet rs, int rowNum) throws SQLException {
                KaryawanTraining training = new KaryawanTraining();
                training.setId(rs.getInt("Id"));
                training.setId_karyawan(rs.getInt("id_karyawan"));
                training.setId_training(rs.getInt("id_training"));
                training.setTanggal_training(rs.getDate("tanggal_training"));
                training.setCreatedAt(rs.getDate("created_date"));
                training.setUpdatedAt(rs.getDate("updated_date"));
                return training;
            }
        });
        return list;
    }

    @Override
    public List<KaryawanTraining> postTrainingKaryawan(KaryawanTraining obj) {
        String sql = "INSERT INTO karyawan_training (id, id_karyawan, id_training, tanggal_training) VALUES (?, ?, ?, ?) returning true";
        int id = obj.getId();
        int id_karyawan = obj.getId_karyawan();
        int id_training = obj.getId_training();
        Date tanggal_training = obj.getTanggal_training();

        return  jdbcTemplate.query(sql, new RowMapper<KaryawanTraining>(){
            @Override
            public KaryawanTraining mapRow(ResultSet rs, int rowNum) throws SQLException {
                return obj ;
            }
        }, id, id_karyawan, id_training, tanggal_training);
    }
}
