import { MessageForum } from "./MessageForum";
import { User } from "./User";

export interface CommentaireForum {
    id: number;
    contenu: string;
    datep: string;
    user: User;
    messageforum:MessageForum
  }