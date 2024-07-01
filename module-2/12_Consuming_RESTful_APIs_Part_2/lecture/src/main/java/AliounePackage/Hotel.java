package AliounePackage;

import java.util.Map;

public class Hotel {
    private int id;
    private String name;
    private int stars;

    private Address address;

//    private Map<String,String>address;
    private int roomsAvailable;
    private String coverImage;


//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }


//    public Map<String, String> getAddress() {
//        return address;
//    }
//
//    public void setAddress(Map<String, String> address) {
//        this.address = address;
//    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getRoomsAvailable() {
        return roomsAvailable;
    }

    public void setRoomsAvailable(int roomsAvailable) {
        this.roomsAvailable = roomsAvailable;
    }

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

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getRoomAvailable() {
        return roomsAvailable;
    }

    public void setRoomAvailable(int roomAvailable) {
        this.roomsAvailable = roomAvailable;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }
}
