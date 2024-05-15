import { Component, OnInit } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';
import { FooterComponent } from '../footer/footer.component';
import { ActivatedRoute } from '@angular/router';
import { User } from '../../Model/User';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-layout',
  standalone: true,
  imports: [NavbarComponent,FooterComponent,HttpClientModule],
  templateUrl: './layout.component.html',
  styleUrl: './layout.component.css'
})
export class LayoutComponent implements OnInit {
message:string="";
user:User;
constructor(private http:HttpClient,private route: ActivatedRoute){
this.user={name:"",password:"",email:"",id:0,cForum:[],cHebergement:[],cStade:[],messageForum:[],connect:false}
}
ngOnInit() {
  this.route.params.subscribe(params => {
    this.message = params['message'];
  });
  this.http.get<User>(`http://localhost:8080/user/Connect/${this.message}`).subscribe((data:User)=>{
    console.log(data)
    this.user= data;
  },(error)=>{
    console.log(error);
  })
}

}
