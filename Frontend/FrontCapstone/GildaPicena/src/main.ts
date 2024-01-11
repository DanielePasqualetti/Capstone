/// <reference types="@angular/localize" />

import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppModule } from './app/app.module';
import { initializeApp } from 'firebase/app';
import { getAnalytics } from 'firebase/analytics';

const firebaseConfig = {
  apiKey: 'AIzaSyAa1KDA3__uvmJoCF9zokeh-H-8iYsNI4c',
  authDomain: 'gildapicena-14ee3.firebaseapp.com',
  projectId: 'gildapicena-14ee3',
  storageBucket: 'gildapicena-14ee3.appspot.com',
  messagingSenderId: '464566287655',
  appId: '1:464566287655:web:8fc8d047b18dd94d207d02',
  measurementId: 'G-V1HSDV6VYR',
};

// Inizializza Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);

platformBrowserDynamic()
  .bootstrapModule(AppModule)
  .catch((err) => console.error(err));
