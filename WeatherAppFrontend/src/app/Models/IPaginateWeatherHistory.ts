import { Weather } from './Weather';
import { WeatherHistory } from '../history/WeatherHistory';

export interface IPaginateWeatherHistory {
   pageData: WeatherHistory[];
   paging: Paging;
}
export interface Paging {
    first: string;
    last: string;
    previous?: any;
    next: string;
}
