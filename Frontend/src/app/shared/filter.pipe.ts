import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(value : any[], filtetString: string, productName:string):any[] {
    const result:any=[];

    //if the value is empty
    if(!value|| filtetString==''||productName==''){
    return value;
  }
  //if some value coming 
  value.forEach((a:any)=>{
    if(a[productName].trim().toLowerCase().includes(filtetString.toLowerCase())){
      result.push(a);
  }
  });
  return result;
}
}
