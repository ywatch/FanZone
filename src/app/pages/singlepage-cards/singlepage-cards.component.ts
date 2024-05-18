import { Component, Injectable, OnInit } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';
import { FooterComponent } from '../footer/footer.component';
import { ActivatedRoute, NavigationEnd, Router ,Event} from '@angular/router';
import { HttpClient, HttpClientModule, HttpErrorResponse } from '@angular/common/http';
import { Hebergement } from '../../Model/Hebergement';
import {catchError, filter, throwError } from 'rxjs';
import { Stade } from '../../Model/Stade';
import { CommentaireStade } from '../../Model/CommentaireStade';
import { User } from '../../Model/User';
import { comment } from '../../Model/comment';
import{Dates}from'../../Model/Dates'

@Component({
  selector: 'app-singlepage-cards',
  standalone: true,
  imports: [NavbarComponent,FooterComponent,HttpClientModule],
  templateUrl: './singlepage-cards.component.html',
  styleUrl: './singlepage-cards.component.css'
})
@Injectable({
  providedIn: 'root'
})
export class SinglepageCardsComponent implements OnInit,Dates {
  dateActuelle: Date;
  jour: string;
  mois: string;
  annee: number;
  dateFormatee: string;
  message: string='';
  private previousUrl: string = '';
  private currentUrl: string = '';
  user:User;
  hebe:Hebergement;
  comment:comment[]=[];
  commentStade:CommentaireStade;
  stade:Stade;
  item:any;
  url:any;
  constructor(private route: ActivatedRoute,private http:HttpClient,private router: Router) {
    this.dateActuelle = new Date();
    this.jour = padToTwoDigits(this.dateActuelle.getDate());
    this.mois = padToTwoDigits(this.dateActuelle.getMonth() + 1);
    this.annee = this.dateActuelle.getFullYear();
    this.dateFormatee = `${this.jour}/${this.mois}/${this.annee}`;
    this.hebe={hid:0,hadd:'',hname:'',hprice:0,pathpic:"",cHebergement:[]}
    this.stade={sid:0,stadename:'',ville:'',capacite:0,pathpic:'',cStade:[]}
    this.user={name:"",password:"",email:"",id:0,cForum:[],cHebergement:[],cStade:[],messageForum:[],connect:false}
    this.commentStade={idCommentaire:0,contenu:'',datep:this.dateFormatee,user:this.user,stade:this.stade}
    this.currentUrl = this.router.url;
    this.router.events
      .pipe(filter((event: Event): event is NavigationEnd => event instanceof NavigationEnd))
      .subscribe((event: NavigationEnd) => {
        this.previousUrl = this.currentUrl;
        this.currentUrl = event.urlAfterRedirects;
      });
  }
  ngOnInit() {
    this.route.params.subscribe(params => {
      this.message = params['message'];
    });
    if (this.previousUrl='/Hebergements') { 
   this.http.get<Hebergement>(`http://localhost:8080/hebergement/${this.message}`).subscribe((data:Hebergement)=>{
    this.hebe=data;
    this.item='Hebergement';
    console.log(this.hebe)
    },(error)=>{
      console.log(error);
    })}
    if (this.previousUrl='/Stades') {
      this.http.get<Stade>(`http://localhost:8080/stade/${this.message}`).subscribe((data:Stade)=>{
      this.stade=data;
      this.item='Stade';
      this.fetchcomentStade();
    },(error)=>{
      console.log(error);
    })
    } else {
      this.router.navigateByUrl(this.previousUrl)
    }
     
  } 
  fetchcomentStade(){
        this.http.get<comment[]>(`http://localhost:8080/CommentaireStade/${this.message}`).subscribe((data:comment[])=>{
        this.comment=data;
        },(error)=>{
         console.log(error);
        })}
  setcommentStade(){
      this.http.post('http://localhost:8080/CommentaireStade/add',this.commentStade,{responseType:'text'}).pipe(
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
        this.router.navigateByUrl('/login');
      },
      error=>{
        console.error(error);
      });
  }
}
function padToTwoDigits(num: number): string {
  return num.toString().padStart(2, '0');
}