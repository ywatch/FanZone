import { Component, OnInit } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';
import { FooterComponent } from '../footer/footer.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Hebergement } from '../../Model/Hebergement';
import { Router } from '@angular/router';

@Component({
  selector: 'app-hebergements',
  standalone: true,
  imports: [NavbarComponent,FooterComponent,HttpClientModule],
  templateUrl: './hebergements.component.html',
  styleUrl: './hebergements.component.css'
})
export class HebergementsComponent implements OnInit {
  hebe:Hebergement[]=[]
  constructor(private http:HttpClient,private router:Router){
    this.fetchData();
  }
  ngOnInit(): void {
    this.fetchData();
  }
  public fetchData(){
    this.http.get<Hebergement[]>("http://localhost:8080/hebergement/getAll").subscribe((data:Hebergement[])=>{
      console.log(data)
      // for (let index = 0; index < data.length; index++) {
      //   const element = data[index];
      //   alert(element.cHebergement)
      //   alert(`./assets${element.pathpic.split('\assets')[1]}`)
      // }
      this.hebe = data;
    },(error)=>{
      console.log(error);
    })
  }
  goToOtherComponent(message:string) {
    this.router.navigate(['/single',message ]);
  }
}
