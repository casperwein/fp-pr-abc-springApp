package perusahaanABCD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import perusahaanABCD.model.KaryawanTraining;
import java.util.List;

@RestController
@RequestMapping("/v1/training-karyawan")
public class KaryawanTrainingController {
    @Autowired
    public perusahaanABCD.service.KaryawanTrainingService karyawanTrainingService;

    private final int ROW_PER_PAGE = 5;

    @PostMapping("/")
    public List<KaryawanTraining> postKaryawanTraining(@RequestBody KaryawanTraining Ktrain){
        List<KaryawanTraining> newKTrain = (List<KaryawanTraining>) karyawanTrainingService.postTrainingKaryawan(Ktrain);
        return newKTrain;
    }

    @GetMapping("/")
    public List<KaryawanTraining> getListTraining(Model model,
                                                  @RequestParam(value = "page", defaultValue = "1") int pageNumber) {
        List<KaryawanTraining> karyawanTrainings = karyawanTrainingService.findAllTrainingKaryawan(pageNumber, ROW_PER_PAGE);
        return karyawanTrainings;
    }
}
