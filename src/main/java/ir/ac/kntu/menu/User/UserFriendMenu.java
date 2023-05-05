package ir.ac.kntu.menu.User;

import ir.ac.kntu.Scan;
import ir.ac.kntu.Store;
import ir.ac.kntu.TerminalColor;
import ir.ac.kntu.models.User;

import java.util.ArrayList;

public class UserFriendMenu {
    private Store storeDB;

    private ArrayList<User> notFriend;

    private ArrayList<User> friends;
    private User currentUser;

    public UserFriendMenu(Store storeDB, User currentUser) {
        this.storeDB = storeDB;
        this.currentUser = currentUser;
        notFriend = currentUser.getUserNotFriend(storeDB);
        friends = currentUser.getFriendsList(storeDB);
    }

    public User searchMenu(String name) {
        name = name.trim().toUpperCase();
        ArrayList<User> result = storeDB.findUserByUsernames(name);
        printUserSearchResult(result);
        if (result.size() != 0) {
            return handleSelect(result);
        }
        return null;
    }


    public ArrayList<User> usernameSearch(ArrayList<User> notFriend) {
        System.out.println("Search User by username : ");
        String name = Scan.getLine().trim().toUpperCase();
        ArrayList<User> result = new ArrayList<>();
        for (User user : notFriend) {
            if (user.getUsername().startsWith(name)) {
                result.add(user);
            }
        }
        return result;
    }


    public User handleSelect(ArrayList<User> searchResult) {
        System.out.println("---- chose number : ");
        String input = Scan.getLine();
        if (!input.matches("[0-9]+")) {
            TerminalColor.red();
            System.out.println("Chose valid number!");
            TerminalColor.reset();
        } else {
            int choose = Integer.parseInt(input) - 1;
            if (choose >= searchResult.size() || choose < 0) {
                TerminalColor.red();
                System.out.println("Chose valid number!");
                TerminalColor.reset();
            } else {
                User user = searchResult.get(choose);
                return user;
            }
        }
        return null;

    }

    public User allFriends() {
        ArrayList<User> result = friends;
        printUserSearchResult(result);
        if (result.size() != 0) {
            User selectedUser = handleSelect(result);
            if (selectedUser == null) {
                return null;
            }
            ProfileMenu profileMenu = new ProfileMenu(storeDB, selectedUser);
            profileMenu.showMenu();
        }
        return null;
    }

    public User addFriend() {
        ArrayList<User> result = usernameSearch(notFriend);
        printUserSearchResult(result);
        if (result.size() != 0) {
            User selectedUser = handleSelect(result);
            if (selectedUser == null) {
                return null;
            }
            ProfileMenu profileMenu = new ProfileMenu(storeDB, selectedUser);
            profileMenu.showMenu();
        }
        return null;
    }

    private void printUserSearchResult(ArrayList<User> result) {
        if (result.size() == 0) {
            System.out.println("Not found ! :(");
        } else {
            int i = 1;
            for (User user : result) {
                TerminalColor.blue();
                System.out.print(i);
                TerminalColor.yellow();
                System.out.print(" | ");
                TerminalColor.blue();
                System.out.println(user);
                TerminalColor.reset();
                i++;
            }
        }
    }

    public void showMenu() {
        UserFriendMenuOption option;
        while ((option = printMenuOptions("Search User", UserFriendMenuOption.class)) != UserFriendMenuOption.EXIT) {
            if (option != null) {
                switch (option) {
                    case ALL_FRIEND: {
                        allFriends();
                        break;
                    }
                    case ADD_FRIEND: {
                        addFriend();
                        break;
                    }
                    case BACK: {
                        break;
                    }
                    default:
                        System.out.println("Invalid choose");
                }
            }

        }
        System.exit(0);

    }

    public <T extends Enum<T>> T getOption(Class<T> menuEnum) {
        T[] options = menuEnum.getEnumConstants();
        String choiceStr = Scan.getLine().trim();
        int choice = -1;
        if (choiceStr.matches("[0-9]+")) {
            choice = Integer.parseInt(choiceStr) - 1;
        }

        if (choice >= 0 && choice < options.length) {
            return options[choice];
        }
        TerminalColor.red();
        System.out.println("Wrong choice !");
        TerminalColor.reset();
        return null;
    }

    public <T extends Enum<T>> T printMenuOptions(String title, Class<T> menuEnum) {
        TerminalColor.cyan();
        System.out.println("----------" + title + "----------");
        TerminalColor.reset();
        T[] options = menuEnum.getEnumConstants();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + " - " + options[i]);
        }
        System.out.print("Enter your choice : ");
        return getOption(menuEnum);
    }
}

