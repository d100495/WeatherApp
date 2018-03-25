import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'dateTransform'
})

export class DateTransformPipe implements PipeTransform {
    transform(value: string): any {
        return value.slice(0, 10);
    }
}