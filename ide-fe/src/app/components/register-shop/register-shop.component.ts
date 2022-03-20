import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ShopService } from './../../services/shop.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ShopRegisterDTO } from 'src/app/models/register.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-shop',
  templateUrl: './register-shop.component.html',
  styleUrls: ['./register-shop.component.scss']
})
export class RegisterShopComponent implements OnInit {

  registerShop:ShopRegisterDTO;
  public rfRegisterShop: FormGroup;
  shopId;
  constructor(private shopService:ShopService, private httpClient:HttpClient,
    private router:Router) { }

  ngOnInit() {
    this.initForm();
    this.shopService.getShopById('3061fd').subscribe(res => {
      console.log(res);
      
      this.shopId = res.shopId;
    }
    )
  }

  onSubmit() {
    //console.log(this.rfRegisterShop);
  }

  onRegisterShop() {
    if (this.rfRegisterShop.status == 'INVALID') {
      return;
    } else {
      //this.router.navigateByUrl('/shop' + '/' + this.shopId);
      let headers = new HttpHeaders();
    headers = headers.append('Content-Type', 'multipart/form-data;boundary=----WebKitFormBoundarysugMKnQblsTCUYbP');
      let formData = new FormData();
      formData.append("name", this.rfRegisterShop.get('NameFrom').value);
      formData.append("phoneNumber", this.rfRegisterShop.get('phoneNumberFrom').value);
      formData.append("image", null);
      
      // this.httpClient
      // .post('http://localhost:8080/api/Shop/register', formData, {headers})
      // .subscribe({
      //   next: (response) => console.log(response),
      //   error: (error) => console.log(error),
      // });
      this.shopService.registerShop(formData).subscribe(res => {
        console.log("res",res);
        
      },(error) => {
        console.log(error)
      }
      )

    }
  }

  onChangeFile(event) {
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.rfRegisterShop.patchValue({
        fileSource: file
      });
      this.rfRegisterShop.get('imageForm').updateValueAndValidity();
    }
  }

  private initForm() {
    this.registerShop = new ShopRegisterDTO();
    this.rfRegisterShop = new FormGroup({
      phoneNumberFrom: new FormControl(this.registerShop.phoneNumber),
      NameFrom: new FormControl(this.registerShop.name),
    })
  }
}
