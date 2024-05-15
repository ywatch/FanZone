import { Hebergement } from "./Hebergement";
import { User } from "./User";

export interface CommentaireHebergement {
    idCommentaire: number;
    contenu: string;
    datep: string;
    user: User;
    hebergement: Hebergement;
  }