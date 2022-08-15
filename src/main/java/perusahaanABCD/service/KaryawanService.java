package perusahaanABCD.service;


import perusahaanABCD.model.Karyawan;

import java.util.List;

public interface KaryawanService {
    public List<Karyawan> postSPKaryawan(Karyawan obj);
//    public Karyawan postORMKaryawan(Karyawan obj);
//    public Karyawan updateSPKaryawan(Karyawan obj);
//    public Karyawan updateORMKaryawan(Karyawan obj);
    public List<Karyawan> findByIdSPKaryawan(long obj);
    public List<Karyawan> findKaryawanByName(String name);

    //
//    public Karyawan findByIdORMKaryawan(long obj);
    public List<Karyawan> findAllKaryawan(int row,int page);
}
