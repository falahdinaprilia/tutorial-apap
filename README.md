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
- [ ] Syntax untuk Spring 
- [ ] Model dan Controller serta kegunaannya