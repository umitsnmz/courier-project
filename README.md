# Courier Tracking Project

Bu proje, Java 17 ve Spring Boot 3 kullanılarak geliştirilmiş basit bir RESTful servis örneğidir. Projede, biri POST isteği alan ve diğeri GET isteği alan iki adet servis bulunmaktadır. Aynı zamanda Swagger, API belgelerini otomatik olarak oluşturmak için kullanılmıştır.

## Gereksinimler

- Java 17 JDK yüklü olmalıdır.
- Apache Maven yüklü olmalıdır.

## Running the application locally
```shell
mvn spring-boot:run
```
## Swagger
Projenin çalıştırılmasıyla birlikte Swagger UI otomatik olarak başlatılacaktır. API belgelerine erişmek için aşağıdaki URL'yi ziyaret edin:t

[Swagger UI](http://localhost:8080/swagger-ui/index.html#/)

## Database
Bu projede H2 daatabase kullanıldığı için projeye ayağa çalıştırıldıktan sonra otomatik olarak tablolar oluşacaktır, verileri kontrol edebilmek için aşağıdaki linkten h2 console a erişim sağlayabilirsiniz application.properties dosyası içeriisnde bağlantı bilgileri yer almaktadır.

[H2 Console](http://localhost:8080/h2-console)

## Kullanım
```
Proje çalıştırılırken data.sql dosyasına eklediğim sorgular ile otomatik olarak kullanılacak olan tablolar ve kayıtlar oluşturulacaktır, bu sebeple proje çalıştıktan sonra isterseniz get servislerini çalıştırarak diretk incelemeleri yapabilirsiniz.

Proje 2 tablodan oluşmakta tablolardan biri kuryelerin tutulduğu dire ise hareketlerin tutulduğu tablodur.

Hareket kayıt etmek için servise istek atılacaktır servis içerisinde yapılan kontroller sayesinde normal hareket veya giriş hareket kaydı tutulacaktır.
```

```
Kuryelerin hareket kayıtlarını tutumak için kullanılan servis isteğidir.

http://localhost:8080/api/v1/save

{
    "courierId":12345,
    "lat":40.98931970276002,
    "lng":29.14672662129282
} 

Kuryelerin toplam aldığı mesafe bilgilerinin verildiği servistir.

http://localhost:8080/api/v1/distance/12345


```