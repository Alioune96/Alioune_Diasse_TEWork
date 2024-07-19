package com.techelevator.clientServer;

import com.techelevator.Server.UserDOA;
import com.techelevator.clientServer.UserInformation;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;


public class UserDOAImp implements UserDOA {

    JdbcTemplate connectToOtherWorld;
    com.techelevator.Server.UserInformation here;


    public UserDOAImp(BasicDataSource winTime){
    this.connectToOtherWorld=new JdbcTemplate(winTime);

    }

    public void createdUser(com.techelevator.Server.UserInformation userClass) {
        String thiswillwork = "INSERT INTO userinfo (first_name,last_name,email,phone_number,age) VALUES (?,?,?,?,?)";
        try{
            connectToOtherWorld.update(thiswillwork,userClass.getFirstName(),userClass.getLastName(),userClass.getEmail(),userClass.getPhoneNumber(),userClass.getAge());

            System.out.println("Hello "+ userClass.getFirstName().toUpperCase());
            displayCurrentdata();

        }catch (CannotGetJdbcConnectionException e){
            throw new RuntimeException("Didn't work "+e);
        }catch (DataIntegrityViolationException e){
            throw new RuntimeException("Keep trying kid ");
        }

    }


    public void deleteAccount(String phonenumber, String makeMe) {

        String firstOne = "SELECT user_id FROM userinfo WHERE first_name ILIKE ? AND phone_number = ?;\n";
        String delete = "DELETE FROM userinfo WHERE user_id = ?;\n";

        try{
            SqlRowSet giveMe = connectToOtherWorld.queryForRowSet(firstOne,makeMe,phonenumber);

            if(!giveMe.wasNull()){
                if(giveMe.next()){
                    int james = giveMe.getInt("user_id");
                    connectToOtherWorld.update(delete,james);

                }
            }



        }catch (CannotGetJdbcConnectionException e){
            throw new RuntimeException("Sorry "+e.getMessage());
        }catch (DataIntegrityViolationException e){
            throw new RuntimeException("This you can fix "+ e.getMessage());
        }

    }

    public void displayCurrentdata(){
        String printOut ="SELECT * FROM userinfo";
        SqlRowSet handOut = connectToOtherWorld.queryForRowSet(printOut);

        while(handOut.next()){
            String name = handOut.getString("first_name");
            System.out.println(name);
        }
    }

//    public com.techelevator.Server.UserInformation checkUser(String firstName, String lastName){
//        com.techelevator.Server.UserInformation returnUser = null;
//        String sqlStuff = "SELECT * FROM userinfo WHERE first_name ILIKE ? AND last_name ILIKE ?;";
//        SqlRowSet findThis = connectToOtherWorld.queryForRowSet(sqlStuff, firstName,lastName);
//        if(!findThis.wasNull()){
//            if(findThis.next()){
//                returnUser = creatingHumans(findThis);
//            }
//        }
//
//
//
//        return returnUser;
//    }




//    public com.techelevator.Server.UserInformation creatingHumans(SqlRowSet setforData){
//        com.techelevator.Server.UserInformation newKid = new UserInformation();
//        newKid.setUserId(setforData.getInt("user_id"));
//        newKid.setFirstName(setforData.getString("first_name"));
//        newKid.setLastName(setforData.getString("last_name"));
//        newKid.setPhoneNumber(setforData.getString("phone_number"));
//        newKid.setAge(setforData.getInt("age"));
//        newKid.setEmail(setforData.getString("email"));
//
//        return newKid;
//    }
}
