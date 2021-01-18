public class Album {

    private int id;
    private String title;
    private String artist;
    private int year;
    private int rating;
    private static int idCounter;

    public Album(String title, String artist, int year, int rating) {
        this.id = getNewId();
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.rating = rating;
    }

    public int getNewId() {
        idCounter++;
        return idCounter;
    }

    @Override
    public String toString() {
        return "\n" +
                "Title: " + title + "\n" +
                "Artist: " + artist + "\n" +
                "Year released: " + year + "\n" +
                "Your score: " + rating + "\n" +
                "Album id: " + id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
