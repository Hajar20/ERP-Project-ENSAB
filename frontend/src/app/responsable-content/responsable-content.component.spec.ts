import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResponsableContentComponent } from './responsable-content.component';

describe('ResponsableContentComponent', () => {
  let component: ResponsableContentComponent;
  let fixture: ComponentFixture<ResponsableContentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ResponsableContentComponent]
    });
    fixture = TestBed.createComponent(ResponsableContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
