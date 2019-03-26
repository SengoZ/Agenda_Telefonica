import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FichaContactoComponent } from './ficha-contacto.component';

describe('FichaContactoComponent', () => {
  let component: FichaContactoComponent;
  let fixture: ComponentFixture<FichaContactoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FichaContactoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FichaContactoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
