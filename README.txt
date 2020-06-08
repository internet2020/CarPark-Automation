******************CarXpark Web Sitesi Projesi****************
//Projenin back-end ve front-end tasarımı,veritabanı ve projede kullanılan bean sınıflarının bütün haklar benim üzerimdedir.
//Projeyi çevreniz ile paylaşabilirsiniz hatta kişisel ihtiyaçlarınız için kullanabilirsiniz fakat Copyright hakkı çiğnenemez,tasarımın footer imzası(Copyright&copy Nodque) değiştirilerek publish(domain alarak internete sunmak) edildiği tespit edilirse tüm sorumluluk değiştiren/kullanan kişidedir.

->Proje Açıklaması;

*Proje Düzeni(10 puan); Yapıldı✓
-CarXPark Projesi JSF ile Web geliştirmenin yapısı olan MVC(Model-View-Controller) ile geliştirilmiştir.
-Html sayfalarının düzeni ise Back-end(Admin Paneli),Front-end-Customer(Müşterinin Login olmasından sonra göreceği private sayfalardır.) ve Front-end-ortak(Login yapmayan public olan front end tasarımıdır.) klasörlerinde düzenli bir şekilde toplanmıştır.
-Resources klasöründe proje için gerekli olan .js .css dosyalarını ve diğer gerekli ögeleri içermektedir.
-.js ve .css kodlarının bir kısmı hazır olarak dışardan alınmış, bir kısmı ise tarafımdan kodlanmıştır.


*Many-To-Many ilişkinin Converter üzerinden Kodlanması(5 puan); Yapıldı✓
*One-to-Many ilişkinin Converter üzerinden kodlanması(5 puan); Yapıldı✓
*Create(7 puan);Yapıldı✓
*Read(7 puan)-tekil; Yapıldı✓
*ReadAll(7 puan); Yapıldı✓
*Update(7 puan); Yapıldı✓
*Delete(7 puan); Yapıldı✓

*Minimum 1 adet Filter Kullanılması(10 Puan); Yapıldı✓
-Login işlemleri için loginFilter oluşturulmuştur.

*Ajax İsteklerinin Tamamlanması(5 puan); Yapıldı✓
-Ajax projemize dinamiklik katar.Bu sebepten dolayı projenin hemen hemen her xhtml sayfasında kullanılmıştır.

**VALIDATOR(Toplam 10 puan) Yapıldı✓

a-)Bean Validator; (5 puan)
-Controller paketinin içersindeki CustomValidateController sınıfındaki methodlar ile bean validation yapılmıştır.
-Projede en az 1 kere kullanılması istenilen bean validate user.xhtml içerisinde(Personel sayfasında) ad-soyad,mail,telefon ve şifre için kullanılmıştır.
-Sınıf methodları yazılmış olup istenilen xhtml sayfasına user.xhtml'de olduğu gibi entegre edilebilir.

b-)HTML validator;(5 puan)
-Yine Bean validatorde olduğu gibi en az 1 kere kullanılması istenilmiştir.
-ParkPackage.xhtml içinde park paketi ekleme formunda maaş alanını alırken validateDoubleRange etiketi ile kontrol gerçekleştirdik. İlgili xhtml sayfasında açıklamayı görebilirsiniz.
-Bean validator gibi 1 sayfada kullanılmıştır.İsterseniz çoğaltabilirsiniz.


Not:Html validator ile Bean validator arasındaki fark;
-Bean validator Java üzerinde methodlar yazılarak custom oluşturulur.
-HTML validator ise html'in bize sunmuş olduğu etiketler(tag) ile hazır olarak oluşturulur. 

*Pagination İşleminin Yapılması(10 puan); Yapıldı✓
-Gerekli olan tüm html sayfaları için pagination yapılmıştır(back end tarafında)


*Dosya İşlemleri(10 puan);Yapıldı✓
-Util paketinde FileServlet oluşturulmuştur.
-Admin Panelimiz üzerinden hem local klasöre hem de veritabanımıza dosya upload işlemi gerçekleştirilmiştir.

