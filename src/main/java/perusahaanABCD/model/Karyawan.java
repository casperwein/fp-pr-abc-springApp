package perusahaanABCD.model;

import lombok.Data;

import java.util.Date;

@Data
public class Karyawan {
    private int id;
    private String nama;
    private String jk;
    private Date dob;
    private String alamat;
    private String status;
    private String nik;
    private String npwp;
    private String error_desc;
    private int error_code;
}
