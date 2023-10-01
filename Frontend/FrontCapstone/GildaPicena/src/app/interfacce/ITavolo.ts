import { IMaster } from './IMaster';
import { IUser } from './IUser';

export interface ITavolo {
  numero: number;
  stato: string;
  gioco: string;
  users: IUser[];
  master: IMaster;
}
