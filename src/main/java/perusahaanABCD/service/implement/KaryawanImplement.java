package perusahaanABCD.service.implement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import perusahaanABCD.model.Karyawan;
import perusahaanABCD.service.KaryawanService;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class KaryawanImplement implements KaryawanService {

    private JdbcTemplate jdbcTemplate;

    public KaryawanImplement(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Karyawan> findAllKaryawan(int row, int page) {
        List<Karyawan> list = jdbcTemplate.query("SELECT * FROM karyawan", new RowMapper<Karyawan>() {
            @Override
            public Karyawan mapRow(ResultSet rs, int rowNum) throws SQLException {
                Karyawan kyw = new Karyawan();
                kyw.setId(rs.getLong("Id"));
                kyw.setNama(rs.getString("Nama"));
                kyw.setJk(rs.getString("jk"));
                kyw.setDob(rs.getDate("Dob"));
                kyw.setStatus(rs.getString("Status"));
                kyw.setAlamat(rs.getString("Alamat"));
                return kyw;
            }
        });
        return list;
    }

//    @Override
//    public Karyawan postSPKaryawan(Karyawan obj) {
//        return null;
//    }
//
//    @Override
//    public Karyawan postORMKaryawan(Karyawan obj) {
//        return null;
//    }
//
//    @Override
//    public Karyawan updateSPKaryawan(Karyawan obj) {
//        return null;
//    }
//
//    @Override
//    public Karyawan updateORMKaryawan(Karyawan obj) {
//        return null;
//    }
//
    @Override
    @GetMapping("/{karyawanId}")
    public List<Karyawan> findByIdSPKaryawan(long obj) {
        String sql = "SELECT * FROM karyawan WHERE id = ?";
        List<Karyawan> list = jdbcTemplate.query(sql, new RowMapper<Karyawan>() {
            @Override
            public Karyawan mapRow(ResultSet rs, int rowNum) throws SQLException {
                Karyawan kyw = new Karyawan();
                kyw.setId(rs.getLong("Id"));
                kyw.setNama(rs.getString("Nama"));
                kyw.setJk(rs.getString("jk"));
                kyw.setDob(rs.getDate("Dob"));
                kyw.setStatus(rs.getString("Status"));
                kyw.setAlamat(rs.getString("Alamat"));
                return kyw;
            }
        }, obj);
        return list;
    }

    @Override
    public List<Karyawan> findKaryawanByName(String name) {
        String sql = "SELECT * FROM karyawan WHERE id = ?";
        String like = "%"+ name + "%";
        List<Karyawan> list = jdbcTemplate.query(sql, new RowMapper<Karyawan>() {
            @Override
            public Karyawan mapRow(ResultSet rs, int rowNum) throws SQLException {
                Karyawan kyw = new Karyawan();
                kyw.setId(rs.getLong("Id"));
                kyw.setNama(rs.getString("Nama"));
                kyw.setJk(rs.getString("jk"));
                kyw.setDob(rs.getDate("Dob"));
                kyw.setStatus(rs.getString("Status"));
                kyw.setAlamat(rs.getString("Alamat"));
                return kyw;
            }
        }, like);
        return list;
    }
//
//    @Override
//    public Karyawan findByIdORMKaryawan(long obj) {
//        return null;
//    }



}
