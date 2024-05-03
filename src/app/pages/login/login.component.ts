import { HttpClient, HttpClientModule,HttpErrorResponse} from '@angular/common/http';
import { Component} from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { catchError, throwError } from 'rxjs';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule,HttpClientModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent{
loginObj:login;
constructor(private http:HttpClient,private router:Router){
  this.loginObj=new login();
}
onLogin(){
this.http.get(`http://localhost:8080/user/login?username=${this.loginObj.Name}&password=${this.loginObj.password}`,{responseType:'text'}).pipe(
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
  this.router.navigateByUrl('/home');
},
error=>{
  console.error(error);
});
}
}
export class login {
  Name:string;
  password:string;
  constructor(){
    this.Name='';
    this.password='';
  }
}