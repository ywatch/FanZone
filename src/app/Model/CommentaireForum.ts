import { MessageForum } from "./MessageForum";
import { Posts } from "./Posts";
import { User } from "./User";

export interface CommentaireForum {
    contenu: string;
    datep: string;
    user: User;
    messageF:MessageForum
  }