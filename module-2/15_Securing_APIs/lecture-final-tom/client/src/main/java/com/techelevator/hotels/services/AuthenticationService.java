package com.techelevator.hotels.services;

import com.techelevator.hotels.model.CredentialsDto;
import com.techelevator.hotels.model.TokenDto;
import com.techelevator.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class AuthenticationService {

    private static final String API_BASE_URL = "http://localhost:8080/";
    private final RestTemplate restTemplate = new RestTemplate();

    public String login(String username, String password) {
        // Get the Body ready
        CredentialsDto credentialsDto = new CredentialsDto();
        credentialsDto.setUsername(username);
        credentialsDto.setPassword(password);

        // Get the Headers ready
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        // Pack the suitcase                                   data
        HttpEntity<CredentialsDto> entity = new HttpEntity<>(credentialsDto, headers);


        // Send it to the server!
        String token = null;
        try {
            ResponseEntity<TokenDto> response = restTemplate.exchange(API_BASE_URL + "login", HttpMethod.POST, entity, TokenDto.class);
            // 2. token = ResponseEntity<TokenDto> response = restTemplate.exchange(API_BASE_URL + "login", HttpMethod.POST, entity, TokenDto.class).getBody().getToken();
            // 3. String token = restTemplate.postForObject(URL, entity, TokenDto.class).getToken();

            TokenDto body = response.getBody();
            if (body != null) {
                token = body.getToken();
            }
        } catch (RestClientResponseException | ResourceAccessException e) { // Catch 2 birds with 1 stone
            BasicLogger.log(e.getMessage());
        }

        return token;
    }

    /*

    USAGE:
    ResponseEntity<Data> fullResponse = restTemplate.exchange(URL, HttpMethod, requestEntity, Data.class);
    Data actualDataInPayload = fullResponse.getBody();

    We've been using shortcuts!
    restTemplate.getForObject(URL, Data.class) --> restTemplate.exchange(URL, HttpMethod.GET, null, Data.class).getBody()
    restTemplate.postForObject(URL, requestEntity, Data.class) --> restTemplate.exchange(URL, HttpMethod.POST, requestEntity, Data.class).getBody();
    restTemplate.put(URL, requestEntity) --> restTemplate.exchange(URL, HttpMethod.PUT, requestEntity, Void.class);
    restTemplate.delete(URL) --> restTemplate.exchange(URL, HttpMethod.DELETE, null, Void.class);


     */






}
