import { CommentaireStade } from "./CommentaireStade";

export interface Stade {
    sid: number;
    stadename: string;
    ville: string;
    capacite: number;
    pathpic: string;
    cStade: CommentaireStade[];
  }