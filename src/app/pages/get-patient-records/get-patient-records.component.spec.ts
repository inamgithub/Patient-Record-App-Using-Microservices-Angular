import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetPatientRecordsComponent } from './get-patient-records.component';

describe('GetPatientRecordsComponent', () => {
  let component: GetPatientRecordsComponent;
  let fixture: ComponentFixture<GetPatientRecordsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GetPatientRecordsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetPatientRecordsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
