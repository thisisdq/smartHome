#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <ArduinoJson.h>
#include <DHT.h>

const char *ssid = "LaptopDQWiFi";  // Nha 42 5Ghz - DanhQuyWiFi
const char *password = "Danhquy2101"; // 0942864875 - 12345678
String baseUrl = "http://192.168.137.1:8888/";

const int GPIO_Port[] = {D0, D1, D2, D3, D4, D5, D6, D7, D8};
const int isPinOut[] =  {0 , 1 , 0 , 1 , 1 , 1 , 1 , 1 , 1};
const int userID = 2;
const int TV_ID = 7;
const float maxTemp = 35;

#define DHTTYPE DHT11
#define DHTPIN D2
#define Device_Fire_Warning D3
#define infraredPin D0

DHT dht(DHTPIN, DHTTYPE);

float previousTemperature = -9999; // Initialize Temperature
float previousHumidity = -9999;    // Initialize Humidity
int previousInfrared = -9999;      // Initialize Infrared

WiFiClient client;
void setup()
{
  Serial.begin(115200);
  dht.begin();

  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED)
  {
    delay(1000);
    Serial.println("Connecting to WiFi...");
  }
  Serial.println("Connected to WiFi");
  
  for (int i = 0; i < sizeof(GPIO_Port) / sizeof(GPIO_Port[0]); i++) {
    if (isPinOut[i]) {pinMode(GPIO_Port[i], OUTPUT);}
      else pinMode(GPIO_Port[i], INPUT);
  }
}

void turnOffTV()
{
  HTTPClient http;
  String url = baseUrl +  "ESP32/turnOffTv/"+ (String)userID ;
  http.begin(client, url);
  http.addHeader("Content-Type", "application/x-www-form-urlencoded");
  int httpResponseCode = http.POST("");
  if (httpResponseCode > 0)
  {
    Serial.print("HTTP Response code TURNOFF TV: ");
    Serial.println(httpResponseCode);
  }
  else
  {
    Serial.print("Error sending POST request TURNOFF TV: ");
    Serial.println(httpResponseCode);
  }

  http.end();
}

void sendTemperature(float temperature)
{
  HTTPClient http;
  String url = baseUrl +  "ESP8266/temperature/" + (String)userID + "/" + String(temperature);
  http.begin(client, url);
  http.addHeader("Content-Type", "application/x-www-form-urlencoded");
  int httpResponseCode = http.POST("");
  if (httpResponseCode > 0)
  {
    Serial.print("HTTP Response code (Temperature): ");
    Serial.println(httpResponseCode);
  }
  else
  {
    Serial.print("Error sending POST request (Temperature): ");
    Serial.println(httpResponseCode);
  }

  http.end();
}

void sendHumidity(float humidity)
{
  HTTPClient http;
  String url = baseUrl +  "ESP8266/humidity/" + (String)userID + "/" + String(humidity);
  http.begin(client, url);
  http.addHeader("Content-Type", "application/x-www-form-urlencoded");
  int httpResponseCode = http.POST("");
  if (httpResponseCode > 0)
  {
    Serial.print("HTTP Response code (Humidity): ");
    Serial.println(httpResponseCode);
  }
  else
  {
    Serial.print("Error sending POST request (Humidity): ");
    Serial.println(httpResponseCode);
  }

  http.end();
}

float readTemperature()
{
  float temperature = dht.readTemperature();
  Serial.print("temperature :");
  Serial.println(temperature);
  return temperature;
}

float readHumidity()
{
  float humidity = dht.readHumidity();
  Serial.print("humidity :");
  Serial.println(humidity);
  return humidity;
}

void controll_LED(const char *port, int isRunning) {
  for (int i = 0; i < sizeof(GPIO_Port) / sizeof(GPIO_Port[0]); i++) {
    if (strcmp(port, String("D" + String(i)).c_str()) == 0 && isPinOut[i]) {
      digitalWrite(GPIO_Port[i], isRunning);
      return;
    }
  }
  Serial.println("Port Not Found");
}

void fetchDataLed() {
  HTTPClient http;
  String url = baseUrl + "ESP32Fetch/" + (String)userID;
  http.begin(client, url);
  http.addHeader("Content-Type", "application/x-www-form-urlencoded");
  int httpResponseCode = http.POST("");
  if (httpResponseCode > 0)
  {
    Serial.print("Fetch LED:  ");
    Serial.println(httpResponseCode);

    String payload = http.getString();
    Serial.println(payload);
    StaticJsonDocument<1024> doc;
    DeserializationError error = deserializeJson(doc, payload);

    if (error) {
      Serial.print(F("Failed to parse JSON: "));
      Serial.println(error.c_str());
      return ;
    }

    JsonArray array = doc.as<JsonArray>();
    for (const JsonVariant &item : array) {
      const char *port = item["port"];
      int isRunning = item["isRunning"];
      if (port != nullptr) {
        controll_LED(port,isRunning);
      }
    }
    http.end();
    return ;
  }
  else
  {
    Serial.print(" bad req Fetch LED : ");
    Serial.println(httpResponseCode);
    http.end();
    return ;
  }
}
const int save_energy = 15000;
int inf = save_energy ;
void loop()
{
  fetchDataLed();
  float temperature = readTemperature();
  float humidity = readHumidity();
  //  int inf = digitalRead(infraredPin);
  if (!isnan(temperature)) {
    if (temperature != previousTemperature)
    {
      sendTemperature(temperature);
      previousTemperature = temperature;
    }
    if(temperature >= maxTemp) {
      digitalWrite(Device_Fire_Warning, HIGH);
    } 
    else (digitalWrite(Device_Fire_Warning, LOW));
  }
  if (!isnan(humidity)) {
    if (humidity != previousHumidity)
    {
      sendHumidity(humidity);
      previousHumidity = humidity;
    }
  }
  if(digitalRead(D7) == HIGH){
    if(digitalRead(infraredPin) == 0){
      inf = save_energy;
    }
    else {
      inf -= 1000;
      if(inf < 0){
        inf = save_energy;
        turnOffTV();
      }
    }
  }
  delay(1000); // Check for sensor data and LED status every 1 seconds
}
