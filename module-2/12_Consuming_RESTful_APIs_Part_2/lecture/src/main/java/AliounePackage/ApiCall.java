package AliounePackage;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiCall {
    private  RestTemplate restTemplate = new RestTemplate();


    public Hotel[] forDisplay(){
        Hotel[]returnOne = restTemplate.getForObject("http://localhost:3000/hotels", Hotel[].class);
//        System.out.println(forDisplay()[0].getName());



        return returnOne;
    }

    public List<Hotel> aliouneWouldVisit(int stars){
        List<Hotel>addtoList = new ArrayList<>();
        Hotel[]addThem = forDisplay();
        for (int i = 0; i <addThem.length ; i++) {
            if(addThem[i].getStars()<= stars){
                addtoList.add(addThem[i]);
            }
        }



        return addtoList;
    }

    public Hotel aliouneWontGoHERE(String letterWithS){

        if(forDisplay()[0].getName().contains(letterWithS.toLowerCase().split("")[0])){
            return forDisplay()[1];
        }
        return null;
    }



    public List<Hotel> badHotelByZip(String zipCode){

        Hotel[] allHotel = forDisplay();
        List<Hotel>hotelsThatWontBeGood = Arrays.asList(allHotel);
        List<Hotel>hoteltoGo = new ArrayList<>();
        for (int i = 0; i <hotelsThatWontBeGood.size() ; i++) {
            if(hotelsThatWontBeGood.get(i).getAddress().getZip().contains(zipCode)){
                hoteltoGo.add(hotelsThatWontBeGood.get(i));
            }


        }


        return hotelsThatWontBeGood;
    }

    public void addHotel(Hotel addAnotherHotel){
        HttpHeaders headOne = new HttpHeaders();
        headOne.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Hotel>completedHotel = new HttpEntity<>(addAnotherHotel,headOne);



        restTemplate.exchange("http://localhost:3000/hotels", HttpMethod.POST,completedHotel, Hotel.class).getBody();


    }








}
