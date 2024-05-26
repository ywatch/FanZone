import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../../Model/User';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { comment } from '../../Model/comment';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [HttpClientModule,FormsModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit {
  message:String='';
  user:User;
  userm:User;
  commentm:comment[]=[];
  comments:comment[]=[];
  commenth:comment[]=[];
  sectionchoose:String='';
  constructor(private route: ActivatedRoute,private router:Router,private http:HttpClient){
  this.user={name:"",password:"",email:"",id:0,cForum:[],cHebergement:[],cStade:[],messageForum:[],connect:false}
  this.userm={name:"",password:"",email:"",id:0,cForum:[],cHebergement:[],cStade:[],messageForum:[],connect:false}
}
  ngOnInit(): void {
    this.route.params.subscribe(params => {
    this.message = params['message'];
  });
  this.getuser();
  this.fetchcomentmessage();
  this.fetchcomentStade();
  this.fetchcomenthebe();
  }
  getuser(){
    this.http.get<User>(`http://localhost:8080/user/${this.message}`).subscribe((data:User)=>{
      this.user=data;
    },(error)=>{
      console.log(error);
    })
  }
  disconnect(){
    this.http.get<User>(`http://localhost:8080/user/Disconnect/${this.message}`).subscribe((data:User)=>{
      this.router.navigate(['/home']);
    },(error)=>{
      console.log(error);
    })
  }
  fetchcomentmessage(){
    this.http.get<comment[]>(`http://localhost:8080/user/commentforum/${this.message}`).subscribe((data:comment[])=>{
    this.commentm=data;
    },(error)=>{
     console.log(error);
    })
  }
  fetchcomentStade(){
    this.http.get<comment[]>(`http://localhost:8080/user/commentstade/${this.message}`).subscribe((data:comment[])=>{
    this.comments=data;
    },(error)=>{
     console.log(error);
    })
  }
  fetchcomenthebe(){
    this.http.get<comment[]>(`http://localhost:8080/user/commenthebe/${this.message}`).subscribe((data:comment[])=>{
    this.commenth=data;
    console.log(this.commenth)
    },(error)=>{
     console.log(error);
    })
  }
  changeuser(){
    this.http.put<User>(`http://localhost:8080/user/${this.message}`,this.userm).subscribe((data:User)=>{
    this.user=data;
    alert("user is changed")
    },(error)=>{
     console.log(error);
    })
  }
  settingchoose(){
    this.sectionchoose='settings'
  }
  profilechoose(){
    this.sectionchoose='profile'
  }
  homechoose(){
    this.sectionchoose=''
  }
}
