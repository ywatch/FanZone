import { CommentaireForum } from "./CommentaireForum";
import { User } from "./User";

export interface Post_send {
    contenu:String ;
    datepublication:String;
    user:User;
    CForum:CommentaireForum[];
}