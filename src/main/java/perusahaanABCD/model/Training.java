package perusahaanABCD.model;

import lombok.Data;

import java.util.Date;

@Data
public class Training {
    private int id;
    private String tema;
    private String nama_pengajar;
    private Date createdAt;
    private Date updatedAt;
}
