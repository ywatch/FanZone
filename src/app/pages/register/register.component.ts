import { HttpClient, HttpClientModule, HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { catchError, throwError } from 'rxjs';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule,HttpClientModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  registerObj: register;
  constructor(private http: HttpClient,private router : Router){
    this.registerObj=new register();
  }
  onRegister(){
    this.http.post('http://localhost:8080/user/add',this.registerObj,{responseType:'text'}).pipe(
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
export class register {
  name:string;
  email:string;
  password:string;
  constructor(){
    this.name='';
    this.email='';
    this.password='';
  }
}