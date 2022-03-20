import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ShopService {

  constructor(private httpClient: HttpClient) { }

  registerShop(registerShop): Observable<any> {
    return this.httpClient.post<any>(environment.registerShop, registerShop);
  }

  getShopById(id: number): Observable<any> {
    return this.httpClient.get<any>(environment.getShopById + '/' + id);
  }
}
