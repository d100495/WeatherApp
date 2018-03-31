export interface ICurrentWeatherOpenWeatherMaps {
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