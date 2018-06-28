package keentech.com.hotpot;

class Restaurant {

    String id;
    String name;
    String address;
    String number;
    String link;

    public Restaurant(String id, String name, String address, String number, String link) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.number = number;
        this.link = link;
    }

    public Restaurant() {
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
