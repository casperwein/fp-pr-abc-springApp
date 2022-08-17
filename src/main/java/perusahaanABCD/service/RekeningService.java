package perusahaanABCD.service;

import perusahaanABCD.model.Rekening;

import java.util.List;

public interface RekeningService {
    public List<Rekening> postRekening(Rekening obj);
    public List<Rekening> updateRekening(Rekening obj);
    public String deleteRekening(int id);
    public List<Rekening> findAllRekening(int row, int page);
}
