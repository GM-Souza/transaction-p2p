package com.transaction_p2p.service;

import com.transaction_p2p.domain.dto.NotificationDTO;
import com.transaction_p2p.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception {
        String email = user.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, message);

       ResponseEntity<String> notificationResponse = restTemplate.postForEntity("http://o4d9z.mocklab.io/notify", notificationRequest, String.class);

       if(!(notificationResponse.getStatusCode() == HttpStatus.OK)){
           System.out.println("Erro ao enviar notificação");
           throw new Exception("Servico de notificação esta fora do ar");
       }
    }
}
