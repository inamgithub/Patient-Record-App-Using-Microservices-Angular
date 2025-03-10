import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-get-all-patients',
  standalone:true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './get-all-patients.component.html',
  styleUrl: './get-all-patients.component.css'
})
export class GetAllPatientsComponent {

  patients: any[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit(){
    this.http.get<any[]>('http://localhost:8080/patients').subscribe((data) =>{
      this.patients = data;
    });
  }

}
