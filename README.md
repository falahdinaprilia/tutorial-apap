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

*apabila gambar tidak muncul, gambar terletak di gopud/src/main/resources/static/img/*

*link online* 

<a href="https://ibb.co/7gWDMCS"><img src="https://i.ibb.co/xmjb9L2/C-after.png" alt="C-after" border="0"></a>
<a href="https://ibb.co/C5y571Q"><img src="https://i.ibb.co/5W3W8ML/C-before.jpg" alt="C-before" border="0"></a>

<a href="https://ibb.co/hdZnr2K"><img src="https://i.ibb.co/Jpyb8rz/G-after.jpg" alt="G-after" border="0"></a>
<a href="https://ibb.co/g9g3q9j"><img src="https://i.ibb.co/7CyXMCY/G-before.jpg" alt="G-before" border="0"></a>

<a href="https://ibb.co/nL81WDX"><img src="https://i.ibb.co/sVJ1BFT/Gopud-Application.png" alt="Gopud-Application" border="0"></a>

<a href="https://ibb.co/kyfBZHs"><img src="https://i.ibb.co/b3ZmtWM/MS-after.png" alt="MS-after" border="0"></a>
<a href="https://ibb.co/x1Nh70w"><img src="https://i.ibb.co/WkLn2w7/MS-before.jpg" alt="MS-before" border="0"></a>

<a href="https://ibb.co/p0vTWsD"><img src="https://i.ibb.co/6nRSvph/RC-after.png" alt="RC-after" border="0"></a>
<a href="https://ibb.co/31Q5ZF9"><img src="https://i.ibb.co/D4TP2MH/RC-before.png" alt="RC-before" border="0"></a>

<a href="https://ibb.co/JrBfvxC"><img src="https://i.ibb.co/SVshtQJ/RS-after.png" alt="RS-after" border="0"></a>
<a href="https://ibb.co/vd7GWWX"><img src="https://i.ibb.co/3FDqbbR/RS-before.png" alt="RS-before" border="0"></a>

<a href="https://ibb.co/yFHkwLW"><img src="https://i.ibb.co/N2cN8wZ/S-after.png" alt="S-after" border="0"></a>
<a href="https://ibb.co/Mhjcs9M"><img src="https://i.ibb.co/RSM397z/S-before.png" alt="S-before" border="0"></a>

*link offline*

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

## Tutorial 6
### What I have learned today
1. Apa itu postman? Apa kegunaan dari postman?

    *postman adalah sebuah tools untuk uji coba API yang telah dibuat ataupun uji coba apakah berhasil mengakses API atau tidak.
    Kegunaan postman adalah sebagai  GUI API Caller namun sekarang namun sekarang postman juga menyadiakan fitur lain yaitu Sharing 
    Collection API for Documentation, Testing API, Realtime Collaboration Team, Monitoring API, dan Integration juga.*

2. Apa kegunaan dari annotation @JsonIgnoreProperties?

    *kegunaan @JsonIgnoreProperties adalah mengabaikan properties yang ditentukan dalam JSON serialization dan deserialization.
    @JsonIgnoreProperties mempunyai elemen allowSetters, allowGetters, ignoreUnknown dan value. Elemen value menentukan nama spesifik
    properties yang akan di ignore.*

3. Apa itu ResponseEntity dan apa kegunaannya?

    *ResponseEntity  mewakili seluruh respons HTTP: kode status, header, dan tubuh. 
    ResponseEntity digunakan untuk mengkonfigurasi respon HTTP sepenuhnya.*
    
## Tutorial 7
### What I have learned today
1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode
yang telah anda buat) konsep tersebut diimplementasi?

    *Otentikasi adalah suatu proses yang merupakan sebuah tindakan pembuktian (validasi) terhadap identitas 
    seorang pengguna pada saat akan memasuki (mengakses) sebuah sistem.*
    
    *pada kode, otentikasi diimplementasikan pada saat login*
    
        @Autowired
        public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
        }
        
        <div th:if="${param.error}">
            <span style="color: red">Invalid username or password</span>
        </div>
        <form th:action="@{/login}" method="POST">
            <div class="row form-group">
                <label class="col-sm-4">Username:</label>
                <input type="text" class="col-sm-8 form-control input-sm" name="username">
            </div>
            <div class="row form-group">
                <label class="col-sm-4">Password:</label>
                <input type="password" class="col-sm-8 form-control input-sm" name="password">
            </div>
            <div class="row form-group">
                <button type="submit" class="btn btn-primary">Sign In</button>
            </div>
        </form>
        
        @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                UserModel user = userDB.findByUsername(username);
        
                Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
                grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getRole()));
        
                return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
            }
    
    *Otorisasi adalah proses untuk memberikan izin seseorang untuk melakukan atau memiliki sesuatu.*
    
    *pada kode, otorisasi diimplementasikan pada pembatasan akses contohnya view all restoran hanya dapat
    diakses oleh user dengan role MERCHANT*

        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/restoran/**").hasAnyAuthority("MERCHANT")
                .antMatchers("/user/addUser/**").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").permitAll();
                
         <div class="row" th:if="${user} == 'ADMIN'">
             <div class="col-md-6">
                 <div class="card">
                     <div class="card-header">Tambah User Baru</div>
                     <div class="card-body">
                         <form th:action="@{/user/addUser}" method="post">
                             <label> User Name </label>
                             <input type="text" name="username" class="form-control"/>
 
                             <label> Password </label>
                             <input type="password" name="password" class="form-control"/>
 
                             <label> Role </label>
                             <select name="role" class="form-control">
                                 <option selected value="">-- Pilih Role --</option>
                                 <option th:each="roleAvailable:${listRole}" th:value="${roleAvailable.id}" th:text="${roleAvailable.role}"></option>
                             </select>
 
                             <br>
                             <button type="submit" class="btn btn-primary">Simpan</button>
                         </form>
                     </div>
                 </div>
             </div>
         </div>
         
         
    
2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerjanya!

    *BCryptPasswordEncoder adalah fungsi yang digunakan untuk hashing password pada spring boot.*
    
    *Cara kerja BCryptPasswordEncoder yaitu BCryptPasswordEncoder secara otomatis menghitung dan 
    menghasilkan hash secara acak dan setiap kali di call, maka hasil hash yang didapatkan akan berbeda-beda.*

3. Jelaskan secara singkat apa itu UUID dan mengapa kita memakai UUID di UserModel.java?

    *UUID (Universally Unique Identifier), juga dikenal sebagai GUID (Globally Unique Identifier) 
    adalah kumpulan 36 karakter (string) yang dibuat secara acak (random) dan unik dengan teknik khusus. 
    UUID terdiri dari 32 karakter alphanumerik dan 4 karakter tanda hubung (strip). 
    Dikarenakan karakter UUID yang unik, sangat kecil kemungkinan sebuah karakter UUID akan sama 
    bahkan jika di-generate dalam tempo 1 detik sekalipun. UUID umumnya digunakan sebagai Primary Key, termasuk pada UserModel.*
    
    *Kita memakai UUID di UserModel.java untuk menghindari konflik primary key dan juga untuk mengamankan data.*

4. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut
padahal kita sudah memiliki class UserRoleServiceImpl.java?

    *UserDetailsServiceImpl merupakan interface inti dalam kerangka kerja Spring Security yang digunakan 
    untuk mengambil informasi otentikasi dan otorisasi pengguna. Maka UserDetailsServiceImpl diletakkan pada package security.
    Interface ini memiliki metode baca-saja tunggal bernama loadUserByUsername() yang mencari pengguna berdasarkan nama pengguna.
    Sedangkan UserRoleServiceImpl hanya berisi service user seperti addUser, getUserByUsername, dan lain-lain.*


## Tutorial 8
### What I have learned today
1.  Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan.

    *Pada nomor 1, saya melakukan pengecekan Item.js, apakah checked sedang dalam keadaan true atau tidak. Apabila checked false, maka checkbox tidak ditampilkan.
    Sedangkan apabila checked true, maka checkbox akan ditampilkan. Pada nomor 2, saya membuat fungsi untuk memisahkan antara operasi add dengan delete, 
    bernama handleItemClick dan handleItemClick2. Fungsi handleItemClick hanya dapat melakukan operasi penambahan tanpa dapat menghapus yang dipanggil oleh list our menu.
    Sedangkan fungsi handleItemClick2 dapat menghapus yang dipanggil oleh list my favorite. Pada nomor 3, saya menambahkan checkbox untuk on/off tampilan favorite list. 
    Saya menambahkan state bernama newState untuk menyimpan state saat ini yang valuenya false, artinya pertama kali favorite list tidak ditampilkan. Selanjutnya saya membuat fungsi bernama showFavorite, yang berfungsi untuk melakukan negasi terhadap value newState. Apabila newState bernilai false / checkbox tidak dicentang, maka list favorite tidak akan muncul, sedangkan apabila bernilai true / checkbox dicentang maka list favorite akan ditampilkan. Pada nomor 4, saya membuat komponen bernama EmptyState.Komponen tersebut akan menampilkan informasi bahwa list favorit kosong. Pada list.js, apabila list items 0, maka fungsi komponen EmptyState akan dipanggil, apabila tidak maka list akan ditampilkan. Saya melakukan approach untuk class-based dan functional.*

### Nomor 1
![nomor-1](img-tutorial-8/nomor1.JPG)

**before**
![nomor-1 before](img-tutorial-8/nomor1-before.JPG)

**after**
![nomor-1 after](img-tutorial-8/nomor1-after.JPG)

### Nomor 2
![nomor-2.1](img-tutorial-8/nomor2-1.JPG)

![nomor-2.2](img-tutorial-8/nomor2-2.JPG)

**tambah**
![nomor-2 tambah](img-tutorial-8/nomor2-tambah.JPG)

**hapus**
![nomor-2 hapus](img-tutorial-8/nomor2-hapus.JPG)

### Nomor 3
![nomor-3.1](img-tutorial-8/nomor3-1.JPG)

**before**
![nomor-3 before](img-tutorial-8/nomor3-before.JPG)

**after**
![nomor-3 after](img-tutorial-8/nomor3-after.JPG)

### Nomor 4
![nomor-4.1](img-tutorial-8/nomor4-1.JPG)

![nomor-4.2](img-tutorial-8/nomor4-2.JPG)

**before**
![nomor-4 before](img-tutorial-8/nomor4-before.JPG)

**after**
![nomor-4 after](img-tutorial-8/nomor4-after.JPG)


## Tutorial 9
### What I have learned today
1. Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan mengapa kalian melakukan langkah - langkah tersebut?

    *Langkah awal yang saya lakukan untuk menyelesaikan latihan 1 yaitu dengan mengeset kembali state dari nama, alamat, nomor telepon dan rating 
    menjadi kosong pada fungsi canceledHandler(). Saat sudah selesai melakukan add restoran / edit retoran, state dari nama,alamat,nomor telepon dan 
    rating berubah dari string kosong menjadi atribut yang sesuai pada form. Oleh karena itu, state dari atribut-atribut tadi perlu di set menjadi 
    string kosong pada atribut addRestoran / editRestoran setelah form berhasil di submit agar valuenya menjadi kosong kembali.*

2. Jelaskan fungsi dari async dan await!

    *async berfungsi untuk mendefine sebuah asyncronous function. Hal ini membuat async function selalu mereturn sebuah nilai.* 
    *Async menyebabkan fungsi dapat dijalankan secara paralel.*

    *await merupakan operator yang digunakan untuk menunggu sebuah promise. Await hanya dapat digunakan di dalam Async block.*
    *Await berfungsi untuk membuat JavaScripts menunggu sampai sebuah promise mengembalikan result. Hal ini membuat eksekusi berlangsung secara sekuensial.*

3. Masukkan jawaban dari TODO (Screenshot) pada Component Lifecycle pada pertanyaan ini.

**before**
![nomor-3](img-tutorial-9/3.JPG)

![nomor-1](img-tutorial-9/1.JPG)

**after**
![nomor-4](img-tutorial-9/4.JPG)

![nomor-2](img-tutorial-9/2.JPG)

4. Jelaskan fungsi dari componentDidMount, shouldComponentUpdate, componentDidUpdate, componentWillReceiveProps, componentWillUnmount.
Notes : Penjelasan harus mencantumkan “kapan fungsi dipanggil” dan “use case apa saja yang biasanya menggunakan lifecycle method tersebut”.

*componentDidMount merupakan mounting lifecycle terakhir yang akan dipanggil ketika render selesai dipanggil untuk pertama kali.*

*shouldComponentUpdate merupakan updating lifecycle kedua yang akan dipanggil setelah componentWillReceiveProps dipanggil dan sebelum rendering html dilakukan.*
*Fungsi ini tidak pernah dipanggil pada inisiasi dan harus mengembalikan nilai yang berupa boolean (true atau false).*

*componentDidUpdate merupakan updating lifecycle terakhir yang dipanggil setelah component berhasil dilakukan dan render html telah selesai di-load.*

*componentWillReceiveProps merupakan updating lifecycle pertama yang akan dipanggil apabila Component memiliki props.*

*componentWillMount merupakan mounting lifecycle pertama yang akan dipanggil sebelum render dipanggil untuk pertama kali. Fungsi ini dipanggil ketika komponen sudah dibuang dari DOM. Fungsi ini digunakan ketika aksi-aksi yang berhubungan dengan pembersihan diperlukan. Use case-nya ketika membuang timer yang sebelumnya didefinisikan di componentDidMount.*



