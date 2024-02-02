package com.jangir.loanservice.dto;

import jakarta.websocket.server.ServerEndpoint;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private String statusCode;
    private String statusMessage;
}
