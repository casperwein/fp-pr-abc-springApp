package perusahaanABCD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import perusahaanABCD.model.Training;

import java.util.List;

@RestController
@RequestMapping("/v1/training")
public class TrainingController {

    @Autowired
    public perusahaanABCD.service.TrainingService trainingService;

    private final int ROW_PER_PAGE = 5;

    @GetMapping("/")
    public List<Training> getListTraining(Model model,
                                          @RequestParam(value = "page", defaultValue = "1") int pageNumber) {
        List<Training> trainings = trainingService.findAllTraining(pageNumber, ROW_PER_PAGE);

        return trainings;
    }

    @GetMapping("/{id}")
    public List<Training> getListKaryawanById(Model model, @PathVariable long id) {
        List<Training> training = trainingService.findByIdTraining(id);
        return training;
    }

    @PostMapping("/")
    public List<Training> postTraining(@RequestBody Training training){
        List<Training> newTraining = (List<Training>) trainingService.postTraining(training);
        return newTraining;
    }


    @PutMapping("/")
    public List<Training> updateTraining(@RequestBody Training training){
        List<Training> newTraining = trainingService.updateTraining(training);
        return newTraining;
    }

    @GetMapping("/list/{tema}")
    public List<Training> findTrainingByTema(Model model, @PathVariable String tema) {
        List<Training> training = trainingService.findTrainingByName(tema);
        return training;
    }
}
