import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-get-patient-records',
  imports: [RouterModule, CommonModule, FormsModule],
  standalone:true,
  templateUrl: './get-patient-records.component.html',
  styleUrl: './get-patient-records.component.css'
})
export class GetPatientRecordsComponent {

  patientId=0;
  patientDetails:any = null;

  constructor(private http: HttpClient){}

  // getDetails() {
  //   this.http.get(`http://localhost:8080/patients/${this.patientId}/detailrecords`).subscribe((data) => {
  //     this.patientDetails = data;
  //   });
  // }

  getDetails() {
    this.http.get(`http://localhost:8080/patients/${this.patientId}/detailrecords`)
      .subscribe({
        next: (data) => {
          console.log('Patient Details:', data);  // Log the response
          this.patientDetails = data;
        },
        error: (err) => {
          console.error('Error fetching data:', err);  // Log errors
        }
      });
  }
  
}
