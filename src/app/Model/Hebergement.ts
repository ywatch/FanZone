import { CommentaireHebergement } from "./CommentaireHebergement";

export interface Hebergement {
    hid: number;
    hname: string;
    hadd: string;
    hprice: number;
    pathpic: string;
    cHebergement: CommentaireHebergement[];
  }