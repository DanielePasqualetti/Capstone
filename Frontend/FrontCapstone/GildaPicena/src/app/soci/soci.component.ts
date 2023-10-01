import { Component } from '@angular/core';
import { ISocio } from '../interfacce/ISocio';
import { SociService } from '../services/soci.service';

@Component({
  selector: 'app-soci',
  templateUrl: './soci.component.html',
  styleUrls: ['./soci.component.scss'],
})
export class SociComponent {
  soci: Partial<ISocio[]> = [];

  nuovoSocio: ISocio = { id: 0, name: '', lastname: '', iscrizione: '' };

  socioDaModificare: ISocio | null = null;

  modificaAttiva: boolean = false;

  constructor(private svc: SociService) {}

  ngOnInit() {
    this.getSoci();
  }

  getSoci() {
    this.svc.getSoci().subscribe((soci) => {
      this.soci = soci;
    });
  }

  aggiungiSocio() {
    this.svc.aggiungiSocio(this.nuovoSocio).subscribe((socio) => {
      console.log('Socio aggiunto con successo', socio);
      this.getSoci();
      this.nuovoSocio = { id: 0, name: '', lastname: '', iscrizione: '' };
    });
  }

  eliminaSocio(id: number) {
    this.svc.eliminaSocio(id).subscribe(() => {
      console.log('Socio eliminato con successo');

      let index: number = this.soci.findIndex((s) => s?.id == id);
      this.soci.splice(index, 1);
    });
  }

  modificaSocio(socio: ISocio) {
    this.socioDaModificare = socio;
    this.nuovoSocio = { ...socio };
    this.modificaAttiva = true;
  }

  salvaModifiche() {
    // this.svc.salvaModifiche().subscribe((socio) => {
    //   console.log('Modifiche al socio salvate con successo', socio);
    //   this.getSoci();
    //   this.nuovoSocio = { name: '', lastname: '', iscrizione: '' };
    // });
    // this.modificaAttiva = false;
    this.svc
      .salvaModifiche(this.nuovoSocio.id, this.nuovoSocio)
      .subscribe((socio) => {
        console.log('Modifiche al socio salvate con successo', socio);
        this.getSoci();
        this.nuovoSocio = { id: 0, name: '', lastname: '', iscrizione: '' };
        this.modificaAttiva = false;
      });
  }
}
