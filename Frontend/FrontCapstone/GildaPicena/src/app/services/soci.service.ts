import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ISocio } from '../interfacce/ISocio';

@Injectable({
  providedIn: 'root',
})
export class SociService {
  private apiUrl = 'http://localhost:8080/api';

  headers = new HttpHeaders();

  constructor(private Http: HttpClient) {}

  getSoci() {
    this.headers = this.headers.set(
      'Authorization',
      'Bearer ' + this.getToken()
    );
    return this.Http.get<Partial<ISocio[]>>(`${this.apiUrl}/soci/get`, {
      headers: this.headers,
    });
  }

  getToken() {
    const user = localStorage.getItem('user');
    if (user) {
      const userData = JSON.parse(user);
      return userData.accessToken;
    } else {
      return '';
    }
  }

  aggiungiSocio(nuovoSocio: ISocio) {
    this.headers = this.headers.set(
      'Authorization',
      'Bearer ' + this.getToken()
    );

    return this.Http.post<any>(`${this.apiUrl}/soci/new`, nuovoSocio, {
      headers: this.headers,
    });
  }

  eliminaSocio(id: number) {
    this.headers = this.headers.set(
      'Authorization',
      'Bearer ' + this.getToken()
    );

    return this.Http.delete<any>(`${this.apiUrl}/soci/${id}`, {
      headers: this.headers,
    });
  }

  salvaModifiche(id: number, socioModificato: ISocio) {
    this.headers = this.headers.set(
      'Authorization',
      'Bearer ' + this.getToken()
    );

    return this.Http.put<any>(`${this.apiUrl}/soci/${id}`, socioModificato, {
      headers: this.headers,
    });
  }
}
