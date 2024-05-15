import { Stade } from "./Stade";
import { User } from "./User";

export interface CommentaireStade {
  idCommentaire: number;
  contenu: string;
  datep: string;
  user: User;
  stade: Stade;
}
