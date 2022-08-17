package perusahaanABCD.service.implement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import perusahaanABCD.model.Rekening;
import perusahaanABCD.service.RekeningService;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class RekeningImplement implements RekeningService {

    private JdbcTemplate jdbcTemplate;

    public RekeningImplement(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<perusahaanABCD.model.Rekening> postRekening(perusahaanABCD.model.Rekening obj) {
        String sql = "INSERT INTO rekening (id, nama, jenis, nomor, id_karyawan) VALUES (?, ?, ?, ?, ?) returning true";
        int id = obj.getId();
        String nama = obj.getNama();
        String Jenis = obj.getJenis();
        String nomor = obj.getNomor();
        int id_karyawan = obj.getId_karyawan();

        return  jdbcTemplate.query(sql, new RowMapper<Rekening>(){
            @Override
            public Rekening mapRow(ResultSet rs, int rowNum) throws SQLException {
                return obj ;
            }
        }, id, nama, Jenis, nomor, id_karyawan);
    }

    @Override
    public List<perusahaanABCD.model.Rekening> updateRekening(perusahaanABCD.model.Rekening obj) {
        String sql = "UPDATE rekening SET id = ?, nama = ?, jenis = ?, nomor = ?, id_karyawan = ? WHERE id = ? returning true";
        int id = obj.getId();
        String nama = obj.getNama();
        String jenis = obj.getJenis();
        String nomor = obj.getNomor();
        int id_karyawan = obj.getId_karyawan();

        return  jdbcTemplate.query(sql, new RowMapper<Rekening>(){
            @Override
            public Rekening mapRow(ResultSet rs, int rowNum) throws SQLException {
                return obj ;
            }
        }, id, nama, jenis, nomor, id_karyawan, id);
    }

    @Override
    public String deleteRekening(int id) {
        String sql = "DELETE FROM rekening WHERE id = ? returning true";
        return jdbcTemplate.query(sql, new RowMapper<String>(){
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return  "Data Has been deleted";
            }
        },id).toString();
    }
//
//    @Override
//    public List<String> deleteRekening(int id) {
//        String sql = "DELETE FROM rekening WHERE id = ? returning true";
//        return  jdbcTemplate.query(sql, new RowMapper<String>(){
//            @Override
//            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
//                return  null;
//            }
//        },id);
//    }
    @Override
    public List<perusahaanABCD.model.Rekening> findAllRekening(int row, int page) {
        String sql = "SELECT * FROM rekening";
        List<Rekening> list = jdbcTemplate.query(sql, new RowMapper<Rekening>() {
            @Override
            public Rekening mapRow(ResultSet rs, int rowNum) throws SQLException {
                Rekening rekening = new Rekening();
                rekening.setId(rs.getInt("Id"));
                rekening.setNama(rs.getString("nama"));
                rekening.setJenis(rs.getString("jenis"));
                rekening.setNomor(rs.getString("nomor"));
                rekening.setId_karyawan(rs.getInt("id_karyawan"));
                rekening.setCreated_date(rs.getDate("created_date"));
                rekening.setUpdated_date(rs.getDate("updated_date"));
                rekening.setDeleted_date(rs.getDate("deleted_date"));
                return rekening;
            }
        });
        return list;
    }
}
