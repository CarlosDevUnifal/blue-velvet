package bluevelvetapi.entitys;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "artist_name")
    private String artist_name;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "music_list")
    private String music_list;
    @Column(name = "photo")
    private String photo;

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getMusic_list() {
        return music_list;
    }

    public void setMusic_list(String music_list) {
        this.music_list = music_list;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Product() {}

    public Product(String name, String artist_name, BigDecimal price, String music_list, String photo) {
        this.name = name;
        this.artist_name = artist_name;
        this.price = price;
        this.music_list = music_list;
        this.photo = photo;
    }

}
