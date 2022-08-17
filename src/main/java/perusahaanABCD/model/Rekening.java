package perusahaanABCD.model;

import lombok.Data;

import java.util.Date;

@Data
public class Rekening {
    private int id;
    private String nama;
    private String jenis;
    private String nomor;
    private int id_karyawan;
    private Date deleted_date;
    private Date updated_date;
    private Date created_date;
}
