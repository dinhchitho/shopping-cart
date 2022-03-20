import { ShopComponent } from './components/shop/shop.component';
import { RegisterComponent } from './components/register/register.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: '', component: RegisterComponent},
  {
    path: '',
    children: [
      { path: 'shop/:id', component: ShopComponent},
      
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
