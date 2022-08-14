package perusahaanABCD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import perusahaanABCD.model.Karyawan;

import java.util.List;

@RestController
@RequestMapping("/v1/karyawan")
public class KaryawanController {
    @Autowired
    public perusahaanABCD.service.KaryawanService karyawanService;

    private final int ROW_PER_PAGE = 5;

    @GetMapping("/list-all")
    public List<Karyawan> getListKaryawan(Model model,
                              @RequestParam(value = "page", defaultValue = "1") int pageNumber) {
        List<Karyawan> karyawans = karyawanService.findAllKaryawan(pageNumber, ROW_PER_PAGE);

        return karyawans;
    }
    @GetMapping("/{karyawanId}")
    public List<Karyawan> getListKaryawanById(Model model, @PathVariable long karyawanId) {
        List<Karyawan> karyawan = karyawanService.findByIdSPKaryawan(karyawanId);
        return karyawan;
    }

    @GetMapping("/list/{karyawanName}")
    public List<Karyawan> getListByKaryawanName(Model model, @PathVariable String karywanname) {
        List<Karyawan> karyawan = karyawanService.findKaryawanByName(karywanname);
        return karyawan;
    }


}
