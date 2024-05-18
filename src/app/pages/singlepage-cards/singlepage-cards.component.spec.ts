import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SinglepageCardsComponent } from './singlepage-cards.component';

describe('SinglepageCardsComponent', () => {
  let component: SinglepageCardsComponent;
  let fixture: ComponentFixture<SinglepageCardsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SinglepageCardsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SinglepageCardsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
