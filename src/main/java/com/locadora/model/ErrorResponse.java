package com.locadora.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    
    /*
    * ERRORS LIST
    */
    
    // 1 : Não foi possível criar o usuário.
    public static int USER_CREATE_ERROR_CODE = 1;
    public static String USER_CREATE_ERROR_STR = "Não foi possível criar o usuário.";
    public static ErrorResponse USER_CREATE_ERROR = 
            new ErrorResponse(ErrorResponse.USER_CREATE_ERROR_CODE, 
                    ErrorResponse.USER_CREATE_ERROR_STR);

    // 2 : Não foi possível fazer o login.
    public static int AUTH_LOGIN_ERROR_CODE = 2;
    public static String AUTH_LOGIN_ERROR_STR = "Não foi possível fazer o login.";
    public static ErrorResponse AUTH_LOGIN_ERROR = 
            new ErrorResponse(ErrorResponse.AUTH_LOGIN_ERROR_CODE, 
                    ErrorResponse.AUTH_LOGIN_ERROR_STR);

    // 3 : Não foi possível fazer o logout.
    public static int AUTH_LOGOUT_ERROR_CODE = 3;
    public static String AUTH_LOGOUT_ERROR_STR = "Não foi possível fazer o logout.";    
    public static ErrorResponse AUTH_LOGOUT_ERROR = 
            new ErrorResponse(ErrorResponse.AUTH_LOGOUT_ERROR_CODE, 
                    ErrorResponse.AUTH_LOGOUT_ERROR_STR);

    // 4 : Não foi possível pesquisar filmes.
    public static int MOVIES_SEARCH_ERROR_CODE = 4;
    public static String MOVIES_SEARCH_ERROR_STR = "Não foi possível pesquisar filmes.";    
    public static ErrorResponse MOVIES_SEARCH_ERROR = 
            new ErrorResponse(ErrorResponse.MOVIES_SEARCH_ERROR_CODE, 
                    ErrorResponse.MOVIES_SEARCH_ERROR_STR);

    // 5 : Não foi possível iniciar a locação.
    public static int LOCATION_START_ERROR_CODE = 5;
    public static String LOCATION_START_ERROR_STR = "Não foi possível iniciar a locação.";    
    public static ErrorResponse LOCATION_START_ERROR = 
            new ErrorResponse(ErrorResponse.LOCATION_START_ERROR_CODE, 
                    ErrorResponse.LOCATION_START_ERROR_STR);

    // 6 : Não foi possível encerrar a locação.
    public static int LOCATION_FINISH_ERROR_CODE = 6;
    public static String LOCATION_FINISH_ERROR_STR = "Não foi possível encerrar a locação.";    
    public static ErrorResponse LOCATION_FINISH_ERROR = 
            new ErrorResponse(ErrorResponse.LOCATION_FINISH_ERROR_CODE, 
                    ErrorResponse.LOCATION_FINISH_ERROR_STR);
    
    
    
        
    private int code;
    private String message;

}
