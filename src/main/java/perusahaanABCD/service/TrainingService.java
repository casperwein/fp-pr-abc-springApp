package perusahaanABCD.service;

import perusahaanABCD.model.Training;

import java.util.List;

public interface TrainingService {
    public List<Training> postTraining(Training obj);
    public List<Training> updateTraining(Training obj);
    public List<Training> findByIdTraining(long obj);
    public List<Training> findTrainingByName(String tema);
    public List<Training> findAllTraining(int row, int page);
}
