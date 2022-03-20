import { HttpClient } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup } from "@angular/forms";
import { Router } from "@angular/router";
import { ShopRegisterDTO } from "src/app/models/register.model";
import { ShopService } from "src/app/services/shop.service";

@Component({
  selector: "app-register",
  templateUrl: "./register.component.html",
  styleUrls: ["./register.component.scss"],
})
export class RegisterComponent implements OnInit {
  registerShop: ShopRegisterDTO;
  public rfRegisterShop: FormGroup;
  shopId;
  constructor(
    private shopService: ShopService,
    private httpClient: HttpClient,
    private router: Router
  ) {}

  ngOnInit() {
    this.initForm();
  }

  onSubmit() {}

  onRegisterShop() {
    if (this.rfRegisterShop.status == "INVALID") {
      return;
    } else {
      this.shopService.registerShop(this.registerShop).subscribe(
        (res) => {
          if (res && res.success && res.data) {
            console.log(res);
            
            let shopId = res.data.shopId;
            this.router.navigateByUrl("/shop" + "/" + shopId);
          }
        },
        (error) => {
          console.log(error);
        }
      );
    }
  }

  onChangeFile(event) {
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.rfRegisterShop.patchValue({
        fileSource: file,
      });
      this.rfRegisterShop.get("imageForm").updateValueAndValidity();
    }
  }

  private initForm() {
    this.registerShop = new ShopRegisterDTO();
    this.rfRegisterShop = new FormGroup({
      phoneNumberFrom: new FormControl(this.registerShop.phoneNumber),
      NameFrom: new FormControl(this.registerShop.name),
    });
  }
}
