import { CustomersComponent } from './components/customers/customers.component';
import { ShopComponent } from './components/shop/shop.component';
import { RegisterShopComponent } from './components/register-shop/register-shop.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: '', component: RegisterShopComponent},
  {
    path: '',
    children: [
      { path: 'shop/:id', component: ShopComponent},
      { path: 'customer', component: CustomersComponent},
      
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
