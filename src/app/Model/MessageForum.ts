import { CommentaireForum } from "./CommentaireForum";
import { User } from "./User";

export interface MessageForum {
    idm: number;
    contenu: string;
    datepublication: string;
    user: User;
    cForum: CommentaireForum[];
  }