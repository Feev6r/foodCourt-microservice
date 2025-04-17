package ferv.dev.foodcourtmicroservice.category.domain.models;


public class Restaurant {

    private Long id;
    private String name;
    private String address;
    private String nit;
    private String phoneNumber;
    private String urlLogo;
    private Long ownerId;

    public Restaurant(Long id, String name, String address, String nit, String phoneNumber, String urlLogo, Long ownerId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.nit = nit;
        this.phoneNumber = phoneNumber;
        this.urlLogo = urlLogo;
        this.ownerId = ownerId;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
