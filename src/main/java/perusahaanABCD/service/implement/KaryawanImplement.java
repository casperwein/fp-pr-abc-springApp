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
import java.util.Date;
import java.util.List;

@Service
public class KaryawanImplement implements KaryawanService {

    private JdbcTemplate jdbcTemplate;

    public KaryawanImplement(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Karyawan> findAllKaryawan(int row, int page) {
        String sql = "SELECT karyawan.id, karyawan.nama, karyawan.jk, karyawan.dob, karyawan.status, karyawan.alamat, detail_karyawan.nik, detail_karyawan.npwp\n" +
                "FROM karyawan\n" +
                "LEFT JOIN detail_karyawan ON Karyawan.id = detail_karyawan.id_karyawan\n" +
                "ORDER BY karyawan.id";
        List<Karyawan> list = jdbcTemplate.query(sql, new RowMapper<Karyawan>() {
            @Override
            public Karyawan mapRow(ResultSet rs, int rowNum) throws SQLException {
                Karyawan kyw = new Karyawan();
                kyw.setId(rs.getInt("Id"));
                kyw.setNama(rs.getString("Nama"));
                kyw.setJk(rs.getString("jk"));
                kyw.setDob(rs.getDate("Dob"));
                kyw.setStatus(rs.getString("Status"));
                kyw.setAlamat(rs.getString("Alamat"));
                kyw.setNik(rs.getString("nik"));
                kyw.setNpwp(rs.getString("npwp"));
                return kyw;
            }
        });
        return list;
    }



    @Override
    public List<Karyawan> postSPKaryawan(Karyawan obj) {
        String sql = "call savekaryawan(?,?,?,?,?,?,?,?,?,?)";
        int id = obj.getId();
        String nama = obj.getNama();
        String jk = obj.getJk();
        Date dob = obj.getDob();
        String status = obj.getStatus();
        String alamat = obj.getAlamat();
        String nik = obj.getNik();
        String npwp = obj.getNpwp();
        String error_desc = obj.getError_desc();
        int error_code = obj.getError_code();

        return  jdbcTemplate.query(sql, new RowMapper<Karyawan>(){
            @Override
            public Karyawan mapRow(ResultSet rs, int rowNum) throws SQLException {
                return obj;
            }
        }, nama, jk, dob, alamat, status, nik, npwp, id, error_desc, error_code);
    }
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
        String sql = "SELECT karyawan.id, karyawan.jk,  karyawan.nama, karyawan.dob, karyawan.status, karyawan.alamat, detail_karyawan.nik, detail_karyawan.npwp\n" +
                "FROM karyawan\n" +
                "LEFT JOIN detail_karyawan ON Karyawan.id = detail_karyawan.id_karyawan\n" +
                "WHERE karyawan.id = ?";
        List<Karyawan> list = jdbcTemplate.query(sql, new RowMapper<Karyawan>() {
            @Override
            public Karyawan mapRow(ResultSet rs, int rowNum) throws SQLException {
                Karyawan kyw = new Karyawan();
                kyw.setId(rs.getInt("Id"));
                kyw.setNama(rs.getString("nama"));
                kyw.setJk(rs.getString("jk"));
                kyw.setDob(rs.getDate("Dob"));
                kyw.setStatus(rs.getString("Status"));
                kyw.setAlamat(rs.getString("Alamat"));
                kyw.setNik(rs.getString("nik"));
                kyw.setNpwp(rs.getString("npwp"));
                return kyw;
            }
        }, obj);
        return list;
    }


    // select all like name
    @Override
    public List<Karyawan> findKaryawanByName(String name) {
//        String sql = "SELECT * FROM karyawan WHERE nama LIKE ?";
        String sql = "SELECT karyawan.id, karyawan.jk,  karyawan.nama, karyawan.dob, karyawan.status, karyawan.alamat, detail_karyawan.nik, detail_karyawan.npwp\n" +
                "FROM karyawan\n" +
                "LEFT JOIN detail_karyawan ON Karyawan.id = detail_karyawan.id_karyawan\n" +
                "WHERE karyawan.nama like '%per%'";
        String like = "'%"+ name + "%'";
        List<Karyawan> list = jdbcTemplate.query(sql, new RowMapper<Karyawan>() {
            @Override
            public Karyawan mapRow(ResultSet rs, int rowNum) throws SQLException {
                Karyawan kyw = new Karyawan();
                kyw.setId(rs.getInt("Id"));
                kyw.setNama(rs.getString("Nama"));
//                kyw.setNama(rs.getString("getlistkaryawanlike"));
                kyw.setJk(rs.getString("jk"));
                kyw.setDob(rs.getDate("Dob"));
                kyw.setStatus(rs.getString("Status"));
                kyw.setAlamat(rs.getString("Alamat"));
                return kyw;
            }
        });
        System.out.println(like);
        return list;
    }

    // select name  by like name Function
//
//    @Override
//    public Karyawan findByIdORMKaryawan(long obj) {
//        return null;
//    }
}
