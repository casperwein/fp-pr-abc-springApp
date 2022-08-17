package perusahaanABCD.service;

import perusahaanABCD.model.KaryawanTraining;

import java.util.List;

public interface KaryawanTrainingService {
    public List<KaryawanTraining> findAllTrainingKaryawan(int row, int page);
    public List<KaryawanTraining> postTrainingKaryawan(KaryawanTraining obj);
}
