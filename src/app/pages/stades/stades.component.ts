import { Component, Injectable, OnInit } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Stade } from '../../Model/Stade';
import { FooterComponent } from '../footer/footer.component';
import { Route, Router } from '@angular/router';
@Component({
  selector: 'app-stades',
  standalone: true,
  imports: [NavbarComponent,HttpClientModule,FooterComponent],
  templateUrl: './stades.component.html',
  styleUrl: './stades.component.css'
})
@Injectable({
  providedIn:'root'
})
export class StadesComponent implements OnInit {
stades:Stade[] = []
constructor(private http:HttpClient,private router:Router){
  this.fetchData();
}
ngOnInit(): void {
  this.fetchData();
}
public fetchData(){
  this.http.get<Stade[]>("http://localhost:8080/stade/getAll").subscribe((data:Stade[])=>{
    console.log(data)
    // for (let index = 0; index < data.length; index++) {
    //   const element = data[index];
    //   alert(element.cStade)
    //   alert(`./assets${element.pathpic.split('\assets')[1]}`)
    // }
    this.stades = data;
  },(error)=>{
    console.log(error);
  })
}
goToOtherComponent(message:string) {
  this.router.navigate(['/single',message ]);
}
}
