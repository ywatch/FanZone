import { Component, Injectable, OnInit } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Stade } from '../../Model/Stade';
@Component({
  selector: 'app-stades',
  standalone: true,
  imports: [NavbarComponent,HttpClientModule],
  templateUrl: './stades.component.html',
  styleUrl: './stades.component.css'
})
@Injectable({
  providedIn:'root'
})
export class StadesComponent implements OnInit {
stades:Stade[] = []
constructor(private http:HttpClient){
  this.fetchData();
}
ngOnInit(): void {
  this.fetchData();
}
public fetchData(){
  this.http.get<Stade[]>("http://localhost:8080/stade/getAll").subscribe((data:Stade[])=>{
    console.log(data)
    this.stades = data;
  },(error)=>{
    console.log(error);
  })
}
}
