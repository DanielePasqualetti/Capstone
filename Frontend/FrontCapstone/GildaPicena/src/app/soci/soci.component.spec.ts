import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SociComponent } from './soci.component';

describe('SociComponent', () => {
  let component: SociComponent;
  let fixture: ComponentFixture<SociComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SociComponent]
    });
    fixture = TestBed.createComponent(SociComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
