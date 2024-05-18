import { Component, Injectable, OnInit } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Stade } from '../../Model/Stade';
import { FooterComponent } from '../footer/footer.component';
import { ActivatedRoute, Route, Router } from '@angular/router';
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
messageu:string="";
constructor(private http:HttpClient,private router:Router,private route: ActivatedRoute){
  this.fetchData();
}
ngOnInit(): void {
  this.route.params.subscribe(params => {
    this.messageu = params['message'];
  });
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
  this.router.navigate(['/single',message,this.messageu]);
}
}
