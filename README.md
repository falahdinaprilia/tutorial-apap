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
- [x] Peletakan suatu method lebih baik di controller, model, atau service.

## Tutorial 4
### What I have learned today
1. Jelaskan yang anda pelajari dari melakukan latihan nomor 2, dan jelaskan tahapan bagaimana
   anda menyelesaikan latihan nomor 2
   
   *Saya mempelajari cara menggunakan fragment pada Thymeleaf dan menamai title yang diletakkan pada fragment header yang dinamis.*
   
   *Tahapan pengerjaan yaitu:*
   
   *a.       Pada fragment/fragment.html saya menambahkan baris kode yang berisi:
        <nav th:fragment="navbar (pageTitle)" class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#" th:text="${pageTitle}">Navbar</a>*

    *dimana nantinya tiap halaman akan berbeda-beda titlenya tergantung dari nilai dari pageTitle-nya.*
    
    *b.     Kemudian, di tiap halaman html, tambahkan pageTitle sebagai identifier di:
           <object th:replace="fragments/fragment :: navbar (pageTitle = '......')"></object>*
   
2. Jelaskan yang anda pelajari dari latihan nomor 3, dan jelaskan tahapan bagaimana anda
   menyelesaikan latihan nomor 3
   
   *Saya mempelajari bahwa sebuah form dapat membuat dynamic fields dimana beberapa data data disubmit sekaligus ke dalam database.*
   
   *Sebelumnya, saya menggunakan AJAX untuk menambahkan baris input field, namun ternyata bisa menggunakan Thymeleaf.*
   
   *Tahapan pengerjaan yaitu:*
   
   *a. Pada menuController, tambahkan Method add yang berguna untuk menyimpan satu menu yang belum memiliki atribut. Menu tersebut nantinya
   akan digunakan pada baris pertama di form untuk menambah menu.*
   
   *b. Pada menuController, tambahkan Method addRow yang berguna untuk menambah baris input field untuk setiap atribut menu dan menyimpan data yang
   dimasukkan ke dalam input field di baris tersebut.*
   
   *c. Pada menuController, tambahkan Method removeRow yang berguna untuk menghapus baris input field.*
   
   *d. Pada menuController, tambahkan Method addMenuSubmit yang berguna untuk men-submit banyak menu sekaligus.*
   
   *e. Pada template view form-add-menu.html tambahkan:*
   
   *<form th:action="@{/menu/add/{id}(id=${idRestoran})}" th:object="${restoran}" method="POST">
            <input type="hidden" th:field="*{idRestoran}" />*
            
    ...........
    
    *<tr th:each="menu, rowStat : *{listMenu}">
                     <td scope="row" style="text-align: center">
                         <input class="form-control" type="text" name="nama" th:field="*{listMenu[__${rowStat.index}__].nama}"/>*
                         
     *yang berguna untuk memberikan index pada setiap th:field.*
            
3. Jelaskan perbedaan th:include dan th:replace

    *th:include dan th:replace sama-sama berguna untuk memasukkan bagian dari halaman lain sebagai fragment.*
    
    *th:include berguna untuk memasukkan konten fragment ke dalam tag hostnya. Contoh: <div th:include="..."> content </div>,
    fragment diletakkan di dalam tag div.*
    
    *th:replace berguna untuk menggantikan tag host dengan tag fragment. Contoh:  <div th:replace="..."> content </div> ,
    div akan diganti dengan fragment.*
    
4. Jelaskan bagaimana penggunaan th:object beserta tujuannya

    *Penggunaan th:object digunakan apabila ingin memasukkan data dari form ke object tersebut.
    Tujuan penggunaannya adalah untuk menghandle input dari user, menentukan objek yang terikat dengan
    data dari form(input) yang di submit.*
    
### What I did not understand
- [x] Kegunaan th:field dan syntaxnya lebih lanjut.

## Tutorial 5
### What I have learned today
1. Jelaskan bagian mana saja dari test yang dibuat pada latihan no 2 adalah given, when, dan and
   then.
   
   *given: saat inisiasi objek restoranModel yang pada hal ini yaitu generateDummyRestoranModel.
   Setelah itu, set Id restoran.*
   
   *when: saat restoranService mencari restoran dengan id restoran.*
   
   *then: dikembalikan restoran model dan ditampilkan di url /restoran/view?idRestoran=1.
   Lalu expect halaman tersebut tersedia, halaman menampilkan string informasi restoran, nama resto,
   alamat resto, dan list menunya. Serta memastikan bahwa resto adalah rentoranmodel yang diinisiasi di awal.
   Terakhir, pastikan bahwa restoranService memanggil method getRestoranByIdRestoran(idRestoran) sebanyak 1 kali.*
   
2. Jelaskan perbedaan line coverage dan logic coverage.

    *Line coverage adalah jenis coverage yang mengacu pada seberapa besar cakupan kode perbarisnya terhadap kegunaan
    di dalam sistem.*
    
    *Logic covergae adalah jenis coverage yang mengacu pada seberapa besar kode dapat menghandle kemungkinan-kemungkinan
    yang terjadi pada logika proses-proses pada sistem.*
    
3. Pada keadaan ideal, apa yang seharusnya dibuat terlebih dahulu, code atau unit test? Mengapa
   seperti itu? Apa akibatnya jika urutannya dibalik, adakah risiko tak terlihat yang mungkin
   terjadi?
   
   *Unit test terlebih dahulu karena di unit test kita membuat ekspektasi jalannya suatu fungsi.
   Setelah jelas semua alurnya, barulah kita implementasikan code-nya. Akibat dari urutannya dibalik
   yaitu apabila code terlebih dahulu, namun nanti jalannya tidak sesuai ekspektasi kita di unit test,
   maka kita harus mengubah kembali code kita. Itu akan memakan waktu yang lebih lama dibandingkan jika
   urutannya unit test dahulu, setelah itu code.*
   
4. [Bonus] Jelaskan mengapa pada latihan no 3, main class spring tidak diikutsertakan ke dalam
   perhitungan coverage? Apa saja yang dapat menyebabkan suatu class dapat di-exclude dari
   perhitungan code coverage.
   
   *karena kita telah membuat konfigurasi pada pom.xml untuk exclude atau tidak memasukkan main class
   ke dalam class yang di test. Hal-hal yang dapat menyebabkan suatu class di exclude:*
   
   *a. apabila class memiliki coverage yang rendah padahal tidak perlu dilakukan test pada class tersebut.
   Karena coverage yang rendah akan mempengaruhi coverage keseluruhan class yang berakibat coverage keseluruhan menjadi turun / rendah.*
   
   *b. class yang tidak memiliki process / tidak ada aktivitas yang dilakukan di dalamnya*.
   
###Lampiran

*apabila gambar tidak muncul, gambar terletak di resource/static/img/*

![Gopud-before](gopud/src/main/resources/static/img/G_before.jpg "Gopud before")

![Gopud-after](gopud/src/main/resources/static/img/G_after.jpg "Gopud after")

![Service-before](gopud/src/main/resources/static/img/S_before.png "Service before")
   
![Service-after](gopud/src/main/resources/static/img/S_after.png "Service after")
      
![MenuService-before](gopud/src/main/resources/static/img/MS_before.jpg "MenuService before")
 
![MenuService-after](gopud/src/main/resources/static/img/MS_after.png "MenuService after")

![RestoranService-before](gopud/src/main/resources/static/img/RS_before.png "RestoranService before")

![RestoranService-after](gopud/src/main/resources/static/img/RS_after.png "RestoranService after")

![RestoranController-before](gopud/src/main/resources/static/img/RC_before.png "RestoranController before")

![RestoranController-after](gopud/src/main/resources/static/img/RC_after.png "RestoranController after")

![Controller-before](gopud/src/main/resources/static/img/C_before.jpg "Controller before")

![Controller-after](gopud/src/main/resources/static/img/C_after.png "Controller after")

![main-class-exclude](gopud/src/main/resources/static/img/GopudApplication.png "main class exclude")

