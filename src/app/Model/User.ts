import { CommentaireForum } from "./CommentaireForum";
import { CommentaireHebergement } from "./CommentaireHebergement";
import { CommentaireStade } from "./CommentaireStade";
import { MessageForum } from "./MessageForum";

export interface User {
    id: number;
    name: string;
    email: string;
    password: string;
    connect:boolean;
    messageForum: MessageForum[];
    cForum: CommentaireForum[];
    cHebergement: CommentaireHebergement[];
    cStade: CommentaireStade[];
  }