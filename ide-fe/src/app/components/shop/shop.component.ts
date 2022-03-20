import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.scss']
})
export class ShopComponent implements OnInit {

  constructor(private routeActive:ActivatedRoute) { }

  ngOnInit() {
    this.routeActive.params.subscribe(param => {
      if(param) {
        console.log(param);
        
      }
    })
  }

}
