import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-add-patient',
  standalone:true,
  imports: [CommonModule, RouterModule, FormsModule],
  templateUrl: './add-patient.component.html',
  styleUrl: './add-patient.component.css'
})
export class AddPatientComponent {

  patient = {patientName:'', patientAge:0, gender:'', phone:'', patientAddress:''}

  constructor(private http: HttpClient){}

  addPatient(){
    this.http.post('http://localhost:8080/patients', this.patient).subscribe(() => {
      alert("Patient addedd successfully");
    });
  }
}
