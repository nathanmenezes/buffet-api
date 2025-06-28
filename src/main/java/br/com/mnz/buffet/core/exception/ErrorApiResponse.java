package br.com.mnz.buffet.core.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorApiResponse {
    private String message;
    private String path;
    private int status;
    private String error;
    private long timestamp;
}
