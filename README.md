# Tutorial APAP

## Authors

* **FALAHDINA APRILIA** - *1706043922* - *C* 

## Tutorial 1
### What I have learned today
(Masukkan pertanyaan yang diikuti jawaban di setiap nomor, contoh seperti dibawah. Anda juga boleh
menambahkan catatan apapun dibagian ini)
#### Github
1. Apa itu Issue Tracker? Masalah apa yang dapat diselesaikan dengan Issue Tracker?

    *Issue Tracking adalah fitur pelacakan masalah yang terjadi dalam project yang sedang dikembangkan. 
    Fitur ini dibekali dengan labels, milestone, assignees (penerimaan pengalihan hak), dan search engine.*
    
2. Apa perbedaan dari git merge dan merge --squash?
    
    **git merge** *dilakukan saat fitur terakhir telah selesai dibuat pada branch, kemudian barulah dimerge ke master.*
    
    Sedangkan, **git merge --squash** *dilakukan dengan menggabungkan seluruh fitur yang ada di branch dari awal sampai akhir, 
    lalu setelah fitur menjadi satu barulah dimerge ke master.*

#### Spring
3. Apa itu library & dependency?

    **Library** adalah *kumpulan class-class yang dapat dipanggil oleh Java saat dijalankan
    dan berguna untuk memudahkan para pengguna untuk mengembangkan aplikasinya*
    
    **Dependency** adalah *ketergantungan antara suatu kelas dengan kelas lain di Java atau 
    keadaan dimana sebuah kelas di Java membuat instance dari kelas lain.*
    
4. Apa itu Maven? Mengapa kita perlu menggunakan Maven?

    **Maven** adalah *Java Build Tools yang menggunakan konsep Project Object Model (POM). 
    POM tersebut berisi informasi dan konfigurasi yang digunakan Maven untuk membuat project. 
    Pada dasarnya POM adalah sebuath XML File yang terdapat di dalam project Maven 
    dan di dalam File inilah konfigurasi dari project kita berada.*
    
    *Kita perlu menggunakan Maven karena:*
    
    *- Maven membuat struktur project sendiri 
    sehingga project tersebut akan dapat dibuka dengan berbagai IDE.*
    
    *- Maven dapat memanage Dependency. 
    Biasanya dalam mendevelop aplikasi Java membutuhkan File Jar 
    dari luar default jar yang tersedia pada class di JDK untuk kemudian kita panggil. 
    Class-class tersebut pun terkadang dependent terhadap Class lain diluar jar packagenya. 
    Dengan Maven hanya definisikan di File POM.xml dependency nya,
    maka Maven akan otomatis mendownload file-file jar tersebut ke Repository sehingga dapat kita gunakan.*
    
5. Apa alternatif dari Maven?

    *- Ant*   
     *- Gradle*
    
### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda sudah mengerti
dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [x] Syntax untuk Spring 
- [x] Model dan Controller serta kegunaannya

## Tutorial 2
### What I have learned today
1. Cobalah untuk menambahkan sebuah restoran dengan mengakses link berikut:
   http://localhost:8080/restoran/add?idRestoran=1&nama=PanyuFC&alamat=Kantin%20Fasilkom&nomorTelepon=14022
   Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
   
   *Terjadi error. Karena file add-restoran.html yang dikembalikan oleh fungsi add
   pada class RestoranController.java belum tersedia di folder templates.*
   
2. Pertanyaan 2: Cobalah untuk menambahkan sebuah restoran dengan mengakses link berikut:
   http://localhost:8080/restoran/add?idRestoran=2&nama=KentukuFC&alamat=Kantin%20FIK
   Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
   
   *Terjadi error. Karena tidak terdapat parameter Nomor Telepon pada link yang akan diakses sedangkan 
   pada class RestoranController diatur bahwa parameter tersebut diharuskan ada.*
   
3. Pertanyaan 3: Jika Papa APAP ingin melihat restoran PanyuFC, link apa yang harus diakses?

    *http://localhost:8080/restoran/view?idRestoran=1*
    
4. Tambahkan 1 contoh restoran lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/restoran/viewall, apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.

    *Link tersebut akan menampilkan semua list restoran berisi id restoran, nama restoran, alamat restoran, dan
    nomor telepon restoran yang sudah ditambahkan.*
    
    <a href="https://imgbb.com/"><img src="https://i.ibb.co/GvqcMXL/Capture.png" alt="Capture" border="0"></a><br /><a target='_blank' href='https://babynamesetc.com/lists'></a><br />

### What I did not understand
- [x] Syntax untuk Controller

## Tutorial 3
### What I have learned today
1. Pada class MenuDb, terdapat method findByRestoranIdRestoran, apakah kegunaan dari
method tersebut?

    *method findByRestoranIdRestoran berguna untuk mencari restoran yang ada di database
    berdasarkan idRestoran tersebut dan mengembalikannya dalam bentuk list bertipe MenuModel.*

2. Pada class RestoranController, jelaskan perbedaan method addRestoranFormPage dan
addRestoranSubmit?

    *method addRestoranFormPage berguna untuk menampilkan halaman form html untuk menambahkan
    restoran dengan beberapa data yang harus diisi. Sedangkan method addRestoranSubmit
    berguna untuk menyimpan data yang telah diisi untuk menambahkan restoran ke dalam
    database dan memberikan halaman berupa pemberitahuan apabila data berhasil ditambahkan.*

3. Jelaskan apa kegunaan dari JPA Repository?

    *JPA Repository berguna untuk memasukkan objek-objek java ke dalam suatu relational database.
    JPA Respository dapat mempermudah dalam pengelolaan objek-objek java yang perlu dimasukkan
    ke dalam database beserta ketentuan yang diharuskan.*

4. Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara RestoranModel dan
MenuModel dibuat?

    *Relasi antara RelationalModel dengan MenuModel terdapat pada @OneToMany dan @ManyToOne.
    @OneToMany terdapat pada RestoranModel yang artinya satu restoran dapat memiliki banyak menu.
    @ManyToOne terdapat pada MenuModel yang artinya banyak menu dapat dimiliki oleh satu restoran.
    Dengan adanya definisi antara kedua model tersebut akan mempermudah dalam pengelolaan objek yang ada.*

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER

    *FetchType.LAZY berguna ketika hanya ingin melakukan fetch disaat butuh datanya, biasa digunakan ketika
    ada relasi one-to-many atau many-to-many.*
     
     *FetchType.EAGER berguna ketika ingin data yang akan di-fetch sudah ada saat dibutuhkan, jadi fetch dilakukan seawal mungkin.
     Biasanya digunakan ketika ada relasi many-to-one atau one-to-one.*
     
     *CascadeType.ALL berguna ketika ingin melakukan perubahan pada suatu entitas A namun perubahan tersebut diterapkan juga
     di entitas yang memiliki relasi dengan entitas A tersebut.Perubahan dapat terjadi berupa UPDATE, DELETE, dan sebagainya.
     Contoh apabila ingin menghapus restoran, maka menunya akan terhapus juga.*

### What I did not understand
- [ ] Peletakan suatu method lebih baik di controller, model, atau service.