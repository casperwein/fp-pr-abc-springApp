## postman: 

### Karyawan Tabel => Store Procedural and Function
#### Method: GET
    Get All Karyawan
        path    : localhost:9490/v1/sp/karyawan/list-all
    Get Karyawan byId
        path    : localhost:9490/v1/sp/karyawan/1 
    Get karyawan like name
        path    : localhost:9490/v1/sp/karyawan/list/per 
#### Method: Post
    - localhost:9490/v1/sp/karyawan/add ==> save data to database with SP savekarywan
    - Keteranga: Pada postman, dibawah url, klik pada body, ke raw, deretan paling kanan,
        -- pilih JSON. lalu masukan data berikut:
        {
            "id": 11,
            "nama": "iqbal",
            "jk": "laki-laki",
            "dob": "2000-04-09",
            "alamat": "jakarta",
            "status": "menikah",
            "nik": "1243242",
            "npwp": "4353453",
            "error_desc": null,
            "error_code": 0,
        }

#### Method: Put
    path    : localhost:9490/v1/sp/karyawan/
        json: 
            {
                "id": 11,
                "nama": "ramadhan",
                "jk": "laki-laki",
                "dob": "2000-04-09",
                "alamat": "bandung",
                "status": "menikah",
                "nik": "1243242",
                "npwp": "4353453",
                "error_desc": null,
                "error_code": 0
            }

### Training Tabel 
#### Method: Get
    Get all training
        path    : localhost:9490/v1/training/

    Get training by id
        path    : localhost:9490/v1/training/7

    Get training like by tema
        path    : localhost:9490/v1/training/list/dev  ==> dev = tema
#### Method: Post
    Post data training
        path    : localhost:9490/v1/training/
        json    :  
            {
                "id": 7,
                "tema": "back-end development",
                "nama_pengajar": "surti remaja"
            }

#### Method: Post
    Update data training
        path     : localhost:9490/v1/training/
        json    :
            {
                "id": 2,
                "tema": "back-end development",
                "nama_pengajar": "surti remaja"
            }


### Karyawan Training Tabel 
#### Method: Get
    Post Karyawan Training
        path    : localhost:9490/v1/training-karyawan/
        json    :  
            {
                "id": 2,
                "id_karyawan": 1,
                "id_training": 1,
                "tanggal_training": "2022-04-05"
            }
        
    Get All training (list) 
        path    : localhost:9490/v1/training-karyawan/


### Rekening Tabel
#### Method: Get

#### Perhatikan pada application.properties:
    - spring.datasource.url=jdbc:postgresql://localhost:5432/perusahaanABC
        
         Note: tambahkan nama database dibelakangnya sesuai dengan yang
                ada pada postgres pg4admin atau database karyawannya
