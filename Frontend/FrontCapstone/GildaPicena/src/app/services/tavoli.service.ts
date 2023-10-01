import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ITavolo } from '../interfacce/ITavolo';

@Injectable({
  providedIn: 'root',
})
export class TavoliService {
  private apiUrl = 'http://localhost:8080/api';

  headers = new HttpHeaders();

  constructor(private Http: HttpClient) {}

  getTavoli() {
    this.headers = this.headers.set(
      'Authorization',
      'Bearer ' + this.getToken()
    );
    return this.Http.get<Partial<ITavolo[]>>(`${this.apiUrl}/tavoli/get`, {
      headers: this.headers,
    });
  }

  getToken(): string {
    const user = localStorage.getItem('user');
    if (user) {
      const userData = JSON.parse(user);
      return userData.accessToken;
    } else {
      return '';
    }
  }
}
