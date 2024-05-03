import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent  {
@Input() url1:string='#';
@Input() url2:string='#';
@Input() url3:string='#';
@Input() url4:string='#';
@Input() url5:string='#';
}
