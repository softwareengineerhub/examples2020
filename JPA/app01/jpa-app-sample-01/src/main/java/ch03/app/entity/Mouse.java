package ch03.app.entity;

import javax.persistence.*;

@Entity
@NamedQueries(
        {@NamedQuery(name = "mouse.findAll", query = "SELECT m FROM Mouse m"),
                @NamedQuery(name = "mouse.findById", query = "SELECT m FROM Mouse m where m.id=:id"),
                @NamedQuery(name = "mouse.findByPrice", query = "SELECT m FROM Mouse m where m.price>=:price"),
                @NamedQuery(name = "mouse.updateAll", query = "UPDATE Mouse m SET m.title=:title"),
                @NamedQuery(name = "mouse.deleteByTitle", query = "DELETE FROM Mouse m WHERE m.title=:title"),
                @NamedQuery(name = "mouse.count", query = "SELECT count(m) FROM Mouse m")
        }
)
public class Mouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int price;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
