package keentech.com.hotpot;

class Product {
    String id;
    String name;
    int serving;
    int price;
    int veg;
    String link;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getServing() {
        return serving;
    }

    public void setServing(int serving) {
        this.serving = serving;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getVeg() {
        return veg;
    }

    public void setVeg(int veg) {
        this.veg = veg;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Product(String id, String name, int serving, int price, int veg, String link) {
        this.id = id;
        this.name = name;
        this.serving = serving;
        this.price = price;
        this.veg = veg;
        this.link = link;
    }

    public Product() {

    }
}
