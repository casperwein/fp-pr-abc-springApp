## postman: 

### Karyawan Tabel => Store Procedural and Function
#### Method: GET
    - localhost:9490/v1/sp/karyawan/list-all  ==> Get All Karyawan
    - localhost:9490/v1/sp/karyawan/1  ===> Get Karyawan byId
    - localhost:9490/v1/sp/karyawan/list/per   ==> Get karyawan like name
#### Method: Post
    - localhost:9490/v1/sp/karyawan/add ==> save data to database with SP savekarywan
    - Keteranga: Pada postman, dibawah url, klik pada body, ke raw, deretan paling kanan,
        -- pilih JSON. lalu masukan data berikut:
            --- "id": 11, // sesuaikan dengan id pada database, tidak boleh duplicate
            ---  "nama": "iqbal",
            --- "jk": "laki-laki",
            --- "dob": "2000-04-09",
            --- "alamat": "jakarta",
            --- "status": "menikah",
            --- "nik": "1243242",
            --- "npwp": "4353453",
            --- "error_desc": null,
            --- "error_code": 0

## Perhatikan pada application.properties:
    - spring.datasource.url=jdbc:postgresql://localhost:5432/perusahaanABC
### Note: tambahkan nama database dibelakangnya sesuai dengan yang ada pada postgres pg4admin atau database karyawannya
