import { Component, NgModule, OnInit } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';
import { FooterComponent } from '../footer/footer.component';
import { MessageForum } from '../../Model/MessageForum';
import { HttpClient, HttpClientModule, HttpErrorResponse } from '@angular/common/http';
import { Posts } from '../../Model/Posts';
import { FormsModule } from '@angular/forms';
import { User } from '../../Model/User';
import { catchError, throwError } from 'rxjs';
import { Post_send } from '../../Model/Post_send';
import { ActivatedRoute } from '@angular/router';
import { comment } from '../../Model/comment';
import { CommentaireForum } from '../../Model/CommentaireForum';

@Component({
  selector: 'app-forum',
  standalone: true,
  imports: [NavbarComponent,FooterComponent,HttpClientModule,FormsModule],
  templateUrl: './forum.component.html',
  styleUrl: './forum.component.css'
})
export class ForumComponent implements OnInit{
  dateActuelle: Date;
  jour: string;
  mois: string;
  annee: number;
  dateFormatee: string;
  messageforum:Posts[]=[]
  Posts:Post_send;
  Post:Posts={id:0,datep:'',pathPic:'',title:'',username:''}
  user:User;
  selectedFile: File | null = null;
  message:String='';
  contenu:String='';
  comment:comment[]=[];
  Showcomment:boolean=false;
  Showcreate:boolean=false;
  commentmessage:CommentaireForum;
  messageForum:MessageForum;
  constructor(private http:HttpClient,private route: ActivatedRoute){
    this.user={id:0,name:'',email:'',password:'',connect:false,cForum:[],cHebergement:[],cStade:[],messageForum:[]}
    this.dateActuelle = new Date();
    this.jour = padToTwoDigits(this.dateActuelle.getDate());
    this.mois = padToTwoDigits(this.dateActuelle.getMonth() + 1);
    this.annee = this.dateActuelle.getFullYear();
    this.dateFormatee = `${this.jour}/${this.mois}/${this.annee}`;
    this.Posts={contenu:'',datepublication:this.dateFormatee,user:this.user,CForum:[]}
    this.messageForum={idm:0,contenu:'',datepublication:'',pathpic:'',user:this.user,cForum:[]}
    this.commentmessage={contenu:'',datep:this.dateFormatee,user:this.user,messageF:this.messageForum}
  }
  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.message = params['message'];
    });
    this.http.get<Posts[]>("http://localhost:8080/Message/all").subscribe((data:Posts[])=>{
      console.log(data)
      this.messageforum = data;
    },(error)=>{
      console.log(error);
    })
    this.getuser();
  }
  showcreate(){
    this.Showcreate=true;
  }
  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
  }
  getuser(){
    this.http.get<User>(`http://localhost:8080/user/${this.message}`).subscribe((data:User)=>{
      this.user=data;
    },(error)=>{
      console.log(error);
    })
  }
  setPost(){
    this.Posts={contenu:this.contenu,datepublication:this.dateFormatee,user:this.user,CForum:[]}
    console.log(this.Posts)
    if (this.selectedFile && this.Posts) {
      // Ensure selectedFile is not null
      if (this.selectedFile !== null) {
    const formData: FormData = new FormData();
    formData.append('message', new Blob([JSON.stringify(this.Posts)], { type: 'application/json' }));
    formData.append('file', this.selectedFile);
    this.http.post('http://localhost:8080/Message/add',formData,{responseType:'text'}).pipe(
        catchError((error: HttpErrorResponse) => {
          if (error.error instanceof ErrorEvent) {
            // A client-side or network error occurred. Handle it accordingly.
            console.error('An error occurred:', error.error.message);
          } else {
            // The backend returned an unsuccessful response code.
            // The response body may contain clues as to what went wrong.
            console.error(
              `Backend returned code ${error.status}, ` +
              `body was: ${error.error}`);
          }
          // Return an observable with a user-facing error message.
          return throwError('Something bad happened; please try again later.');
        })
      ).subscribe(response=>{
        alert(response);
        // this.router.navigateByUrl('/login');
      },
      error=>{
        console.error(error);
      });
  }}}
  
fetchcomentmessage(id:number){
  this.Showcomment=true;
  this.getmessage(id)
  this.http.get<comment[]>(`http://localhost:8080/CommentairemessageForum/${id}`).subscribe((data:comment[])=>{
  this.comment=data;
  },(error)=>{
   console.log(error);
  })
}
setcommentMessage(){
    this.commentmessage={contenu:this.commentmessage.contenu,datep:this.dateFormatee,user:this.user,messageF:this.messageForum}
    console.log(this.commentmessage)  
    this.http.post('http://localhost:8080/CommentairemessageForum/add',this.commentmessage,{responseType:'text'}).pipe(
        catchError((error: HttpErrorResponse) => {
          if (error.error instanceof ErrorEvent) {
            // A client-side or network error occurred. Handle it accordingly.
            console.error('An error occurred:', error.error.message);
          } else {
            // The backend returned an unsuccessful response code.
            // The response body may contain clues as to what went wrong.
            console.error(
              `Backend returned code ${error.status}, ` +
              `body was: ${error.error}`);
          }
          // Return an observable with a user-facing error message.
          return throwError('Something bad happened; please try again later.');
        })
      ).subscribe(response=>{
        alert(response);
        // this.router.navigateByUrl('/login');
      },
      error=>{
        console.error(error);
      });
  }
  getmessage(id:number){
      console.log(id);
      this.http.get<MessageForum>(`http://localhost:8080/Message/${id}`).subscribe((data:MessageForum)=>{
      this.messageForum=data;
      console.log(this.messageForum)
    },(error)=>{
      console.log(error);
    })
  }
}
function padToTwoDigits(num: number): string {
  return num.toString().padStart(2, '0');
}