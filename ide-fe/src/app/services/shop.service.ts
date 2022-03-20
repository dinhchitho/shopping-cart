import { ShopRegisterDTO } from 'src/app/models/register.model';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import {map} from 'rxjs/operators'

@Injectable({
  providedIn: 'root'
})

export class ShopService {

  constructor(private httpClient: HttpClient) { }

  registerShop(registerShop :FormData): Observable<any> {
    let headers = new HttpHeaders();
    headers = headers.append('Content-Type', 'multipart/form-data;boundary=----WebKitFormBoundarysugMKnQblsTCUYbP');
    headers = headers.append('accept', 'text/plain');
    return this.httpClient.post<any>(environment.registerShop, registerShop, {headers});
  }

  getShopById(id): Observable<any> {
    return this.httpClient.get<any>(environment.getShopById + '/' + id);
  }
}
