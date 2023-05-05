package ir.ac.kntu.menu.User;

import ir.ac.kntu.Scan;
import ir.ac.kntu.TerminalColor;
import ir.ac.kntu.menu.Menu;
import ir.ac.kntu.models.User;

public class FriendProfileMenu extends Menu {

    private User friend;
    private User currentUser;

    public FriendProfileMenu(User friend, User currentUser) {
        this.friend = friend;
        this.currentUser = currentUser;
    }

    @Override
    public void showMenu() {
        FriendProfileOptions option;
        while ((option = printMenuOptions(friend.getUsername(), FriendProfileOptions.class)) != FriendProfileOptions.EXIT){
            if (option != null) {
                switch (option) {
                    case REMOVE_FRIEND: {
                        if(removeFriend()){
                            return;
                        }
                        break;
                    }
                    case SHOW_USER_GAMES: {
                        showFriendGames();
                        break;
                    }
                    case BACK: {
                        return;
                    }
                    default:
                        System.out.println("Invalid choose");
                }
            }
        }
        System.exit(0);
    }

    private void showFriendGames() {
    }

    private boolean removeFriend(){
        System.out.println("Are you  sure ? (Y/N)");
        String input;
        while (!(input = Scan.getLine().trim()).matches("Y|N")){
            TerminalColor.red();
            System.out.println("Wrong chios!");
            TerminalColor.reset();
            System.out.println("Are you  sure ? (Y/N)");
        }
        if (input.equals("Y")){
            currentUser.removeFriend(friend);
            friend.removeFriend(currentUser);
            return true;
        }
        return false;
    }
}
