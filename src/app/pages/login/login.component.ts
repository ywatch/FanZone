import { HttpClient, HttpClientModule,HttpErrorResponse} from '@angular/common/http';
import { Component} from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { catchError, throwError } from 'rxjs';
import { User } from '../../Model/User';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule,HttpClientModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent{
user:User;
constructor(private http:HttpClient,private router:Router){
this.user={name:"",password:"",email:"",id:0,cForum:[],cHebergement:[],cStade:[],messageForum:[],connect:false}
}
onLogin(){
this.http.get(`http://localhost:8080/user/login?username=${this.user?.name}&password=${this.user?.password}`,{responseType:'text'}).pipe(
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
  const message = this.user.name;
  alert(response);
  this.router.navigate(['/home',message]);
},
error=>{
  console.error(error);
});
}
}