#include <Wire.h>
#include <Adafruit_BMP085.h>
#include <DHT.h>

#define DHTPIN A1 // pino que estamos conectado
#define DHTTYPE DHT11 // DHT 11
#define Adafruit_BMP085PIN A4 && A5 //

Adafruit_BMP085 bmp180;

DHT dht(DHTPIN, DHTTYPE);

void setup() 
{
  Serial.begin(9600);
  dht.begin();
  bmp180.begin();
}

void loop() 
{
    float p = bmp180.readPressure();
    float h = dht.readHumidity();
    float t = dht.readTemperature();
    float a = bmp180.readAltitude();
    // testa se retorno é valido, caso contrário algo está errado.
    if (isnan(t)||isnan(h)) 
  {
    Serial.println("Falha na leitura do DHT");
    
    if (isnan(p)||isnan(a)) 
  {
    Serial.println("Falha na leitura do BMP180");
  } 
  
  } 
  else 
  {
    Serial.print(" \n");
    Serial.print("DADOS COLETADOS \n");
    Serial.print("Umidade: ");
    Serial.print(h);
    Serial.print(" %\n");
    Serial.print("Temperatura: ");
    Serial.print(t);
    Serial.println(" *C");
    Serial.print("Pressão: ");
    Serial.print(p);
    Serial.println(" Pa");
    Serial.print("Altitude: ");
    Serial.print(a);
    Serial.println(" m");

   
    
    delay(60000);
  }
} 
