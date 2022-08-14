## postman: 
#### Method: GET
    - localhost:9490/v1/sp/karyawan/list-all  ==> Get All Karyawan
    - localhost:9490/v1/sp/karyawan/1  ===> Get Karyawan byId
    - localhost:9490/v1/sp/karyawan/list/per   ==> Get karyawan like name

## Perhatikan pada application.properties:
    - spring.datasource.url=jdbc:postgresql://localhost:5432/perusahaanABC
### Note: tambahkan nama database dibelakangnya sesuai dengan yang ada pada postgres pg4admin atau database karyawannya
