//conf bpm
#include <Wire.h>
#include <Adafruit_BMP085.h>

//conf dht
#include <DHT.h>
#define DHTPIN A0
#define DHTTYPE DHT11
DHT dht(DHTPIN, DHTTYPE);

//conf chuva
int pino_d = 2;
int val_d = 0;

Adafruit_BMP085 bmp180;
void setup()
{
  pinMode(pino_d, INPUT);
  Serial.begin(9600);
  dht.begin();
  bmp180.begin();
}

void loop()
{
  float h = dht.readHumidity();
  float t = dht.readTemperature();
  val_d = digitalRead(pino_d);
  float p = bmp180.readPressure();

  if(isnan(h)||isnan(t)||isnan(p))
  {
    Serial.print("Falha na leitura dos sensores ");
  }
  else
  {
  Serial.print(t);
  Serial.print("C, "); 
  Serial.print(h);
  Serial.print("%, ");
  Serial.print(p);
  Serial.print("Pa, ");

  }
  if(val_d==1)
  {
    Serial.println("Nao ha chuva ");
  }
  else if(val_d==0)
  {
    Serial.println("Ha chuva ");
  }
  delay(5000);
}
