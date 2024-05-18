import { Stade } from "./Stade";
import { User } from "./User";

export interface CommentaireStade {
  contenu: string;
  datep: string;
  user: User;
  stade: Stade;
}
