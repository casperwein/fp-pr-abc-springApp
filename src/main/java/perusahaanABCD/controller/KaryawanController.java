package perusahaanABCD.controller;

import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import perusahaanABCD.model.Karyawan;

import java.util.List;

@RestController
@RequestMapping("/v1/sp/karyawan")
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
    public List<Karyawan> getListByKaryawanName(Model model, @PathVariable String karyawanName) {
        List<Karyawan> karyawan = karyawanService.findKaryawanByName(karyawanName);
        return karyawan;
    }


    @PostMapping("/add")
    public List<Karyawan> postKaryawan( @RequestBody Karyawan karyawan){
        List<Karyawan> newKaryawan = (List<Karyawan>) karyawanService.postSPKaryawan(karyawan);
        System.out.println(karyawan);
        return newKaryawan;
    }

}
//    @RequestBody int id , @RequestBody String nama, String jk,
//@RequestBody String dob, @RequestBody String alamat,
//
//new Karyawan(karyawan.getId(), karyawan.getJk(), karyawan.getDob(), karyawan.getNama(),
//        karyawan.getAlamat(), karyawan.getStatus(), karyawan.getNik(), karyawan.getNpwp(), karyawan.getError_code(), karyawan.getError_desc()));
//        return "Data karyawan sudah ditambahkan"