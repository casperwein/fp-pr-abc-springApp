package perusahaanABCD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import perusahaanABCD.model.Rekening;

import java.util.List;


@RestController
@RequestMapping("/v1/rekening")
public class RekeningController {

    @Autowired
    public perusahaanABCD.service.RekeningService rekeningService;

    private final int ROW_PER_PAGE = 5;

    @GetMapping("/")
    public List<Rekening> getAllRekening(Model model,
                                          @RequestParam(value = "page", defaultValue = "1") int pageNumber) {
        List<Rekening> rekenings = rekeningService.findAllRekening(pageNumber, ROW_PER_PAGE);
        return rekenings;
    }

    @PostMapping("/")
    public List<Rekening> postRekening(@RequestBody Rekening Ktrain){
        List<Rekening> newRekening = (List<Rekening>) rekeningService.postRekening(Ktrain);
        return newRekening;
    }

    @PutMapping("/")
    public List<Rekening> updateRekening(@RequestBody Rekening training){
        List<Rekening> rekening = rekeningService.updateRekening(training);
        return rekening;
    }

    @DeleteMapping("/{id}")
    public String deletedRekening(@PathVariable int id){
        String rekening = rekeningService.deleteRekening(id);
        return rekening;
    }
}
