import { Hebergement } from "./Hebergement";
import { User } from "./User";

export interface CommentaireHebergement {
    contenu: string;
    datep: string;
    user: User;
    hebe: Hebergement;
  }