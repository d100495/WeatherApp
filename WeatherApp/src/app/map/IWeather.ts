export interface IWeather {
    // Temperature: number;
    // Longitude: number;
    // Latitude: number;
    // Pressure: number;
    // WindSpeed: number;
    // WindChill: number;

    main: IMain;
    wind: IWind;
    coord: ICoord;

}

export interface IWind {
    speed: number;

}

export interface IMain {
    temp: number;
    pressure: number;
}

export interface ICoord {
    lon: number;
    lat: number;
}