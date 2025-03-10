import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-update-patient',
  standalone:true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './update-patient.component.html',
  styleUrl: './update-patient.component.css'
})
export class UpdatePatientComponent {

  patientId=0;
  patient = {patientName:'', patientAge:0, gender:'', phone:'', patientAddress:''}

  constructor(private http: HttpClient){}

  updatePatientDetails(){
    if (this.patientId <= 0) {
      alert("Please enter a valid Patient ID.");
      return;
    }
  
    this.http.put(`http://localhost:8080/patients/${this.patientId}`, this.patient).subscribe(
      () => {
        alert('Patient updated successfully!');
      },
      (error) => {
        alert('Error updating patient: ' + error.message);
      }
    );  
  }
  

}
