import java.util.Scanner;

public class AlbumMain {

    public static void main(String[] args) {

        loadDb();
        mainMenu();


    }

    public static void mainMenu() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to your albumcatalog!");
        System.out.println("What do you want to do?");

        while (true) {

            System.out.println("\n[1] Add album");
            System.out.println("[2] Update album score");
            System.out.println("[3] Delete album");
            System.out.println("[4] Show all albums");
            System.out.println("[5] Show albums by artist");
            System.out.println("[6] Show albums by release year");
            System.out.println("[7] Show albums by rating");
            System.out.println("[8] Show average rating");

            System.out.println("[0] Exit");
            int menuChoice = scanner.nextInt();

            switch(menuChoice) {
                case 1:
                    AlbumManagement.createAlbum();
                    break;
                case 2:
                    AlbumManagement.updateAlbumRating();
                    break;
                case 3:
                    AlbumManagement.deleteAlbum();
                    break;
                case 4:
                    AlbumManagement.printAlbums();
                    break;
                case 5:
                    AlbumManagement.findAlbumByArtist();
                    break;
                case 6:
                    AlbumManagement.findAlbumByYear();
                    break;
                case 7:
                    AlbumManagement.findAlbumByRating();
                    break;
                case 8:
                    AlbumManagement.showAverageRating();
                    break;
                default:
                    System.exit(0);
            }

        }


    }

    private static void loadDb() {
        Album a1 = new Album("Abbey Road", "The Beatles", 1969, 10);
        Album a2 = new Album("Let it Bleed", "The Rolling Stones", 1969, 5);
        Album a3 = new Album("Aladdin Sane", "David Bowie", 1973, 7);
        Album a4 = new Album("Artpop", "Lady Gaga", 2013, 2);
        Album a5 = new Album("Thriller", "Michael Jackson", 1982, 9);
        Album a6 = new Album("Folklore", "Taylor Swift", 2020, 8);
        Album a7 = new Album("Revolver", "The Beatles", 1966, 4);

        AlbumManagement.addAlbum(a1);
        AlbumManagement.addAlbum(a2);
        AlbumManagement.addAlbum(a3);
        AlbumManagement.addAlbum(a4);
        AlbumManagement.addAlbum(a5);
        AlbumManagement.addAlbum(a6);
        AlbumManagement.addAlbum(a7);

    }

}
