import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { HomeComponent } from './pages/home/home.component';
import { PatientsComponent } from './pages/patients/patients.component';
import { GetAllPatientsComponent } from './pages/get-all-patients/get-all-patients.component';
import { AddPatientComponent } from './pages/add-patient/add-patient.component';
import { UpdatePatientComponent } from './pages/update-patient/update-patient.component';
import { GetPatientRecordsComponent } from './pages/get-patient-records/get-patient-records.component';
import { provideHttpClient } from '@angular/common/http';

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter([
      { path: '', component: HomeComponent },
      { path: 'patients', component: PatientsComponent },
      { path: 'patients/all', component: GetAllPatientsComponent },
      { path: 'patients/add', component: AddPatientComponent },
      { path: 'patients/update', component: UpdatePatientComponent },
      { path: 'patients/details', component: GetPatientRecordsComponent },
    ]),
    provideHttpClient(),
  ],
};