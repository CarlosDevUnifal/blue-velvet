package entitys.product;

public class Product {
    private int id;
    private String name;
    private String artistName;
    private double price;
    private String musicList;
    private String photo;

    public Product(int id, String name, String artistName, double price, String musicList, String photo) {
        this.id = id;
        this.name = name;
        this.artistName = artistName;
        this.price = price;
        this.musicList = musicList;
        this.photo = photo;
    }

    public Product(String name, String artistName, double price, String musicList, String photo) {
        this.name = name;
        this.artistName = artistName;
        this.price = price;
        this.musicList = musicList;
        this.photo = photo;
    }

    // Getters and setters omitted for brevity
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMusicList() {
        return musicList;
    }

    public void setMusicList(String musicList) {
        this.musicList = musicList;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}

