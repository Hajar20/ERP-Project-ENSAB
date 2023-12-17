import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListOfNewsComponent } from './list-of-news.component';

describe('ListOfNewsComponent', () => {
  let component: ListOfNewsComponent;
  let fixture: ComponentFixture<ListOfNewsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListOfNewsComponent]
    });
    fixture = TestBed.createComponent(ListOfNewsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
