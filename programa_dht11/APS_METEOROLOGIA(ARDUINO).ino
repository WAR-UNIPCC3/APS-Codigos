#include <Wire.h>
#include <Adafruit_BMP085.h>
#include <DHT.h>

#define DHTPIN A0 // pino que estamos conectado
#define DHTTYPE DHT11 // DHT 11
#define Adafruit_BMP085PIN A4 && A5 //

Adafruit_BMP085 bmp180;

DHT dht(DHTPIN, DHTTYPE);
int pinoa = A2;

void setup() 
{
  pinMode(  pinoa, INPUT);
  dht.begin();
  bmp180.begin();
  Serial.begin(9600);
}

void loop() 
{
    int chuva = analogRead( pinoa );
    chuva = chuva;
    float p = bmp180.readPressure();
    float h = dht.readHumidity();
    float t = dht.readTemperature();
    float a = bmp180.readAltitude();
    // testa se retorno é valido, caso contrário algo está errado.
    if (isnan(t)||isnan(h)) 
  {
    Serial.println("Falha na leitura do DHT");
  }
    if (isnan(p)||isnan(a)) 
  {
    Serial.println("Falha na leitura do BMP180");
  } 
    if (isnan(chuva))
    {
    Serial.println("Falha na leitura do Sensor de Chuva");
    } 
  else 
  {
    Serial.println(" \n");
    Serial.println("DADOS COLETADOS");
    Serial.print("Umidade: ");
    Serial.print(h);
    Serial.println(" %");
    Serial.print("Temperatura: ");
    Serial.print(t);
    Serial.println(" *C");
    Serial.print("Pressao: ");
    Serial.print(p);
    Serial.println(" Pa");
    Serial.print("Altitude: ");
    Serial.print(a);
    Serial.println(" m");
    Serial.print("Precipitacao ");
    Serial.println(chuva);
    Serial.print("Intensidade: ");
     if (chuva >900 && chuva <1024)
  {
    Serial.println("Sem chuva");
  }
  else if (chuva >600 && chuva <900)
  {
    Serial.println("Chuva fraca");
  }
  else if (chuva >400 && chuva <600)
  {
    Serial.println("Chuva moderada");
  }
  else if (chuva <400)
  {
    Serial.println("Chuva forte");
  }    
  }
    delay(5000);
}
