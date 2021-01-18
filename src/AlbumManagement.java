import java.util.Scanner;

public class AlbumManagement {

    private static Album[] albums = new Album[5];
    private static int counter = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void addAlbum(Album album) {

        if (counter == albums.length) {
            Album[] temp = new Album[albums.length * 2];

            for (int i = 0; i < albums.length; i++) {
                temp[i] = albums[i];
            }
            albums = temp;
        }

        albums[counter] = album;
        counter++;
    }

    public static void createAlbum() {
        System.out.print("\nTitle: ");
        String title = scanner.nextLine();
        System.out.print("Artist: ");
        String artist = scanner.nextLine();
        System.out.print("Year released: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Score: ");
        int score = scanner.nextInt();
        scanner.nextLine();
        Album album = new Album(title, artist, year, score);
        addAlbum(album);
        System.out.println("Album added");
    }

    public static void printAlbums() {
        System.out.println("Sorted by: ");
        boolean menu = true;

        while(menu) {
            System.out.println("[1] Year");
            System.out.println("[2] Rating");
            System.out.println("[3] When added");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if(choice == 1) {
                sortByYear();
                menu = false;
            } else if (choice == 2) {
                sortByRating();
                menu = false;
            } else if (choice == 3) {
                sortByAdded();
                menu = false;
            } else {
                System.out.println("Choose one: ");
            }
        }



    }

    public static void updateAlbumRating() {
        findAlbumByArtist();

        System.out.print("\nProvide the id for the album you want to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Album album = findAlbumById(id);
        if (album != null) {
            System.out.println("Current rating: " + album.getRating());
            boolean menu = true;
            while (menu) {
                System.out.print("New rating (1-10): ");
                int rating = scanner.nextInt();
                scanner.nextLine();
                if (rating < 1 || rating > 10) {
                    System.out.println("Rating can only be set to numbers from 1 to 10");
                } else {
                    album.setRating(rating);
                    System.out.println("Rating updated");
                    menu = false;
                }
            }
        } else {
            System.out.println("Couldn't find the album");
        }

    }

    public static void deleteAlbum() {
        findAlbumByArtist();

        System.out.print("\nProvide the id for the album you want to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean albumExists = false;

        for (int i = 0; i < counter; i++) {
            if (albums[i].getId() == id) {
                albumExists = true;
                albums[i] = albums[counter - 1];
                albums[counter - 1] = null;
                counter--;
            }
        }

        if (albumExists) {
            System.out.println("Album deleted");
        } else {
            System.out.println("Couldn't find the album");
        }
    }

    public static void findAlbumByArtist() {
        System.out.print("\nArtist: ");
        String artist = scanner.nextLine();
        boolean albumExists = false;
        for (int i = 0; i < counter; i++) {
            if (albums[i].getArtist().equalsIgnoreCase(artist)) {
                albumExists = true;
                System.out.println(albums[i]);
            }
        }
        if (!albumExists) {
            System.out.println("There's no albums by " + artist + " in the catalog");
            AlbumMain.mainMenu();
        }
    }

    public static void findAlbumByYear() {
        System.out.print("\nYear: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        boolean albumExists = false;
        for (int i = 0; i < counter; i++) {
            if (albums[i].getYear() == year) {
                albumExists = true;
                System.out.println(albums[i]);
            }
        }
        if (!albumExists) {
            System.out.println("There's no albums released in year " + year + " in the catalog");
        }
    }

    public static void findAlbumByRating() {
        System.out.print("\nRating: ");
        int rating = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < counter; i++) {
            if (albums[i].getRating() == rating) {
                System.out.println(albums[i]);
            }
        }
    }

    public static Album findAlbumById(int id) {
        for (int i = 0; i < counter; i++) {
            if (albums[i].getId() == id) {
                return albums[i];
            }
        }
        return null;
    }

    public static void showAverageRating() {
        int scoreSum = 0;
        for (int i = 0; i < counter; i++) {
            scoreSum = scoreSum + albums[i].getRating();
        }
        System.out.println("The average album rating is: " + (scoreSum / counter));
    }

    public static void sortByYear() {
        Album temp;
        boolean menu = true;

        while(menu) {
            System.out.println("[1] Newest to oldest");
            System.out.println("[2] Oldest to newest");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                for (int i = 0; i < counter; i++) {
                    for (int j = i + 1; j < counter; j++) {
                        if(albums[i].getYear() < albums[j].getYear()) {
                            temp = albums[i];
                            albums[i] = albums[j];
                            albums[j] = temp;
                        }
                    }
                }
                for (int i = 0; i < counter; i++) {
                    System.out.println(albums[i]);
                }

                menu = false;

            } else if (choice == 2) {

                for (int i = 0; i < counter; i++) {
                    for (int j = i + 1; j < counter; j++) {
                        if(albums[i].getYear() > albums[j].getYear()) {
                            temp = albums[i];
                            albums[i] = albums[j];
                            albums[j] = temp;
                        }
                    }
                }
                for (int i = 0; i < counter; i++) {
                    System.out.println(albums[i]);
                }

                menu = false;

            } else {
                System.out.println("Choose one: ");
            }
        }
    }

    public static void sortByRating() {
        Album temp;
        boolean menu = true;

        while(menu) {
            System.out.println("[1] Highest to lowest");
            System.out.println("[2] Lowest to highest");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                for (int i = 0; i < counter; i++) {
                    for (int j = i + 1; j < counter; j++) {
                        if(albums[i].getRating() < albums[j].getRating()) {
                            temp = albums[i];
                            albums[i] = albums[j];
                            albums[j] = temp;
                        }
                    }
                }
                for (int i = 0; i < counter; i++) {
                    System.out.println(albums[i]);
                }

                menu = false;

            } else if (choice == 2) {

                for (int i = 0; i < counter; i++) {
                    for (int j = i + 1; j < counter; j++) {
                        if(albums[i].getRating() > albums[j].getRating()) {
                            temp = albums[i];
                            albums[i] = albums[j];
                            albums[j] = temp;
                        }
                    }
                }
                for (int i = 0; i < counter; i++) {
                    System.out.println(albums[i]);
                }

                menu = false;

            } else {
                System.out.println("Choose one: ");
            }
        }
    }

    public static void sortByAdded() {
        Album temp;
        boolean menu = true;

        while(menu) {
            System.out.println("[1] Newest to oldest");
            System.out.println("[2] Oldest to newest");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                for (int i = 0; i < counter; i++) {
                    for (int j = i + 1; j < counter; j++) {
                        if(albums[i].getId() < albums[j].getId()) {
                            temp = albums[i];
                            albums[i] = albums[j];
                            albums[j] = temp;
                        }
                    }
                }
                for (int i = 0; i < counter; i++) {
                    System.out.println(albums[i]);
                }

                menu = false;

            } else if (choice == 2) {

                for (int i = 0; i < counter; i++) {
                    for (int j = i + 1; j < counter; j++) {
                        if(albums[i].getId() > albums[j].getId()) {
                            temp = albums[i];
                            albums[i] = albums[j];
                            albums[j] = temp;
                        }
                    }
                }
                for (int i = 0; i < counter; i++) {
                    System.out.println(albums[i]);
                }

                menu = false;

            } else {
                System.out.println("Choose one: ");
            }
        }
    }

}
