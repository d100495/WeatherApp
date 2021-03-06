export interface IWeatherForecast {
  cod: string;
  message: number;
  cnt: number;
  list?: (ListEntity)[] | null;
  city: City;
}
export interface ListEntity {
  dt: number;
  main: Main;
  weather?: (WeatherEntity)[] | null;
  clouds: Clouds;
  wind: Wind;
  rain: Rain;
  sys: Sys;
  dt_txt: string;
}
export interface Main {
  temp: number;
  temp_min: number;
  temp_max: number;
  pressure: number;
  sea_level: number;
  grnd_level: number;
  humidity: number;
  temp_kf: number;
}
export interface WeatherEntity {
  id: number;
  main: string;
  description: string;
  icon: string;
}
export interface Clouds {
  all: number;
}
export interface Wind {
  speed: number;
  deg: number;
}
export interface Rain {
  h: number;
}
export interface Sys {
  pod: string;
}
export interface City {
  id: number;
  name: string;
  coord: Coord;
  country: string;
  population: number;
}
export interface Coord {
  lat: number;
  lon: number;
}
