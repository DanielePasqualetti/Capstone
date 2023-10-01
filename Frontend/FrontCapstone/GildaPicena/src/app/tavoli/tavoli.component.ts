import { Component } from '@angular/core';
import { ITavolo } from '../interfacce/ITavolo';
import { TavoliService } from '../services/tavoli.service';

@Component({
  selector: 'app-tavoli',
  templateUrl: './tavoli.component.html',
  styleUrls: ['./tavoli.component.scss'],
})
export class TavoliComponent {
  tavoli: Partial<ITavolo[]> = [];

  constructor(private svc: TavoliService) {}

  ngOnInit() {
    this.getTavoli();
  }

  getTavoli(): void {
    this.svc.getTavoli().subscribe((tavoli) => {
      this.tavoli = tavoli;
    });
  }
}
