package perusahaanABCD.model;

import lombok.Data;

import java.util.Date;

@Data
public class KaryawanTraining {
    private int id;
    private int id_karyawan;
    private int id_training;
    private Date tanggal_training;
    private Date createdAt;
    private Date updatedAt;
}
