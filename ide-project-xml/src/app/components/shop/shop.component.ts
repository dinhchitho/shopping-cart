import { ShopService } from './../../services/shop.service';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.scss']
})
export class ShopComponent implements OnInit,OnDestroy {

  shopInfo;

  constructor(private activeRouter:ActivatedRoute, private shopService:ShopService) { }
  ngOnDestroy(): void {
    
  }

  ngOnInit() {
    this.activeRouter.paramMap.subscribe(param => {
      if (param) {
        let shopId:number = parseInt(param.get('shopId'));
        this.shopService.getShopById(shopId).subscribe(res => {
          if (res && res.success) {
            console.log(res);
            
            this.shopInfo = res.data;
            
          }
        })
        
      }
    })
  }

}
