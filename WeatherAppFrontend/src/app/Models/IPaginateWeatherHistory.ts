import { Weather } from './Weather';

export interface IPaginateWeatherHistory {
   pageData: Weather[];
   paging: Paging;
}
export interface Paging {
    first: string;
    last: string;
    previous?: any;
    next: string;
}
