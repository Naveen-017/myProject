import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CarService } from '../../services/car.service';
import { Car } from '../../common/car';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-adminpage',
  templateUrl: './adminpage.component.html',
  styleUrl: './adminpage.component.css'
})
export class AdminpageComponent {
  carFormGroup: FormGroup;

  constructor(private route: Router ,private service: CarService,private formBuilder: FormBuilder,){}


  ngOnInit() {
    this.carFormGroup= this.formBuilder.group({
      model:['',[Validators.required]],
      color:['',[Validators.required]],
      year:['',[Validators.required]],
      imageUrl:['',[Validators.required]],
      availablestatus:['',[Validators.required]],
      capacity:['',[Validators.required]],
      price_per_day:['',[Validators.required]],
      numberPlate:['',[Validators.required]],
    })
  }
  addCar() {
    if (this.carFormGroup.valid) {
      this.service
        .createCar(this.carFormGroup.value)
        .subscribe((data) => {
          alert('New Car Added Successfully');
          this.route.navigateByUrl('/adminpage');
          // console.log(data)
        });

    } else {
      alert('Invalid');
    }
  }

}
